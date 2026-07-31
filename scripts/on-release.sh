#!/usr/bin/env bash

echo "Starting ${0}"

if [ -z "${GITHUB_ACTIONS}" ]
then
  echo "This script can only be run in a Github action container."
  echo "Local runs are not yet supported."
  exit 1
fi
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
PROJECT_DIR="${SCRIPT_DIR}/.."
CHANGELOG_PATH="${PROJECT_DIR}/CHANGELOG.md"
RELEASE_NUM=""
NEXT_RELEASE_NUM=""
NEXT_RELEASE_BRANCH_BASE="chore/prepare-next-release-"
RC_OR_BETA=false
IS_SNAPSHOT=false

FAILURE_BOILERPLATE="Please delete the tag ${CIRCLE_TAG} and the related release, and start again."

github_check(){

  if [ "${GITHUB_EVENT_NAME}" == "workflow_dispatch" ]; then
    echo "WARNING: This script is targeted for 'release' not ${GITHUB_EVENT_NAME}."
    echo "Continuing for debugging."
    return
  fi

  if [ "${GITHUB_EVENT_NAME}" == "push" ]; then
    echo "WARNING: this script is targeted for 'release' not ${GITHUB_EVENT_NAME}"
    echo " Checking env"
    env
    exit 1
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

set_release_number(){
    RELEASE_NUM=$(echo ${RELEASE_TAG_NAME} | sed -r "s/-(rc|beta)[0-9]+//" | sed -r "s/^v//")
}

verify_rc_or_beta(){
  if [  -n "$(echo ${RELEASE_TAG_NAME} | grep -E "rc|beta")" ]
  then
    RC_OR_BETA=true
  fi
}

verify_changelog() {

  CHANGELOG_RELEASE_HEADERS=$(sed -n '/^#.*[0-9].[0-9]*.[0-9].*/p' "${CHANGELOG_PATH}")

  mapfile -t HEADER_ARRAY <<< "$CHANGELOG_RELEASE_HEADERS"

  mapfile -td ' ' HEADER_LINE <<< "${HEADER_ARRAY[0]}"

  HEADER_TAG="${HEADER_LINE[1]}"
  HEADER_DATE="${HEADER_LINE[2]:1:-2}"

  if [ "$HEADER_TAG" != "$RELEASE_NUM"  ]; then
    printf "ERROR: Latest HEADER_TAG in CHANGELOG.md (%s) does not match release number (%s) from git tag (%s)\n" \
    "$HEADER_TAG" \
    "$RELEASE_NUM" \
    "$RELEASE_TAG_NAME"
    printf "Please update the latest HEADER_TAG in CHANGELOG.md\n"
    printf "%s" "${FAILURE_BOILERPLATE}"
    exit 1
  else
    printf "CHANGELOG.md release number check: OK ✓\n"
  fi

  if [[ ! "$HEADER_DATE" =~ ^[0-9]{4}-[0-9]{2}-[0-9]{2}$ ]]; then
    printf "ERROR invalid commit date (%s) in last CHANGELOG.md entry\n" "$HEADER_DATE"
    printf "Please update the commit date in CHANGELOG.md\n"
    printf "%s\n" "${FAILURE_BOILERPLATE}"
    exit 1
  else
    printf "CHANGELOG.md release date check: OK ✓\n"
  fi
}

echo "Running in Github Actions container."

github_check

verify_rc_or_beta
set_release_number

verify_changelog

setup

echo "====== DEBUG ENV ====="

env
