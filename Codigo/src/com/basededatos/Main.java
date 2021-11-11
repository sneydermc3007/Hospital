package com.basededatos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        int tabla;

        System.out.println("---Digite la opción ---.");
        System.out.println("---   1.Agregar.    ---");
        System.out.println("---   2.Modificar.  ---"); //todos datos
        System.out.println("---   3.Eliminar.   ---");//id
        System.out.println("---   4.Consultar.  ---");//id
        tabla = lector.nextInt();

        switch (tabla) {
            case 1:
                ClsAgregar agregar = new ClsAgregar();
                agregar.menu();
                break;
            case 2:
                ClsModificar modificar = new ClsModificar();
                break;
            case 3:
                ClsEliminar eliminar= new ClsEliminar();
                break;
            case 4:
                ClsConsultar consultar=new ClsConsultar();
                break;
            default:
                System.out.println("La opción ingresada no se ha encontrado.");
        }
    }
}
