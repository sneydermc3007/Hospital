//CRUD tbl_Medico
package com.basededatos.medico;

import java.sql.*;
import com.basededatos.ClsConexion;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Datos extends ClsQueries {
    private final float ID;
    private final String nombres;
    private final String apellidos;

    Connection cnnConnection;
    Statement state;
    ResultSet result;

    public Base_Datos(float id, String nombres, String apellidos) {
        ID = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    float resultado = 0;
    ClsConexion objcone = new ClsConexion();

    @Override
    public float Query(float ID, String nombres, String apellidos) { //Adicionar
        objcone.Conexion();
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
    public float Query(float ID) { //Consultar
        objcone.Conexion();
        try {
            state = cnnConnection.createStatement();
            result = state.executeQuery(" SELECT * FROM tbl_medico WHERE ID_MEDICO = "+ID+" ");
        } catch (SQLException e){
            Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }

    @Override
    public void QueryModificar(float ID, String nombres, String apellidos) { //Modificar
        objcone.Conexion();
        String query = "UPDATE tbl_medico SET Nombre_M = '"+nombres+"', Apellido_M = '"+apellidos+"' WHERE(ID_MEDICO = "+ID+")";
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
    public void QueryEliminar(float ID) {
        objcone.Conexion();
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate("DELETE FROM tbl_medico WHERE ID_MEDICO = "+ID+"");
            System.out.println("Registro eliminado");
            System.out.println("-----------------------------------------------------");
        } catch (SQLException e) {
            Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Registro no existente");
        }
    }
}