package Planner;

import Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class TeacherTest {
    @BeforeAll
    static void beforeAll() {
        Main.main(new String[] {});
    }

    @Test
    void getCopyOfInstance() throws IllegalAccessException {
        Teacher teacher = new Teacher("Teacher");

        Authority copy = (Authority) teacher.getCopyOfInstance();

        for (Field teacherfield : teacher.getClass().getDeclaredFields()) {
            Assertions.assertEquals(teacherfield.get(teacher), teacherfield.get(copy));
        }
    }
}