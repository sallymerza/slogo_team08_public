package command.otherCommands;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import controller.ParseTreeChildren;
import controller.Traverser;
import model.data.CommandData;


public class MakeUserInstruction extends Command {
    private CommandData allData;
    Traverser traverser = new Traverser();

    public MakeUserInstruction (CommandData allData) {
        super(allData);
        this.allData = allData;
    }


    private static final long serialVersionUID = 6069217154717721913L;

    @Override
    public double execute (ParseTreeChildren distance) {
        double ans = 0;
        allData.getUserCommandMap().put(distance.getCommandName(0, 0), distance.getChildListAt(2));
        List<String> tempVariableList = new ArrayList<String>();

        for (int i = 1; i < distance.getChildListAt(1).size() - 1; i++) {
            tempVariableList.add(distance.getCommandName(1, i));
        }
        allData.getMyCommandVariableMap().put(distance.getCommandName(0, 0), tempVariableList);
        ans = 1;

        return ans;
    }

}
