#!/usr/bin/env bash

echo "Starting ${0}"

if [ -z "${GITHUB_ACTIONS}" ]
then
  echo "This script can only be run in a Github action container."
  echo "Local runs are not yet supported."
  exit 1
fi

FAILURE_BOILERPLATE="Please delete the tag ${CIRCLE_TAG} and the related release, and start again."

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

setup(){
  ADDITIONAL_INSTALLS=""
  if ! [ -x "$(command -v xmllint)" ]
  then
    ADDITIONAL_INSTALLS="${ADDITIONAL_INSTALLS} libxml2-utils"
  else
    printf "have xmllint\n"
  fi

  if [ -n "${ADDITIONAL_INSTALLS}" ]
  then
    printf "This script requires the following unavailable libraries: %s\n" "${ADDITIONAL_INSTALLS}"
    printf "Please install them and then continue.\n"
    printf "%s\n" "${FAILURE_BOILERPLATE}"
    exit 1
  else
    printf "Additional requirements already satisfied.\n"
  fi
}

echo "Running in Github Actions container."
github_check
setup

echo "====== DEBUG ENV ====="

env
