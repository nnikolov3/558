# Useful commands

- Find the IP address of Raspberry Pi
    `hostname -I`

- Find the status of the mosquitto service
    `service mosquitto status`

- MQTT client that publishes a message to the topic
    `moquitto_pub -V mqttv311 -t <topic> -m "<message>"
