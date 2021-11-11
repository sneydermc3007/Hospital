//Clase abstracta
package com.basededatos.medico;

public abstract class ClsQueries {

    abstract public float Query();
    abstract public float Query(float ID);
    abstract public void QueryModificar(float ID, String nombres, String apellidos);
    abstract public void QueryEliminar(float ID);
}