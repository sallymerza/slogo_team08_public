/**
 *
 */
package command.math.arithmetic;

import command.Command;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class Log extends Command {
    /**
     *
     */
    private static final long serialVersionUID = -870186448395394224L;

    public Log () {
        super();
    }

    @Override
    public double execute (ParseTreeChildren number) {
        double log = Math.log(number.getCommandValue(0, 0));
        setValue(log);
        return log;

    }

}
