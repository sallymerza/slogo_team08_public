package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.data.CommandData;


public class MakeVariable extends Command {


    private static final long serialVersionUID = 3131529990290290269L;
    private CommandData allData;

    public MakeVariable (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    @Override
    public double execute (ParseTreeChildren argument) {

        String varName = argument.getCommandName(0, 0);
        Double value = argument.getCommandValue(1, 0);
        allData.updateVariableMap(varName, value);
        return value;
    }

}
