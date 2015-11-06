
package command.display.setters.turtleDisplay;

import command.display.Display;
import command.display.setters.SetDisplayCommands;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public class SetPenColor extends SetDisplayCommands {


	public SetPenColor(TurtleData displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = 5673442278693959109L;

    @Override
    public Display getEnum () {
        return Display.SETPC;
    }

}
