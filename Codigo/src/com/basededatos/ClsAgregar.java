package com.basededatos;

import java.util.Scanner;

public class ClsAgregar {


    public void menu (){
        Scanner lector=new Scanner(System.in);
        int tabla;
        System.out.println("---Digite la opción---.");
        System.out.println("---   1.Paciente.  ---");
        System.out.println("---   2.Medico.    ---");
        System.out.println("---   3.Turno.     ---");
        tabla=lector.nextInt();

        switch (tabla){
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

    public void Turno() {
        //obj de las conexiones
        Scanner lector=new Scanner(System.in);
        int ID_TURNO;
        String Fecha_Turno,Estado,Observacion;
        System.out.println("Digite el ID turno:");
        ID_TURNO= lector.nextInt();
        System.out.println("Digite la fecha del turno:");
        Fecha_Turno=lector.nextLine();
        System.out.println("Digite el estado:");
        Estado= lector.nextLine();
        System.out.println("Observaciones:");
        Observacion=lector.nextLine();
    }

    public void Medico() {
        //obj de las conexiones
        Scanner lector=new Scanner(System.in);
        String Nombre_M,Apellido_M;
        int ID_MEDICO;
        System.out.println("Digite el ID del medico");
        ID_MEDICO=lector.nextInt();
        System.out.println("Digite el primer nombre del medico:");
        Nombre_M= lector.nextLine();
        System.out.println("Digite el primer apellido del medico");
        Apellido_M=lector.nextLine();
        //uso del agregar dentro de la clase conexiones
    }

    public void Paciente() {
        //obj de las conexiones
        Scanner lector=new Scanner(System.in);

        int ID_PACIENTE;
        String Nombre_P,Apellido,Fecha_Nacimiento,Domicilio,Telefono,Email,Obsevacion;

        System.out.println("Digite el ID del paciente:");
        ID_PACIENTE=lector.nextInt();
        System.out.println("Primer Nombre:");
        Nombre_P=lector.nextLine();
        System.out.println("Primer Apellido:");
        Apellido=lector.nextLine();
        System.out.println("Fecha de nacimiento:");
        Fecha_Nacimiento=lector.nextLine();
        System.out.println("Domicilio:");
        Domicilio=lector.nextLine();
        System.out.println("Telefono:");
        Telefono=lector.nextLine();
        System.out.println("Email:");
        Email=lector.nextLine();
        System.out.println("Observaciones");
        Obsevacion=lector.nextLine();
        //Eliminar dentro de la tabla paciente el campo ID_pais

        //uso del agregar dentro de la clase conexiones
        //
    }
}
