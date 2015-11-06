
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;
/**
 *
 * @author Sally Al
 *
 */
public class Home extends TurtleAbsolutePosition {

    private static final long serialVersionUID = -667813910576164717L;

    public Home (TurtleData turtleData) {
        super(turtleData);
    }

    @Override
    public double executeCommand (ParseTreeChildren argument) {
        setValue(resetTurtlePosition());
        return resetTurtlePosition();
    }

}
