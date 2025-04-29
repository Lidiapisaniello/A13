#!/bin/sh

echo "Starting backup loop..."

while true; do
  TS=$(date +"%Y%m%d_%H%M%S")

  echo "[T4] Backing up PostgreSQL..."
  PGPASSWORD=postgres pg_dump -h t4-postgres_db -U postgres postgres | gzip > /Backups/T4_pg_backup_${TS}.sql.gz

  echo "[T23] Backing up MySQL..."
  mysqldump -h t23-mysql_db -uroot -ppassword studentsrepo | gzip > /Backups/T23_mysql_backup_${TS}.sql.gz

  echo "Backup completed. Sleeping for 6h..."
  sleep 21600 # 6 hours
done
