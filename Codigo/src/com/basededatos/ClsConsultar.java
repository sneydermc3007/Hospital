package com.basededatos;

import javax.swing.table.DefaultTableModel;
import java.util.Scanner;

public class ClsConsultar {
    public void menu() {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("---Digite la opción---.");
        System.out.println("---   1.Paciente.  ---");
        System.out.println("---   2.Medico.    ---");
        System.out.println("---   3.Turno.     ---");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1:
                Paciente();
                break;
            case 2:
                Medico();
                break;
            case 3:
                Turno();
                break;
            default:
                System.out.println("Opcion no encontrada");
        }

    }

    private void Paciente() {
        Scanner lector = new Scanner(System.in);
        int ID_TURNO;
        System.out.println("Digite el ID del paciente:");
        ID_TURNO = lector.nextInt();
        //declararión de la clase y del objeto
    }

    private void Medico() {
        Scanner lector=new Scanner(System.in);
        int ID_MEDICO;
        System.out.println("Digite el ID del medico:");
        ID_MEDICO=lector.nextInt();
        //declararión de la clase y del objeto
    }

    private void Turno() {
        Scanner lector=new Scanner(System.in);
        int ID_TURNO;
        System.out.println("Digite el ID turno:");
        ID_TURNO= lector.nextInt();
        //declararión de la clase y del objeto
    }
}
