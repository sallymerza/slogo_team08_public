package command.otherCommands;
//created by kevin to include infinite parameters
import java.util.ArrayList;
import java.util.List;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.CommandData;


public abstract class UnlimitedInputDoubleCommand extends Command {


	private static final long serialVersionUID = -2278163311708568906L;
	Traverser traverser = new Traverser();
    protected CommandData allData;

    public UnlimitedInputDoubleCommand (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    public double parameterLoop (UnlimitedInputDoubleInterface inter, ParseTreeChildren arguments) {

        List<Double> compiledList = new ArrayList<Double>();
        for (int i = 0; i < arguments.getNodeList().size(); i++) {
            List<ParseTreeNode<CommandInterface>> tempList = arguments.getChildListAt(i);
            traverser.traverse(tempList, allData);
            for (int j = 0; j < tempList.size(); j++) {
                if (!(arguments.getCommand(i, j).getClass().getSimpleName().equals("ListEnd") ||
                      (arguments.getCommand(i, j).getClass().getSimpleName()
                              .equals("ListStart")))) {
                    compiledList.add(arguments.getCommandValue(i, j));
                }
            }

        }
        double ans = 0;
        ans = inter.doFunction(compiledList);
        return ans;

    }
}
