# How to set up VNC

## Setup the VNC server

First, run the following commands to make sure you have the latest version:

`sudo apt-get update`
`sudo apt-get install realvnc-vnc-server`

If you’re already using an older version of VNC Server, restart it. 
If not, and you’re already booted into the graphical desktop, 
   select Menu > Preferences > Raspberry Pi Configuration > Interfaces and make sure VNC is set to Enabled.

Alternatively, run the command `sudo raspi-config` , navigate to Interfacing Options > VNC and select Yes.

Source: https://help.realvnc.com/hc/en-us/articles/360002249917-VNC-Connect-and-Raspberry-Pi#setting-up-your-raspberry-pi-0-0

## Download Remmina for your OS - I used a flatpak from here: https://flathub.org/apps/details/org.remmina.Remmina

## Connect to Raspberry Pi OS via VNC using Remmina

   ssh in the raspberry pi

   - `sudo vncpasswd -service`
        Update the password for the vnc
        I kept both (ssh and vnc) the same
   - `sudo nano /root/.vnc/config.d/vncserver-x11`

   - and add the following line at the end of the file: 
   - `Authentication=VncAuth`
   - `sudo systemctl restart vncserver-x11-serviced`

## Creating and remoting a virtual desktop

If your Raspberry Pi is headless (that is, not plugged into a monitor) or 
embedded in a robot, it’s unlikely to be running a graphical desktop.

VNC Server can run in Virtual Mode to create a resource-efficient virtual desktop on demand, 
giving you graphical remote access even when there is no actual desktop to remote. 
This virtual desktop exists only in your Raspberry Pi’s memory


On your Raspberry Pi, run the command `vncserver`.
Make a note of the IP address/display number printed to the console, for example `192.167.5.149:1`.
On the device you will use to take control, enter this information in VNC Viewer.

Example:

```text

pi@Penguin:~ $ vncserver
VNC(R) Server 6.7.2 (r42622) ARMv6 (May 13 2020 19:34:20)
Copyright (C) 2002-2020 RealVNC Ltd.
RealVNC and VNC are trademarks of RealVNC Ltd and are protected by trademark
registrations and/or pending trademark applications in the European Union,
United States of America and other jurisdictions.
Protected by UK patent 2481870; US patent 8760366; EU patent 2652951.
See https://www.realvnc.com for information on VNC.
For third party acknowledgements see:
https://www.realvnc.com/docs/6/foss.html
OS: Raspbian GNU/Linux 10, Linux 5.10.11, armv7l

Generating private key... done
xauth:  file /home/pi/.Xauthority does not exist
On some distributions (in particular Red Hat), you may get a better experience
by running vncserver-virtual in conjunction with the system Xorg server, rather
than the old version built-in to Xvnc. More desktop environments and
applications will likely be compatible. For more information on this alternative
implementation, please see: https://www.realvnc.com/doclink/kb-546

Running applications in /etc/vnc/xstartup

VNC Server catchphrase: "Quality insect magenta. Combat sushi mars."
             signature: bd-27-97-92-c3-94-4d-44

Log file is /home/pi/.vnc/Penguin:1.log
New desktop is Penguin:1 (10.0.0.198:1)
```
Note, when you connect to with Remmina to your VNC session do not add the `:1`

You can operate VNC Server exclusively at the command line or via SSH if you prefer.

Common commands for Raspberry Pi OS (previously called Raspbian) Jessie 
(which is based on Debian 8, and uses systemd) are:

- To start VNC Server now: `sudo systemctl start vncserver-x11-serviced.service`
- To start VNC Server at next boot, and every subsequent boot: `sudo systemctl enable vncserver-x11-serviced.service`
- To stop VNC Server: `sudo systemctl stop vncserver-x11-serviced.service`
- To prevent VNC Server starting at boot: `sudo systemctl disable vncserver-x11-serviced.service`

## Enabling SSH and VNC with raspi-config

- `sudo raspi-config`
-  Interface options
    - Enable VNC
    - Enable SSH



## Modifying the /boot/config.txt

In /boot/config.txt add:

    hdmi_force_hotplug
    hdmi_group 2
    hdmi_group 16 - this one you might need to modify based on your monitor
                    in my case I used 76 (2560 x 1600)



## Using key-based authentication

Link with information: https://www.raspberrypi.org/documentation/configuration/security.md
Thd link above will explain how to modify the user from pi to something else

More on ssh key : ssh-copy-id <USERNAME>@<IP-ADDRESS>

In your laptop type : https://www.raspberrypi.org/documentation/remote-access/ssh/passwordless.md#copy-your-public-key-to-your-raspberry-pi

- The most basic steps are: 

`ssh-keygen`

And then copy the key to the Raspberry Pi

`ssh-copy-id <USERNAME>@<IP-ADDRESS>`

After than you can ssh without typing your password every time


Example of successful VNC session:

(images/successful-vnc-session.png)


