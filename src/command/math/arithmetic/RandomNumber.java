/**
 *
 */
package command.math.arithmetic;

import java.util.Random;
import command.Command;
import controller.ParseTreeChildren;


/**
 *
 * @author Sally Al
 *
 */
public class RandomNumber extends Command {

    /**
     *
     */
    private static final long serialVersionUID = -5872935478310813722L;
    private Random random = new Random();

    @Override
    public double execute (ParseTreeChildren max) {
        double randomValue = random.nextInt((int) max.getCommandValue(0, 0));
        setValue(randomValue);
        return randomValue;
    }

}
