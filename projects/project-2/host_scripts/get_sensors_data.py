#!/usr/bin/env python3
# -----------------------------
# File: read_sensors.py
# Author: nnikolov3 (GitHub)
# Date:Sun Feb 28 04:46:27 PM PST 2021
# -----------------------------

import adafruit_dht
import time
import explorerhat as HAT
import board
import json
from datetime import datetime

# current date and time
now = datetime.now()
date = str(now).split(".")
print("timestamp =", date[0])
print("""

This Python code is for reporting on the
value of two DH22 sensors".

Assumptions: a Raspberry Pi with the Pimoroni
ExplorerHat Pro software and hardware.  See

  - https://shop.pimoroni.com/products/explorer-hat
  - https://github.com/pimoroni/explorer-hat
  """)

# you can pass DHT22 use_pulseio=False if you
# wouldn't like to use pulseio.
# This may be necessary on a Linux single
# board computer like the Raspberry Pi,
# but it will not work in CircuitPython.
# dhtDevice = adafruit_dht.DHT22(board.D18, use_pulseio=False)

# ---------------------------------------
# Used pull down resistors
# And used the I2C
# ---------------------------------------
dhtDevice1 = adafruit_dht.DHT22(board.D3)
# ---------------------------------------
while True:
    # ---------------------------------------
    try:
        # ---------------------------------------
        now = datetime.now()
        date = str(now).split(".")
        temperature_c = round(dhtDevice1.temperature, 2)
        temperature_f = round(temperature_c * (9 / 5) + 32, 2)
        humidity = round(dhtDevice1.humidity, 2)
        data = [date[0], temperature_f, temperature_c, humidity]
        print(data[0], data[1])
        time.sleep(5.0)
    except RuntimeError as error:
        # Errors happen fairly often, DHT's are hard to read, just keep going
        time.sleep(5.0)
        continue
        timestamp = datetime.timestamp(now)

    # ---------------------------------------
    except Exception as error:
        time.sleep(2.0)
