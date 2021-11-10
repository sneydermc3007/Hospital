package com.basededatos.paciente;

import java.util.Date;

public abstract class ClsQueries {

    abstract public float Query(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                                char pais, String telefono, String email, String observacion);
    abstract public float Query(float ID);
    abstract public void QueryModificar(float ID, String nombres, String apellidos, Date nacimiento, String domicilio,
                                        char pais, String telefono, String email, String observacion);
    abstract public void QueryEliminar(float ID);
}
