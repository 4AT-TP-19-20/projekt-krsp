package Planner;

import Main.Main;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class AuthorityTest {
    @BeforeAll
    static void setUp() {
        Main.main(new String[] {});
    }

    @Test
    void getCopyOfInstance() throws IllegalAccessException {
        Authority authority = new Authority("Authority");

        Authority copy = (Authority) authority.getCopyOfInstance();

        for (Field authorityField : authority.getClass().getDeclaredFields()) {
            if (authorityField.get(authority) instanceof Region){
                Region region = (Region) authorityField.get(authority);
                Region regionCopy = (Region) authorityField.get(copy);
                for (Field regionField : region.getClass().getFields()) {
                    Assertions.assertEquals(regionField.get(region), regionField.get(regionCopy));
                }
            } else {
                Assertions.assertEquals(authorityField.get(authority), authorityField.get(copy));
            }
        }
    }

    @Test
    void makeDraggable() {
        Authority authority = new Authority("Authority");
        authority.makeDraggable(new BorderPane(), new VBox());
    }
}