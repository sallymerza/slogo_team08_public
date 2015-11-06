package view.shapes;

import java.util.ArrayList;
import java.util.List;

import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;
import view.settings.SlogoProperties;


public class StraightLine extends AbstractShape {
    protected List<Line> myAllShapes = new ArrayList<Line>();

    public StraightLine (TurtleScene turtlescene, ModelController controller) {
        super(turtlescene, controller);
        Line myRecentLine = new Line();
        myAllShapes.add(myRecentLine);
    }

    public List<Line> getAllLines () {
        return myAllShapes;
    }

    @Override
    public ArrayList<Line> drawShape (List<Point2D> currTrailList,
                                      List<Double> currPenStatus,
                                      List<String> penColors,
                                      List<Integer> penThicks,
                                      List<Double> penDash) {
    	
        ArrayList<Point2D> allScreenPoints = new ArrayList<Point2D>();
        ArrayList<Double> allPenStatuses = new ArrayList<Double>();
        ArrayList<String> allPenColors = new ArrayList<String>();
        ArrayList<Integer> allPenThicks = new ArrayList<Integer>();
        ArrayList<Double> allPenDash = new ArrayList<Double>();

        for (int i = 0; i < currTrailList.size(); i++) {
        	List<Point2D> screenPoints = translateForScreen(currTrailList.get(i));

        	Double currPenStats = currPenStatus.get(i);
        	String currPenColor = penColors.get(i);
        	Integer currPenThick = penThicks.get(i);
        	Double currPenDash = penDash.get(i);

        	for (Point2D eachPoint : screenPoints){
        		allScreenPoints.add(eachPoint);
        		allPenStatuses.add(currPenStats);
        		allPenColors.add(currPenColor);
        		allPenThicks.add(currPenThick);
        		allPenDash.add(currPenDash);
        	}
        }
        
        
        ArrayList<Line> ret = new ArrayList<Line>();
        for (int i = 0; i < allScreenPoints.size() - 1; i++) {
            if (allPenStatuses.get(i + 1) == 1.0) {
                Point2D point1 = allScreenPoints.get(i);
                Point2D point2 = allScreenPoints.get(i + 1);
                
                double distance = Math.sqrt( Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
                if (distance < SlogoProperties.getSceneHeight() - myTurtScene.getMyCanvasHeight()) {
                	Line recentLine =
                            new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
                    recentLine.setStroke(Color.web(allPenColors.get(i+1)));
                    recentLine.setStrokeWidth(allPenThicks.get(i+1));
                    recentLine.getStrokeDashArray().add(0, allPenDash.get(i+1));
                    myAllShapes.add(recentLine);
                    ret.add(recentLine);
                }
            }
        }
        return ret;
        
        
        
//        ArrayList<Line> ret = new ArrayList<Line>();
//        for (int i = 0; i < currTrailList.size() - 1; i++) {
//            if (currPenStatus.get(i + 1) == 1.0) {
//                List<Point2D> point1 = translateForScreen(currTrailList.get(i));
//                List<Point2D> point2 = translateForScreen(currTrailList.get(i + 1));
//                
//                Line recentLine =
//                        new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
//                recentLine.setStroke(Color.web(penColors.get(i)));
//                recentLine.setStrokeWidth(penThicks.get(i));
//                // if (penDash.get(i) != 0.0) {
//                recentLine.getStrokeDashArray().add(0, penDash.get(i));
//                // }
//                myAllShapes.add(recentLine);
//                ret.add(recentLine);
//            }
//        }
//        return ret;
    }

}
