package controller;

import java.io.Serializable;
import java.util.List;

import command.Command;


public class ParseTreeNode<CommandInterface> implements Serializable {


    private static final long serialVersionUID = -7349603750906614666L;

    private Command command;

    private ParseTreeChildren children;
    private ParseTreeNode<CommandInterface> parent = this;

    public ParseTreeNode () {
        super();
        children = new ParseTreeChildren((ParseTreeNode<command.CommandInterface>) this);
    }

    public ParseTreeNode (Command command) {
        this();
        setCommand(command);

    }

    public ParseTreeChildren getChildren () {
        return this.children;
    }

    public int getNumberOfChildren () {
        return getChildren().getSize();
    }

    public boolean hasChildren () {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren (ParseTreeChildren children) {
        this.children = children;
    }

    public void addChild (List<ParseTreeNode<command.CommandInterface>> child) {
        children.addChildList(child);

    }

    public void addChildAt (int index,
                            List<ParseTreeNode<command.CommandInterface>> child) throws IndexOutOfBoundsException {
        children.addChildListAt(index, child);
    }

    public void removeChildren () {
        this.children = new ParseTreeChildren((ParseTreeNode<command.CommandInterface>) this);
    }

    public void removeChildListAt (int index) throws IndexOutOfBoundsException {
        children.removeChildListAt(index);
    }

    public List<ParseTreeNode<command.CommandInterface>> getChildListAt (int index) throws IndexOutOfBoundsException {
        return children.getChildListAt(index);
    }

    public Command getCommand () {

        return this.command;
    }

    public void setCommand (Command command) {
        this.command = command;

    }

    public void setParent (ParseTreeNode<CommandInterface> p) {
        this.parent = p;
    }

    public ParseTreeNode<CommandInterface> getParent () {
        return this.parent;
    }

    public double getCommandValue () {

        return this.command.getValue();
    }

    public void setCommandValue (double d) {
        this.command.setValue(d);
    }

    public String getCommandName () {
        return this.command.getName();
    }

}
