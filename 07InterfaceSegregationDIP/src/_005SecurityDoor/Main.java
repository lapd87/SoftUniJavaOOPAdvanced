package _005SecurityDoor;

import _005SecurityDoor.contracts.SecurityUI;
import _005SecurityDoor.io.impl.ConsoleReader;
import _005SecurityDoor.io.impl.ConsoleWriter;
import _005SecurityDoor.io.interfaces.Reader;
import _005SecurityDoor.io.interfaces.Writer;
import _005SecurityDoor.models.KeyCardCheck;
import _005SecurityDoor.models.PinCodeCheck;
import _005SecurityDoor.models.ScannerUI;
import _005SecurityDoor.models.SecurityManager;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 14:05 ч.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        SecurityUI scannerUI = new ScannerUI(reader, writer);

        KeyCardCheck keyCardCheck = new KeyCardCheck(scannerUI);
        PinCodeCheck pinCodeCheck = new PinCodeCheck(scannerUI);

        SecurityManager manager = new SecurityManager(keyCardCheck,
                pinCodeCheck, reader, writer);

        manager.check();
    }
}