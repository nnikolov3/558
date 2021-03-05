#!/usr/bin/python3.7
""" Date:Sun Feb 28 04:46:27 PM PST 2021
Author: nnikolov3 (GitHub)
purpose: Get all the readings from the sensor
"""

import paho.mqtt.client as mqtt
from time import sleep
import subprocess
import sys


# Print a welcoming message
print("Subscriber for DHT22 and Explorer Pro HAT")
print("==========================================")

# ---------------------------------------
# 10K pull up resistors
# And used the I2C
# ---------------------------------------


class const:
    """ Constants """

    HOST = "Penguin"
    KEEPALIVE = 60
    CLIENT = mqtt.Client()
    PORT = 1883


class Subscriber(object):
    """ Object to update and publish the data """

    @staticmethod
    def on_connect(CLIENT):
        # Subscribing in on_connect() means that if we lose the connection and
        # reconnect then subscriptions will be renewed.
        CLIENT.subscribe("$SYS/#")
        return

    @staticmethod
    def led1_on():
        print("led 1 on ... ")
        return subprocess.run(["./led1_on.py", "&"])

    @staticmethod
    def led1_off():
        print("led 1 off ... ")
        return subprocess.run(["./led1_off.py", "&"])

    @staticmethod
    def led2_on():
        print("led 2 on ... ")
        return subprocess.run(["./led2_on.py", "&"])

    @staticmethod
    def led2_off():
        print("led 2 off ... ")
        return subprocess.run(["./led2_off.py", "&"])

    @staticmethod
    def start_deamon():
        """ establish connection """

        CLIENT = const.CLIENT
        HOST = const.HOST
        PORT = const.PORT
        KEEPALIVE = const.KEEPALIVE
        # This only works if loop_start exist
        CLIENT.connect(HOST, PORT, KEEPALIVE)
        print("Connected")
        return

    # The callback for when a PUBLISH message is received from the server.
    def on_message(client, userdata, msg):
        print("Received payload")
        payload = str(msg.payload)
        if msg.topic == "led_1":
            if payload == "on":
                Subscriber.led_1_on()
            elif payload == "off":
                Subscriber.led_1_off()

        elif msg.topic == "led_2":

            if payload == "on":
                Subscriber.led_2_on()
            elif payload == "off":
                Subscriber.led_2_off()
        else:
            print("Unknown cmd")

        return


def main():

    # Callback for the led drivers
    const.CLIENT.loop_start()
    Subscriber.start_deamon()

    const.CLIENT.on_connect = Subscriber.on_connect(const.CLIENT)
    const.CLIENT.on_message = Subscriber.on_message
    const.CLIENT.loop_forever()
    while True:
        try:
            sleep(1.0)

        except RuntimeError as error:
            print(error)
            sys.exit(1)
            # Ctrl + C
        except KeyboardInterrupt:
            sys.exit(1)

            # Catches any other exceptions.
        except Exception:
            sys.exit(1)


if __name__ == "__main__":
    main()
