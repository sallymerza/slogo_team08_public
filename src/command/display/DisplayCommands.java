
package command.display;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.Command;
import model.data.BackgroundData;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public abstract class DisplayCommands extends Command {

	private static Map<Display, List<Double>> map = new HashMap<Display, List<Double>>();

	public DisplayCommands(BackgroundData displayData) {
		this.addObserver(displayData.getDisplayCommandsObserver());
	}

	public DisplayCommands(TurtleData displayData) {
		this.addObserver(displayData.getTurtleCommandsObserver());
	}

	private static final long serialVersionUID = -5049592034094334507L;

	public abstract Display getEnum();

	public Map<Display, List<Double>> getMap() {
		return map;
	}

	public static void setMap(Map<Display, List<Double>> map) {
		DisplayCommands.map = map;
	}

}
