#!/usr/bin/bash

exec ../scripts/turn_led0_on.py &> /dev/null
# This will prevent of having mutliple
# calls to the same pin
exec kill -9 $(ps | grep led) &> /dev/null

exit 0
