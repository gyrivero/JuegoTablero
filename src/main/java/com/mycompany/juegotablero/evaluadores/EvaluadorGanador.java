package com.mycompany.juegotablero.evaluadores;

import com.mycompany.juegotablero.Jugador;
import com.mycompany.juegotablero.Tablero;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluadorGanador {

    private List<Jugador> listaAuxiliar;
    private boolean muertos = false;
    private boolean ganadores = false;

    public boolean isMuertos() {
        return muertos;
    }

    public boolean isGanadores() {
        return ganadores;
    }    
   
    public boolean evaluar(List<Jugador> evaluadores) {
        muertos = evaluarMuertos(evaluadores);
        ganadores = evaluarGanador(evaluadores);        
        return ganadores || muertos;
    }

    public boolean evaluarGanador(List<Jugador> evaluadores) {
        listaAuxiliar = evaluadores.stream()
                .filter(z -> z.getPosicion() >= Tablero.getCasillaFinal())
                .filter(z -> z.getVida()>0)
                .collect(Collectors.toList());
        if (listaAuxiliar.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean evaluarMuertos(List<Jugador> evaluadores) {
        List<Jugador> listaAuxiliar2;
        listaAuxiliar2 = evaluadores.stream()
                .filter(z -> z.getVida()>0)
                .collect(Collectors.toList());
        if (listaAuxiliar2.isEmpty()) {
            return true;
        }
        return false;
    }
   
    public void devolverResultado(boolean opt1, boolean opt2) {
        if (opt1) {
            if (listaAuxiliar.size()<1) {
                System.out.println(listaAuxiliar.get(0).getNombre() + ".");
                return;
            }
            System.out.println("El ganador es: " + listaAuxiliar.stream().max(Comparator.comparingInt(Jugador::getVida)).get().getNombre() + ".");
            return;
        }
        if (opt2) {
            System.out.println("Estan todos muertos");
        }        
    }
}
