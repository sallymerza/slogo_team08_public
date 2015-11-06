package model.turtleinfo;

import javafx.scene.paint.Color;


public class Pen extends AbstractPen { // class with properties of the path

    /**
     *
     */
    private static final long serialVersionUID = -2922947045714960867L;

    public Pen () {
        super(Color.BLACK, 1, 1.0, 1.0);
    }

    public Pen (AbstractPen pen) {
        super(pen.myColor, pen.myThickness, pen.myDashSparsity, pen.myStatus);
    }

}
