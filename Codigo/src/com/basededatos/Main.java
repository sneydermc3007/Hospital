package com.basededatos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        int tabla;

        System.out.println("---Digite la opción---.");
        System.out.println("---   1.Agregar.    ---");
        System.out.println("---   2.Modificar.  ---");
        System.out.println("---   3.Elimar.    ---");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1:
                ClsAgregar agregar = new ClsAgregar();
                agregar.menuAgregar();
                break;
            case 2:
                ClsModificar modificar = new ClsModificar();
                break;
        }
    }
}
