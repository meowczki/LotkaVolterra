import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class LotkaVolterra3ODE implements FirstOrderDifferentialEquations {
    private double [] params;

    public LotkaVolterra3ODE(double[] params) {
        this.params = params;
    }

    public int getDimension() {
        return 2;
    }

    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        //1 element tab ofiary x
        dxdt[0]=(params[0]-params[1]*x[1])*x[0]-params[4]*x[0]*x[0];
        dxdt[1]=(params[2]*x[0]-params[3])*x[1]-params[5]*x[0]*x[0];
    }
}
