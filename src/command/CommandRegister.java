package command;

import command.booleanOperations.And;
import command.booleanOperations.Equal;
import command.booleanOperations.GreaterThan;
import command.booleanOperations.LessThan;
import command.booleanOperations.Not;
import command.booleanOperations.NotEqual;
import command.booleanOperations.Or;
import command.display.setters.SetPalette;
import command.display.setters.turtleDisplay.SetPenColor;
import command.display.setters.turtleDisplay.SetPenSize;
import command.display.setters.turtleDisplay.SetShape;
import command.display.setters.SetBackground;
import command.math.arithmetic.Difference;
import command.math.arithmetic.Log;
import command.math.arithmetic.Minus;
import command.math.arithmetic.Pi;
import command.math.arithmetic.Power;
import command.math.arithmetic.Product;
import command.math.arithmetic.Quotient;
import command.math.arithmetic.RandomNumber;
import command.math.arithmetic.Remainder;
import command.math.arithmetic.Sum;
import command.math.trig.ArcTangent;
import command.math.trig.Cosine;
import command.math.trig.Sine;
import command.math.trig.Tangent;
import command.otherCommands.DoTimes;
import command.otherCommands.MakeUserInstruction;
import command.otherCommands.MakeVariable;
import command.otherCommands.Repeat;
import command.otherCommands.UserCommand;
import command.otherCommands.Variable;
import command.otherCommands.askCommands.Ask;
import command.otherCommands.askCommands.AskWith;
import command.syntax.Constant;
import command.syntax.ListEnd;
import command.syntax.ListStart;
import command.turtle.multiTurtle.Tell;
import command.turtle.multiTurtle.Turtles;
import command.turtle.turtleCommands.Backward;
import command.turtle.turtleCommands.ClearScreen;
import command.turtle.turtleCommands.Forward;
import command.turtle.turtleCommands.HideTurtle;
import command.turtle.turtleCommands.Home;
import command.turtle.turtleCommands.Left;
import command.turtle.turtleCommands.PenDown;
import command.turtle.turtleCommands.PenUp;
import command.turtle.turtleCommands.Right;
import command.turtle.turtleCommands.SetHeading;
import command.turtle.turtleCommands.SetPosition;
import command.turtle.turtleCommands.ShowTurtle;
import command.turtle.turtleQueries.Heading;
import command.turtle.turtleQueries.IsPenDown;
import command.turtle.turtleQueries.XCoordinate;
import command.turtle.turtleQueries.YCoordinate;


public class CommandRegister {
    private CommandFactory cf;

    public CommandRegister (CommandFactory commandfac) {
        cf = commandfac;
    }

    public void register () {
        // turtle commands:
        cf.registerCommand("Forward", Forward.class);
        cf.registerCommand("Backward", Backward.class);
        cf.registerCommand("Right", Right.class);
        cf.registerCommand("Left", Left.class);
        cf.registerCommand("Home", Home.class);
        cf.registerCommand("SetHeading", SetHeading.class);
        cf.registerCommand("SetPosition", SetPosition.class);
        cf.registerCommand("ClearScreen", ClearScreen.class);
        cf.registerCommand("Heading", Heading.class);
        cf.registerCommand("Constant", Constant.class);
        cf.registerCommand("ListEnd", ListEnd.class);
        cf.registerCommand("ListStart", ListStart.class);

        // math-arithmetic
        cf.registerCommand("Difference", Difference.class);
        cf.registerCommand("Log", Log.class);
        cf.registerCommand("Minus", Minus.class);
        cf.registerCommand("Pi", Pi.class);
        cf.registerCommand("Power", Power.class);
        cf.registerCommand("Product", Product.class);
        cf.registerCommand("Quotient", Quotient.class);
        cf.registerCommand("Random", RandomNumber.class);
        cf.registerCommand("Remainder", Remainder.class);
        cf.registerCommand("Sum", Sum.class);

        // math-trig
        cf.registerCommand("ArcTangent", ArcTangent.class);
        cf.registerCommand("Cosine", Cosine.class);
        cf.registerCommand("Sine", Sine.class);
        cf.registerCommand("Tangent", Tangent.class);
        cf.registerCommand("Sine", Sine.class);

        // show-hide
        cf.registerCommand("PenDown", PenDown.class);
        cf.registerCommand("PenUp", PenUp.class);
        cf.registerCommand("IsPenDown", IsPenDown.class);
        cf.registerCommand("HideTurtle", HideTurtle.class);
        cf.registerCommand("ShowTurtle", ShowTurtle.class);
        cf.registerCommand("PenDown", PenDown.class);
        cf.registerCommand("PenUp", PenUp.class);
        cf.registerCommand("PenUp", PenUp.class);
        cf.registerCommand("IsPenDown", IsPenDown.class);

        // harder-commands
        cf.registerCommand("MakeUserInstruction", MakeUserInstruction.class);
        cf.registerCommand("DoTimes", DoTimes.class);
        cf.registerCommand("Repeat", Repeat.class);
        cf.registerCommand("MakeVariable", MakeVariable.class);
        cf.registerCommand("Variable", Variable.class);
        cf.registerCommand("UserCommand", UserCommand.class);

        // turtle-queries
        cf.registerCommand("XCoordinate", XCoordinate.class);
        cf.registerCommand("YCoordinate", YCoordinate.class);

        // logic commands
        cf.registerCommand("And", And.class);
        cf.registerCommand("Or", Or.class);
        cf.registerCommand("GreaterThan", GreaterThan.class);
        cf.registerCommand("Equal", Equal.class);
        cf.registerCommand("NotEqual", NotEqual.class);
        cf.registerCommand("LessThan", LessThan.class);
        cf.registerCommand("Not", Not.class);

        // extension:
        cf.registerCommand("Turtles", Turtles.class);
        cf.registerCommand("Tell", Tell.class);

        cf.registerCommand("SetPalette", SetPalette.class);
        cf.registerCommand("SetBackground", SetBackground.class);
        cf.registerCommand("SetPenColor", SetPenColor.class);
        cf.registerCommand("SetPenSize", SetPenSize.class);
        cf.registerCommand("SetShape", SetShape.class);
        cf.registerCommand("Ask", Ask.class);
        cf.registerCommand("AskWith", AskWith.class);


    }
}
