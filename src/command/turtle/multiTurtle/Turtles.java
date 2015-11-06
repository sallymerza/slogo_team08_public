
package command.turtle.multiTurtle;

import command.Command;
import controller.ParseTreeChildren;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public class Turtles extends Command {

    private static final long serialVersionUID = 8732815082745195432L;
    TurtleData turtleData;

    public Turtles (TurtleData turtleData) {
        super(turtleData);
        this.turtleData = turtleData;
    }

    @Override
    public double execute (ParseTreeChildren distance) {
        return turtleData.myTurtles().turtleListSize();
    }

}
