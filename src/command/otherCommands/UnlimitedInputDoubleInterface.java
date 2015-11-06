package command.otherCommands;

import java.util.List;


@FunctionalInterface
public interface UnlimitedInputDoubleInterface {
    public double doFunction (List<Double> compiledList);
}

/*
 * Our program will NOT be handling unlimited inputs for
 * non-arithmetic commands simply because it wouldn't make sense
 * however it would be easy to add given the unlimited parameter interface added
 */
