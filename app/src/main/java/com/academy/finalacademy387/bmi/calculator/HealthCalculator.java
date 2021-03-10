package com.academy.finalacademy387.bmi.calculator;

public class HealthCalculator {
    private String errorMessage;


    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Method for calculating BMI accepts two parameters:
     *
     * @param heightCm
     * @param weightKg
     * @return bmiIndex or -1 if parameters are not correct
     */
    public double calculateBMI(double heightCm, double weightKg) {
        double bmiIndex = -1;
        if (heightCm <= 0 && weightKg <= 0) {
            errorMessage = "Height and weight cannot be zero or less";
        } else {
            bmiIndex = weightKg / ((heightCm / 100) * (heightCm / 100));
        }
        return bmiIndex;
    }

    /**
     * Method for determining body mass index category
     * @param bmiIndex
     * @return bmiCategory
     */
    public String determineBMICategory(double bmiIndex){
        String bmiCategory = "";
        if(bmiIndex<16){
            bmiCategory = "Severe Thinness";
        }else if(bmiIndex >= 16 && bmiIndex < 17){
            bmiCategory = "Moderate Thinness";
        }else if(bmiIndex >= 17 && bmiIndex < 18.5){
            bmiCategory = "Mild Thinness";
        }else if(bmiIndex >= 18.5 && bmiIndex < 25){
            bmiCategory = "Normal";
        }else if (bmiIndex >= 25 && bmiIndex < 30) {
            bmiCategory = "Overweight";
        } else if (bmiIndex >= 30 && bmiIndex < 35) {
            bmiCategory = "Obese Class I";
        } else if (bmiIndex >= 35 && bmiIndex < 40) {
            bmiCategory = "Obese Class II";
        } else if (bmiIndex >= 40) {
            bmiCategory = "Obese Class III";
        }
        return bmiCategory;
    }
}
