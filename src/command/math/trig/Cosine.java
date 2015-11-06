/**
 *
 */
package command.math.trig;

import command.Command;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class Cosine extends Command {

    private static final long serialVersionUID = -8210600920444364245L;

    public Cosine () {
        super();
    }

   @Override
    public double execute(ParseTreeChildren argument) {
        double cosangle = Math.cos(Math.toRadians(argument.getCommandValue(0, 0)));
        cosangle = RoundTo2Decimals(cosangle);
        setValue(cosangle);
        return cosangle;
    }


}
