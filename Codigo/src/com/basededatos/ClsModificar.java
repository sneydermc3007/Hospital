package com.basededatos;

import com.basededatos.medico.Base_Datos_M;
import com.basededatos.paciente.Base_Datos_P;
import com.basededatos.turno.Base_Datos_T;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class ClsModificar {
    public void menu() {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("\n ---- Menu de agregar datos ----");
        System.out.println(" 1. Escojo Paciente. ");
        System.out.println(" 2. Escojo Medico. ");
        System.out.println(" 3. Escojo Turno. ");
        System.out.print("\n Digite la opción en la que la desea modificar: ");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1 -> Paciente();
            case 2 -> Medico();
            case 3 -> Turno();
            default -> System.out.println("Opción no valida");
        }
    }

    public void Paciente() {
        Scanner lector = new Scanner(System.in);
        float ID_PACIENTE;
        String Nombre_P, Apellido, Nacimiento, Domicilio, Pais, Telefono, Email, Obsevacion;

        System.out.println("\n...Datos del paciente...");
        System.out.print("Escriba el ID del paciente que desea modificar: ");
        ID_PACIENTE = lector.nextInt();
        System.out.print("Escriba el nuevo nombre: ");
        Nombre_P = lector.next();
        System.out.print("Escriba de nuevo los apellidos: ");
        Apellido = lector.next();
        System.out.print("Escriba la nueva fecha de nacimiento (año-mes-dia): ");
        Nacimiento = lector.next();
        java.sql.Date FormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            FormatoDate = new java.sql.Date(sdf.parse(Nacimiento).getTime());
            System.out.println("\t Fecha con el formato java.sql.Date: " + FormatoDate);
        } catch (Exception ex) {
            System.out.println("\t Error al obtener el formato de la fecha " + ex.getMessage());
        }
        System.out.print("Escriba su nuevo lugar de residencia: ");
        Domicilio = lector.next();
        System.out.print("Escriba el nuevo pais: ");
        Pais = lector.next();
        System.out.print("Escriba el nuevo telefono: ");
        Telefono = lector.next();
        System.out.print("Escriba el nuevo email: ");
        Email = lector.next();
        System.out.print("Escriba las nuevas observaciones: ");
        Obsevacion = lector.next();

        Base_Datos_P objeto = new Base_Datos_P(ID_PACIENTE, Nombre_P, Apellido, FormatoDate, Domicilio, Pais, Telefono, Email, Obsevacion);
        objeto.QueryModificar(ID_PACIENTE, Nombre_P, Apellido, FormatoDate, Domicilio, Pais, Telefono, Email, Obsevacion);
    }

    public void Medico() {
        Scanner lector = new Scanner(System.in);
        String Nombre_M, Apellido_M;
        int ID_MEDICO;
        System.out.print("Digite el ID del medico que desea modificar: ");
        ID_MEDICO = lector.nextInt();
        System.out.print("Digite el nuevo nombre del medico: ");
        Nombre_M = lector.next();
        System.out.print("Digite el nuevo apellido del medico: ");
        Apellido_M = lector.next();

        Base_Datos_M objeto = new Base_Datos_M(ID_MEDICO, Nombre_M, Apellido_M);
        objeto.QueryModificar();
    }

    private void Turno() {
        Scanner lector = new Scanner(System.in);
        int ID_TURNO;
        String Fecha_Turno, Observacion;

        System.out.print("Digite el ID del cita que desea actualizar: ");
        ID_TURNO = lector.nextInt();
        System.out.print("Digite la nueva fecha del turno: ");
        Fecha_Turno = lector.next();

        java.sql.Date FormatoDateT = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            FormatoDateT = new java.sql.Date(sdf.parse(Fecha_Turno).getTime());
            System.out.println("\t La fecha: " + FormatoDateT + ", fue perfectamente ingresada.");
        } catch (Exception ex) {
            System.out.println("\t Error al obtener el formato de la fecha: " + ex.getMessage());
        }
        System.out.print("Escriba las nuevas observaciones: ");
        Observacion = lector.next();

        Base_Datos_T objeto = new Base_Datos_T(ID_TURNO, FormatoDateT, Observacion);
        objeto.Query(ID_TURNO, FormatoDateT, Observacion);
    }
}
