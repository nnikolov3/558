#!/usr/bin/bash

exec ../scripts/turn_led0_on.py
# This will prevent of having mutltiple turn on
# all at once
exec kill -9 $(ps | grep led) &> /dev/null

exit 0
