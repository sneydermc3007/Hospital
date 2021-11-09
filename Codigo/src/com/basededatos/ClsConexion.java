//Establecer la conexion para el programa principal

package com.basededatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClsConexion {
    Connection cnnConnection;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/hospital_poo?&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    public void Conexion(){
        try {
            Class.forName(driver);
            cnnConnection = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ClsConexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
