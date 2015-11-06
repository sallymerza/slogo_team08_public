
package command.syntax;

import command.Command;
import controller.ParseTreeChildren;


public class Bracket extends Command {

    /**
     *
     */
    private static final long serialVersionUID = -2178229337604706839L;

    public Bracket () {

    }

    @Override
    public double execute (ParseTreeChildren distance) {
        System.out.println("this happened");
        return 0;
    }

}
