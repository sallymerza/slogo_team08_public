
package command.turtle.turtleCommands;

import command.Command;
import controller.ParseTreeChildren;

/**
 *
 * @author Sally Al
 *
 */
public class Towards extends Command {

	private static final long serialVersionUID = 9008069239665135874L;

	@Override
	public double execute(ParseTreeChildren distance) {
		setValue(0);
		return 0;
	}

}
