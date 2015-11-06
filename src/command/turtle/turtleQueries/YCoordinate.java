
package command.turtle.turtleQueries;

import command.turtle.turtleCommands.TurtleCommands;
import controller.ParseTreeChildren;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class YCoordinate extends TurtleCommands {

	private static final long serialVersionUID = 6465432849463275329L;

	public YCoordinate(TurtleData data) {
		super(data);

	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {
		double y = getCurrY();
		setValue(y);
		return y;
	}

}
