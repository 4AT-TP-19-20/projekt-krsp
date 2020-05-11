package Planner;

import Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntervalTest {
    @BeforeAll
    static void setUp() {
        Main.main(new String[] {});
    }

    @Test
    void getStartValue() {
        Assertions.assertEquals("0", new Interval().getStartValue());
        Assertions.assertEquals("10", new Interval(10, 20).getStartValue());
        Assertions.assertEquals("8", new Interval(10, 8).getStartValue());
        Assertions.assertEquals("0", new Interval(-10, 10).getStartValue());
    }

    @Test
    void getEndValue() {
        Assertions.assertEquals("0", new Interval().getEndValue());
        Assertions.assertEquals("20", new Interval(10, 20).getEndValue());
        Assertions.assertEquals("10", new Interval(10, 8).getEndValue());
        Assertions.assertEquals("0", new Interval(-10, -5).getEndValue());
    }
}