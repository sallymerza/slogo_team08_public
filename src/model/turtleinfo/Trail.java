package model.turtleinfo;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.geometry.Point2D;


public class Trail implements Serializable {

    private static final long serialVersionUID = -1670975363453388685L;
    private transient Point2D myPoint;
    private Double[] myDPoint = new Double[2];
    private transient ArrayList<Point2D> myPath = new ArrayList<Point2D>();
    private ArrayList<Double> myPenStatus = new ArrayList<Double>();
    private ArrayList<Double[]> myDPath = new ArrayList<Double[]>();
    private ArrayList<String> myPathColors = new ArrayList<String>();
    private ArrayList<Integer> myPathThicknesses = new ArrayList<Integer>();
    private ArrayList<Double> myPathDashes = new ArrayList<Double>();
    private double myDirection;

    public Trail (Trail oldBearing) {
        this(oldBearing.getPoint(), oldBearing.getDirection());
    }

    public Trail (Point2D point, double direction) {
        Point2D starter = new Point2D(0.0, 0.0);
        myPath.add(starter);
        myPenStatus.add(1.0);
        myPoint = starter;
        myDPoint[0] = starter.getX();
        myDPoint[1] = starter.getY();
        Double[] temp = new Double[2];
        temp[0] = starter.getX();
        temp[1] = starter.getY();
        myDPath.add(temp);
        myDirection = direction;
        
        myPathColors.add("black");
        myPathThicknesses.add(1);
        myPathDashes.add(1.0);
    }

    public Trail () {
        this(new Point2D(0, 0), 0);
    }

    public ArrayList<Point2D> getPathCoordinates () {
        return myPath;
    }

    public ArrayList<Double> getPenPath () {
        return myPenStatus;
    }

    public ArrayList<String> getColorPath () {
        return myPathColors;
    }

    public ArrayList<Double> getDashPath () {
        return myPathDashes;
    }

    public ArrayList<Integer> getThicknessPath () {
        return myPathThicknesses;
    }

    public double getX () {
        return myPoint.getX();
    }

    public void recreate () {
        myPoint = new Point2D(0, 0);
        myPath = new ArrayList<Point2D>();
        for (int i = 0; i < myDPath.size(); i++) {
            myPath.add(new Point2D(myDPath.get(i)[0], myDPath.get(i)[1]));
        }
        myPoint = new Point2D(myDPoint[0], myDPoint[1]);

    }

    public double getY () {
        return myPoint.getY();
    }

    public void setPoint (Point2D point) {
        myPoint = point;
        myDPoint[0] = point.getX();
        myDPoint[1] = point.getY();
    }

    public Point2D getPoint () {
        return myPoint;
    }

    public void setDirection (double direction) {
        myDirection = direction;
    }

    public double getDirection () {
        return myDirection;
    }

    public void addCoord (Point2D current, Double upDown, String penColor, int thick, double dash) {
        myPath.add(current);
        myPenStatus.add(upDown);
        myPathColors.add(penColor);
        myPathThicknesses.add(thick);
        myPathDashes.add(dash);
        Double[] temp = { current.getX(), current.getY() };
        myDPath.add(temp);
    }

}
