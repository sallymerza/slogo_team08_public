package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.CommandData;


public class DoTimes extends Command {

    private static final long serialVersionUID = -1709915109882273600L;
    private CommandData  allData;
  private  Traverser traverser = new Traverser();

    public DoTimes (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren list) {
        int range = (int) list.getCommandValue(0, 2);
        double answer = 0;
        for (double i = 1; i < range + 1; i++) {
            allData.updateVariableMap(list.getCommandName(0, 1), i);
            answer = traverser.traverse(list.getChildListAt(1), allData);
        }
        return answer;
    }

}
