package com.basededatos;

import java.util.Scanner;

public class ClsEliminar extends ClsConsultar{
    //necesitamos mostrar los datos para saber el id a eliminar

    @Override
    public void menu() {
        super.menu();
    }
    public void Turno() {
        Scanner lector=new Scanner(System.in);
        int ID_TURNO;
        System.out.println("Digte el ID del turno:");
        ID_TURNO=lector.nextInt();
    }

    public void Medico() {
        int ID_MEDICO;
        Scanner lector=new Scanner(System.in);
        System.out.println("Digite el ID del medico");
        ID_MEDICO = lector.nextInt();

    }

    public void Paciente() {
        Scanner lector=new Scanner(System.in);
        int ID_PACIENTE;

        //consultar();??
        System.out.println("Digite el ID del paciente:");
        ID_PACIENTE=lector.nextInt();

    }
}


