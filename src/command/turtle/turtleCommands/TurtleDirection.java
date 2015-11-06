
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleDirection extends TurtleCommands {

    private static final long serialVersionUID = 4365978061345276670L;

    public TurtleDirection (TurtleData data) {
        super(data);
    }

    protected abstract int sign ();

    @Override
    public double executeCommand (ParseTreeChildren angle) {
        double angleValue = angle.getCommandValue(0, 0);
        double newHeadAngle = getTurtle().getRotationAngle() + ((sign()) * angleValue);
        setValue(angleValue);
        updateLocation(getCurrX(), getCurrY(), newHeadAngle);
        return angleValue;
    }

}
