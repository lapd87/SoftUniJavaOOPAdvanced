package _08PanzerUnitTesting.io;

import _08PanzerUnitTesting.contracts.OutputWriter;

public class Writer implements OutputWriter {
    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}