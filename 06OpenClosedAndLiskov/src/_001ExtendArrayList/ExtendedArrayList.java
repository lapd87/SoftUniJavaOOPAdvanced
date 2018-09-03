package _001ExtendArrayList;


import java.util.ArrayList;
import java.util.Comparator;

public class ExtendedArrayList<T extends Comparable<T>>
        extends ArrayList<T> {

    public T min() {
        return super.stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    public T max() {
        return super.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

}
