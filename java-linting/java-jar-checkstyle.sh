#!/usr/bin/bash

filename="$1"
extension="${filename##*.}"
if [ "$extension" == "java" ]; then
    java -jar "$HOME"/checkstyle-8.41-all.jar -c "$HOME"/google_checks.xml
else
    echo "Pass ..."
fi
exit 0
