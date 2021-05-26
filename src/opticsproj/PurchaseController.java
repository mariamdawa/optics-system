/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

import static java.lang.System.exit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bloodymary
 */
public class PurchaseController implements Initializable {
    ObservableList<String> typeofP=FXCollections.observableArrayList("Sunglasses","Medical Glasses");
    ObservableList<String> typeofL=FXCollections.observableArrayList("Glass","Plastic");
    @FXML
    private TextField name,phone,fbrand,fcode,lbrand,lcode,gbrand,gcode,type,left,right;
    @FXML
    private TextArea note,gnote;
    @FXML
    private ComboBox purchase,material;
    @FXML
    private Button send,cancel;
    @FXML
    private AnchorPane sunglasses,medical;
    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        purchase.setItems(typeofP);
        material.setItems(typeofL);
        
        // TODO
    } 
    @FXML
    private void send(ActionEvent e) throws SQLException{
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Barki", "BarkiOptics","123123");
        PreparedStatement st=con.prepareStatement("Select NUMBER from GLASSES where CODE=? ");
        st.setString(1,gcode.getText());
        ResultSet rs=st.executeQuery();
        rs.next();
        int newnum=rs.getInt(1)-1;
        PreparedStatement st1=con.prepareStatement("Update GLASSES set NUMBER=? ");
        st1.setInt(1,newnum);
        st1.executeUpdate();
        System.out.println(newnum+"    "+ rs.getInt(1));
        con.commit();
        
    }
    @FXML
    private void cancel(ActionEvent event){
        exit(0);
    }
    @FXML
    private void typeChoice(ActionEvent ev){
        if(purchase.getValue()=="Sunglasses"){
            sunglasses.setVisible(true);
            medical.setVisible(false);
        }
        else{
            medical.setVisible(true);
            sunglasses.setVisible(false);
        }
    }
    
    
}
