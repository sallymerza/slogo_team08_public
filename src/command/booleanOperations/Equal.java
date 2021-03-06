/**
 *
 */
package command.booleanOperations;

import command.Command;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class Equal extends Command {

    /**
     *
     */
    private static final long serialVersionUID = -1495800189429201692L;

    @Override
    public double execute (ParseTreeChildren argument) {

        if (argument.getCommandValue(0, 0) == argument.getCommandValue(1, 0)) {
            setValue(1);
            return 1.0;
        }
        else {
            setValue(0);
            return 0;
        }

    }
}
