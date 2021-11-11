package com.basededatos;

import java.util.Scanner;

public class ClsModificar {
    public void menu() {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("--- Digite la opción en la que la desea modificar. ---");
        System.out.println("---   1. Paciente.  ---");
        System.out.println("---   2. Medico.    ---");
        System.out.println("---   3. Turno.     ---");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1 -> Paciente();
            case 2 -> Medico();
            case 3 -> Turno();
            default -> System.out.println("Opción no valida");
        }
    }

    public void Turno() {}
    public void Medico() {}
    public void Paciente() {}
}
