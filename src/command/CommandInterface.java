package command;

import controller.ParseTreeChildren;


public interface CommandInterface {
    public abstract String getName ();

    public abstract void setName (String name);

    public abstract double getValue ();

    public void setValue (double d);

    public abstract double execute (ParseTreeChildren distance);

}
