#!/usr/bin/env bash

RC_OR_BETA=false


echo "DEBUG TEST_TAG_NAME ${TEST_TAG_NAME}"

LOWER_TAG_NAME=$(echo "${TEST_TAG_NAME}" | tr '[:upper:]' '[:lower:]')

echo "DEBUG LOWER_TAG_NAME ${LOWER_TAG_NAME}"

if echo "${LOWER_TAG_NAME}" | grep -q "rc|beta"
then
  RC_OR_BETA=false
fi

export RC_OR_BETA
