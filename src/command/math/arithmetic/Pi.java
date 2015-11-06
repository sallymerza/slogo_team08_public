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
public class Pi extends Command {
    /**
     *
     */
    private static final long serialVersionUID = -7294696481342781769L;
    public static final double PI = 3.1416;

    public Pi () {
        super();
    }

    @Override
    public double execute (ParseTreeChildren argument) {

        setValue(PI);
        return PI;
    }

}
