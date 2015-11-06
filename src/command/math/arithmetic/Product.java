
package command.math.arithmetic;

import command.otherCommands.UnlimitedInputDoubleCommand;
import controller.ParseTreeChildren;
import model.data.CommandData;


/**
 *
 * @author Sally Al
 *
 */
public class Product extends UnlimitedInputDoubleCommand {
    public Product (CommandData allData) {
        super(allData);
    }

    private static final long serialVersionUID = -3795052450458213450L;

    @Override
    public double execute (ParseTreeChildren arguments) {
        double ans =
                parameterLoop( (list) -> list.stream().reduce( (x, y) -> x * y).get(), arguments);
        setValue(ans);
        return ans;
    }

}
