package com.lewgordon;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by lew on 9/25/14.
 */
public class TestCollatz {
    private Map<Integer, Integer> testNumbers;

    @Before
    public void setupTestNumbers(){
        testNumbers = new HashMap<>();
        testNumbers.put(3, 7);
        testNumbers.put(34, 13);
        testNumbers.put(75, 14);
        testNumbers.put(27, 111);
        testNumbers.put(101, 25);
        testNumbers.put(-1, 0);
    }

    @Test
    public void testCollatz(){
        Iterator iter = testNumbers.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry pairs = (Map.Entry) iter.next();
            assertEquals(pairs.getValue(), Collatz.calculateSteps((Integer) pairs.getKey()));
            iter.remove();
        }
    }
}
