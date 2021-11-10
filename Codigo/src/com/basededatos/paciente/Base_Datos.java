package com.basededatos.paciente;

import com.basededatos.ClsConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Datos extends ClsQueries{
    private final float ID;
    private final String nombres;
    private final String apellidos;
    private final Date nacimiento;
    private final String domicilio;
    private final char pais;
    private final String telefono;
    private final String email;
    private final String observacion;

    Connection cnnConnection;
    Statement state;
    ResultSet result;

    public Base_Datos(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                      char pais, String telefono, String email, String observacion) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.domicilio = domicilio;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.observacion = observacion;
    }

    float resultado = 0;
    ClsConexion objcone = new ClsConexion();

    @Override
    public float Query(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                       char pais, String telefono, String email, String observacion) { //Adicionar
        objcone.Conexion();
        String consulta = "INSERT INTO tbl_paciente (ID_PACIENTE, Nombre_P, Apellido, Fecha_Nacimiento, Domicilio, ID_Pais, Telefono, Email, Observacion) " +
                            "VALUES ("+ID+", '"+nombres+"', '"+apellidos+"', '"+nacimiento+"', '"+domicilio+"', '"+pais+"', '"+telefono+"', '"+email+"', '"+observacion+"')";
        try{
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
            result = state.executeQuery(" SELECT * FROM tbl_paciente WHERE ID_PACIENTE = "+ID+" ");
        } catch (SQLException e){
            Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultado;
    }

    @Override
    public void QueryModificar(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                               char pais, String telefono, String email, String observacion) {
        objcone.Conexion();
        String query = "UPDATE tbl_paciente SET Nombre_P = '"+nombres+"', Apellido = '"+apellidos+"', Fecha_Nacimiento = '"+nacimiento+"', Domicilio = '"+domicilio+"', " +
                "ID_Pais = '"+pais+"', Telefono = '"+telefono+"', Email = '"+email+"', Observacion = '"+observacion+"' WHERE (ID_PACIENTE = "+ID+")";
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate(query);
            System.out.println("Registro paciente actualizado");
            System.out.println("-----------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Problemas al actualizar el registro del paciente.");
        }
    }

    @Override
    public void QueryEliminar(float ID) {
        objcone.Conexion();
        try{
            state = cnnConnection.createStatement();
            state.executeUpdate("DELETE FROM tbl_paciente WHERE ID_PACIENTE = "+ID+"");
            System.out.println("Registro eliminado");
            System.out.println("-----------------------------------------------------");
        } catch (SQLException e) {
            Logger.getLogger(com.basededatos.medico.Base_Datos.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Registro no existente");
        }
    }
}