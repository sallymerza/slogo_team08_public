
package command.turtle.turtleCommands;

import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class Backward extends TurtleMovement {

    private static final long serialVersionUID = 6054146528991269604L;

    public Backward (TurtleData data) {
        super(data);
    }

    @Override
    protected int getSign () {
        return -1;
    }

}
