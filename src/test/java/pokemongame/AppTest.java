package pokemongame;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import org.junit.Test;

import pokemongame.customcollections.LimitedArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // TESTS FOR CUSTOMCOLLECTIONS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Tests for limited array list data structure // 
    
    @Test
    public void testAdd()
    {
       List<Integer> actual = new LimitedArrayList<Integer>(4);
       actual.add(1);
       actual.add(2);
       actual.add(3);
       actual.add(4);
       
       Integer[] arr = {1,2,3,4};
       List<Integer> expected = new LimitedArrayList<Integer>(4, arr);
       assertThat(actual, is(expected));
    }
}
