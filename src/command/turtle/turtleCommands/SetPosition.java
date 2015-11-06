
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */// goto x y
public class SetPosition extends TurtleAbsolutePosition {

	private static final long serialVersionUID = 8951107742111791983L;

	public SetPosition(TurtleData turtleData) {
		super(turtleData);

	}

	@Override
	public double executeCommand(ParseTreeChildren newLocation) {
		double distance = calculateDistanceBetweenTwoPoints(newLocation.getCommandValue(0, 0),
				newLocation.getCommandValue(1, 0));
		setValue(distance);
		updateLocation(newLocation.getCommandValue(0, 0), newLocation.getCommandValue(1, 0),
				getTurtle().getRotationAngle());
		return distance;
	}

}
