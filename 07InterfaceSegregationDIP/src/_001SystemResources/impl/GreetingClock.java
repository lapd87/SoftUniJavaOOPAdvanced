package _001SystemResources.impl;

import _001SystemResources.interfaces.GreetingDevice;
import _001SystemResources.interfaces.TimeProvider;
import _001SystemResources.io.interfaces.Writer;

public class GreetingClock implements GreetingDevice {

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (time.getCurrentHour() < 12) {
            writer.writeLine("Good morning...");
        } else if (time.getCurrentHour() < 18) {
            writer.writeLine("Good afternoon...");
        } else {
            writer.writeLine("Good evening...");
        }
    }
}
