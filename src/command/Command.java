/**
 *
 */
package command;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Observable;

import controller.ParseTreeChildren;
import model.data.BackgroundData;
import model.data.CommandData;
import model.data.Data;
import model.data.TurtleData;


/**
 *
 * @author Sally Al
 *
 */
public abstract class Command extends Observable implements CommandInterface, Serializable {

    private static final long serialVersionUID = -8555344826572870264L;

    public Command () {
    }

    public Command (TurtleData allData) {
    }
    public Command (BackgroundData allData) {
    }

    public Command (Data allData) {
    }
    public Command (CommandData allData) {
    }

    private String name;

    private double value;

    @Override
    public String getName () {
        return name;

    }

    @Override
    public void setName (String name) {
        this.name = name;
    }

    @Override
    public abstract double execute (ParseTreeChildren distance);

    @Override
    public double getValue () {
        return value;
    }

    @Override
    public void setValue (double d) {
        value = d;
    }

    protected double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}
}
