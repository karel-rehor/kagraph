#!/usr/bin/env bash

RC_OR_BETA=false

if [[ -z "${RELEASE_TAG_NAME}" ]]
then
  RELEASE_TAG_NAME=0.0.0-RC3
fi

echo "DEBUG RELEASE_TAG_NAME ${RELEASE_TAG_NAME}"

LOWER_TAG_NAME=$(echo "${RELEASE_TAG_NAME}" | tr '[:upper:]' '[:lower:]')

echo "DEBUG LOWER_TAG_NAME ${LOWER_TAG_NAME}"

if echo "${LOWER_TAG_NAME}" | grep -q "rc|beta"
then
  RC_OR_BETA=true
fi

export RC_OR_BETA
