import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;
import java.util.List;

public class LotkaVolterraPath implements StepHandler {
    private List<Double> time = new ArrayList<>();
    private List<Double> preys = new ArrayList<>();
    private List<Double> predators = new ArrayList<>();

    public List<Double> getTime() {
        return time;
    }

    public void setTime(List<Double> time) {
        this.time = time;
    }

    public List<Double> getPreys() {
        return preys;
    }

    public void setPreys(List<Double> preys) {
        this.preys = preys;
    }

    public List<Double> getPredators() {
        return predators;
    }

    public void setPredators(List<Double> predators) {
        this.predators = predators;
    }

    @Override
    public void init(double t0, double[] y0, double t) {

    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        time.add(interpolator.getCurrentTime());
        double[]x=interpolator.getInterpolatedState();
        preys.add(x[0]);
        predators.add(x[1]);
    }
}
