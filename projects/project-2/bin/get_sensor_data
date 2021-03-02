#!/usr/bin/bash

# Get current path

# Does the script exist?

if test -f "../scripts/get_sensor_data.py"; then
    exec ../scripts/get_sensor_data.py
else
    echo "File not found"
    exit 1
fi

# Cleanup
kill -9 $(ps | grep get_sensor_data) &> /dev/null
kill -9 $(ps | grep libgpiod_pulsei) &> /dev/null

exit 0
