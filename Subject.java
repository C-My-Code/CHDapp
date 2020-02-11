/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHDapp;


/**
 *
 * @author Kevin
 */
public class Subject {
    private int subjectID;
    private String sex;
    private int age;
    private int education;
    private boolean smoker;
    private int cigsPerDay;
    private boolean bpMeds;
    private boolean prevStroke;
    private boolean prevHyp;
    private boolean diabetes; 
    private int totalChol;
    private int sysBP;
    private int diaBP;
    private float BMI;
    private int heartRate;
    private int glucose;
    private boolean tenYearCHD;

    public Subject(int subjectID, String sex, int age, int education, boolean smoker, int cigsPerDay, boolean bpMeds, boolean prevStroke, boolean prevHyp, boolean diabetes, int totalChol, int sysBP, int diaBP, float BMI, int heartRate, int glucose, boolean tenYearCHD) {
        this.subjectID = subjectID;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.smoker = smoker;
        this.cigsPerDay = cigsPerDay;
        this.bpMeds = bpMeds;
        this.prevStroke = prevStroke;
        this.prevHyp = prevHyp;
        this.diabetes = diabetes;
        this.totalChol = totalChol;
        this.sysBP = sysBP;
        this.diaBP = diaBP;
        this.BMI = BMI;
        this.heartRate = heartRate;
        this.glucose = glucose;
        this.tenYearCHD = tenYearCHD;
    }
    public Subject(String sex, int age, int education, boolean smoker, int cigsPerDay, boolean bpMeds, boolean prevStroke, boolean prevHyp, boolean diabetes, int totalChol, int sysBP, int diaBP, float BMI, int heartRate, int glucose) {
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.smoker = smoker;
        this.cigsPerDay = cigsPerDay;
        this.bpMeds = bpMeds;
        this.prevStroke = prevStroke;
        this.prevHyp = prevHyp;
        this.diabetes = diabetes;
        this.totalChol = totalChol;
        this.sysBP = sysBP;
        this.diaBP = diaBP;
        this.BMI = BMI;
        this.heartRate = heartRate;
        this.glucose = glucose;
    }
    
    
     public static boolean convertToBool(String input){
        boolean value = false;
        try{
            int bool = Integer.parseInt(input);
            if(bool == 1){
                value = true;
            }
            if(bool == 0){
                value = false;
            }
        }
        catch(Exception e){
          
        }
        return value;
  
    } 
    public static String convertToSex(String input){
        String sex = "male";
        if(Integer.parseInt(input) == 0){
            sex = "female";
        }
        return sex;
    }
    public static int convertEdu(String input){
        int value;
        if(input.contentEquals("NA")){
            value = 0;
        }
        else{
            value = Integer.parseInt(input);
        }
        return value;
    }
    
    public static int roundToInt(String input){
        int value = Math.round(Float.parseFloat(input));
        return value;
    }
    public static float stringToFloat(String input){
        float value;
        try{
            value = Float.parseFloat(input);
        }
        catch(Exception e){
            value = (float) 26.5;
        }
        return value;
    }
    

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public int getCigsPerDay() {
        return cigsPerDay;
    }

    public void setCigsPerDay(int cigsPerDay) {
        this.cigsPerDay = cigsPerDay;
    }

    public boolean isBpMeds() {
        return bpMeds;
    }

    public void setBpMeds(boolean bpMeds) {
        this.bpMeds = bpMeds;
    }

    public boolean isPrevStroke() {
        return prevStroke;
    }

    public void setPrevStroke(boolean prevStroke) {
        this.prevStroke = prevStroke;
    }

    public boolean isPrevHyp() {
        return prevHyp;
    }

    public void setPrevHyp(boolean prevHyp) {
        this.prevHyp = prevHyp;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public int getTotalChol() {
        return totalChol;
    }

    public void setTotalChol(int totalChol) {
        this.totalChol = totalChol;
    }

    public int getSysBP() {
        return sysBP;
    }

    public void setSysBP(int sysBP) {
        this.sysBP = sysBP;
    }

    public int getDiaBP() {
        return diaBP;
    }

    public void setDiaBP(int diaBP) {
        this.diaBP = diaBP;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMI(float BMI) {
        this.BMI = BMI;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public boolean isTenYearCHD() {
        return tenYearCHD;
    }

    public void setTenYearCHD(boolean tenYearCHD) {
        this.tenYearCHD = tenYearCHD;
    }
    
    public int getAge(){
        return this.age;
    }
    
    
    
    
    
}
