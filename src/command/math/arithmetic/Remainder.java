/**
 *
 */
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


/**
 *
 * @author Sally Al
 *
 */
public class Remainder extends UnlimitedInputDoubleCommand {

    public Remainder (CommandData allData) {
        super(allData);
    }

    private static final long serialVersionUID = -5675238179764860997L;

    @Override
    public double execute (ParseTreeChildren argument) {
        double ans =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> x % y).get(), argument);
        setValue(ans);
        return ans;
    }

}
