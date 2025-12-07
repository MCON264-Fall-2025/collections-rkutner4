package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LLNode<T> current = head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getLink() != null) {
                sb.append(", ");
            }
            current = current.getLink();
        }
        sb.append("]");
        return sb.toString();    }


    public int count(T target) {
        int cnt = 0;
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                cnt++;
            }
            current = current.getLink();
        }
        return cnt;    }

    public void removeAll(T target) {
        // Remove nodes from the head that match target
        while (head != null && head.getInfo().equals(target)) {
            head = head.getLink();
            numElements--;
        }

        // Remove nodes after head
        LLNode<T> current = head;
        LLNode<T> previous = null;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                previous.setLink(current.getLink());
                numElements--;
            } else {
                previous = current;
            }
            current = current.getLink();
        }
    }
}
