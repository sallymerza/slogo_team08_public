package view.shapes;

import java.util.List;
import javafx.geometry.Point2D;


public interface ShapeInterface {

    public void addShape (Object shape);

    public List<Object> getAllShapes ();

    public abstract Object drawShape (List<Point2D> currTrailList,
                                      List<Double> currPenStatus,
                                      List<String> penColors,
                                      List<Integer> penThicks,
                                      List<Double> penDash);

}
