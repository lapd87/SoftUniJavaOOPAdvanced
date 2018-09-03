package _005SecurityDoor.models;

import _005SecurityDoor.contracts.SecurityUI;
import _005SecurityDoor.io.interfaces.Reader;
import _005SecurityDoor.io.interfaces.Writer;

public class ScannerUI implements SecurityUI {

    private Reader reader;
    private Writer writer;

    public ScannerUI(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public String requestKeyCard() {
        this.writer.writeLine("slide your key card");
        return this.reader.readLine();
    }

    @Override
    public int requestPinCode() {
        this.writer.writeLine("enter your pin code");
        return Integer.parseInt(this.reader.readLine());
    }
}
