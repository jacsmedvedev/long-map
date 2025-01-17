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

/*
    REMARK !!! (для разработчиков компании Сomparus, которые будут проверять
                данные тесты)

                На текущем проекте вообще не используются юнит-тесты, поэтому
                мои умения их писать очень невелики. Но я готов учиться их писать.
 */

@RunWith(JUnit4.class)
public class LongMapImplTest {

    private final int INIT_SIZE = 50;
    private final int NUMBER_OF_ADDED_ITEMS = 10;
    private LongMapImpl testMap;

    @Before
    public void initMap(){
        testMap = new LongMapImpl(INIT_SIZE);
        testMap.put(3434l,"Test");
        testMap.put(33l,"Test2");
        testMap.put(555l,"Test3");
        testMap.put(2345l,"XXX");
        testMap.put(2345l,"XXX");
        testMap.put(431l,"Check");
        testMap.put(7364l,"Do");
        testMap.put(001l,"Some");
        testMap.put(70743l,"Medved");
    }

    @Test
    public void getTest() {
        assertEquals("Test2", testMap.get(33L));
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
        testMap.clear();
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
        testMap.clear();
        for (int i = 0; i < NUMBER_OF_ADDED_ITEMS; i++) {
            testMap.put(i, String.valueOf(i));
        }
        assertThat((int)testMap.size(), is(NUMBER_OF_ADDED_ITEMS));
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