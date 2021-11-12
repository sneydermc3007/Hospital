//Conexion Diferentes tablas
package com.basededatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Muestra {
    Connection cnnConnection;
    Statement state;
    ResultSet result;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/hospital_poo?" +
            "&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    public void Conexion_All(){
        try {
            Class.forName(driver);
            cnnConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Muestra.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    ResultSet consultar_all(){
        try {
            Conexion_All();
            String query = "SELECT pa.Nombre_P, pa.Apellido, pa.Observacion, aux.FK_ID_PACIENTE as 'ID PACIENTE' from tbl_paciente AS pa " +
                            "INNER JOIN tbl_auxiliar AS aux on pa.ID_PACIENTE = aux.FK_ID_PACIENTE;";
            state = cnnConnection.createStatement();
            result = state.executeQuery(query);
        }catch (SQLException e){
            Logger.getLogger(Muestra.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
}
