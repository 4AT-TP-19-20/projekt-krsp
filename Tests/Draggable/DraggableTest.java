package Draggable;

import Main.Main;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DraggableTest {
    @BeforeAll
    static void setUp() {
        Main.main(new String[] {});
    }

    @Test
    void makeDraggable() {
        Pane rootPane = new Pane();
        Pane container = new Pane();
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(rootPane, container);
        Assertions.assertNotNull(draggable.onMousePressedProperty().get());
        Assertions.assertNotNull(draggable.onMouseDraggedProperty().get());
        Assertions.assertNotNull(draggable.onMouseReleasedProperty().get());
        Assertions.assertNotNull(draggable.getRootPane());
        Assertions.assertEquals(rootPane, draggable.getRootPane());
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(1, draggable.getPossibleContainers().size());
        Assertions.assertEquals(container, draggable.getPossibleContainers().get(0));
    }

    @Test
    void arrayListMakeDraggable() {
        Pane rootPane = new Pane();
        ArrayList<Pane> containers = new ArrayList<>();
        containers.add(new Pane());
        containers.add(new Pane());
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(rootPane, containers);
        Assertions.assertNotNull(draggable.onMousePressedProperty().get());
        Assertions.assertNotNull(draggable.onMouseDraggedProperty().get());
        Assertions.assertNotNull(draggable.onMouseReleasedProperty().get());
        Assertions.assertNotNull(draggable.getRootPane());
        Assertions.assertEquals(rootPane, draggable.getRootPane());
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(containers.size(), draggable.getPossibleContainers().size());
        Assertions.assertEquals(containers, draggable.getPossibleContainers());
    }

    @Test
    void multipleArgsMakeDraggable() {
        Pane rootPane = new Pane();
        ArrayList<Pane> containers = new ArrayList<>();
        Pane contentPane1 = new Pane();
        Pane contentPane2 = new Pane();
        containers.add(contentPane1);
        containers.add(contentPane2);
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(rootPane, contentPane1, contentPane2);
        Assertions.assertNotNull(draggable.onMousePressedProperty().get());
        Assertions.assertNotNull(draggable.onMouseDraggedProperty().get());
        Assertions.assertNotNull(draggable.onMouseReleasedProperty().get());
        Assertions.assertNotNull(draggable.getRootPane());
        Assertions.assertEquals(rootPane, draggable.getRootPane());
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(containers.size(), draggable.getPossibleContainers().size());
        for(int i = 0; i < containers.size(); i++) {
            Assertions.assertEquals(containers.get(i), draggable.getPossibleContainers().get(i));
        }
    }

    @Test
    void makeUnDraggable() {
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeUnDraggable();
        Assertions.assertNull(draggable.getRootPane());
        Assertions.assertNull(draggable.getPossibleContainers());
    }

    @Test
    void getPossibleContainers() {
        Pane container = new Pane();
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(new Pane(), container);
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(1, draggable.getPossibleContainers().size());
        Assertions.assertEquals(container, draggable.getPossibleContainers().get(0));
    }

    @Test
    void arrayListGetPossibleContainers() {
        ArrayList<Pane> containers = new ArrayList<>();
        containers.add(new Pane());
        containers.add(new Pane());
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(new Pane(), containers);
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(containers.size(), draggable.getPossibleContainers().size());
        Assertions.assertEquals(containers, draggable.getPossibleContainers());
    }

    @Test
    void multipleArgsGetPossibleContainers() {
        ArrayList<Pane> containers = new ArrayList<>();
        Pane container1 = new Pane();
        Pane container2 = new Pane();
        containers.add(container1);
        containers.add(container2);
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(new Pane(), container1, container2);
        Assertions.assertNotNull(draggable.getPossibleContainers());
        Assertions.assertEquals(containers.size(), draggable.getPossibleContainers().size());
        Assertions.assertEquals(containers, draggable.getPossibleContainers());
    }

    @Test
    void getRootPane() {
        Pane rootPane = new Pane();
        DraggableImplementation draggable = new DraggableImplementation();
        draggable.makeDraggable(rootPane, new Pane());
        Assertions.assertNotNull(draggable.getRootPane());
        Assertions.assertEquals(rootPane, draggable.getRootPane());
    }
}

class DraggableImplementation extends Draggable {
    @Override
    protected Node getCopyOfInstance() {
        DraggableImplementation copy = new DraggableImplementation();
        if(getRootPane() != null) {
            copy.makeDraggable(getRootPane(), getPossibleContainers());
        }
        return copy;
    }
}