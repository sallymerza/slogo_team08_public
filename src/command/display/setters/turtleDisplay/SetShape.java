
package command.display.setters.turtleDisplay;

import command.display.Display;
import command.display.setters.SetDisplayCommands;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public class SetShape extends SetDisplayCommands {


	public SetShape(TurtleData displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = 5765949474471118329L;

    @Override
    public Display getEnum () {
        return Display.SETSH;
    }

}
