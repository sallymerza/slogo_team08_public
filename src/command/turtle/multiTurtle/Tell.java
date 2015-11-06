
package command.turtle.multiTurtle;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import model.data.TurtleData;

/**
 *
 * @author Sally Al
 *
 */
public class Tell extends Command {
	private TurtleData turtleData;

	public Tell(TurtleData turtleData) {
		super(turtleData);
		this.turtleData = turtleData;
	}

	private static final long serialVersionUID = -477042076707708488L;
	private static final double ERROR_SIGNAL = -1000000.0;

	@Override
	public double execute(ParseTreeChildren distance) {

		List<ParseTreeNode<CommandInterface>> tempList = distance.getChildListAt(0);
		List<Double> turtlesToWorkOn = new ArrayList<Double>();
		try {
			for (int i = 1; i < tempList.size() - 1; i++) {
				turtlesToWorkOn.add(tempList.get(i).getCommandValue());
			}

	turtleData.prepareActiveTurtles().clear();
	} catch (Exception e) {
		return 0;
	}

	int range = 0;for(
	int j = 0;j<turtlesToWorkOn.size();j++)

	{
		range = turtlesToWorkOn.get(j).intValue();
		int size = turtleData.myTurtles().turtleListSize();
		if (range > size) {
			int diff = range - size;
			int max = size + diff;
			for (int i = size; i < max; i++) {
				turtleData.createTurtle();

			}
			add(range);

		} else {
			add(range);
		}
	}

	return range;

	}

	private void add(int range) {
		for (int i = 0; i < range; i++) {
			turtleData.prepareActiveTurtles().update(i);
		}
	}

}
