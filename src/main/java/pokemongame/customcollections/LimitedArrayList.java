package pokemongame.customcollections;

import java.util.ArrayList;
import java.util.Collection;

// Special array list with predefined limit and guardian code
public class LimitedArrayList<E> extends ArrayList<E> {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSTANCE VARIABLES
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    private final int maximumSize;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public LimitedArrayList(int maximumSize) {
        super(maximumSize);
        this.maximumSize = maximumSize;
    }

    public LimitedArrayList(int maximumSize, E[] array) {
        super(maximumSize);
        this.maximumSize = maximumSize;
        if (array.length > maximumSize) {
            throw new IndexOutOfBoundsException("Array length is greater than maximum size!");
        } else {
            for (int i = 0; i < maximumSize; i++) {
                super.add(array[i]);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // OVERRIDDEN METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override 
    public void add(int index, E element) {
        if (this.size() < maximumSize) {
            super.add(index, element);
        } else {
            throw new IndexOutOfBoundsException("The list is full!");
        }
    }

    @Override
    public boolean add(E e) {
        if (this.size() < maximumSize) {
            return super.add(e);
        } else {
            throw new IndexOutOfBoundsException("The list is full!");
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if ((this.size() + c.size()) > maximumSize) {
            throw new IndexOutOfBoundsException("The list is full!");
        } else {
            return super.addAll(index, c);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if ((this.size() + c.size()) > maximumSize) {
            throw new IndexOutOfBoundsException("The list is full!");
        } else {
            return super.addAll(c);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // TESTING
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Integer[] array = {5,6};
        LimitedArrayList<Integer> limList = new LimitedArrayList<>(4);
        LimitedArrayList<Integer> limList2 = new LimitedArrayList<>(4, array);

        limList.add(1);
        limList.add(2);
        limList.add(3);
        // limList.add(4);
        System.out.println(limList);
        System.out.println(limList2);

        limList.addAll(0, limList2);

        System.out.println(limList);
    }
}
