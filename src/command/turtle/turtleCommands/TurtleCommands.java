/**
 *
 */
package command.turtle.turtleCommands;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import controller.ParseTreeChildren;
import model.data.ActiveTurtles;
import model.data.TurtleData;
import model.data.turtleEnum;
import model.turtleinfo.SlogoObjects;

/***
 * @author Sally Al
 ***/
public abstract class TurtleCommands extends Command {

	private static final long serialVersionUID = 3800846758549642667L;

	private Map<turtleEnum, Double> coordinates = new HashMap<turtleEnum, Double>();





	private TurtleData turtleData;

	public TurtleCommands(TurtleData turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
		this.addObserver(turtleData.getTurtleCommandsObserver());
	}




	protected void updateLocation(Double x, Double y, double angle) {

		coordinates.put(turtleEnum.XCor, x);
		coordinates.put(turtleEnum.YCor, y);
		coordinates.put(turtleEnum.Angle, angle);
		coordinates.put(turtleEnum.ID, (double) id);
		setChanged();
		notifyObservers();
	}

	public Map<turtleEnum, Double> getCoordinates() {
		return coordinates;
	}

	int id = 0;

	@Override
	public double execute(ParseTreeChildren distance) {
		int range = getActiveList().size();
		double value = 0;

		for (int i = 0; i < range; i++) {
			id = getActiveList().activeTurtleListValue(i);
			turtleData.setActiveTurtle(id);
			value = executeCommand(distance);
			setValue(value);
		}
		return value;

	}




	private ActiveTurtles getActiveList() {
		return turtleData.prepareActiveTurtles();
	}

	public abstract double executeCommand(ParseTreeChildren distance);

	protected SlogoObjects getTurtle() {
		return turtleData.myTurtles().getTurtle(id);
	}

	protected double getCurrX() {
		return getTurtle().getTrail().getX();
	}

	protected double getCurrY() {
		return getTurtle().getTrail().getY();
	}

}
