#!/usr/bin/python3.7
""" Date:Sun Feb 28 04:46:27 PM PST 2021
Author: nnikolov3 (GitHub)
purpose: Get all the readings from the sensor
"""

import paho.mqtt.client as mqtt
from time import sleep
from datetime import datetime
import adafruit_dht
from ISStreamer.Streamer import Streamer
import board
import socket

# stamp
NOW = datetime.now()
DATE = str(NOW).split(".")

# Print a welcoming message
print("Client for DHT22 and Explorer Pro HAT")
print("==========================================")

# ---------------------------------------
# 10K pull up resistors
# And used the I2C
# ---------------------------------------


class constants:
    """ Constants """

    HOST = socket.gethostname()
    KEEPALIVE = 60
    CLIENT = mqtt.Client()
    DEVICE = adafruit_dht.DHT22(board.D3)
    PORT = 1883


class Publisher(object):
    """ Object to update and publish the data """

    @staticmethod
    def on_connect(CLIENT):
        # Subscribing in on_connect() means that if we lose the connection and
        # reconnect then subscriptions will be renewed.
        CLIENT.subscribe("$SYS/#")
        return

    @staticmethod
    def publish_to_cloud(_date, _temp_f, _temp_c, _humidity):
        """Using the service stream to log the data on the cloud"""
        print("Logging data to Initial State Account")

        B_KEY = "8MVMYVW8D9XN"
        A_KEY = "ist_JtPyZAci_C-lCO0cxFT4YxrDfjJP00oU"
        B_NAME = "dht22"
        streamer = Streamer(bucket_name=B_NAME, bucket_key=B_KEY, access_key=A_KEY)
        streamer.log("TEMP_C ", _temp_c)
        sleep(0.5)
        streamer.log("TEMP_F ", _temp_f)
        sleep(0.5)
        streamer.log("HUMID ", _humidity)
        sleep(0.5)
        streamer.flush()
        print("==========================================")
        return True

    @staticmethod
    def publish_mqtt(_data):
        """ Publish sensor data to topic SENSOR """
        try:
            CLIENT = constants.CLIENT
            # method returns a tuple (result, mid)
            CLIENT.publish("TEMP_F", _data[1])
            print("Topic: TEMP_F " + str(_data[1]))
            CLIENT.publish("TEMP_C", _data[2])
            print("Topic: TEMP_C " + str(_data[2]))
            CLIENT.publish("HUMID", _data[3])
            print("Topic: HUMID " + str(_data[3]))
            print("Published to MQTT")
            print("==========================================")
            return True
        except RuntimeError:
            print("Error: Could not publish to mqtt")
            pass

        return False

    # ---------------------------------------

    @staticmethod
    def create_payload():
        """ Get the readings from the sensor """
        sleep(2.0)
        DEVICE = constants.DEVICE
        NOW2 = datetime.now()
        DATE2 = str(NOW2).split(".")
        TEMPERATURE_C = round(DEVICE.temperature, 2)
        TEMPERATURE_F = round(TEMPERATURE_C * (9 / 5) + 32, 2)
        HUMIDITY = round(DEVICE.humidity, 3)
        if TEMPERATURE_F:
            DATA = [DATE2[0], TEMPERATURE_F, TEMPERATURE_C, HUMIDITY]
        else:
            print("Error: No data")
            print("==========================================")
            exit(1)
        # ---------------------------------------
        try:
            if len(DATA) > 0:
                return DATA
        except RuntimeError:
            print("Error: No data")
            print("==========================================")
            exit(1)

        print("Error: Payload was not created")
        print("==========================================")
        return False

    # ---------------------------------------

    @staticmethod
    def start_deamon():
        """ establish connection """

        CLIENT = constants.CLIENT
        HOST = constants.HOST
        PORT = constants.PORT
        KEEPALIVE = constants.KEEPALIVE
        # -----------------
        CLIENT.connect(HOST, PORT, KEEPALIVE)
        print("Connected")
        print("==========================================")
        return True

    # ---------------------------------------
    @staticmethod
    def publisher_worker():
        """ Gather data and publish it """
        DATA = Publisher.create_payload()
        if len(DATA) > 0:
            print("Payload Created")
            print("==========================================")
            sleep(2)
            Publisher.publish_to_cloud(DATA[0], DATA[1], DATA[2], DATA[3])
            sleep(2)
            Publisher.publish_mqtt(DATA)
            print("Published ... OK")
            print("==========================================")
            sleep(6)
            return True
        else:
            print("Failed to publish")
            print("==========================================")
            exit(2)

        return False

    # ---------------------------------------

    @staticmethod
    def publish():
        is_published = Publisher.publisher_worker()
        if is_published is True:
            print("Success")
            print("==========================================")
            return True

        else:
            print("Failed")
            print("==========================================")
            exit(1)

        return False


# ---------------------------------------
# ---------------------------------------
# ---------------------------------------


def main():

    constants.CLIENT.loop_start()
    Publisher.start_deamon()
    constants.CLIENT.on_connect = Publisher.on_connect(constants.CLIENT)
    while True:
        sleep(3.0)
        try:
            Publisher.publish()
            sleep(10.0)

        except RuntimeError as error:
            print(error)
            sleep(5.0)
            continue

        # Ctrl + C
        except KeyboardInterrupt:
            print("Keyboard Interrupt: Aborting")
            exit(1)

    return


if __name__ == "__main__":
    main()

# ---------------------------------------
