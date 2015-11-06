
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


/**
 *
 * @author Sally Al
 *
 */
public class Power extends UnlimitedInputDoubleCommand {
    public Power (CommandData allData) {
        super(allData);
    }

    private static final long serialVersionUID = 1369755541702689606L;

    @Override
    public double execute (ParseTreeChildren argument) {
        double ans =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> Math.pow(x, y)).get(),
                               argument);
        setValue(ans);
        return ans;

    }

}
