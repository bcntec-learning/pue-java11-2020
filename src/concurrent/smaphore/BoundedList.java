package concurrent.smaphore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BoundedList<T> {

    private final Semaphore semaphore;
    private List<T> arraylist;

    BoundedList(List<T> boundedList, int limit) {
        this.arraylist = boundedList;
        semaphore = new Semaphore(limit);
    }

    /*
     * Add element to the list and call semaphore.acquire method
     * */
    public boolean add(T t) throws InterruptedException {
        boolean added = false;
        System.out.println("available "+semaphore.availablePermits());
        semaphore.acquire();
        try {
            added = arraylist.add(t);
            return added;
        } finally {
            if (!added)
                semaphore.release();
        }

    }

    /*
     * remove element from the list and call semaphore.release method
     * */
    public boolean remove(T t) {
        boolean wasRemoved = arraylist.remove(t);
        if (wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

    public void remove(int index) {
        arraylist.remove(index);
        semaphore.release();
    }

    public List getArraylist() {
        return arraylist;
    }


    public Semaphore getSemaphore() {
        return semaphore;
    }
}