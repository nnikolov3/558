# Setting up the Raspberry Pi

## Original Settings
- Raspberry Pi OS : Raspberry Pi OS with desktop 
Link: https://www.raspberrypi.org/software/operating-systems/#raspberry-pi-os-32-bit

## Pre-reqs

### What you’ll need

    - microSD card (4GB minimum, 8GB recommended)
    - computer with a microSD card drive
    - Raspberry Pi 2, 3 or 4
    - micro-USB power cable (USB-C for the Pi 4)
    - Wi-Fi network or an ethernet cable with an internet connection

## Implementation 
    
    Raspberry Pi official link : https://projects.raspberrypi.org/en/projects/raspberry-pi-setting-up/2

    1) I used Raspberry Pi Imager, however Fedora Silverblue supports flatpack. I installed the Raspberry Pi Image from flathub.

    Link: https://flathub.org/apps/details/org.raspberrypi.rpi-imager

    2) Used the Raspberry Pi Imager to download and write to the SD card 
    3) Setting up the Raspberry Pi to connect to the Wi-Fi
    
    Notes:

    - In order to pick up the Wi-Fi need to create an empty ssh in the boot directory
    after writing the OS to the SD card
    - Create a file in boot directory wpa_supplicant.conf

    Should look something like this:

    ```shell

    country=US
    ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
    update_config=1

    network={
        ssid="<name of wifi>"
            psk="<your wifi password"
    }
    
    ```

    4) Remove the SD card and boot the Raspberry Pi
    5) To ssh

        ```bash
        ssh pi@raspberrypi.local
        ```

    6) Modify host and password with `sudo raspi-config`


