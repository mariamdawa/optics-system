/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bloodymary
 */
public class ChoiceController implements Initializable {
@FXML
private Button employee,purchase;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML private void create(ActionEvent e) throws IOException{
        Parent employee=FXMLLoader.load(getClass().getResource("Employee.fxml"));
           Scene employeeScene=new Scene(employee);
           Stage login=(Stage)((Node)e.getSource()).getScene().getWindow(); 
           login.hide();
           login.setScene(employeeScene);
           login.show();
        
        
    }
    @FXML private void purchase(ActionEvent ev) throws IOException{
        Parent employee=FXMLLoader.load(getClass().getResource("Purchase.fxml"));
           Scene employeeScene=new Scene(employee);
           Stage login=(Stage)((Node)ev.getSource()).getScene().getWindow(); 
           login.hide();
           login.setScene(employeeScene);
           login.show();
        
    }
    
}
