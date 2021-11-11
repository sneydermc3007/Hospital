//CRUD tbl_Turno
package com.basededatos.turno;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Datos_T extends ClsQueries{
    private final float ID;
    private final Date cita;
    private final String observacion;

    Connection cnnConnection;
    Statement state;
    ResultSet result;

    public Base_Datos_T(float ID, Date cita, String observacion) {
        this.ID = ID;
        this.cita = cita;
        this.observacion = observacion;
    }

    float resultado = 0;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/hospital_poo?&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    public void ConexionTurno(){
        try {
            Class.forName(driver);
            cnnConnection = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Base_Datos_T.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public float Query() { //Adicionar
        ConexionTurno();
        String consulta = "INSERT INTO tbl_turno (ID_TURNO, Fecha_Turno, Observacion) " +
                "VALUES ("+ID+", '"+cita+"', '"+observacion+"')";
        try {
            state = cnnConnection.createStatement();
            resultado = state.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public float Query(float ID) { //Consultar
        ConexionTurno();
        try {
            state = cnnConnection.createStatement();
            result = state.executeQuery(" SELECT * FROM tbl_turno WHERE ID_TURNO = "+ID+" ");
        }catch (SQLException e){
            Logger.getLogger(Base_Datos_T.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }

    @Override
    public void QueryModificar(float ID, Date Cita, String Observacion) { //Modificar
        ConexionTurno();
        String query = " UPDATE tbl_turno SET Fecha_Turno = '"+Cita+"', Observacion = '"+Observacion+"' WHERE(ID_TURNO = "+ID+") ";
        try {
            state = cnnConnection.createStatement();
            state.executeUpdate(query);
            System.out.println("Registro de la cita actualizado");
            System.out.println("-----------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Problemas al actualizar el registro de la cita.");
        }
    }

    @Override
    public void QueryEliminar(float ID, String estado) { //Anular
        ConexionTurno();
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate(" UPDATE tbl_turno SET Estado = '"+estado+"' WHERE ID_TURNO = "+ID+" ");
            System.out.println("Cita cancelada");
            System.out.println("-----------------------------------------------------");
        }catch (SQLException e) {
            Logger.getLogger(Base_Datos_T.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Registro no existente");
        }
    }
}