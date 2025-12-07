package exercises;

import edu.touro.mcon264.apps.collections.CollectionInterface;

/**
 * Advance Set Interface
 * @param <T>
 */
public interface AdvanceSetInterface <T> extends CollectionInterface<T> {
    // Returns a new set containing all elements in this set or another set
    AdvanceSetInterface<T> union(AdvanceSetInterface<T> otherSet);

    // Returns a new set containing only elements present in both sets
    AdvanceSetInterface<T> intersection(AdvanceSetInterface<T> otherSet);

    // Returns a new set containing elements in this set but not in the other set
    AdvanceSetInterface<T> difference(AdvanceSetInterface<T> otherSet);

}
