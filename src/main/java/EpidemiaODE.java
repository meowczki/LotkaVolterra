import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class EpidemiaODE implements FirstOrderDifferentialEquations {
    private double population;
    private double infecting;
    private double days;

    public EpidemiaODE(double population, double infecting, double days) {
        this.population = population;
        this.infecting = infecting;
        this.days = days;
    }

    @Override
    public int getDimension() {
        return 0;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        dxdt[0] = -(infecting / population) * x[0] * x[1];
        dxdt[1] = (infecting / population) * x[0] * x[1] - (1 / days) * x[1];
        dxdt[2] = -(1 / days) * x[1];
    }
}
