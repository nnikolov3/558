#!/usr/bin/python3
# -----------------------------
# Date:Sun Feb 28 04:46:27 PM PST 2021
# Author: nnikolov3 (GitHub)
# Purpose: Get all the readings from the sensor
# -----------------------------

# -----------------------------
# Import libraries
# -----------------------------
import adafruit_dht
import paho.mqtt.client as paho
import explorerhat as HAT
import RPi.GPIO as GPIO
import board
import time
from datetime import datetime
from ISStreamer.Streamer import Streamer
# -----------------------------

# -----------------------------
# current date and time
# Might not be necessary since the
# the broker already has a time
# stamp
# -----------------------------
now = datetime.now()
date = str(now).split(".")

# -----------------------------
broker = "10.0.0.198"
port = 1883
# -----------------------------
# Print a welcoming message
# -----------------------------
print("""
# -----------------------------

This Python code is for reporting on the
value of two DH22 sensors".

Assumptions: a Raspberry Pi with the Pimoroni
ExplorerHat Pro software and hardware.  See

  - https://shop.pimoroni.com/products/explorer-hat
  - https://github.com/pimoroni/explorer-hat
# -----------------------------
  """)

# you can pass DHT22 use_pulseio=False if you
# wouldn't like to use pulseio.
# This may be necessary on a Linux single
# board computer like the Raspberry Pi,
# but it will not work in CircuitPython.
# dhtDevice = adafruit_dht.DHT22(board.D18, use_pulseio=False)

# ---------------------------------------
# 10K pull up resistors
# And used the I2C
# ---------------------------------------
dhtDevice1 = adafruit_dht.DHT22(board.D3)
# ---------------------------------------
# Sleep 5 seconds during startup

# Using the service stream to log the data online
def publish(date, temperature_f, temperature_c, humidity):
    if date & & temperature_c & & temperature_f & & humidity:
        istreamer.log("Date:" + " ", date)
        istreamer.log("Temp(C):" + " ", temperature_c)
        istreamer.log("Temp(F):" + " ", temperature_f)
        istreamer.log("Humidity:" + " ", humidity)


client1 = paho.Client("control1")  # create client object
client1.on_publish = on_publish  # assign function to callback
client1.connect(broker, port)  # establish connection
ret = client1.publish("house/bulb1", "on")  # publish

time.sleep(5.0)
try:
    while True:
        # Sleep between each iteration
        time.sleep(1.0)
        # ---------------------------------------
        try:
            # ---------------------------------------
            now = datetime.now()
            date = str(now).split(".")
            temperature_c = round(dhtDevice1.temperature, 2)
            # ---------------------------------------
            temperature_f = round(temperature_c * (9 / 5) + 32, 2)
            humidity = round(dhtDevice1.humidity, 2)
            data = []
            data = [date[0], temperature_f, temperature_c, humidity]
            # ---------------------------------------
            # If we get successfully a reading
            # Sleep one minute
            time.sleep(60)

            # ---------------------------------------

        except RuntimeError as error:
            # Errors happen fairly often, DHT's are hard to read, just keep going
            time.sleep(5.0)
            continue

        # ---------------------------------------
        except Exception as error:
            time.sleep(2.0)

## Ctrl + C
except KeyboardInterrupt:
    pass

# Catches any other exceptions.
except Exception:
    pass

# Clean up GPIO before exit.
finally:
    GPIO.cleanup()
