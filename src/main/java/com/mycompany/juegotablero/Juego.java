package com.mycompany.juegotablero;

import com.mycompany.juegotablero.evaluadores.EvaluadorPreguntas;
import com.mycompany.juegotablero.repositorio.Conexion;
import com.mycompany.juegotablero.repositorio.GrabadorPartida;
import com.mycompany.juegotablero.repositorio.LimpiadorBD;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    List<Jugador> jugadores = new ArrayList<>();
    Tablero tablero = new Tablero();  
    GrabadorPartida grabador = new GrabadorPartida(Conexion.getConnection());  
    LimpiadorBD limpiador = new LimpiadorBD(Conexion.getConnection());

    private int cantidadJugadores;
    private int ronda = 1;
    private int momentoDeRonda = 0;

    public int getMomentoDeRonda() {
        return momentoDeRonda;
    }

    public void setMomentoDeRonda(int momentoDeRonda) {
        this.momentoDeRonda = momentoDeRonda;
    }    

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
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
            System.out.println("\nJugador Nª: " + (i+1));
            jugadores.add(new Jugador(EvaluadorPreguntas.preguntarNombres(),(i+1)));            
        }
    }

    public void ronda() {      
        System.out.println("Comienza la ronda N°" + ronda);
        for (Jugador j : jugadores) {
            if (j.getId() == momentoDeRonda) {
                if (j.getVida()>0) {
                System.out.println("\nTurno de: " + j.getNombre() + ".\n--");
                fasePrimera(j);
                EvaluadorPreguntas.esperarTecla();
                System.out.println("---------------------------");
                faseEmboscada(j,jugadores);
                }
                momentoDeRonda += 1;                
            }            
        }
        momentoDeRonda = 1;
        ronda +=1;
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
                    limpiador.LimpiarBD();
                    grabador.grabarDatos(ronda, cantidadJugadores, momentoDeRonda);
                    for (Jugador jugador : jugadores) {
                        grabador.grabarJugadores(jugador);   
                    }
                    break;
                case 4:
                    finalizar(true);                    
                case 5:
                    dadoLanzado=true;
                    j.moverse(tablero);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        }
    }

    public void finalizar(boolean salir) {
        if (salir) {            
            System.out.println("\nSales del juego!");            
            System.exit(0);
        }
        else {
            System.out.println("El juego ha terminado!");
        }        
        System.out.println("Presione enter para salir.");
        EvaluadorPreguntas.esperarTecla();
        
    }

}
