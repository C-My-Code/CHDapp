/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHDapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Kevin
 */
public class MainPageFXMLController implements Initializable {
    
    public static ObservableList<Subject> subjectArray = FXCollections.observableArrayList();
    public static ObservableList<Subject> sortedSubjectArray = FXCollections.observableArrayList();
    public ArrayList<Subject> patient = new ArrayList<>();
    public static int idCount;
    
    //PATIENT ANALYSIS TAB
    @FXML
    private TextField totCholField;

    @FXML
    private RadioButton smokeYesRadio;

    @FXML
    private RadioButton hypNoRadio;

    @FXML
    private RadioButton diabetesNoRadio;

    @FXML
    private TextField hrField;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton diabetesYesRadio;

    @FXML
    private static final ObservableList<String> educationList = FXCollections.observableArrayList("1. Less than High School", "2. Some High School", "3. High School or GED", "4. Some College", "5. College");
    
    @FXML
    private ChoiceBox<String> educationBox;
    

    @FXML
    private RadioButton bpYesRadio;

    @FXML
    private TextField glucoseField;

    @FXML
    private TextField cigsPerDayField;

    @FXML
    private RadioButton strokeNoRadio;

    @FXML
    private TextField ageField;

    @FXML
    private ToggleGroup sex;

    @FXML
    private ToggleGroup smoke;

    @FXML
    private RadioButton strokeYesRadio;

    @FXML
    private ToggleGroup bpmeds;

    @FXML
    private ToggleGroup stroke;

    @FXML
    private TextField diaBPField;

    @FXML
    private TextField bmiField;

    @FXML
    private RadioButton hypYesRadio;

    @FXML
    private Button exitButton;

    @FXML
    private Tab patientTab;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private TextField sysBPField;

    @FXML
    private Tab reportsTab;

    @FXML
    private TabPane tabPanel;

    @FXML
    private RadioButton bpNoRadio;

    @FXML
    private RadioButton smokeNoRadio;

    @FXML
    private ToggleGroup diabetes;

    @FXML
    private ToggleGroup hyp;
    
    @FXML
    private Button clearButton;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Label ageErrorLabel;
    
    @FXML
    private Label educationErrorLabel;
    
    @FXML
    private Label cigsErrorLabel;
    
    @FXML
    private Label totCholErrorLabel;
    
    @FXML
    private Label sysBPErrorLabel;
    
    @FXML
    private Label diaBPErrorLabel;
    
    @FXML
    private Label bmiErrorLabel;
    
    @FXML
    private Label hrErrorLabel;
    
    @FXML
    private Label glucoseErrorLabel;
    
    @FXML
    private BarChart<?, ?> riskBarChart;
  
    @FXML
    private PieChart factorPieChart;
    
    @FXML
    private Pane patientPane;
    
    
    
    //DATA TAB ______________________________________
    
    @FXML
    private TableView<Subject> reportsTable;
   
    @FXML
    private Button submitScatterButton;
    
    @FXML
    private static final ObservableList<String> selectDataList = FXCollections.observableArrayList("All", "Males", "Females", "Non-Smokers", "Smokers", "Hypertension", "10 Year CHD"); 
            
    @FXML
    private ChoiceBox<String> selectChoiceBox;
    
    @FXML
    private TableColumn<?, ?> totCholCol;
    @FXML
    private TableColumn<?, ?> recordNumCol;
    @FXML
    private TableColumn<?, ?> bpMedCol;
    @FXML
    private TableColumn<?, ?> cigCol;
    @FXML
    private TableColumn<?, ?> chdCol;
    @FXML
    private TableColumn<?, ?> sexCol;
    @FXML
    private TableColumn<?, ?> diabeticCol;
    @FXML
    private TableColumn<?, ?> bmiCol;
    @FXML
    private TableColumn<?, ?> bpCol;
    @FXML
    private TableColumn<?, ?> hypCol;
    @FXML
    private TableColumn<?, ?> ageCol;
    @FXML
    private TableColumn<?, ?> strokeCol;
    @FXML
    private TableColumn<?, ?> glucoseCol;
    @FXML
    private TableColumn<?, ?> eduCol;
    @FXML
    private TextField sexPercentField;
    @FXML
    private TextField avgAgeField;
    @FXML
    private TextField avgCigsField;
    @FXML
    private TextField hypPercentField;
    @FXML
    private TextField bpMedPercentField;
    @FXML
    private TextField strokePercentField;
    @FXML
    private TextField diabeticPercentField;
    @FXML
    private TextField avgCholField;
    @FXML
    private TextField avgSysField;
    @FXML
    private TextField avgBMIField;
    @FXML
    private TextField avgGlucoseField;
    @FXML
    private TextField chdPercentField;
    
    
    
    
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        educationBox.setItems(educationList);
        educationBox.setValue(educationBox.getItems().get(0));
        selectChoiceBox.setItems(selectDataList);
        selectChoiceBox.setValue(selectChoiceBox.getItems().get(0));
       
        
        //IMPORTING, PARSING, AND CLEANING DATA FROM CSV
        File csvFile = new File("C:\\Users\\Kevin.MONSTER\\Documents\\NetBeansProjects\\Practice\\Capstone\\src\\capstone\\framingham.csv");
        try {
            Scanner inputStream = new Scanner(csvFile);
            while(inputStream.hasNext()){
                String data = inputStream.next();
                String[] subjectLine = data.split(","); //Parsing CSV
                //Cleaning data and creating subjects
                Subject newSubject = new Subject(idGenerator(),Subject.convertToSex(subjectLine[0]), Subject.convertEdu(subjectLine[1]), Subject.convertEdu(subjectLine[2]), Subject.convertToBool(subjectLine[3]), Subject.convertEdu(subjectLine[4]),
                Subject.convertToBool(subjectLine[5]), Subject.convertToBool(subjectLine[6]), Subject.convertToBool(subjectLine[7]), Subject.convertToBool(subjectLine[8]), Subject.convertEdu(subjectLine[9]), Subject.roundToInt(subjectLine[10]),
                Subject.roundToInt(subjectLine[11]), Subject.stringToFloat(subjectLine[12]), Subject.convertEdu(subjectLine[13]), Subject.convertEdu(subjectLine[14]), Subject.convertToBool(subjectLine[15]) );
                //Adding subjects to array
                subjectArray.add(newSubject);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //TESTING  CODE  SECTION
        double chdGlucose =0;
        double nonGlucose =0;
        double totalWithCHD = 0;

        for(int i=0;i<subjectArray.size();i++){
            if(subjectArray.get(i).isTenYearCHD()){
                totalWithCHD+=1;
                chdGlucose+=subjectArray.get(i).getDiaBP();
            }
            else{
               nonGlucose+=subjectArray.get(i).getDiaBP();
            }
        }
        double a = nonGlucose/(subjectArray.size()-totalWithCHD);
        double b = chdGlucose/totalWithCHD; 
        double result= b - a;
        System.out.println("B ="+b+" "+"A ="+a+" "+result*.01);
   }
       
    
    public static int idGenerator(){
        idCount +=1;
        int newID=idCount;
        return newID;
    }
    
   @FXML
   private void exitProgram(ActionEvent event){
        
        System.exit(0);
    }
   
   @FXML
   private void clearSubject(ActionEvent event){
       patient.clear();
       ageField.clear();
       cigsPerDayField.clear();
       totCholField.clear();
       sysBPField.clear();
       diaBPField.clear();
       bmiField.clear();
       hrField.clear();
       glucoseField.clear();
       ageErrorLabel.setVisible(false);
       educationErrorLabel.setVisible(false);
       cigsErrorLabel.setVisible(false);
       totCholErrorLabel.setVisible(false);
       sysBPErrorLabel.setVisible(false);
       diaBPErrorLabel.setVisible(false);
       bmiErrorLabel.setVisible(false);
       hrErrorLabel.setVisible(false);
       glucoseErrorLabel.setVisible(false);
      
   }
   
   @FXML
   private void submitPatient(ActionEvent event){
       patient.clear();
       ageErrorLabel.setVisible(false);
       educationErrorLabel.setVisible(false);
       cigsErrorLabel.setVisible(false);
       totCholErrorLabel.setVisible(false);
       sysBPErrorLabel.setVisible(false);
       diaBPErrorLabel.setVisible(false);
       bmiErrorLabel.setVisible(false);
       hrErrorLabel.setVisible(false);
       glucoseErrorLabel.setVisible(false);
       
        if(patientIsValid()){
           String subjectSex;
           boolean smoker;
           boolean bpMeds;
           boolean prevStroke;
           boolean hypertension;
           boolean diabetic;
           if(maleRadio.isSelected()){
               subjectSex = "male";
           }
           else{
               subjectSex = "female";
           }
           if(smokeYesRadio.isSelected()){
               smoker = true;
           }
           else{
               smoker = false;
           }
           if(bpYesRadio.isSelected()){
               bpMeds = true;
           }
           else{
               bpMeds = false;
           }
           if(strokeYesRadio.isSelected()){
               prevStroke = true;
           }
           else{
               prevStroke = false;
           }
           if(hypYesRadio.isSelected()){
               hypertension = true;
           }
           else{
               hypertension = false;
           }
           if(diabetesYesRadio.isSelected()){
               diabetic = true;
           }
           else{
               diabetic = false;
           }
           
           int age = Integer.parseInt(ageField.getText());
           int education = Integer.parseInt(String.valueOf(educationBox.getValue().charAt(0)))-1;
           int cigs = Integer.parseInt(cigsPerDayField.getText());
           int chol = Integer.parseInt(totCholField.getText());
           int sysBP = Integer.parseInt(sysBPField.getText());
           int diaBP = Integer.parseInt(diaBPField.getText());
           float bmi = Float.parseFloat(bmiField.getText());
           int hr = Integer.parseInt(hrField.getText());
           int glucose = Integer.parseInt(glucoseField.getText());
           
           Subject newSubject = new Subject(subjectSex, age, education, smoker, cigs, bpMeds, prevStroke, hypertension, diabetic, chol, sysBP, diaBP, bmi, hr, glucose);
           patient.add(newSubject);
           calculateFactors(patient.get(0));
       }
        
        
        
       
   }
    
   public boolean patientIsValid(){
       boolean value = false;
       int errors = 0;
       
       //AGE FIELD CHECK
       if(ageField.getText().isEmpty()){
           errors +=1;
           ageErrorLabel.setText("Must Enter Valid Age 18+");
           ageErrorLabel.setVisible(true);
       }
       else{
           try{
               int age = Integer.parseInt(ageField.getText());
               if(age<18 || age>110){
                errors +=1;   
                ageErrorLabel.setText("Must Enter Valid Age 18+");
                ageErrorLabel.setVisible(true);
               }
           }
           catch(Exception e){
               errors +=1;
               ageErrorLabel.setText("Must enter valid age 18+");
               ageErrorLabel.setVisible(true);
           }
       }
       if(bpYesRadio.isSelected()){
           hypYesRadio.setSelected(true);
       }
       
       //CIGS PER DAY FIELD CHECK
       if(smokeYesRadio.isSelected()){
          try{
              int i = Integer.parseInt(cigsPerDayField.getText());
              if(i<1){
                  errors+=1;
                  cigsErrorLabel.setText("Must enter valid number");
                  cigsErrorLabel.setVisible(true);
                  
              }
          }
          catch(Exception e){
              errors+=1;
              cigsErrorLabel.setText("Must enter valid number");
              cigsErrorLabel.setVisible(true);
          }
       }
       else{
           cigsPerDayField.setText("0");
       }
       
       //TOTAL CHOL FIELD CHECK
       if(totCholField.getText().isEmpty()){
           errors+=1;
           totCholErrorLabel.setText("Must enter valid number");
           totCholErrorLabel.setVisible(true);
       }
       else{
           try{
               int tot = Integer.parseInt(totCholField.getText());
                if(tot<90){
                   errors+=1;
                   totCholErrorLabel.setText("Must enter valid number");
                   totCholErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                totCholErrorLabel.setText("Must enter valid number");
                totCholErrorLabel.setVisible(true); 
           }
       }
       
       
       //SYS BP FIELD CHECK
        if(sysBPField.getText().isEmpty()){
           errors+=1;
           sysBPErrorLabel.setText("Must enter valid number");
           sysBPErrorLabel.setVisible(true);
       }
       else{
           try{
               int bp = Integer.parseInt(sysBPField.getText());
                if(bp<90){
                   errors+=1;
                   sysBPErrorLabel.setText("Must enter valid number");
                   sysBPErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                sysBPErrorLabel.setText("Must enter valid number");
                sysBPErrorLabel.setVisible(true); 
           }
       }
        //DIA BP FIELD CHECK
        if(diaBPField.getText().isEmpty()){
           errors+=1;
           diaBPErrorLabel.setText("Must enter valid number");
           diaBPErrorLabel.setVisible(true);
       }
       else{
           try{
               int bp = Integer.parseInt(diaBPField.getText());
                if(bp<50){
                   errors+=1;
                   diaBPErrorLabel.setText("Must enter valid number");
                   diaBPErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                diaBPErrorLabel.setText("Must enter valid number");
                diaBPErrorLabel.setVisible(true); 
           }
       }
        
        //BMI FIELD CHECK
        if(bmiField.getText().isEmpty()){
           errors+=1;
           bmiErrorLabel.setText("Must enter valid number");
           bmiErrorLabel.setVisible(true);
       }
       else{
           try{
               float bp = Float.parseFloat(diaBPField.getText());
                if(bp<(float)18){
                   errors+=1;
                   bmiErrorLabel.setText("Must enter valid number");
                   bmiErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                bmiErrorLabel.setText("Must enter valid number");
                bmiErrorLabel.setVisible(true); 
           }
       }
        
        //HEART RATE FIELD CHECK
        if(hrField.getText().isEmpty()){
           errors+=1;
           hrErrorLabel.setText("Must enter valid number");
           hrErrorLabel.setVisible(true);
       }
       else{
           try{
               int hr = Integer.parseInt(hrField.getText());
                if(hr<40){
                   errors+=1;
                   hrErrorLabel.setText("Must enter valid number");
                   hrErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                hrErrorLabel.setText("Must enter valid number");
                hrErrorLabel.setVisible(true); 
           }
       }
        
        
        //GLUCOSE FIELD CHECK
          if(glucoseField.getText().isEmpty()){
           errors+=1;
           glucoseErrorLabel.setText("Must enter valid number");
           glucoseErrorLabel.setVisible(true);
       }
       else{
           try{
               int glucose = Integer.parseInt(glucoseField.getText());
                if(glucose<55){
                   errors+=1;
                   glucoseErrorLabel.setText("Must enter valid number");
                   glucoseErrorLabel.setVisible(true); 
                }
           }
           catch(Exception e){
                errors+=1;
                glucoseErrorLabel.setText("Must enter valid number");
                glucoseErrorLabel.setVisible(true); 
           }
       }
       
        if(errors==0){
            value=true;
        }
       
       
        return value;
   }
   
   
   //LOADS PATIENT ANALYSIS LINECHART WITH DATA

    
   
   private void calculateFactors(Subject subject){
        riskBarChart.getData().clear();
        factorPieChart.getData().clear();
        double totalMale = 0;
        double chdTotalAge = 0;
        double nonTotalAge = 0;
        double chdEduTotal = 0;
        double nonEduTotal = 0;
        double chdSmokers = 0;
        double totalSmokers = 0;
        double chdCigs = 0;
        double nonCigs = 0;
        double chdBPMed =0;
        double nonBPMed = 0;
        double chdHyp = 0;
        double nonHyp = 0;
        double chdStroke = 0;
        double nonStroke = 0;
        double chdDiabetes = 0;
        double nonDiabetes = 0;
        double chdChol=0;
        double nonChol=0;
        double chdSysBP=0;
        double nonSysBP=0;
        double chdDiaBP=0;
        double nonDiaBP=0;
        double chdBMI=0;
        double nonBMI=0;
        double chdHR=0;
        double nonHR=0;
        double chdGlucose=0;
        double nonGlucose=0;
        double totalWithCHD = 0;
        for(int i=0;i<subjectArray.size();i++){
            if(subjectArray.get(i).isTenYearCHD()){
                totalWithCHD+=1;
                chdTotalAge+=subjectArray.get(i).getAge();
                chdEduTotal+=subjectArray.get(i).getEducation();
                chdChol+=subjectArray.get(i).getTotalChol();
                chdSysBP+=subjectArray.get(i).getSysBP();
                chdDiaBP+=subjectArray.get(i).getDiaBP();
                chdBMI+=subjectArray.get(i).getBMI();
                chdHR+=subjectArray.get(i).getHeartRate();
                chdGlucose+=subjectArray.get(i).getGlucose();
                if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                    totalMale+=1;
                }
                if(subjectArray.get(i).isSmoker()){
                    chdSmokers+=1;
                    totalSmokers+=1;
                    chdCigs+=subjectArray.get(i).getCigsPerDay();
                }
                if(subjectArray.get(i).isBpMeds()){
                    chdBPMed+=1;
                }
                if(subjectArray.get(i).isPrevHyp()){
                    chdHyp+=1;
                }
                if(subjectArray.get(i).isPrevStroke()){
                    chdStroke+=1;
                }
                if(subjectArray.get(i).isDiabetes()){
                    chdDiabetes+=1;
                }
            }
            else{
                nonTotalAge+=subjectArray.get(i).getAge();
                nonEduTotal+=subjectArray.get(i).getEducation();
                nonChol+=subjectArray.get(i).getTotalChol();
                nonSysBP+=subjectArray.get(i).getSysBP();
                nonDiaBP+=subjectArray.get(i).getDiaBP();
                nonBMI+=subjectArray.get(i).getBMI();
                nonHR+=subjectArray.get(i).getHeartRate();
                nonGlucose+=subjectArray.get(i).getGlucose();
                if(subjectArray.get(i).isSmoker()){
                    totalSmokers+=1;
                    nonCigs+=subjectArray.get(i).getCigsPerDay();
                }
                if(subjectArray.get(i).isBpMeds()){
                    nonBPMed+=1;
                    
                }
                if(subjectArray.get(i).isPrevHyp()){
                    nonHyp+=1;
                }
                if(subjectArray.get(i).isPrevStroke()){
                    nonStroke+=1;
                }
                 if(subjectArray.get(i).isDiabetes()){
                    nonDiabetes+=1;
                }
            }
            
        }
        double maleFactor = totalMale/totalWithCHD;
        double femaleFactor = (totalWithCHD-totalMale)/totalWithCHD;
        double ageFactor = ((chdTotalAge/totalWithCHD)-(nonTotalAge/(subjectArray.size()-totalWithCHD)))*.01;
        double eduFactor = ((chdEduTotal/totalWithCHD)-(nonEduTotal/(subjectArray.size()-totalWithCHD)))*.01;
        double smokeFactor = chdSmokers/totalSmokers;
        double cigsFactor = (((chdCigs/chdSmokers)-(nonCigs/totalSmokers-chdSmokers)))*.0001;
        double noMedsHypFactor = chdHyp/(chdHyp+nonHyp);
        double bpMedsHypFactor = noMedsHypFactor-(chdBPMed/(chdBPMed+nonBPMed));
        double strokeFactor = chdStroke/(chdStroke+nonStroke);
        double diabetesFactor = chdDiabetes/(chdDiabetes+nonDiabetes);
        double avgNonChol = nonChol/(subjectArray.size()-totalWithCHD);
        double totCholFactor = ((chdChol/totalWithCHD)-avgNonChol)*.01; // RISK ASSESSED > 232  avgNonChol
        double avgNonSys = nonSysBP/(subjectArray.size()-totalWithCHD);
        double sysBPFactor = ((chdSysBP/totalWithCHD)-avgNonSys)*.01;// Risk Assessed Above > 130 avgNonSys
        double avgNonDiaBP = nonDiaBP/(subjectArray.size()-totalWithCHD);
        double diaBPFactor = ((chdDiaBP/totalWithCHD)-avgNonDiaBP)*.01;//Risk assessed Above >82 avgNonDiaBP
        double avgNonBMI = nonBMI/(subjectArray.size()-totalWithCHD);
        double bmiFactor = ((chdBMI/totalWithCHD)-avgNonBMI)*.01; //Risk assessed Above > 25 avgNonBMI
        double avgNonHR = nonHR/(subjectArray.size()-totalWithCHD);
        double hrFactor = ((chdHR/totalWithCHD)-avgNonHR)*.01; //Risk assessed Above > 75 avgNonHR
        double avgNonGlucose = nonGlucose/(subjectArray.size()-totalWithCHD);
        double glucoseFactor = ((chdGlucose/totalWithCHD)-avgNonGlucose)*.01; //Risk assessed Above 73 avgNonGlucose
        
        
        //CALCUATING SUBJECT PROBABILITY
        double subSexFactor;
        double subAgeFactor = subject.getAge()*ageFactor;
        double subSecAgeFactor = (subject.getAge()+10)*ageFactor;
        double subThrAgeFactor = (subject.getAge()+20)*ageFactor;
        double subEdFactor = subject.getEducation()*eduFactor;
        double subSmokeFactor;
        double subCigsFactor = subject.getCigsPerDay()*cigsFactor;
        double subHypFactor;
        double subStrokeFactor;
        double subDiabeticFactor;
        double subCholFactor;
        double subSysFactor;
        double subDiaFactor;
        double subBMIFactor;
        double subHRFactor;
        double subGlucoseFactor;
        if(subject.getSex().equalsIgnoreCase("male")){
            subSexFactor = maleFactor;
        }
        else{
            subSexFactor = femaleFactor;
        }
        if(subject.isSmoker()){
            subSmokeFactor = smokeFactor;
        }
        else{
            subSmokeFactor = 0;
        }
        if(subject.isPrevHyp()){
            if(subject.isBpMeds()){
                subHypFactor = noMedsHypFactor-bpMedsHypFactor;
            }
            else{
                subHypFactor = noMedsHypFactor;
            }
        }
        else{
            subHypFactor = 0;
        }
        if(subject.isPrevStroke()){
            subStrokeFactor = strokeFactor;
        }
        else{
            subStrokeFactor = 0;
        }
        if(subject.isDiabetes()){
            subDiabeticFactor = diabetesFactor;
        }
        else{
            subDiabeticFactor = 0;
        }
        if(subject.getTotalChol()>avgNonChol){
            subCholFactor = (subject.getTotalChol()-avgNonChol)*totCholFactor;
        }
        else{
            subCholFactor = 0;
        }
        if(subject.getSysBP()>avgNonSys){
            subSysFactor = (subject.getSysBP()-avgNonSys)*sysBPFactor;
        }
        else{
            subSysFactor = 0;
        }
        if(subject.getDiaBP()>avgNonDiaBP){
            subDiaFactor = (subject.getDiaBP()-avgNonDiaBP)*diaBPFactor;
        }
        else{
            subDiaFactor = 0;
        }
        if(subject.getBMI()>avgNonBMI){
            subBMIFactor = (subject.getBMI()-avgNonBMI)*bmiFactor;
        }
        else{
            subBMIFactor = 0;
        }
        if(subject.getHeartRate()>avgNonHR){
            subHRFactor = (subject.getHeartRate()-avgNonHR)*hrFactor;
        }
        else{
            subHRFactor = 0;
        }
        if(subject.getGlucose()>avgNonGlucose){
            subGlucoseFactor = (subject.getGlucose()-avgNonGlucose)*glucoseFactor;
        }
        else{
            subGlucoseFactor = 0;
        }
        
      // Male Factor: "+maleFactor+", Female Factor: "+femaleFactor+ ", Age Factor: "+ageFactor+", Edu Factor: "+eduFactor+", Smoke Factor: "+smokeFactor+", Cigs Factor: "+cigsFactor+", No Med Hyp: "+noMedsHypFactor+", Meds Hyp Factor: "+bpMedsHypFactor+
     //  ", Stoke Factor: "+strokeFactor+", Diabetic Factor: "+diabetesFactor+", Chol Factor: "+totCholFactor+", Sys BP: "+sysBPFactor+", Dia BP: "+diaBPFactor+", BMI: "+bmiFactor+", HR: "+hrFactor+", Glucose: "+glucoseFactor
        double currentProb = subSexFactor+subAgeFactor+subEdFactor+subSmokeFactor+subCigsFactor+subHypFactor+subStrokeFactor+subDiabeticFactor+subCholFactor+subSysFactor+subDiaFactor+subBMIFactor+subHRFactor+subGlucoseFactor;
        double secProb = subSexFactor+subSecAgeFactor+subEdFactor+subSmokeFactor+subCigsFactor+subHypFactor+subStrokeFactor+subDiabeticFactor+subCholFactor+subSysFactor+subDiaFactor+subBMIFactor+subHRFactor+subGlucoseFactor;
        double thrProb = subSexFactor+subThrAgeFactor+subEdFactor+subSmokeFactor+subCigsFactor+subHypFactor+subStrokeFactor+subDiabeticFactor+subCholFactor+subSysFactor+subDiaFactor+subBMIFactor+subHRFactor+subGlucoseFactor;
        System.out.println("PROB: "+currentProb+", Sex: "+ subSexFactor+", Age: "+subAgeFactor+", Ed: "+subEdFactor+", Smoke: "+subSmokeFactor+", Cigs: "+subCigsFactor+", HYP: "+subHypFactor+", Stroke: "+subStrokeFactor+", Diabetics: "+subDiabeticFactor+
                ", Chol: "+subCholFactor+", Sys: "+subSysFactor+", Dia: "+subDiaFactor+", BMI: "+subBMIFactor+", HR: "+subHRFactor+", Glucose: "+subGlucoseFactor);
        
        
        //LOAD LINE CHART 
        
       XYChart.Series series = new XYChart.Series<>();
       series.getData().add(new XYChart.Data(String.valueOf(subject.getAge())+"-"+String.valueOf(subject.getAge()+10), currentProb));
       series.getData().add(new XYChart.Data(String.valueOf(subject.getAge()+10)+"-"+String.valueOf(subject.getAge()+20), secProb));
       series.getData().add(new XYChart.Data(String.valueOf(subject.getAge()+20)+"-"+String.valueOf(subject.getAge()+30), thrProb));
       series.setName("Coronary Heart Disease");
       riskBarChart.getData().addAll(series);
        
       
       //LOAD PIE CHART
       
       factorPieChart.getData().add(new PieChart.Data(subject.getSex(),subSexFactor));
       factorPieChart.getData().add(new PieChart.Data("Age",subAgeFactor));
       factorPieChart.getData().add(new PieChart.Data("Education/Demographic",subEdFactor));
       if(subGlucoseFactor>0){
           factorPieChart.getData().add(new PieChart.Data("Glucose",subGlucoseFactor));
       }
       if(subHRFactor>0){
           factorPieChart.getData().add(new PieChart.Data("Heart Rate",subHRFactor));
       }
       if(subBMIFactor>0){
           factorPieChart.getData().add(new PieChart.Data("Body Mass Index",subBMIFactor));
       }
       if(subCholFactor>0){
           factorPieChart.getData().add(new PieChart.Data("Cholesterol",subCholFactor));
       }
       if(subject.isDiabetes()){
           factorPieChart.getData().add(new PieChart.Data("Diabetes",subDiabeticFactor));
       }
       if(subject.isPrevStroke()){
           factorPieChart.getData().add(new PieChart.Data("Previous Stroke",subStrokeFactor));
       }
       if(subject.isPrevHyp() || subSysFactor>0 || subDiaFactor >0){
           factorPieChart.getData().add(new PieChart.Data("Hypertension",subHypFactor+subSysFactor+subDiaFactor));
       }
       if(subject.isSmoker()){
            factorPieChart.getData().add(new PieChart.Data("Smoking",subSmokeFactor+subCigsFactor));
       }
   }

   @FXML
   private void loadDataReport(ActionEvent e){
       sortedSubjectArray.clear();
       if(selectChoiceBox.getValue().equalsIgnoreCase("All")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           
           for(int i=0;i<subjectArray.size();i++){
                totalAge+=subjectArray.get(i).getAge();
                
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales++;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp++;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP++;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke++;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
           }
           
           reportsTable.setItems(subjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/subjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/subjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/subjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/subjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/subjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/subjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/subjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/subjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/subjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/subjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/subjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/subjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/subjectArray.size()).substring(4,5)+"%");
           
       }
       if(selectChoiceBox.getValue().equalsIgnoreCase("Males")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
                  
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales+=1;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
           }
           reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
       }
       if(selectChoiceBox.getValue().equalsIgnoreCase("Females")){
           
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(subjectArray.get(i).getSex().equalsIgnoreCase("female")){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
       
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
               
           }
            reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
       }

       if(selectChoiceBox.getValue().equalsIgnoreCase("Non-Smokers")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(!subjectArray.get(i).isSmoker()){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
            
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales+=1;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
           }
           reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
           
           
           
           
           
           
       }
       if(selectChoiceBox.getValue().equalsIgnoreCase("Smokers")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(subjectArray.get(i).isSmoker()){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
        
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales+=1;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
           }
             reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
       }
       if(selectChoiceBox.getValue().equalsIgnoreCase("Hypertension")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(subjectArray.get(i).isPrevHyp()){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
       
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales+=1;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
           }
            reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
       }
       if(selectChoiceBox.getValue().equalsIgnoreCase("10 year CHD")){
           double totalMales=0;
           int totalAge=0;
           int totalCigs=0;
           double totalHyp=0;
           double totalBP=0;
           double totalStroke=0;
           double totalDiabetic=0;
           int totalChol=0;
           int totalSys=0;
           double totalBMI=0;
           int totalGlucose=0;
           double totalCHD=0;
           for(int i=0;i<subjectArray.size();i++){
               if(subjectArray.get(i).isTenYearCHD()){
                   sortedSubjectArray.add(subjectArray.get(i));
                   totalAge+=subjectArray.get(i).getAge();
         
                   totalCigs+=subjectArray.get(i).getCigsPerDay();
                   totalChol+=subjectArray.get(i).getTotalChol();
                   totalSys+=subjectArray.get(i).getSysBP();
                   totalBMI+=subjectArray.get(i).getBMI();
                   totalGlucose+=subjectArray.get(i).getGlucose();
                   if(subjectArray.get(i).getSex().equalsIgnoreCase("male")){
                       totalMales+=1;
                   }
                   if(subjectArray.get(i).isPrevHyp()){
                       totalHyp+=1;
                   }
                   if(subjectArray.get(i).isBpMeds()){
                       totalBP+=1;
                   }
                   if(subjectArray.get(i).isPrevStroke()){
                       totalStroke+=1;
                   }
                   if(subjectArray.get(i).isDiabetes()){
                       totalDiabetic+=1;
                   }
                   if(subjectArray.get(i).isTenYearCHD()){
                       totalCHD+=1;
                   }
               }
           }
           reportsTable.setItems(sortedSubjectArray);
           recordNumCol.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
           sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
           eduCol.setCellValueFactory(new PropertyValueFactory<>("education"));
           cigCol.setCellValueFactory(new PropertyValueFactory<>("cigsPerDay"));
           hypCol.setCellValueFactory(new PropertyValueFactory<>("prevHyp"));
           bpMedCol.setCellValueFactory(new PropertyValueFactory<>("bpMeds"));
           strokeCol.setCellValueFactory(new PropertyValueFactory<>("prevStroke"));
           diabeticCol.setCellValueFactory(new PropertyValueFactory<>("diabetes"));
           totCholCol.setCellValueFactory(new PropertyValueFactory<>("totalChol"));
           bpCol.setCellValueFactory(new PropertyValueFactory<>("sysBP"));
           bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
           glucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
           chdCol.setCellValueFactory(new PropertyValueFactory<>("tenYearCHD"));
           
           sexPercentField.setText(String.valueOf(totalMales/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalMales/sortedSubjectArray.size()).substring(4,5)+"%");
           avgAgeField.setText(String.valueOf(Math.round(totalAge/sortedSubjectArray.size())));
           avgCigsField.setText(String.valueOf(Math.round(totalCigs/sortedSubjectArray.size())));
           hypPercentField.setText(String.valueOf(totalHyp/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalHyp/sortedSubjectArray.size()).substring(4,5)+"%");
           bpMedPercentField.setText(String.valueOf(totalBP/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalBP/sortedSubjectArray.size()).substring(4,5)+"%");
           strokePercentField.setText(String.valueOf(totalStroke/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalStroke/sortedSubjectArray.size()).substring(4,5)+"%");
           diabeticPercentField.setText(String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalDiabetic/sortedSubjectArray.size()).substring(4,5)+"%");
           avgCholField.setText(String.valueOf(Math.round(totalChol/sortedSubjectArray.size())));
           avgSysField.setText(String.valueOf(Math.round(totalSys/sortedSubjectArray.size())));
           avgBMIField.setText(String.valueOf(totalBMI/sortedSubjectArray.size()));
           avgGlucoseField.setText(String.valueOf(Math.round(totalGlucose/sortedSubjectArray.size())));
           chdPercentField.setText(String.valueOf(totalCHD/sortedSubjectArray.size()).substring(2, 4)+"."+String.valueOf(totalCHD/sortedSubjectArray.size()).substring(4,5)+"%");
       }
       
       
   }
   
   @FXML
   private void analyzeRecord(ActionEvent e){
       Subject subject = reportsTable.getSelectionModel().getSelectedItem();
       ageField.setText(String.valueOf(subject.getAge()));
       cigsPerDayField.setText(String.valueOf(subject.getCigsPerDay()));
       totCholField.setText(String.valueOf(subject.getTotalChol()));
       sysBPField.setText(String.valueOf(subject.getSysBP()));
       diaBPField.setText(String.valueOf(subject.getDiaBP()));
       bmiField.setText(String.valueOf(subject.getBMI()));
       hrField.setText(String.valueOf(subject.getHeartRate()));
       glucoseField.setText(String.valueOf(subject.getGlucose()));
       educationBox.setItems(educationList);
       educationBox.setValue(educationBox.getItems().get(subject.getEducation()));
       if(subject.getSex().equalsIgnoreCase("male")){
           maleRadio.setSelected(true);
       }
       else{
           femaleRadio.setSelected(true);
       }
       if(subject.isSmoker()){
           smokeYesRadio.setSelected(true);
       }
       else{
           smokeNoRadio.setSelected(true);
       }
       if(subject.isBpMeds()){
           bpYesRadio.setSelected(true);
       }
       else{
           bpNoRadio.setSelected(true);
       }
       if(subject.isPrevStroke()){
           strokeYesRadio.setSelected(true);
       }
       else{
           strokeNoRadio.setSelected(true);
       }
       if(subject.isPrevHyp()){
           hypYesRadio.setSelected(true);
       }
       else{
           hypNoRadio.setSelected(true);
       }
       if(subject.isDiabetes()){
           diabetesYesRadio.setSelected(true);
       }
       else{
           diabetesNoRadio.setSelected(true);
       }
       tabPanel.getSelectionModel().select(patientTab);
       submitPatient(e);
   } 
   

    
}
