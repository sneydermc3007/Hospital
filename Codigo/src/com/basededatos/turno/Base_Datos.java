//CRUD tbl_Turno
package com.basededatos.turno;

import java.sql.*;
import com.basededatos.ClsConexion;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Datos extends ClsQueries{
    private final float ID;
    private final Date cita;
    private final String observacion;
    private final String estado;

    Connection cnnConnection;
    Statement state;
    ResultSet result;

    public Base_Datos(float ID, Date cita, String observacion, String estado) {
        this.ID = ID;
        this.cita = cita;
        this.observacion = observacion;
        this.estado = estado;
    }

    float resultado = 0;
    ClsConexion objcone = new ClsConexion();

    @Override
    public float Query(float ID, Date Cita, String Observacion) { //Adicionar
        objcone.Conexion();
        String consulta = "INSERT INTO tbl_turno (ID_TURNO, Fecha_Turno, Observacion) " +
                "VALUES ("+ID+", '"+Cita+"', '"+Observacion+"')";
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
            result = state.executeQuery(" SELECT * FROM tbl_turno WHERE ID_TURNO = "+ID+" ");
        }catch (SQLException e){
            Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }

    @Override
    public void QueryModificar(float ID, Date Cita, String Observacion) { //Modificar
        objcone.Conexion();
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
    public void QueryEliminar(float ID) { //Anular
        objcone.Conexion();
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate(" UPDATE tbl_turno SET Estado = '"+estado+"' WHERE ID_TURNO = "+ID+" ");
            System.out.println("Cita cancelada");
            System.out.println("-----------------------------------------------------");
        }catch (SQLException e) {
            Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Registro no existente");
        }
    }
}