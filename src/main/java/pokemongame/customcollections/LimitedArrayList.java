package pokemongame.customcollections;

import java.util.ArrayList;
import java.util.Arrays;
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
        super(Arrays.asList(array));
        this.maximumSize = maximumSize;
        if (array.length > maximumSize) {
            throw new IndexOutOfBoundsException("Array length is greater than maximum size!");
        }
    }

    public LimitedArrayList(int maximumSize, Collection<? extends E> c) {
        super(c);
        this.maximumSize = maximumSize;
        Object[] array = c.toArray();
        if (array.length > maximumSize) {
            throw new IndexOutOfBoundsException("Array length is greater than maximum size!");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // GETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getMaximumSize() {
        return this.maximumSize;
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
}
