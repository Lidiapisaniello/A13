#!/bin/bash

SERVICE="$1"
BACKUP_FILE="$2"
CONTAINER_NAME="db-backup"

if [[ -z "$SERVICE" || -z "$BACKUP_FILE" ]]; then
  echo "Usage: ./restore_backup.sh <T23|T4> <backup_filename.sql.gz>"
  exit 1
fi

if [[ "$SERVICE" == "T23" ]]; then
  CMD="gunzip < /Backups/$BACKUP_FILE | mysql -h t23-mysql_db -u user -ppassword studentsrepo"
elif [[ "$SERVICE" == "T4" ]]; then
  CMD="PGPASSWORD=postgres psql -h t4-postgres_db -U postgres -d postgres -c 'DROP SCHEMA public CASCADE; CREATE SCHEMA public;' && gunzip < /Backups/$BACKUP_FILE | PGPASSWORD=postgres psql -h t4-postgres_db -U postgres -d postgres"
else
  echo "Service invalid, select T23 or T4."
  exit 1
fi

echo "Restoring backup $BACKUP_FILE for service $SERVICE"
docker exec -i "$CONTAINER_NAME" /bin/sh -c "$CMD"

if [ $? -eq 0 ]; then
  echo "Restore completed successfully"
else
  echo "Error encountered restoring backup."
fi
