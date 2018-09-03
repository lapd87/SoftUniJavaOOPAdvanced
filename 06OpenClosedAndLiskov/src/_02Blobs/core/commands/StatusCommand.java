package _02Blobs.core.commands;

import _02Blobs.annotations.Inject;
import _02Blobs.interfaces.Executable;
import _02Blobs.interfaces.Repository;
import _02Blobs.io.interfaces.Writer;
import _02Blobs.models.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:59 ч.
 */
public class StatusCommand implements Executable {


    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.blobRepository.findAll()
                .forEach(b -> this.writer.writeLine(b.toString()));
    }
}