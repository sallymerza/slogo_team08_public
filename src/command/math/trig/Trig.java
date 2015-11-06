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
public abstract class Trig extends Command {
    /**
     *
     */
    private static final long serialVersionUID = -7985189152995269845L;
    private static final int ANGLE = 90;

    @Override
    public double execute (ParseTreeChildren angle) {
        if (checkUnderfinedAngle(angle.getCommandValue(0, 0))) {
            setValue(0);
        }
        else {

            setValue(evaluateAngle(Math.toRadians(angle.getCommandValue(0, 0))));
        }
        return getValue();

    }

    private Boolean checkUnderfinedAngle (double angle) {
        return (angle % ANGLE == 0);
    }

    protected abstract double evaluateAngle (double angle);

}
