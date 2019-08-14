package de.comparus.opensource.longmap.impl;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LongMapImplTest {

    private final int INIT_SIZE = 50;
    private LongMapImpl testMap;

    @Before
    public void initMap(){
        testMap = new LongMapImpl(INIT_SIZE);
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
    }

    @Test
    public void getTest() {
        assertThat("Test2", is(testMap.get(33l)));
    }

    @Test
    public void putTest() {
        assertEquals("Test2", testMap.get(33l));
    }

    @Test
    public void removeTest() {
        testMap.remove(33l);
        assertNull(testMap.get(33l));
    }

    @Test
    public void containsKeyTest() {
        assertTrue(testMap.containsKey(33L));
    }

    @Test
    public void containsValueTest() {
        assertTrue(testMap.containsValue("Test2"));
    }

    @Test
    public void keysTest() {
        long[] arr = new long[INIT_SIZE];
        arr[0] = 11l;
        arr[1] = 222l;
        arr[2] = 555l;
        arr[3] = 125l;
        testMap.put(11L,"Test");
        testMap.put(222L,"Test2");
        testMap.put(555L,"Test3");
        testMap.put(125L,"Test4");
        long[] arr2 = testMap.keys();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        assertArrayEquals(arr, arr2);    }

    @Test
    public void valuesTest() {
        testMap.put(657L,"Test11");
        testMap.put(2734L,"Test22");
        testMap.put(44L,"Test33");
        testMap.put(6565L,"Test44");
        assertNotNull(testMap.values());
    }

    @Test
    public void isEmptyTest() {
        LongMapImpl emptyMap = new LongMapImpl();
        assertThat(0L, is(emptyMap.size()));
    }

    @Test
    public void sizeTest() {
        for (int i = 0; i < 20L; i++) {
            testMap.put(i, String.valueOf(i));
        }
        assertThat(testMap.size(), is(23L));
    }

    @Test
    public void clearTest() {
        testMap.clear();
        assertThat(testMap.size(), is(0L));
    }

    @After
    public void clearAfterTest() {
       testMap.clear();
    }
}