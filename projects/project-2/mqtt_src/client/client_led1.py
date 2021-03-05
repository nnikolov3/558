#!/usr/bin/python3.7
""" Date:Sun Feb 28 04:46:27 PM PST 2021
Author: nnikolov3 (GitHub)
purpose: Get all the readings from the sensor
"""

import paho.mqtt.client as mqtt
from time import sleep
import adafruit_dht
import board
import subprocess

# Print a welcoming message
print("Client for DHT22 and Explorer Pro HAT")
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
    DEVICE = adafruit_dht.DHT22(board.D3)
    PORT = 1883


class Client(object):
    """ Object to update and publish the data """

    @staticmethod
    def on_connect(CLIENT):
        # Subscribing in on_connect() means that if we lose the connection and
        # reconnect then subscriptions will be renewed.
        CLIENT.subscribe("$SYS/#")
        return

    @staticmethod
    def led1_callback():
        subprocess.run(["../", "-l", "/dev/null"], capture_output=True)

    def led2_callback():
        subprocess.run(["../", "-l", "/dev/null"], capture_output=True)

    @staticmethod
    def start_deamon():
        """ establish connection """

        CLIENT = const.CLIENT
        HOST = const.HOST
        PORT = const.PORT
        KEEPALIVE = const.KEEPALIVE
        # -----------------
        CLIENT.connect(HOST, PORT, KEEPALIVE)
        print("Connected")
        return

    return


def main():

    const.CLIENT.loop_start()
    Client.start_deamon()
    const.CLIENT.on_connect() = Client.on_connect(const.CLIENT)

    while True:
        sleep(3.0)

        try:
            sleep(3.0)

        except RuntimeError as error:
            print(error)
            sleep(5.0)
            continue

            # Ctrl + C
        except KeyboardInterrupt:
            pass

            # Catches any other exceptions.
        except Exception:
            pass

    return False


if __name__ == "__main__":
    main()
