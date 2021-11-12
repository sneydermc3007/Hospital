package com.basededatos.turno;

import java.sql.Date;
import java.sql.ResultSet;

public abstract class ClsQueries {

    abstract public float Query();
    abstract public ResultSet Query(float ID);
    abstract public void Query(float ID, Date Cita, String Observacion);
    abstract public void Query(float ID, String estado);
}