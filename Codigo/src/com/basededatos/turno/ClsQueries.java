package com.basededatos.turno;

import java.sql.Date;

public abstract class ClsQueries {

    abstract public float Query();
    abstract public float Query(float ID);
    abstract public void QueryModificar(float ID, Date Cita, String Observacion);
    abstract public void QueryEliminar(float ID, String estado);
}