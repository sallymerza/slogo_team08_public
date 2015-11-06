
package command.turtle.turtleCommands;

import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public class PenDown extends PenCommands {

    private static final long serialVersionUID = 2673531222514598884L;

    public PenDown (TurtleData turtleData) {
        super(turtleData);
    }

    @Override
    protected double switchPen () {
        return 1.0;
    }

}
