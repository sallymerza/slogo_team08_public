package view.shapes;

import java.util.ArrayList;
import java.util.List;
import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;


public abstract class AbstractShape implements ShapeInterface {
    protected TurtleScene myTurtScene;
    protected List<Object> myAllShapes = new ArrayList<Object>();
    protected ModelController myModelController;

    public AbstractShape (TurtleScene turtlescene, ModelController controller) {
        myTurtScene = turtlescene;
        myModelController = controller;
    }

    @Override
    public void addShape (Object shape) {
        myAllShapes.add(shape);
    }

    @Override
    public List<Object> getAllShapes () {
        return myAllShapes;
    }

    @Override
    public abstract ArrayList<Line> drawShape (List<Point2D> currTrailList,
                                               List<Double> currPenStatus,
                                               List<String> penColors,
                                               List<Integer> penThicks,
                                               List<Double> penDash);

    protected List<Point2D> translateForScreen (Point2D point) {
        List<Point2D> allPoints = new ArrayList<Point2D>();

        long canvasWidth = (long) myTurtScene.getCurrTab().getMyCanvasWidth();
        long canvasHeight = (long) myTurtScene.getCurrTab().getMyCanvasHeight();

        long canvasX1 = (long) myTurtScene.getCanvasX();
        long canvasX2 = canvasX1 + canvasWidth;
        long canvasY1 = (long) myTurtScene.getCanvasY();
        long canvasY2 = canvasY1 + canvasHeight;

        long X = (long) (point.getX() + myTurtScene.getX() + canvasWidth / 2);
        long Y = (long) (myTurtScene.getY() + canvasHeight / 2 - point.getY());
        long modX = Math.floorMod(X, canvasWidth);
        long modY = Math.floorMod(Y, canvasHeight);

        if(X != modX && Y == modY) { //if only X needs to be mod
        	
        	if(modX - canvasX1 < canvasX2 - modX){
        		Point2D firstPoint = new Point2D(canvasX2, Y);
        		Point2D secPoint = new Point2D(canvasX1, Y);
        		allPoints.add(firstPoint);
            	allPoints.add(secPoint);
        	}else{
        		Point2D firstPoint = new Point2D(canvasX1, Y);
        		Point2D secPoint = new Point2D(canvasX2, Y);
        		allPoints.add(firstPoint);
            	allPoints.add(secPoint);
        	}

        	Point2D thirdPoint = new Point2D( modX, Y);
        	allPoints.add(thirdPoint);
        } else if(X == modX && Y != modY) {
        	if(modY - canvasY1 < canvasY2 - modY){
        		Point2D firstPoint = new Point2D(X, canvasY2);
        		Point2D secPoint = new Point2D(X, canvasY1);
        		allPoints.add(firstPoint);
            	allPoints.add(secPoint);
        	}else{
        		Point2D firstPoint = new Point2D(X, canvasY1);
        		Point2D secPoint = new Point2D(X, canvasY2);
        		allPoints.add(firstPoint);
            	allPoints.add(secPoint);
        	}

        	Point2D thirdPoint = new Point2D(X, modY);
        	allPoints.add(thirdPoint);
        } else if(X != modX && Y != modY) {
        	allPoints.add(new Point2D(modX, modY)); //wrong
        } else {
        	allPoints.add(new Point2D(modX, modY));
        }

        return allPoints;
    }

    protected boolean checkBounds (double x, double y) {
        TurtleSceneTab currTab = myTurtScene.getCurrTab();
        return (myTurtScene.getX() + currTab.getMyCanvasWidth() > x  && x > myTurtScene.getX()  &&
        		myTurtScene.getY() + currTab.getMyCanvasHeight() > y && y > myTurtScene.getY() );
    }

}
