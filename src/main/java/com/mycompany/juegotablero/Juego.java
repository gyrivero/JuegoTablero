package com.mycompany.juegotablero;

import com.mycompany.juegotablero.Interfaces.Evaluador;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    List<Jugador> jugadores = new ArrayList<>();
    Tablero tablero = new Tablero();
    Evaluador eval = new EvaluadorGanador();

    static int cantidadJugadores;

    public void inicioJuego() {
        bienvenida();
        EvaluadorPreguntas.esperarTecla();
        crearJugadores();
        turno();
    }

    public void bienvenida() {
        cantidadJugadores = EvaluadorPreguntas.preguntarCantidadJugadores();
        if (cantidadJugadores>1) {
            System.out.println("Bienvenidos al juego");
        }
        else
        {
            System.out.println("Bienvenido al juego");
        }
    }

    public void crearJugadores() {
        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Jugador Nª: " + (i+1));
            jugadores.add(new Jugador(EvaluadorPreguntas.preguntarNombres()));
        }
    }

    public void turno() {
        boolean juegoTerminado = false;
        while(!juegoTerminado) {
            for (Jugador j : jugadores) {
                if (j.getVida()>0) {
                    System.out.println("\nTurno de: " + j.getNombre() + ".\n--");
                    fasePrimera(j);
                    EvaluadorPreguntas.esperarTecla();
                    System.out.println("---------------------------");
                    faseEmboscada(j,jugadores);
                }
            }
            juegoTerminado = eval.evaluar(jugadores);
        }
    }

    private void faseEmboscada(Jugador j, List<Jugador> jugadores) {
        for (Jugador jugador:jugadores) {
            if (!jugador.equals(j) && j.getPosicion()==jugador.getPosicion() && jugador.getVida()>0 && j.getVida()>0){
                j.atacarJugador(jugador);
            }
        }
    }

    static void faseAtaque(Jugador j, Monstruos monstruo) {
        System.out.println();
        monstruo.mostrarMonstruo();
        while(j.getVida()>0) {
            if (j.getVida()<j.vidaMaxima && j.getPociones()>0) {
                System.out.println("Queres tomar una pocion? Si lo haces, no podras atacar.");
                if (EvaluadorPreguntas.preguntarSiNo()) {
                    j.tomarPocion();
                }
                else {
                    j.atacar(monstruo);
                }
            }
            else {
                j.atacar(monstruo);
            }
            if (monstruo.getVida()<= 0)
            {
                System.out.println("Has derrotado al " + monstruo.getNombre() + ".");
                break;
            }
            monstruo.atacar(j);
        }
    }

    public void fasePrimera(Jugador j){
        boolean dadoLanzado = false;
        int accion;
        while (!dadoLanzado) {
            accion = EvaluadorPreguntas.elegirAccion();
            switch (accion) {
                case 1:
                    j.revisarEstadisticas();
                    break;
                case 2:
                    j.tomarPocion();
                    break;
                case 3:
                    dadoLanzado=true;
                    j.moverse(tablero);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
    }

}
