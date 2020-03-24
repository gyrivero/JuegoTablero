package com.mycompany.juegotablero;

import com.mycompany.juegotablero.evaluadores.EvaluadorGanador;
import com.mycompany.juegotablero.evaluadores.EvaluadorPreguntas;
import com.mycompany.juegotablero.repositorio.Conexion;
import com.mycompany.juegotablero.repositorio.GrabadorPartida;
import com.mycompany.juegotablero.repositorio.LimpiadorBD;
import com.mycompany.juegotablero.repositorio.RecuperadorPartida;

public class App {
    public static void main(String[] args) {
        Juego juego = new Juego();
        EvaluadorGanador eval = new EvaluadorGanador();
        RecuperadorPartida recuperador = new RecuperadorPartida(Conexion.getConnection());
        GrabadorPartida grabador = new GrabadorPartida(Conexion.getConnection());  
        LimpiadorBD limpiador = new LimpiadorBD(Conexion.getConnection());
        
        if(recuperador.chequearDatos() && EvaluadorPreguntas.preguntarRecuperar()) {            
            recuperador.recuperarJugadores(juego);
            recuperador.recuperarDatos(juego);            
        }
        else {
            limpiador.LimpiarBD();
            juego.bienvenida();
            juego.crearJugadores();            
        }        
        EvaluadorPreguntas.esperarTecla();        
        while (!eval.evaluar(juego.getJugadores()) && !EvaluadorPreguntas.preguntarGrabar()) {
            juego.ronda();            
        }
        if (eval.evaluar(juego.getJugadores())){
            eval.devolverResultado(eval.isGanadores(),eval.isMuertos());
        }
        else {
        limpiador.LimpiarBD();
            for (Jugador jugador : juego.getJugadores()) {
                grabador.grabarJugadores(jugador);   
            }           
            grabador.grabarDatos(juego.getRonda(), juego.getCantidadJugadores());
        }
        juego.finalizar();
        

    }
}
