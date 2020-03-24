package com.mycompany.juegotablero;

public class EvaluadorPreguntas {
    static java.util.Scanner teclado = new java.util.Scanner(System.in);
    static String ingresoUsuario;
    static boolean ingresoCorrecto = false;

    static public void esperarTecla() {
        ingresoUsuario = teclado.nextLine();
    }

    static public boolean preguntarSiNo() {
        System.out.println("Elige Si o No.");
        ingresoUsuario = teclado.nextLine();
        while (!ingresoCorrecto) {
            if (ingresoUsuario.equalsIgnoreCase("Si")) {
                return true;
            } else if (ingresoUsuario.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Opcion incorrecta. Ingresa Si o No.");
            ingresoUsuario = teclado.nextLine();
        }
        return false;

    }

    static public int preguntarCantidadJugadores(){
        System.out.println("Cuantos jugadores seran?");
        ingresoUsuario = teclado.nextLine();
        while (!ingresoCorrecto) {
            try {
                Integer.parseInt(ingresoUsuario);
            } catch (NumberFormatException e) {
                System.out.println("Opcion incorrecta. Ingrese un numero.");
                ingresoUsuario = teclado.nextLine();
                continue;
            }
            ingresoCorrecto = true;
        }
        ingresoCorrecto=false;
        return Integer.parseInt(ingresoUsuario);
    }

    static public String preguntarNombres(){
        System.out.println("Escribe el nombre del jugador.");
        return ingresoUsuario = teclado.nextLine();
    }

    static public int elegirAccion(){
        while (!ingresoCorrecto) {
            System.out.println("Escribe 'est' para ver tu equipo y estadisticas.\nEscribe 'pocion' para tomar una pocion.\nPresiona Enter para lanzar el dado.");
            ingresoUsuario = teclado.nextLine();
            if (ingresoUsuario.equalsIgnoreCase("est")){
                return 1;
            }
            else if (ingresoUsuario.equalsIgnoreCase("pocion")){
                return 2;
            }
            else if (ingresoUsuario.isEmpty()){
            return 3;
            }
        }
        return 3;
    }
}
