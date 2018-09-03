package _02Blobs.core.commands;

import _02Blobs.annotations.Inject;
import _02Blobs.factories.AttackFactory;
import _02Blobs.factories.BehaviorFactory;
import _02Blobs.factories.BlobFactory;
import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.interfaces.Executable;
import _02Blobs.interfaces.Repository;
import _02Blobs.models.Blob;
import _02Blobs.observers.Subject;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:59 ч.
 */
public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Override
    public void execute() {
        String name = data[0];
        int health = Integer.parseInt(data[1]);
        int damage = Integer.parseInt(data[2]);
        Behavior behavior = BehaviorFactory.create(data[3]);
        Attack attack = AttackFactory.create(data[4]);

        Blob blob = BlobFactory.create(name, health, damage,
                behavior, attack, subject);

        this.blobRepository.add(blob);
    }
}