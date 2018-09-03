package _005SecurityDoor.models;


import _005SecurityDoor.io.interfaces.Reader;
import _005SecurityDoor.io.interfaces.Writer;

public class SecurityManager {

    private KeyCardCheck keyCardCheck;
    private PinCodeCheck pinCodeCheck;
    private Reader reader;
    private Writer writer;

    public SecurityManager(KeyCardCheck keyCardCheck,
                           PinCodeCheck pinCodeCheck,
                           Reader reader,
                           Writer writer) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
        this.reader = reader;
        this.writer = writer;
    }

    public void check() {
        int option = Integer.parseInt(reader.readLine());

        switch (option) {
            case 1:
                writer.writeLine(String
                        .valueOf(keyCardCheck.validateUser()));
                break;
            case 2:
                writer.writeLine(String
                        .valueOf(pinCodeCheck.validateUser()));
                break;
        }
    }
}
