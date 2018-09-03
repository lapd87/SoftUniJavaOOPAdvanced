package _02Blobs.core.commands;

import _02Blobs.annotations.Inject;
import _02Blobs.interfaces.Executable;
import _02Blobs.interfaces.Repository;
import _02Blobs.models.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:59 ч.
 */
public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Override
    public void execute() {
        Blob attacker = this.blobRepository
                .getByName(data[0]);
        Blob target = this.blobRepository
                .getByName(data[1]);

        attacker.attack(target);
    }
}