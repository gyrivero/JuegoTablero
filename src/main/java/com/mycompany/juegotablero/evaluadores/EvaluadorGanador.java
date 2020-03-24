package com.mycompany.juegotablero.evaluadores;

import com.mycompany.juegotablero.Jugador;
import com.mycompany.juegotablero.Tablero;
import com.mycompany.juegotablero.interfaces.Evaluador;
import javafx.scene.control.Tab;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluadorGanador implements Evaluador<Jugador> {

    List<Jugador> listaAuxiliar;

    @Override
    public boolean evaluar(List<Jugador> evaluadores) {
        System.out.println(devolverResultado(evaluarGanador(evaluadores),evaluarMuertos(evaluadores)));
        return evaluarGanador(evaluadores) || evaluarMuertos(evaluadores);
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

    @Override
    public String devolverResultado(boolean opt1, boolean opt2) {
        if (opt1) {
            if (listaAuxiliar.size()<1) {
                return listaAuxiliar.get(0).getNombre();
            }
            return "El ganador es: " + listaAuxiliar.stream().max(Comparator.comparingInt(Jugador::getVida)).get().getNombre() + ".";
        }
        if (opt2) {
            return "Estan todos muertos";
        }
        return "Comienza la ronda Nª2";
    }
}
