package com.basededatos;

import com.basededatos.medico.Base_Datos_M;
import com.basededatos.paciente.Base_Datos_P;
import com.basededatos.turno.Base_Datos_T;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class ClsEliminar {

    public void menu() {
        Scanner lector = new Scanner(System.in);
        int tabla;
        System.out.println("\n ---- Menu para eliminar datos ----");
        System.out.println("\t 1. Escojo Paciente. ");
        System.out.println("\t 2. Escojo Medico.   ");
        System.out.println("\t 3. Escojo Turno.    ");
        System.out.print("\n Digite la opción en donde va eliminar registros: ");
        tabla = lector.nextInt();

        switch (tabla) {
            case 1 -> Paciente();
            case 2 -> Medico();
            case 3 -> Turno();
            default -> System.out.println("Opción no valida");
        }
    }

    private void Paciente() {
        Scanner lector = new Scanner(System.in);
        int ID_PACIENTE;
        String fecha = "2021-11-11";

        System.out.print("Digite el ID del paciente: ");
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ID_PACIENTE = lector.nextInt();
        Base_Datos_P objeto = new Base_Datos_P(ID_PACIENTE, "", "", fecFormatoDate, "", "",
                                                "", "", "");
        objeto.QueryEliminar(ID_PACIENTE);
    }

    private void Medico() {
        Scanner lector = new Scanner(System.in);
        int ID_MEDICO;

        System.out.print("Digite el ID del medico: ");
        ID_MEDICO = lector.nextInt();

        Base_Datos_M objeto = new Base_Datos_M(ID_MEDICO, "","");
        objeto.QueryEliminar();
    }

    private void Turno() {
        Scanner lector = new Scanner(System.in);
        int ID_TURNO;
        String fecha = "2021-11-11";

        System.out.print("Digite el ID turno que desea eliminar:");
        ID_TURNO = lector.nextInt();
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Base_Datos_T objeto = new Base_Datos_T(ID_TURNO, fecFormatoDate, "");
        objeto.Query(ID_TURNO, "no");
    }
}