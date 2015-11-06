
package command.turtle.turtleCommands;

import controller.ParseTreeChildren;
import model.data.TurtleData;
import model.turtleinfo.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public abstract class TurtleMovement extends TurtleCommands {

	private static final long serialVersionUID = 8387538421594848834L;

	public TurtleMovement(TurtleData allData) {
		super(allData);

	}

	@Override
	public double executeCommand(ParseTreeChildren distance) {

		moveFdorBK(distance.getCommandValue(0, 0), getTurtle());
		setValue(distance.getCommandValue(0, 0));
		return distance.getCommandValue(0, 0);

	}

	public void moveFdorBK(double distance, SlogoObjects myTurtle) {
		int sign = getSign();

		double degrees = myTurtle.getRotationAngle();
		double radians = Math.toRadians(degrees);

		double tempXLocation = RoundTo2Decimals(Math.sin(radians));
		double tempYLocation = RoundTo2Decimals(Math.cos(radians));

		tempXLocation = calcualteCoordinate(tempXLocation, getCurrX(), sign, distance);
		tempYLocation = calcualteCoordinate(tempYLocation, getCurrY(), sign, distance);

		updateLocation(tempXLocation, tempYLocation, degrees);

	}

	private double calcualteCoordinate(double Tempcoordinate, double previousCoordinate, int sign, double distance) {
		if (Tempcoordinate == 0.0 || Tempcoordinate == -0.0) {
			return previousCoordinate;
		} else {

			return (previousCoordinate + (sign * (distance * Tempcoordinate)));
		}
	}

	protected abstract int getSign();
}
