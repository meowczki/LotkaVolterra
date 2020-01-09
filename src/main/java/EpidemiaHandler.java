import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;
import java.util.List;

public class EpidemiaHandler implements StepHandler {
    private List<Double> time = new ArrayList<>();
    private List<Double> zdrowi = new ArrayList<>();
    private List<Double> chorowali = new ArrayList<>();
    private List<Double> narazeni = new ArrayList<>();

    public List<Double> getTime() {
        return time;
    }

    public void setTime(List<Double> time) {
        this.time = time;
    }

    public List<Double> getZdrowi() {
        return zdrowi;
    }

    public void setZdrowi(List<Double> zdrowi) {
        this.zdrowi = zdrowi;
    }

    public List<Double> getChorowali() {
        return chorowali;
    }

    public void setChorowali(List<Double> chorowali) {
        this.chorowali = chorowali;
    }

    public List<Double> getNarazeni() {
        return narazeni;
    }

    public void setNarazeni(List<Double> narazeni) {
        this.narazeni = narazeni;
    }

    @Override
    public void init(double t0, double[] y0, double t) {

    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        time.add(interpolator.getCurrentTime());
        double[]x=interpolator.getInterpolatedState();
        zdrowi.add(x[0]);
        chorowali.add(x[1]);
        narazeni.add(x[2]);
    }
}
