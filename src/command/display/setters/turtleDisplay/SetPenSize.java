
package command.display.setters.turtleDisplay;

import command.display.Display;
import command.display.setters.SetDisplayCommands;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public class SetPenSize extends SetDisplayCommands {


	public SetPenSize(TurtleData displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = -7187401381565709898L;

    @Override
    public Display getEnum () {
        return Display.SETPS;
    }

}
