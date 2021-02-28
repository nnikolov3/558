# Setting up Mosquitto

- Install software-properties-common
`sudo apt-get install software-properties-common`

- Update OS
`sudo apt-get update`

- Install the Mosquitto Library
`sudo apt-get install moquitto`

- Install the client library
`sudo apt-get install mosquitto-clients`

- Check the status of the server
`sudo service mosquitto status`

Example output:
```text

pi@Penguin:~ $ sudo service mosquitto status
● mosquitto.service - Mosquitto MQTT v3.1/v3.1.1 Broker
Loaded: loaded (/lib/systemd/system/mosquitto.service; enabled; vendor preset: enabled)
Active: active (running) since Sun 2021-02-28 11:54:51 PST; 3min 57s ago
Docs: man:mosquitto.conf(5)
man:mosquitto(8)
Main PID: 4029 (mosquitto)
Tasks: 1 (limit: 4915)
CGroup: /system.slice/mosquitto.service
└─4029 /usr/sbin/mosquitto -c /etc/mosquitto/mosquitto.conf

Feb 28 11:54:51 Penguin systemd[1]: Starting Mosquitto MQTT v3.1/v3.1.1 Broker...
Feb 28 11:54:51 Penguin systemd[1]: Started Mosquitto MQTT v3.1/v3.1.1 Broker.
pi@Penguin:~ $

```
- Check if Mosquitto is listenning the default server
    `netstat -an | grep 1883`

Example output:

```
pi@Penguin:~ $ netstat -an | grep 1883
tcp        0      0 0.0.0.0:1883            0.0.0.0:*               LISTEN     
tcp6       0      0 :::1883                 :::*                    LISTEN     
pi@Penguin:~ $ 

```


