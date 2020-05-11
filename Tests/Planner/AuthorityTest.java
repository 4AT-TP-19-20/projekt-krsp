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
    static void beforeAll() {
        Main.main(new String[] {});
    }

    @Test
    void getCopyOfInstance() throws IllegalAccessException {
        Authority authority = new Authority("Authority");

        Authority copy = (Authority) authority.getCopyOfInstance();

        for (Field authorityfield : authority.getClass().getDeclaredFields()) {
            if (authorityfield.get(authority) instanceof Region){
                Region region = (Region) authorityfield.get(authority);
                Region regioncopy = (Region) authorityfield.get(copy);
                for (Field regionfield : region.getClass().getFields()) {
                    Assertions.assertEquals(regionfield.get(region), regionfield.get(regioncopy));
                }
            }else{
                Assertions.assertEquals(authorityfield.get(authority), authorityfield.get(copy));
            }
        }
    }

    @Test
    void makeDraggable() {
        Authority authority = new Authority("Authority");
        authority.makeDraggable(new BorderPane(), new VBox());
    }
}