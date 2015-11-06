package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.CommandData;


public class IfElse extends Command {

	private static final long serialVersionUID = -1491608247002727538L;
	private CommandData allData;
    Traverser traverser = new Traverser();

    public IfElse (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren distance) {
        double ans = 0;
        if (distance.getCommandValue(0, 0) != 0) {
            ans = traverser.traverse(distance.getChildListAt(1), allData);
        }
        else {
            ans = traverser.traverse(distance.getChildListAt(2), allData);

        }
        return ans;
    }

}
