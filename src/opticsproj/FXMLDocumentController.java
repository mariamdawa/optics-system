/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

import static java.awt.SystemColor.info;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 *
 * @author bloodymary
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button login;
    @FXML
    private TextField id;
     @FXML
     private PasswordField password;

    
    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Barki","BarkiOptics","123123");
       try{ PreparedStatement st = conn.prepareStatement("select ID from EMPLOYEES where ID=?");
        st.setString(1,id.getText());
        PreparedStatement st2=conn.prepareStatement("select  * from EMPLOYEES where ID=?");
        st2.setString(1,id.getText());
        ResultSet rs=st2.executeQuery();
        rs.next();
//        System.out.println("THIS IS RESULT"+rs.getString(11));
//        System.out.println(st);
        if(rs.getString(11).compareTo(password.getText())==0){
            if(rs.getBoolean(8)==true){
             Parent manager=FXMLLoader.load(getClass().getResource("choice.fxml"));
             Scene managerScene=new Scene(manager);
            Stage login=(Stage)((Node)event.getSource()).getScene().getWindow(); 
            login.hide();
            login.setScene(managerScene);
            login.show();
            }
            else{
             Parent employee=FXMLLoader.load(getClass().getResource("Purchase.fxml"));
             Scene employeeScene=new Scene(employee);
             Stage login=(Stage)((Node)event.getSource()).getScene().getWindow(); 
             login.hide();
             login.setScene(employeeScene);
             login.show();}
         }
       
        else{
            label.setText("Password invalid");
//            System.out.println(rs.getString(11));
            System.out.println(password.getText());
        }
       }
    
       catch(SQLException e){
           label.setText("Username not valid");
       }
       catch(IOException ex){
           label.setText("Username not valid");
       }
        //kol el 7agat b2a
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
