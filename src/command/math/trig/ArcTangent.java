/**
 *
 */
package command.math.trig;

/**
 *
 * @author Sally Al
 *
 */
public class ArcTangent extends Trig {
    /**
     *
     */
    private static final long serialVersionUID = 1770768285470329057L;

    public ArcTangent () {
        super();
    }

    @Override
    protected double evaluateAngle (double angle) {
        return (Math.atan(angle));
    }

}
