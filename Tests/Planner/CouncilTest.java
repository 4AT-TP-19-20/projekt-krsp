package Planner;

import Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CouncilTest {
    @BeforeAll
    static void setUp() {
        Main.main(new String[] {});
    }

    @Test
    void getName() {
        Assertions.assertEquals("name", new Council("name", 10).getName());
        Assertions.assertEquals("0", new Council("0", 10).getName());
        Assertions.assertEquals("", new Council("", 10).getName());
    }

    @Test
    void getDuration() {
        Assertions.assertEquals(0, new Council("name", 0).getDuration());
        Assertions.assertEquals(10, new Council("name", 10).getDuration());
        Assertions.assertEquals(10.1, new Council("name", 10.1).getDuration());
        Assertions.assertEquals(0, new Council("name", -10).getDuration());
    }

    @Test
    void setDuration() {
        double[] set = new double[] {5, -2, 5.2};
        double[] expected = new double[] {5, 0, 5.2};

        for(int i = 0; i < set.length; i++) {
            Council council = new Council("name", 10);
            council.setDuration(set[i]);
            Assertions.assertEquals(expected[i], council.getDuration());
        }
    }

    @Test
    void getTeachers() {
        Council council = new Council("name", 10);
        Assertions.assertNotNull(council.getTeachers());
        Assertions.assertEquals(0, council.getTeachers().size());
    }

    @Test
    void getAuthorities() {
        Council council = new Council("name", 10);
        Assertions.assertNotNull(council.getAuthorities());
        Assertions.assertEquals(0, council.getAuthorities().size());
    }

    @Test
    void setName() {
        Council council = new Council("oldName", 10);
        council.setName("newName");
        Assertions.assertEquals("newName", council.getName());
    }
}