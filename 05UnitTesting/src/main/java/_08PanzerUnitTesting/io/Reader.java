package _08PanzerUnitTesting.io;

import _08PanzerUnitTesting.contracts.InputReader;

import java.util.Scanner;

public class Reader implements InputReader {
    private Scanner skener;

    public Reader() {
        this.skener =new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return skener.nextLine();
    }
}
