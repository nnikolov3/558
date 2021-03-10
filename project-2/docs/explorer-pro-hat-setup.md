# Setting up the pimoroni explorer pro hat 

## Getting the software set up

- ssh in the Raspberry Pi

- execute the commands bellow

    ``` bash
    sudo apt-get update
    sudo apt-get upgrade

    curl https://get.pimoroni.com/i2c | bash
    sudo apt-get install python-smbus
    sudo apt-get install python-pip
    sudo pip install explorerhat

    ```

Next, you'll want to plug your Explorer HAT Pro into 
the 40 pin GPIO connector on your Raspberry Pi.
Ensure the HAT fits fully on the Raspberry Pi.
You can check it's working by typing the following straight in the terminal:
    
    ```bash
    python -c 'import time, explorerhat; explorerhat.light.on(); time.sleep(1); explorerhat.light.off()'

    ```

The board should blink the 4 LEDs.
