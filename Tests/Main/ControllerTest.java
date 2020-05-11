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
        Interval i1 = new Interval(2,4);
        Interval i2 = new Interval(3,7);
        double commonTimeStart = Math.max(Double.parseDouble(i1.getStartValue()), Double.parseDouble(i2.getStartValue()));
        double commonTimeEnd = Math.min(Double.parseDouble(i1.getEndValue()), Double.parseDouble(i2.getEndValue()));
        Interval commonInterval = new Interval(commonTimeStart, commonTimeEnd);
        Controller controller = new Controller();
        Interval returned = controller.overlaps(i1, i2);
        Assertions.assertEquals(commonInterval.getStartValue(), returned.getStartValue());
        Assertions.assertEquals(commonInterval.getEndValue(), returned.getEndValue());
    }
}