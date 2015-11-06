package command.otherCommands;

import command.Command;
import controller.ParseTreeChildren;
import model.data.CommandData;


public class Variable extends Command {
    private CommandData allData;

    public Variable (CommandData allData) {
        super(allData);
        this.allData = allData;
    }

    private static final long serialVersionUID = 8952601530556268609L;

    @Override
    public double execute (ParseTreeChildren argument) {
        double ans = 0;
        if (allData.getVariableMap().containsKey(getName())) {
            setValue(allData.getVariableMap().get(getName()));
            ans = allData.getVariableMap().get(getName());
        }
        return ans;

    }

}
