
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


/**
 *
 * @author Sally Al
 *
 */
public class Difference extends UnlimitedInputDoubleCommand {
    public Difference (CommandData allData) {
        super(allData);
    }

    private static final long serialVersionUID = -7357237139931369565L;

    @Override
    public double execute (ParseTreeChildren argument) {
        double ans =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> x - y).get(), argument);
        setValue(ans);
        return ans;
    }

}
