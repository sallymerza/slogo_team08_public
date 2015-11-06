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
public class Minus extends Command {
    /**
     *
     */
    private static final long serialVersionUID = 8903675332338885329L;

    public Minus () {
        super();
    }

    @Override
    public double execute (ParseTreeChildren argument) {
        double negative = -(argument.getCommandValue(0, 0));
        setValue(negative);
        return negative;
    }

}
