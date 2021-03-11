#!/usr/bin/python3
# -----------------------------
# Date: Mon March 1 13:34
# Author: nnikolov3 (GitHub)
# Purpose: Turn LED 0 ON (not the one on
# Explorer HAT
# -----------------------------

from time import sleep
import explorerhat as HAT
import RPi.GPIO as GPIO
import sys
import subprocess


# Toggle
def turn_on_led2():
    while True:
        try:
            HAT.output.two.on()
            sleep(360.0)

        # Ctrl-C
        except KeyboardInterrupt:
            sys.exit(1)

        # Anything else
        except Exception:
            sys.exit(1)

        finally:
            GPIO.cleanup()
            sys.exit(1)


def main():
    # if the led is on and the process runs in the background
    subprocess.run(["kill", "-9", "$(ps | grep led1_on.py |  awk '$0')"])
    # Ensure everything is stopped before we turn it on
    HAT.output.two.stop()
    turn_on_led2()


if __name__ == "__main__":
    # execute only if run as a script
    main()
