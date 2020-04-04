package Planner;

import Draggable.Draggable;
import javafx.scene.Node;

public class Teacher extends Authority {
    public Teacher(String name) {
        super(name);
    }

    @Override
    protected Node getCopyOfInstance() {
        Authority copy = new Authority(this.name);
        copy.setTimeTable(this.timeTable);
        return copy;
    }
}
