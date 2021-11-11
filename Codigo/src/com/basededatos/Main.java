package com.basededatos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("---- Menu Principal ----");
        System.out.println("\t 1. Deseo Agregar.  ");
        System.out.println("\t 2. Deseo Modificar.");
        System.out.println("\t 3. Deseo Eliminar. ");
        System.out.println("\t 4. Deseo Consultar.");
        System.out.print("\nEscriba una opción para elegir un apartado del CRUD: ");

        tabla = lector.nextInt();

        switch (tabla) {
            case 1 -> {
                ClsAgregar agregar = new ClsAgregar();
                agregar.menu();
            }
            case 2 -> {
                ClsModificar modificar = new ClsModificar();
                modificar.menu();
            }
            case 3 -> {
                ClsEliminar eliminar = new ClsEliminar();
                eliminar.menu();
            }
            case 4 -> {
                ClsConsultar consultar = new ClsConsultar();
                consultar.menu();
            }
            default -> System.out.println("La opción ingresada no se ha encontrado.");
        }
    }
}