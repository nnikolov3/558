#!/usr/bin/python3
# -----------------------------
# Date: Mon March 1 13:34
# Author: nnikolov3 (GitHub)
# Purpose: Turn LED 0 ON (not the one on
# Explorer HAT
# -----------------------------

import time
import explorerhat as HAT
import RPi.GPIO as GPIO
# Make sure everything is stopped
HAT.output.one.stop()
# Turn on LED 0
try:
    while True:
        HAT.output.one.on()
    time.sleep(3600)

except KeyboardInterrupt:
    pass

# Catches any other exceptions.
except Exception:
    pass

finally:
    GPIO.cleanup()
