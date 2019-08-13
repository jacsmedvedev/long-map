package de.comparus.opensource.longmap;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class LongMapImplTest {

    private final int INIT_SIZE = 50;
    private LongMapImpl testMap;

    @Before
    public void initMap(){
        testMap = new LongMapImpl(INIT_SIZE);
    }

    @Test
    public void putTest() {
        testMap.put(3434L,"Test");
        testMap.put(33L,"Test2");
        testMap.put(555L,"Test3");
        Node n = new Node(33L,"Test2");
//        assertThat(testMap, n.equals(testMap.get(33L)));
    }

    @Test
    public void getTest() {
        testMap.put(3434L,"Test");
        testMap.put(33L,"Test2");
        testMap.put(555L,"Test3");
        Node n = new Node(33L,"Test2");
        assertThat(n.getValue(), is(testMap.get(33L)));
    }

    @Test
    public void removeTest() {
        testMap.put(3434L,"Test");
        testMap.put(33L,"Test2");
        testMap.put(555L,"Test3");
        Node n = new Node(33L,"Test2");
        testMap.remove(33L);
//        assertThat(null, testMap.get(33L));
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
        testMap.put(3434L,"Test");
        testMap.put(33L,"Test2");
        testMap.put(555L,"Test3");
        testMap.clear();
        assertThat(testMap.size(), is(0L));
    }
}