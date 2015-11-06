
package command.otherCommands.askCommands;

import java.util.ArrayList;
import java.util.List;

import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.ActiveTurtles;
import model.data.Data;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class Ask extends MultiCommands {

	private TurtleData turtleData;
	private Data data;
	private Traverser traverser = new Traverser();

	public Ask(Data data) {
		super(data);
		this.turtleData = data.getturtleData();
		this.data = data;

	}

	private static final long serialVersionUID = 6992411696017450102L;

	@Override
	public double execute(ParseTreeChildren input) {
		List<Integer> newActiveList = new ArrayList<Integer>();

		this.backUpActive();
		getActiveList().clear();
		List<ParseTreeNode<CommandInterface>> inputTurtleList = input.getChildListAt(0);
		createTempActivleList(inputTurtleList, newActiveList);

		int range = 0;

		for (int j = 0; j < newActiveList.size(); j++) {
			range = newActiveList.get(j).intValue();
			int size = turtleData.myTurtles().turtleListSize();
			if (range > size) {
				int diff = range - size;
				int max = size + diff;
				for (int i = size; i < max; i++) {
					turtleData.createTurtle();

				}

			}

		}

		for (int i = 0; i < newActiveList.size(); i++) {
			getActiveList().update(newActiveList.get(i) - 1);

		}

		Double answer = 0.0;
		for (int i = 0; i < getActiveList().size(); i++) {
			turtleData.setActiveTurtle(getActiveList().activeTurtleListValue(i));
			// turtleData.updateVariableMap(input.getCommandName(0, 1), (double)
			// i);
			try {
				answer = traverser.traverse(input.getChildListAt(1), data.getCommandData());
			} catch (Exception e) {
				answer = 0.0;
			}
		}
		turtleData.setActiveTurtle(originalID);
		getActiveList().clear();
		resetActiveList();
		return answer;
	}

	private ActiveTurtles getActiveList() {
		return turtleData.prepareActiveTurtles();
	}

}
