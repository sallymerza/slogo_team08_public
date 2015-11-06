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
public class GreaterThan extends Command {


    private static final long serialVersionUID = 8827586110836348387L;

    @Override
    public double execute (ParseTreeChildren argument) {
        if (argument.getCommandValue(0, 0) > argument.getCommandValue(1, 0)) {
            setValue(1.0);
            return 1.0;
        }
        else {
            setValue(0);
            return 0;
        }

    }

}
