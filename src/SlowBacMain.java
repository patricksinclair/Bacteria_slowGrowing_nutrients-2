public class SlowBacMain {

    public static void main(String[] args){

        /*double alpha_specific = Math.log(11.5)/500.;
        System.out.println(alpha_specific);
        double c_500 = Math.exp(alpha_specific*500) - 1;
        System.out.println(c_500);*/
        BioSystem.spatialAndNutrientDistributions(0.02);
    }
}
