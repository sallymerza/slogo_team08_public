package model.turtleinfo;

import java.io.Serializable;
import javafx.scene.paint.Color;


public abstract class AbstractPen implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3942383150109943668L;

    protected transient Color myColor;

    protected String mySColor;

    protected int myThickness;

    protected Double myDashSparsity;

    protected Double myStatus;

    // pen down =1.0 , pen up =0.0
    public AbstractPen (Color color, int thickness, Double dashSparsity, Double bool) {
        myStatus = bool;
        myColor = color;
        mySColor = color.toString();
        myThickness = thickness;
        myDashSparsity = dashSparsity;
    }

    public int getThickness () {
        return myThickness;
    }

    public void setThickness (int myThickness) {
        this.myThickness = myThickness;
    }

    public Double getDashes () {
        return myDashSparsity;
    }

    public void setDashes (Double dash) {
        myDashSparsity = dash;
    }

    public void setColor (Color color) {
        myColor = color;
        mySColor = color.toString();
    }

    public void recreate () {
        myColor = Color.web(mySColor);
    }

    public Color getColor () {
        return myColor;
    }

    public void setPenDown (Double bool) {
        myStatus = bool;
    }

    public Double isDown () {
        return myStatus;
    }

}
