#!/bin/bash

set -e

echo "Docker push process started"

docker login || { echo "Docker login failed" ; exit 1; }

docker_images=(
    "mick0974/a13:t1-g11"
    "mick0974/a13:t23-g1"
    "mick0974/a13:t4-g18"
    "mick0974/a13:t5-g2"
    "mick0974/a13:t7-g31"
    "mick0974/a13:t8-g21"
    "mick0974/a13:ui-gateway"
    "mick0974/a13:api-gateway"
    "mick0974/a13:t0"
    "mick0974/a13:db-backup"
)

for image in "${docker_images[@]}"; do
    echo "Pushing $image"
    docker push "$image" || { echo "Error pushing $image" ; exit 1; }
done

echo "Docker push process completed"
