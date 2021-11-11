package com.basededatos;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import com.basededatos.medico.Base_Datos_M;
import com.basededatos.paciente.*;
import com.basededatos.turno.Base_Datos_T;

public class ClsAgregar {
    float resultado;

    public void menu (){
        Scanner lector=new Scanner(System.in);
        int tabla;
        System.out.println("\n ---- Menu de agregar datos ----");
        System.out.println("\t 1. Escojo Paciente.");
        System.out.println("\t 2. Escojo Medico.");
        System.out.println("\t 3. Escojo Turno. ");
        System.out.print("\n Digite la opción en la que la desea agregar registros: ");
        tabla=lector.nextInt();

        switch (tabla) {
            case 1 -> Paciente();
            case 2 -> Medico();
            case 3 -> Turno();
            default -> System.out.println("Opcion no encontrada");
        }
    }

    public void Paciente() {
        Scanner lector=new Scanner(System.in);
        float ID_PACIENTE;
        String Nombre_P, Apellido, Fecha_Nacimiento, Domicilio, Pais, Telefono, Email, Obsevacion;

        System.out.println("\n...Datos del paciente...");
        System.out.print("Escriba el ID del paciente: ");
        ID_PACIENTE=lector.nextInt();
        System.out.print("Escriba su primer nombre: ");
        Nombre_P=lector.next();
        System.out.print("Escriba sus apellidos: ");
        Apellido = lector.next();
        System.out.print("Escriba su fecha de nacimiento (año-mes-dia): ");
        Fecha_Nacimiento = lector.next();
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(Fecha_Nacimiento).getTime());
            System.out.println("\t Fecha con el formato java.sql.Date: " + fecFormatoDate);
        } catch (Exception ex) {
            System.out.println("\t Error al obtener el formato de la fecha " + ex.getMessage());
        }
        Domicilio=lector.nextLine();
        System.out.print("Escriba su pais: ");
        Pais = lector.nextLine();
        System.out.print("Escriba su telefono: ");
        Telefono=lector.nextLine();
        System.out.print("Escriba su email: ");
        Email=lector.nextLine();
        System.out.print("Escriba su observaciones: ");
        Obsevacion=lector.nextLine();

        Base_Datos_P objeto = new Base_Datos_P(ID_PACIENTE, Nombre_P, Apellido, fecFormatoDate, Domicilio, Pais, Telefono, Email, Obsevacion);
        resultado = objeto.Query(ID_PACIENTE, Nombre_P, Apellido, fecFormatoDate, Domicilio, Pais, Telefono, Email, Obsevacion);

        if(resultado != 0){
            System.out.println("Paciente adicionado");
            System.out.println("-----------------------------------------------------");
        }
        else System.out.println("Se ha tenido un error, inténtelo de nuevo");
    }

    public void Medico() {
        Scanner lector=new Scanner(System.in);
        String Nombre_M,Apellido_M;
        int ID_MEDICO;
        System.out.println("\n...Datos del medico...");
        System.out.print("Digite el ID del medico: ");
        ID_MEDICO=lector.nextInt();
        System.out.print("Digite su(s) nombres del medico: ");
        Nombre_M= lector.next();
        System.out.print("Digite los apellidos del medico: ");
        Apellido_M=lector.next();

        Base_Datos_M objeto = new Base_Datos_M(ID_MEDICO, Nombre_M, Apellido_M);
        resultado = objeto.Query();

        if(resultado != 0){
            System.out.println("Medico adicionado al sistema");
            System.out.println("-----------------------------------------------------");
        }
        else System.out.println("Se ha tenido un error, inténtelo de nuevo");
    }

    public void  Turno() {
        Scanner lector=new Scanner(System.in);
        int ID_TURNO;
        String Fecha_Turno,Observacion;

        System.out.print("Digite un ID para asignarle a la cita: ");
        ID_TURNO= lector.nextInt();
        System.out.print("Digite la fecha del turno: ");
        Fecha_Turno=lector.next();
        java.sql.Date FormatoDateT = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            FormatoDateT = new java.sql.Date(sdf.parse(Fecha_Turno).getTime());
            System.out.println("\t La fecha: " + FormatoDateT + ", fue perfectamente ingresada.");
        } catch (Exception ex) {
            System.out.println("\t Error al obtener el formato de la fecha: " + ex.getMessage());
        }
        System.out.print("Observaciones: ");
        Observacion=lector.nextLine();

        Base_Datos_T objeto = new Base_Datos_T(ID_TURNO, FormatoDateT, Observacion);
        resultado = objeto.Query();

        if(resultado != 0){
            System.out.println("El horario adicionado al sistema");
            System.out.println("-----------------------------------------------------");
        }
        else System.out.println("Se ha tenido un error, inténtelo de nuevo");
    }
}