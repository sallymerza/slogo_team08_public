/**
 *
 */
package command.math.trig;

/**
 *
 * @author Sally Al
 *
 */
public class Tangent extends Trig {

    /**
     *
     */
    private static final long serialVersionUID = 878811280886142326L;

    @Override
    protected double evaluateAngle (double angle) {
        return (Math.tan(angle));
    }

}
