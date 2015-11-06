package command.turtle.turtleCommands;

import model.data.TurtleData;

public class Forward extends TurtleMovement {


    private static final long serialVersionUID = 5686629616609060685L;

    public Forward (TurtleData data) {
        super(data);
    }

    @Override
    protected int getSign () {
        return 1;
    }

}
