FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    mysql-client \
    postgresql-client \
    gzip \
    ca-certificates \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY scripts/backup.sh ./backup.sh
RUN chmod +x ./backup.sh

ENTRYPOINT ["/app/backup.sh"]
