package util;

/**
 * Created by Ymk Sun on 3/12/2016.
 */
public class CaluclateBMI {

    private double bmi;
    private double bmr;

    public CaluclateBMI(){
        bmi = 0.0;
        bmr = 0.0;
    }

    public double calulateBMI_KgCm(double weight, double height) {
        // kilogram && CM
        bmi = (weight * 10000) / (height * height);
        return bmi;
    }

    public double calulateBMI_LbIn(double weight, double height) {
        // pounds&&inches
        bmi = (weight * 703) / (height * height);
        return bmi;
    }

    public double calulateBMR_KgCm(double weight, double height, double age,
                                   String gender) {

        if (gender.equals("female")) {
            // kilogram && CM

            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);

        } else {
            // kilogram && CM
            bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        }

        return bmr;
    }

    public double calulateBMR_LbIn(double weight, double height, double age,
                                   String gender) {

        if (gender.equals("female")) {
            // pounds&&inches

            bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
        } else {
            // pounds&&inches
            bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
        }
        return bmr;
    }
}
