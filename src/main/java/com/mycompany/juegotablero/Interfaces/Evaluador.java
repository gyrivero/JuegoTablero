package com.mycompany.juegotablero.Interfaces;

import java.util.List;

public interface Evaluador <A> {

    boolean evaluar(List<A> evaluadores);
    String devolverResultado(boolean opt1, boolean opt2);
}
