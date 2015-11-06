package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.CommandData;


public class Repeat extends Command {

    private static final long serialVersionUID = 4606139237584581984L;
    Traverser traverse = new Traverser();
    private CommandData allData;

    public Repeat (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren distance) {
        int repeatTimes = (int) distance.getCommandValue(0, 0);
        double returnValue = 0.0;
        for (int i = 0; i < repeatTimes; i++) {
            returnValue = traverse.traverse(distance.getChildListAt(1), allData);
        }
        return returnValue;
    }
}
