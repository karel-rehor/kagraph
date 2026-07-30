#!/usr/bin/env bash

echo "Starting ${0}"

if [ -n "${GITHUB_ACTIONS}" ]
then
  echo "Running in Github Actions container"
  echo "DEBUG event ${GITHUB_EVENT_NAME}"
  echo "DEBUG RELEASE_TAG_NAME #${RELEASE_TAG_NAME}#"
else
  echo "Running locally"
fi

echo "======"

env