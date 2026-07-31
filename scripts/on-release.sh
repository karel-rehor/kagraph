#!/usr/bin/env bash

echo "Starting ${0}"

github_check(){

  if [ "${GITHUB_EVENT_NAME}" == "workflow_dispatch" ]; then
    echo "WARNING: This script is targeted for 'release' not ${GITHUB_EVENT_NAME}."
    echo "Continuing for debugging."
    return
  fi

  if [ "${GITHUB_EVENT_NAME}" != "release" ]; then
    echo "This script can run only on 'release'.  Detected Github event ${GITHUB_EVENT_NAME}."
    exit 1
  fi

  if [ -z "${RELEASE_TAG_NAME}" ]; then
    echo "This script requires a release tag, but none was found."
    exit 1
  fi

  echo "Running ${GITHUB_EVENT_NAME} with tag ${RELEASE_TAG_NAME}."
}


if [ -n "${GITHUB_ACTIONS}" ]
then
  echo "Running in Github Actions container."
  github_check
else
  echo "This script can only be run in a Github action container."
  echo "Local runs are not yet supported."
  exit 1
fi

echo "======"

env