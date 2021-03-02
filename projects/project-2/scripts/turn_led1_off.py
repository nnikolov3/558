#!/usr/bin/python3
# -----------------------------
# Date: Mon March 1 13:34
# Author: nnikolov3 (GitHub)
# Purpose: Turn LED 0 OFF (not the one on
# Explorer HAT
# -----------------------------

import time
import explorerhat as HAT
import RPi.GPIO as GPIO

# Make sure everything is stopped
HAT.output.one.stop()
# Turn off LED 1

try:
    HAT.output.two.off()
except KeyboardInterrupt:
    pass

# Catches any other exceptions.

except Exception:
    pass

# Clean up GPIO before exit.
finally:
    GPIO.cleanup()
