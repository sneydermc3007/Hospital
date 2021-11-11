package com.basededatos;

import com.basededatos.medico.Base_Datos_M;
import com.basededatos.paciente.Base_Datos_P;
import com.basededatos.turno.Base_Datos_T;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class ClsConsultar {
    ResultSet result;

    public void menu() throws SQLException {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("\n ---- Menu para consultar datos ----");
        System.out.println("\t 1. Escojo Paciente.");
        System.out.println("\t 2. Escojo Medico.");
        System.out.println("\t 3. Escojo Turno. ");
        System.out.print("\n Digite la opción en donde desea consultar registros: ");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1 -> Paciente();
            case 2 -> Medico();
            case 3 -> Turno();
            default -> System.out.println("Opción no encontrada");
        }
    }

    private void Paciente() throws SQLException {
        Scanner lector = new Scanner(System.in);
        int ID_PACIENTE;
        String fecha = "2021-11-11";

        System.out.println("Digite el ID del paciente:");
        ID_PACIENTE = lector.nextInt();
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Base_Datos_P objeto = new Base_Datos_P(ID_PACIENTE, "", "", fecFormatoDate, "", "",
                                                "", "", "");
        result = objeto.Query(ID_PACIENTE);

        if(result.next()) {
            System.out.println("Registro hallado");
            result.getString("Nombre_P");
            System.out.println("\n Perteneciente al paciente con nombre: " + result.getString("Nombre_P") +
                    " " + result.getString("Apellido") +  ", su fecha de nacimiento es: " +
                    result.getString("Fecha_Nacimiento") + ", el domicilio del paciente es: " + result.getString("Domicilio") +
                    ", la observacion que tiene paciente el paciente es: " + result.getString("Observacion"));
            System.out.println("-----------------------------------------------------");
        } else System.out.println("Registro no existente");
    }

    private void Medico() throws SQLException {
        Scanner lector=new Scanner(System.in);
        int ID_MEDICO;

        System.out.print("Digite el ID del medico: ");
        ID_MEDICO=lector.nextInt();

        Base_Datos_M objeto = new Base_Datos_M(ID_MEDICO, "", "");
        result = objeto.Query(ID_MEDICO);

        if(result.next()){
            System.out.println("Registro hallado");
            result.getString("Nombre_M");
            System.out.println("\n Perteneciente al doctor(a) con nombre: " + result.getString("Nombre_M") +
                    " " + result.getString("Apellido_M"));
            System.out.println("-----------------------------------------------------");
        } else System.out.println("Registro no existente");
    }

    private void Turno() throws SQLException {
        Scanner lector=new Scanner(System.in);
        int ID_TURNO;
        String fecha = "2021-11-11";

        System.out.print("Digite el ID turno:");
        ID_TURNO = lector.nextInt();
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Base_Datos_T objeto = new Base_Datos_T(ID_TURNO, fecFormatoDate, "");
        result = objeto.Query(ID_TURNO);

        if(result.next()){
            System.out.println("Registro hallado");
            result.getString("Observacion");
            System.out.println("\n Con fecha: " + result.getString("Fecha_Turno") +
                    ", esta cita esta activo: " + result.getString("Estado"));
        }
    }
}
