/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHDapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Kevin
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


 


public class LoginFXMLController implements Initializable {
    
    private String user = "user";
    private String password = "password";
    
    @FXML
    private Button exitButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Label userErrorLabel;
    
    @FXML
    private Label passwordErrorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException{
        userErrorLabel.setVisible(false);
        passwordErrorLabel.setVisible(false);
        if(userIsValid()&&passwordIsValid()){
        Parent mainParent;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPageFXML.fxml"));
        mainParent = loader.load();
        Scene mainScene = new Scene(mainParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainScene);
        stage.show();
        }
    }
    @FXML
   private void exitProgram(ActionEvent event){
        
        System.exit(0);
    }
   
   private boolean userIsValid(){
       int errors =0;
       if(userField.getText().isEmpty()){
           userErrorLabel.setText("Enter User Name");
           errors++;
       }
       else{
           if(!userField.getText().equals(user)){
               userErrorLabel.setText("Incorrect User Name");
               errors++;
           }
       }
       if(errors>0){
           userErrorLabel.setVisible(true);
        return false;
       }
       else{
           return true;
       }
   }
   private boolean passwordIsValid(){
       int errors =0;
       if(passwordField.getText().isEmpty()){
           passwordErrorLabel.setText("Enter Password");
           errors++;
       }
       else{
           if(!passwordField.getText().equals(password)){
               passwordErrorLabel.setText("Incorrect Password");
               errors++;
           }
       }
       if(errors>0){
           passwordErrorLabel.setVisible(true);
        return false;
       }
       else{
           return true;
       }
   }
}
