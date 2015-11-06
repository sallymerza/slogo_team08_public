
package command.commandsObservers;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import command.turtle.turtleCommands.TurtleCommands;
import javafx.geometry.Point2D;
import model.data.TurtleData;
import model.data.turtleEnum;
import model.turtleinfo.SlogoObjects;


/**
 *
 * @author Sally Al
 *
 */
public class TurtleCommandsObserver implements Observer, Serializable {

    private static final long serialVersionUID = 8077018140841818623L;
    private TurtleData data;

    public TurtleCommandsObserver (TurtleData data) {
        this.data = data;
    }

    @Override
    public void update (Observable o, Object arg) {

        TurtleCommands observedClass = (TurtleCommands) o;
        int index = observedClass.getCoordinates().get(turtleEnum.ID).intValue();
        SlogoObjects turtle = data.myTurtles().getTurtle(index);
        double ycor = observedClass.getCoordinates().get(turtleEnum.YCor);
        double xcor = observedClass.getCoordinates().get(turtleEnum.XCor);
        turtle.setRotationAngle(observedClass.getCoordinates().get(turtleEnum.Angle));

        updateTurtle(index, turtle, ycor, xcor);

    }

    private void updateTurtle (int index, SlogoObjects turtle, double ycor, double xcor) {
        Point2D NewCoordinate = new Point2D(xcor, ycor);
        addTrail(NewCoordinate, turtle);
        turtle.setTrail(turtle.getTrail());
        turtle.getTrail().setPoint(NewCoordinate);
        data.myTurtles().setTurtle(index, turtle);
    }

    private void addTrail (Point2D NewCoordinate, SlogoObjects turtle) {
        turtle.getTrail().addCoord(NewCoordinate, turtle.getPen().isDown(),
                                   turtle.getPen().getColor().toString(),
                                   turtle.getPen().getThickness(), turtle.getPen().getDashes());
    }
}
