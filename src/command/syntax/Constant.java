package command.syntax;

import command.Command;
import controller.ParseTreeChildren;
import model.data.TurtleData;

public class Constant extends Command {

    private static final long serialVersionUID = -4748693328683228805L;
    TurtleData data;

    public Constant () {
    }

    public Constant (TurtleData s) {
        super(s);
        data = s;
    }

    @Override
    public double execute (ParseTreeChildren argument) {
        return 0;
    }

}
