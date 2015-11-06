
package command.otherCommands.askCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeNode;
import model.data.ActiveTurtles;
import model.data.Data;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public abstract class MultiCommands extends Command {

	private static final long serialVersionUID = 456274188677983060L;
	TurtleData turtleData;
	protected int originalID;
	private ResourceBundle errorResources;
	    private final String ERROR_RESOURCES = "resources/error";
	protected List<Integer> originalActiveList;


	public MultiCommands(Data data) {
		this.turtleData = data.getturtleData();
		originalID = turtleData.getActiveTurtleID();
		originalActiveList = new ArrayList<Integer>();
		errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);


	}
	protected  void check(List<Integer> activeToBe) {
		int range;
		for (int j = 0; j < activeToBe.size(); j++) {
			range = activeToBe.get(j).intValue();
			int size = turtleData.myTurtles().turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}

			}}
		}

	protected void backUpActive() {
		for (int i = 0; i < getActiveList().size(); i++) {
			originalActiveList.add(getActiveList().activeTurtleListValue(i));
		}
	}
	private ActiveTurtles getActiveList() {
		return turtleData.prepareActiveTurtles();
	}

	protected void createTempActivleList(List<ParseTreeNode<CommandInterface>> turtles, List<Integer> newActiveList) {
		for (int i = 1; i < turtles.size() - 1; i++) {
			newActiveList.add((int) turtles.get(i).getCommandValue());
		}

	}



	protected void resetActiveList() {
		for (int i = 0; i < originalActiveList.size(); i++) {
			getActiveList().update(originalActiveList.get(i));
		}
	}

}
