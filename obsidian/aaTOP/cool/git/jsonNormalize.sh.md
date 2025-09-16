#!/bin/bash
# loop through all files calling pretty printer. IF the resulting file is zero bytes, say as much and exit early.
#
#
# Changes:
# 2020-03-10 (MAF):
#   There are now three ways to use this script:
#
#   1) Default behavior with no arguments finds all JSON files in the project and normalizes each one.
#
#   2) One or more file paths provided as arguments will each be normalized.
#
#   3) An argument of -- will cause this script to read from stdin and normalize each file path provided.
#      (One file path per line.)
#
SCRIPT="${0}"
DIR_SCRIPT="$(dirname "${SCRIPT}")"
JQ_SCRIPT="${DIR_SCRIPT}/../bin/jq-linux64"

if [[ "$OSTYPE" == "darwin"* ]]; then
    JQ_SCRIPT="${DIR_SCRIPT}/../bin/jq-osx-amd64"
fi

#echo "Using executable: ${JQ_SCRIPT}"

normalizeFile() {
    file="${1}"
    case "${file}" in *.json)
        if [ -f "${file}" ]
        then
          echo "Executing: ${JQ_SCRIPT} -e --indent 4 -S '.' \"$file\" > \"$file.tmp\""
          ${JQ_SCRIPT} -e --indent 4 -S '.' "${file}" > "${file}.tmp" || exit 1;
          [[ ! -s "${file}.tmp" ]] && echo "$file.tmp appears corrupt, exiting early!" && exit 1;
          mv "${file}.tmp" "${file}"
        else
          echo "Skipping ${file}, which no longer exists."
        fi
        git add "${file}"
        ;;
    esac
}

if [ $# -gt 0 ]
then
    if [ "${1}" == "--" ]
    then
        # List of paths provided via stdin, one file per line.
        while read file
        do
            normalizeFile "${file}"
        done
    else
        # List of paths provided as arguments, one file per argument.
        while [ $# -gt 0 ]
        do
            normalizeFile "${1}"
            shift
        done
    fi
else
    # Default behavior: Search for all JSON files in project.
    find . -not -path "**/target/*" -iname "*.json" | while read file
    do
        normalizeFile "${file}"
    done
fi

##for file in $(find . -not -path "**/target/*" -iname "*.json"); do
##    echo "Executing: ${JQ_SCRIPT} -e --indent 4 -S '.' \"$file\" > \"$file.tmp\""
##    ${JQ_SCRIPT} -e --indent 4 -S '.' "${file}" > "${file}.tmp" || exit 1;
##    [[ ! -s "${file}.tmp" ]] && echo "$file.tmp appears corrupt, exiting early!" && exit 1;
##    mv "${file}.tmp" "${file}"
##    git add "${file}"
##done
