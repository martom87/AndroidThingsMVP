package com.example.marcinek.androidthingsmvp;

import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class LedFactory {

    public Gpio led;
    public PeripheralManager manager = PeripheralManager.getInstance();




    public Gpio createLed(String gpioAdress, String gpioDirection) {
        if (gpioDirection == "low") {
            led = makeLowLed(gpioAdress);
        } else if (gpioDirection == "high") {
            led = makeHighLed(gpioAdress);
        } else {
            //TODO error messsage
        }

        return led;
    }

    public Gpio makeLowLed(String gpioAdress) {
        try {
            led = manager.openGpio(gpioAdress);
            led.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            Log.w(TAG, "Unable to access GPIO", e);
        }
        return led;
    }


    public Gpio makeHighLed(String gpioAdress) {
        try {
            led = manager.openGpio(gpioAdress);
            led.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
        } catch (IOException e) {
            Log.w(TAG, "Unable to access GPIO", e);
        }
        return led;
    }


}
