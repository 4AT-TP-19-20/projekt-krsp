package Main;

import Planner.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ControllerTest {
    @BeforeAll
    static void setUp() {
        Main.main(new String[] {});
    }

    @Test
    void overlaps() {
        Interval i = new Interval(2,4);
        Interval j = new Interval(3,7);
        double min = Math.min(Double.parseDouble(i.getEndValue()), Double.parseDouble(j.getEndValue()));
        double max = Math.max(Double.parseDouble(i.getStartValue()), Double.parseDouble(j.getStartValue()));
        Assertions.assertEquals(4, min);
        Assertions.assertEquals(3, max);
        Assertions.assertTrue(min <= max);
    }
}