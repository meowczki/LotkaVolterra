import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;
import org.apache.commons.math3.ode.sampling.StepHandler;

import java.util.ArrayList;
import java.util.List;

public class TesterLotkaVolterra {

    public static void main(String[] args) {
        double[] params1 = {1.5, 1., 1., 3.};
        double[] params2 = {1.5, 1., 1., 3.,1,1};
        double[] params3 = {1.5, 1., 1., 3.,1.,1.};

        double[] xStart = {50, 10};
        double[] xStop = {0, 0};

        LotkaVolterraODE lotkaVolterraODE1 = new LotkaVolterraODE(params1);
        LotkaVolterraODE lotkaVolterraODE2 = new LotkaVolterraODE(params2);
        LotkaVolterraODE lotkaVolterraODE3 = new LotkaVolterraODE(params3);


        FirstOrderDifferentialEquations epidemiaODE=new EpidemiaODE(1000,1,10);

        FirstOrderIntegrator eulerIntegrator = new EulerIntegrator(0.001);
        LotkaVolterraPath volterraPath = new LotkaVolterraPath();
        eulerIntegrator.addStepHandler(volterraPath);

        eulerIntegrator.integrate(lotkaVolterraODE1, 0, xStart, 50, xStop);
        List<Double>time=volterraPath.getTime();
        List<Double>preys=volterraPath.getPreys();
        List<Double>predators=volterraPath.getPredators();

        eulerIntegrator.integrate(lotkaVolterraODE2, 0, xStart, 50, xStop);
        time=volterraPath.getTime();
       preys=volterraPath.getPreys();
        predators=volterraPath.getPredators();

        eulerIntegrator.integrate(lotkaVolterraODE3, 0, xStart, 50, xStop);
        time=volterraPath.getTime();
        preys=volterraPath.getPreys();
        predators=volterraPath.getPredators();

        EpidemiaHandler epidemiaHandler=new EpidemiaHandler();
        eulerIntegrator.addStepHandler(epidemiaHandler);
        
        double[] xStart2 = {900, 90,10};
        double[] xStop2 = {0, 0,0};
        eulerIntegrator.integrate(epidemiaODE,0,xStart2,100,xStop2);
        List<Double>timeE=epidemiaHandler.getTime();
        List<Double>x=epidemiaHandler.getZdrowi();
        List<Double>y=epidemiaHandler.getChorowali();
        List<Double>z=epidemiaHandler.getNarazeni();


    }


}
