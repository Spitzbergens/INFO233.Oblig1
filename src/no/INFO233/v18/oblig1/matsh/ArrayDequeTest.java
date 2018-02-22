package no.INFO233.v18.oblig1.matsh;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        // True if there has not been added anything to the list. False otherwise and the list has
        // length above 0
        IDeque<String> testDq = new ArrayDeque<>();
        Boolean isTrue;
        if (testDq.size() <= 0) {
            isTrue = true;
            assertTrue(isTrue);
        } else {
            isTrue = false;
            assertTrue(isTrue);
        }
    }

    @org.junit.jupiter.api.Test
    void size() {

        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("testMan");
        assertEquals(1, testDq.size());


    }

    @org.junit.jupiter.api.Test
    void addFirst() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("Mats");
        assertEquals("Mats", testDq.peekFirst());

    }

    @org.junit.jupiter.api.Test
    void addLast() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addLast("Mats");

        assertEquals("Mats", testDq.peekLast());
    }

    @org.junit.jupiter.api.Test
    void pullFirst() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("Test");
        testDq.addFirst("Test2");
        // There should now be two elements in the deque. And the assertion should be correct with 1 expected
        testDq.pullFirst();
        assertEquals(1, testDq.size());

    }

    @org.junit.jupiter.api.Test
    void peekFirst() {

        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("test");
        Object test = testDq.pullFirst();
        assertEquals("test", test);

    }

    @org.junit.jupiter.api.Test
    void pullLast() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addLast("test");
        Object test = testDq.pullLast();
        assertEquals("test", test);

    }

    @org.junit.jupiter.api.Test
    void peekLast() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addLast("test");
        Object test = testDq.peekLast();
        assertEquals("test", test);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("test");
        Boolean test = testDq.contains("test");
        assertTrue(test);

    }

    @org.junit.jupiter.api.Test
    void toArray() {
        IDeque<String> testDq = new ArrayDeque<>();
        testDq.addFirst("test");
        testDq.addFirst("test2");

        String[] copy = testDq.toArray(new String[0]);
        assertArrayEquals(copy, testDq.toArray(new String[0]));
    }

    @org.junit.jupiter.api.Test
    void clear() {

        IDeque<String> testDq = new ArrayDeque<String>();
        testDq.addFirst("Test");
        testDq.addFirst("Test2");
        testDq.clear();

        assertTrue(testDq.size() <= 0);
    }

}