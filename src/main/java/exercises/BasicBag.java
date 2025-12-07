package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {

    public BasicBag() {
        super();
    }

    public BasicBag(int capacity) {
        super(capacity);
    }

    /**
     * Returns a random element from the bag.
     * @return a randomly selected element, or null if empty
     */

    @Override
    public T grab() {
        if (isEmpty()) return null;
        int index = (int) (Math.random() * numElements);
        T element = elements[index];

        // Remove the element by replacing it with the last one
        elements[index] = elements[numElements - 1];
        elements[numElements - 1] = null;
        numElements--;

        return element;
    }

    /**
     * Counts the number of occurrences of the given element in the bag.
     * @param target element to count
     * @return number of occurrences of target
     */
    @Override
    public int count(T target) {
        int cnt = 0;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Removes all occurrences of the given element from the bag.
     * @param target element to remove
     * @return number of elements removed
     */
    @Override
    public int removeAll(T target) {
        int removed = 0;
        int i = 0;
        while (i < numElements) {
            if (elements[i].equals(target)) {
                elements[i] = elements[numElements - 1]; // replace with last element
                elements[numElements - 1] = null;
                numElements--;
                removed++;
                // do not increment i, check new element at position i
            } else {
                i++;
            }
        }
        return removed;
    }

    /**
     * Removes all elements from the bag, making it empty.
     */
    @Override
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
        }

}

//this follows SRP because each class only has one responsibility
//this follows OCP because the code is open for extension but closed for modification
