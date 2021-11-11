package com.basededatos.paciente;

import java.sql.Date;
import java.sql.ResultSet;

public abstract class ClsQueries {

    abstract public float Query(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                                String pais, String telefono, String email, String observacion);
    abstract public ResultSet Query(float ID);
    abstract public void QueryModificar(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                                        String pais, String telefono, String email, String observacion);
    abstract public void QueryEliminar(float ID);
}
