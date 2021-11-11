//CRUD tbl_Medico
package com.basededatos.medico;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Datos_M extends ClsQueries {
    private final float ID;
    private final String nombres;
    private final String apellidos;

    Connection cnnConnection;
    Statement state;
    ResultSet result;

    public Base_Datos_M(float id, String nombres, String apellidos) {
        ID = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    float resultado = 0;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/hospital_poo?&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    public void ConexionMedico(){
        try {
            Class.forName(driver);
            cnnConnection = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Base_Datos_M.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public float Query() { //Adicionar
        ConexionMedico();
        String consulta = "INSERT INTO tbl_medico (ID_MEDICO, Nombre_M, Apellido_M) " +
                "VALUES ("+ID+", '"+nombres+"', '"+apellidos+"')";
        try {

            state = cnnConnection.createStatement();
            resultado = state.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ResultSet Query(float ID) { //Consultar
        ConexionMedico();
        try {
            state = cnnConnection.createStatement();
            result = state.executeQuery(" SELECT * FROM tbl_medico WHERE ID_MEDICO = "+ID+" ");
        } catch (SQLException e){
            Logger.getLogger(Base_Datos_M.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public void QueryModificar(float ID, String nombres, String apellidos) { //Modificar
        ConexionMedico();
        String query = " UPDATE tbl_medico SET Nombre_M = '"+nombres+"', Apellido_M = '"+apellidos+"' WHERE(ID_MEDICO = "+ID+") ";
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate(query);
            System.out.println("Registro medico actualizado");
            System.out.println("-----------------------------------------------------");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problemas al actualizar el registro del medico");
        }
    }

    @Override
    public void QueryEliminar(float ID) { //Anular
        ConexionMedico();
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate("DELETE FROM tbl_medico WHERE ID_MEDICO = "+ID+"");
            System.out.println("Registro eliminado");
            System.out.println("-----------------------------------------------------");
        } catch (SQLException e) {
            Logger.getLogger(Base_Datos_M.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Registro no existente");
        }
    }
}