/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author bloodymary
 */
public class Employee {
     private String name;
    private String id,SSN;
    private String password;
    private LocalDate dob;
    private String m_phone;
    private String h_phone;
    private String emg_phone;
    private String note;
    private boolean mang;
    

    public Employee(String name, String id, String password, LocalDate dob, String m_phone, String h_phone, String emg_phone, String note, boolean mang, String SSN) throws SQLException {
        this.name = name;
        this.id = id;
        this.password = password;
        this.dob = dob;
        this.m_phone = m_phone;
        this.h_phone = h_phone;
        this.emg_phone = emg_phone;
        this.note = note;
        this.mang = mang;
        this.SSN=SSN;
        
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Barki","BarkiOptics","123123"); 
         PreparedStatement st = conn.prepareStatement("insert into  EMPLOYEES(SSN,NAME,M_PHONE,H_PHONE,EMG_PHONE,NOTE,MANAGER,ID,PASSWORD) values (?,?,?,?,?,?,?,?,?)");
         st.setString(1,SSN);
         st.setString(2,name);

         st.setString(3,m_phone);
         st.setString(4,h_phone);
         st.setString(5,emg_phone);
         st.setString(6,note);
         st.setBoolean(7, mang);
         st.setString(8, id);
         st.setString(9, password);
         st.executeUpdate();
         conn.commit();

         
         
         
         
                
    }
    public Employee(String name, String id, String password, LocalDate dob, String m_phone, String h_phone, boolean mang, String SSN) throws SQLException {
        this.name = name;
        this.id = id;
        this.password = password;
        this.dob = dob;
        this.m_phone = m_phone;
        this.h_phone = h_phone;
        this.mang = mang;
        this.SSN=SSN;
        
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Barki","BarkiOptics","123123"); 
         PreparedStatement st = conn.prepareStatement("insert into  EMPLOYEES(SSN,NAME,M_PHONE,H_PHONE,MANAGER,ID,PASSWORD) values (?,?,?,?,?,?,?)");
         st.setString(1,SSN);
         st.setString(2,name);

         st.setString(3,m_phone);
         st.setString(4,h_phone);
         st.setBoolean(5, mang);
         st.setString(6, id);
         st.setString(7, password);
         st.executeUpdate();
         conn.commit();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public void setH_phone(String h_phone) {
        this.h_phone = h_phone;
    }

    public void setEmg_phone(String emg_phone) {
        this.emg_phone = emg_phone;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setMang(boolean mang) {
        this.mang = mang;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getM_phone() {
        return m_phone;
    }

    public String getH_phone() {
        return h_phone;
    }

    public String getEmg_phone() {
        return emg_phone;
    }

    public String getNote() {
        return note;
    }

    public boolean isMang() {
        return mang;
    }
    
    
}
