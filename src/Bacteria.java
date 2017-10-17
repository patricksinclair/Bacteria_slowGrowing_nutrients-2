import java.util.ArrayList;

public class Bacteria {

    //m corresponds to the current genotype of the bacterium
    private int m;
    //finalM is the total no. of genotypes in this evolutionary path
    private int finalM;
    private final int initialM = 1;
    //migration rate: probability the bacterium migrates from one microhabitat to a neighbouring one
    private double b = 0.1;
    //death rate
    private double d = 0.;
    //mutation rate
    private double mu = 0.;

    public Bacteria(int m){
        this.m = m;
        this.finalM = 6;
    }


    public int getM(){return m;}
    public double getB(){return b;}
    public double getD(){return d;}


    //MIC now depends on the nutrients present in the microhabitat
    //s = no. of nutrients, s_max =  max no. of nutrients present at the start
    public double beta(double s, double s_max, double K){

        double mu = s/(K+s);
        double mu_max = s_max/(K+s_max);

        return 1. + 9*mu/mu_max;
    }

    public double growthRate(double c, double s, double s_max, double K){

        double phi_c = 1. - (c/beta(s, s_max, K))*(c/beta(s, s_max, K));

        if(phi_c < 0.) return 0.;
        else return phi_c;
    }

    public double replicationRate(double c, double s, double s_max, double K){

        return growthRate(c, s, s_max, K) * s/(K + s);
    }



    public static ArrayList<Bacteria> initialPopulation(int K, int initM){

        ArrayList<Bacteria> initPop = new ArrayList<Bacteria>(K);

        for(int i = 0; i < K; i++){
            initPop.add(new Bacteria(initM));
        }
        return initPop;
    }


}
