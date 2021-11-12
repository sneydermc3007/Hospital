//Clase abstracta
package com.basededatos.medico;

import java.sql.ResultSet;

public abstract class ClsQueries {

    abstract public float Query();
    abstract public ResultSet Query(float ID);
    abstract public void QueryModificar();
    abstract public void QueryEliminar();
}