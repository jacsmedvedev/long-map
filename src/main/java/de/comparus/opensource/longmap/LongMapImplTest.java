package de.comparus.opensource.longmap;


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
    }

    @Test
    public void getTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        assertThat("Test2", is(testMap.get(33l)));
    }

    @Test
    public void putTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        Node n = new Node(33l,"Test2");
        assertEquals(n.getValue(), testMap.get(33l));
    }

    @Test
    public void removeTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        testMap.remove(33l);
        assertNull(testMap.get(33l));
    }

    @Test
    public void containsKeyTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        assertTrue(testMap.containsKey(33L));
    }

    @Test
    public void containsValueTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        assertTrue(testMap.containsValue("Test2"));
    }

    @Test
    public void keysTest() {
        long[] arr = new long[INIT_SIZE];
        arr[0] = 3434l;
        arr[1] = 33l;
        arr[2] = 555l;
        arr[3] = 125l;
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        testMap.put(125l,"Test4");
        long[] arr2 = testMap.keys();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        assertArrayEquals(arr, arr2);    }

    @Test
    public void valuesTest() {
        testMap.put(3434l,"Test11");
        testMap.put(33l,"Test22");
        testMap.put(555l,"Test33");
        testMap.put(125l,"Test44");
        assertNotNull(testMap.values());
    }

    @Test
    public void isEmptyTest() {
        LongMapImpl emptyMap = new LongMapImpl();
        assertThat(0l, is(emptyMap.size()));
    }

    @Test
    public void sizeTest() {
        for (int i = 0; i < 20l; i++) {
            testMap.put(i, String.valueOf(i));
        }
        assertThat(testMap.size(), is(20l));
    }

    @Test
    public void clearTest() {
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        testMap.clear();
        assertThat(testMap.size(), is(0l));
    }

    @After
    public void clearAfterTest() {
       testMap.clear();
    }
}