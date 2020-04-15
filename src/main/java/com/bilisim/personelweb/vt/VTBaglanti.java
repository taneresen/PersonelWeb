package com.bilisim.personelweb.vt;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VTBaglanti {

    // static koymadik.Amac Baglanti acacagimiz yerde vt baglantidan obje olusturacagiz.
    public Connection baglantiAc() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.238:5432/pbs", "postgres", "postgres");
            
            return conn;
        } catch (ClassNotFoundException ex) {

            System.err.println("Postgresql JDBC driver bulunmadi");
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            System.err.println("SQL hatasi olustu!" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }

    }
    
    public void baglantiKapat(Connection p_conn)
   {
        try {
            p_conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   
   
   
   
   }

}
