package _02Blobs;

import _02Blobs.core.Engine;
import _02Blobs.interfaces.Repository;
import _02Blobs.interfaces.Runnable;
import _02Blobs.io.impl.ConsoleReader;
import _02Blobs.io.impl.ConsoleWriter;
import _02Blobs.io.interfaces.Reader;
import _02Blobs.io.interfaces.Writer;
import _02Blobs.models.Blob;
import _02Blobs.observers.Subject;
import _02Blobs.repositories.BlobRepo;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 13:52 ч.
 */
public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Repository<Blob> blobRepository = new BlobRepo();
        Subject subject = new Subject();

        Runnable engine = new Engine(reader, writer,
                blobRepository, subject);

        engine.run();
    }
}