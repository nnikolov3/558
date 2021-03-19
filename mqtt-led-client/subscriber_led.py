#!/usr/bin/python3.7
""" Date:Sun Feb 28 04:46:27 PM PST 2021
Author: nnikolov3 (GitHub)
purpose: Get all the readings from the sensor
"""

import paho.mqtt.client as mqtt
import re

import explorerhat as HAT

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
        CLIENT.subscribe("led1")
        CLIENT.subscribe("led2")
        return

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
        print("-------------------------------")
        return

    @staticmethod
    def on_subscribe(CLIENT, userdata, mid, granted_qos):
        print("Subscribed")
        print("-------------------------------")
        return

    @staticmethod
    def on_message_led1(CLIENT, userdata, msg):
        payload = str(msg.payload)

        if payload:
            print("Payload received")
            print("-------------------------------")

        is_on = re.compile("ON")
        is_off = re.compile("OFF")

        print("TOPIC: LED1 ...")
        print("-------------------------------")
        if is_on.search(payload) or is_off.search(payload):
            print("LED 1 TOGGLE!")
            HAT.output.one.toggle()
            print("-------------------------------")

    @staticmethod
    def on_message_led2(CLIENT, userdata, msg):

        payload = str(msg.payload)

        if payload:
            print("Payload received")
            print("-------------------------------")

        is_on = re.compile("ON")
        is_off = re.compile("OFF")
        print("LED 2 ...")
        print("-------------------------------")
        if is_on.search(payload) or is_off.search(payload):
            print("LED 2 TOGGLE!")
            print("-------------------------------")
            HAT.output.two.toggle()


def main():

    # Callback for the led drivers
    Subscriber.start_deamon()
    const.CLIENT.loop_start()
    const.CLIENT.on_connect = Subscriber.on_connect(const.CLIENT)
    const.CLIENT.on_subscribe = Subscriber.on_subscribe
    const.CLIENT.message_callback_add("led1", Subscriber.on_message_led1)
    const.CLIENT.message_callback_add("led2", Subscriber.on_message_led2)

    const.CLIENT.loop_forever()


if __name__ == "__main__":
    main()
