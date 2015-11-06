
package command.turtle.turtleCommands;

import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class ShowTurtle extends TurtleVisibility {

	private static final long serialVersionUID = -234848329032905536L;

	public ShowTurtle(TurtleData turtleData) {
		super(turtleData);
	}

	@Override
	protected Boolean visibility() {
		return true;
	}

	@Override
	protected double visibilityValue() {
		return 1;
	}

}
