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

# stamp
NOW = datetime.now()
DATE = str(NOW).split(".")

# Print a welcoming message
print("Publisher for DHT22 and Explorer Pro HAT")
print("==========================================")

# ---------------------------------------
# 10K pull up resistors
# And used the I2C
# ---------------------------------------


class constants:
    """ Constants """

    BUCKET_KEY = "UNRVD4Y88Y59"
    ACCESS_KEY = "ist_JtPyZAci_C-lCO0cxFT4YxrDfjJP00oU"
    BUCKET_NAME = "sensor"
    HOST = "Penguin"
    KEEPALIVE = 60
    STREAMER = Streamer()
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

        STREAMER = constants.STREAMER
        STREAMER.log("DATE", _date)
        STREAMER.log("TEMP_C ", _temp_c)
        STREAMER.log("TEMP_F ", _temp_f)
        STREAMER.log("HUMID ", _humidity)
        STREAMER.flush()
        print("Published to Cloud ...")
        return

    @staticmethod
    def publish_mqtt(_data):
        """ Publish sensor data to topic SENSOR """

        CLIENT = constants.CLIENT
        # method returns a tuple (result, mid)
        CLIENT.publish("TEMP_F", _data[1])
        CLIENT.publish("TEMP_C", _data[2])
        CLIENT.publish("HUMID", _data[3])
        print("Published to MQTT")
        return

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
        DATA = [DATE2[0], TEMPERATURE_F, TEMPERATURE_C, HUMIDITY]
        # ---------------------------------------
        print("Created Payload")
        return DATA

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
        return

    @staticmethod
    def publisher_worker():
        """ Gather data and publish it """
        DATA = Publisher.create_payload()
        Publisher.publish_to_cloud(DATA[0], DATA[1], DATA[2], DATA[3])
        Publisher.publish_mqtt(DATA)
        print("Published ... OK")
        return

    @staticmethod
    def publish():
        is_published = Publisher.publisher_worker()
        print(is_published)
        return


def main():

    constants.CLIENT.loop_start()
    Publisher.start_deamon()

    constants.CLIENT.on_connect = Publisher.on_connect(constants.CLIENT)
    while True:

        sleep(3.0)
        try:
            Publisher.publish()
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
