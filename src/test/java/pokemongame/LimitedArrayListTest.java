package pokemongame;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import pokemongame.customcollections.LimitedArrayList;

public class LimitedArrayListTest {

    @Test
    public void testLimitedArrayListConstructors() {

        // standard constructor
        List<Integer> actual1 = new LimitedArrayList<Integer>(4);
        assertEquals(4, ((LimitedArrayList<Integer>) actual1).getMaximumSize());
        assertTrue(actual1 instanceof LimitedArrayList);

        // overloaded constructor with valid array and size passed in
        Integer[] arr = {1,2,3,4,5};
        List<Integer> actual2 = new LimitedArrayList<Integer>(8, arr);
        assertEquals(8, ((LimitedArrayList<Integer>) actual2).getMaximumSize());
        assertThat(actual2, contains(1,2,3,4,5));
        assertTrue(actual2 instanceof LimitedArrayList);

        // overloaded constructor with invalid array and size combination
        try {
            Integer[] arr2 = {1,2,3};
            new LimitedArrayList<Integer>(2, arr2);
            fail("Index out of bounds exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Array length is greater than maximum size!", e.getMessage());
        }

        // overloaded constructor with valid collection and size passed in
        Integer[] arr3 = {1,2,3,4,5,6,7};
        List<Integer> arrlist3 = Arrays.asList(arr3);
        List<Integer> actual3 = new LimitedArrayList<Integer>(7, arrlist3);
        assertEquals(7, ((LimitedArrayList<Integer>) actual3).getMaximumSize());
        assertThat(actual3, contains(1,2,3,4,5,6,7));
        assertTrue(actual3 instanceof LimitedArrayList);

        // overloaded constructor with invalid collection and size combination
        try {
            Integer[] arr4 = {1,2,3};
            List<Integer> arrlist4 = Arrays.asList(arr4);
            new LimitedArrayList<Integer>(2, arrlist4);
            fail("Index out of bounds exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Array length is greater than maximum size!", e.getMessage());
        }
    }
    
    @Test
    public void testAdd() {

        // test that adding works as expected 
       List<Integer> actual = new LimitedArrayList<Integer>(4);
       actual.add(1);
       actual.add(2);
       actual.add(3);
       actual.add(4);
       assertThat(actual, contains(1,2,3,4));

       // test that adding over the max size throws an error 
       try {
            actual.add(5);
            fail("Index out of bounds exception not thrown");
       } catch (IndexOutOfBoundsException e) {
            assertEquals("The list is full!", e.getMessage());
       }

       // test that removing items works
       actual.remove(3);
       assertThat(actual, contains(1,2,3));
       assertEquals(3, actual.size());

       // test overloaded add
       actual.add(0,0);
       assertThat(actual, contains(0,1,2,3));

       // now test if it throws error if list is full
       try {
            actual.add(-1,0);
            fail("Index out of bounds exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("The list is full!", e.getMessage());
        }
    }

    @Test
    public void testAddAll() {

        // test that adding to an empty list works
        Integer[] arr = {1,2};
        List<Integer> arrlist = Arrays.asList(arr);
        List<Integer> actual = new LimitedArrayList<Integer>(4);
        actual.addAll(arrlist);
        assertThat(actual, contains(1,2));
        assertEquals(2, actual.size());

        // test that adding an collection that is too large causes an error
        Integer[] arr2 = {3,4,5};
        List<Integer> arrlist2 = Arrays.asList(arr2);
        try {
            actual.addAll(arrlist2);
            fail("Index out of bounds exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("The list is full!", e.getMessage());
        }

        // test that adding to an index works
        Integer[] arr3 = {-1,0};
        List<Integer> arrlist3 = Arrays.asList(arr3);
        actual.addAll(0, arrlist3);
        assertThat(actual, contains(-1,0,1,2));
        assertEquals(4, actual.size());

        // test that it can also throw an error
        Integer[] arr4 = {3,4};
        List<Integer> arrlist4 = Arrays.asList(arr4);
        try {
            actual.addAll(3, arrlist4);
            fail("Index out of bounds exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("The list is full!", e.getMessage());
        }
    }
}
