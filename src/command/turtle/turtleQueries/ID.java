
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class ID extends TurtleCommands {

    private static final long serialVersionUID = 3565943439758546699L;
    TurtleData turtleData;

    public ID (TurtleData turtleData) {
        super(turtleData);
        this.turtleData = turtleData;
    }

    @Override
    public double executeCommand (ParseTreeChildren distance) {
    	this.setValue(turtleData.getActiveTurtleID());
        return turtleData.getActiveTurtleID();
    }

}
