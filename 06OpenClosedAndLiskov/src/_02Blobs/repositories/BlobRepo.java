package _02Blobs.repositories;

import _02Blobs.interfaces.Repository;
import _02Blobs.models.Blob;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:00 ч.
 */
public class BlobRepo implements Repository<Blob> {

    private Map<String, Blob> blobs;

    public BlobRepo() {
        blobs = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob blob) {
        this.blobs.putIfAbsent(blob.getName(), blob);
    }

    @Override
    public Blob getByName(String name) {
        return this.blobs.get(name);
    }

    @Override
    public Collection<Blob> findAll() {
        return this.blobs.values();
    }
}