/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

import static java.lang.System.exit;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bloodymary
 */
public class EmployeeController implements Initializable {
    @FXML
    private TextField name,id,password,ssn,mobile,home,emgphone;
    @FXML
    private DatePicker dob;
    @FXML
    private CheckBox manager;
    @FXML
    private Button submit,cancel;
    @FXML
    private TextArea note;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void submit(ActionEvent e) throws SQLException{
        
        Employee emp=new Employee(name.getText(),
                                    id.getText(),
                                    password.getText(),
                                    dob.getValue(),
                                    mobile.getText(),
                                    home.getText(),
                                    emgphone.getText(),
                                    note.getText(),
                                    manager.isSelected(),
                                    ssn.getText());
        System.out.println(dob.getValue());
        exit(0);
        
        
        
    }
    @FXML
    private void cancel(ActionEvent ev){
        exit(0);
    }
    
}
