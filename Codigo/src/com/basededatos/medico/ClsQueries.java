//Clase abstracta
package com.basededatos.medico;

import java.sql.ResultSet;

public abstract class ClsQueries {

    abstract public float Query();
    abstract public ResultSet Query(float ID);
    abstract public void QueryModificar(float ID, String nombres, String apellidos);
    abstract public void QueryEliminar();
}