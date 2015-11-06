
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


/**
 *
 * @author Sally Al
 *
 */
public class Quotient extends UnlimitedInputDoubleCommand {

    private static final long serialVersionUID = -5543181629851201807L;

    public Quotient (CommandData allData) {
        super(allData);
    }

    @Override
    public double execute (ParseTreeChildren argument) {

        double ans = 0;

        try {
            ans = parameterLoop( (list) -> list.stream().reduce( (x, y) -> x / y).get(), argument);
        }
        catch (ArithmeticException e) {
            System.out.println("cannot divide by 0");
        }
        setValue(ans);
        return ans;
    }

}
