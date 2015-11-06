
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class ClearScreen extends TurtleAbsolutePosition {

    private static final long serialVersionUID = -240865876563370225L;

    public ClearScreen (TurtleData data) {
        super(data);
    }

    @Override
    public double executeCommand (ParseTreeChildren distance) {
        setValue(resetTurtlePosition());
        getTurtle().setClearTrail(true);
        return resetTurtlePosition();

    }

}
