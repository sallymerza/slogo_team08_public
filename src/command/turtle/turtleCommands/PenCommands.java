
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;
import model.turtleinfo.Pen;


/**
 *
 * @author Sally Al
 *
 */
public abstract class PenCommands extends TurtleCommands {

    private static final long serialVersionUID = -7003996375537002670L;

    public PenCommands (TurtleData turtleData) {
        super(turtleData);
    }

    @Override
    public double executeCommand (ParseTreeChildren distance) {
        Pen currPen = getTurtle().getPen();
        currPen.setPenDown(switchPen());
        getTurtle().setPen(currPen);
        setValue(switchPen());
        return switchPen();
    }

    protected abstract double switchPen ();

}
