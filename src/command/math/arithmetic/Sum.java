package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


public class Sum extends UnlimitedInputDoubleCommand {

    private static final long serialVersionUID = -3214409066608523993L;

    public Sum (CommandData allData) {
        super(allData);
    }

    @Override
    public double execute (ParseTreeChildren arguments) {

        double sum =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> x + y).get(), arguments);
        setValue(sum);
        return sum;

    }

}
