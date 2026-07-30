#!/usr/bin/env bash

echo "Starting ${0}"

if [ -n "${GITHUB_ACTIONS}" ]
then
  echo "Running in Github Actions container"
  echo "DEBUG tag name #${{ github.event.release.tag_name }}#"
else
  echo "Running locally"
fi

env