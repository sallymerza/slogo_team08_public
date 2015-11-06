package model.turtleinfo;

import java.io.Serializable;

import javafx.geometry.Point2D;


public abstract class SlogoObjects implements Serializable {


    private static final long serialVersionUID = 2429059406459972387L;
    private Trail myTrail;
    private AbstractPen myPen;
    private boolean isShowing;
    private double myRotationAngle;
    private boolean clearTrails;
    private boolean isActive;
    private static int SlogoObjectID = 0;
    private int turtleID;

    public SlogoObjects () {
        turtleID = SlogoObjectID;
        SlogoObjectID++;
        Point2D startPoint = new Point2D(0, 0);
        setTrail(new Trail(startPoint, 0));
        setPen(new Pen());
        setIsShowing(true);
        setClearTrail(false);
        setIsActive(false);

    }

    public void setTrail (Trail loc) {
        myTrail = loc;
    }

    public Trail getTrail () {
        return myTrail;
    }

    public boolean getClearTrail () {
        return clearTrails;
    }

    public void setClearTrail (boolean b) {
        clearTrails = b;
    }

    public Pen getPen () {
        return (Pen) myPen;
    }

    public void setPen (AbstractPen myPen2) {
        myPen = myPen2;
    }

    public void setIsShowing (boolean value) {
        isShowing = value;
    }

    public boolean getIsShowing () {
        return isShowing;
    }

    public void setRotationAngle (Double angle) {
        myRotationAngle = angle;
    }

    public double getRotationAngle () {
        return myRotationAngle;
    }

    public void setIsActive (boolean b) {
        isActive = b;
    }

    public boolean getIsActive () {
        return isActive;
    }

    public int getTurtleID () {
        return turtleID;
    }

}
