package com.mycompany.juegotablero;

import com.mycompany.juegotablero.evaluadores.EvaluadorPreguntas;

public enum Monstruos {
    GOBLIN(5, 5,1,4,"Goblin"),
    LOBO(10, 10,2,5,"Lobo"),
    ORCO(20,20,4,7,"Orco"),
    OGRO(25,25,5,10,"Ogro"),
    DRAGON(40,40,12,20,"Dragon");

    private int vidaOriginal;
    private int vida;
    private int dañoMin;
    private int dañoMax;
    private String nombre;
    private Dado dado = new Dado();

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDañoMin() {
        return dañoMin;
    }

    public void setDañoMin(int dañoMin) {
        this.dañoMin = dañoMin;
    }

    public int getDañoMax() {
        return dañoMax;
    }

    public void setDañoMax(int dañoMax) {
        this.dañoMax = dañoMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    Monstruos(int vidaOriginal, int vida, int dañoMin, int dañoMax, String nombre) {
        this.vidaOriginal = vidaOriginal;
        this.vida = vida;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.nombre = nombre;
    }

    public void atacar(Jugador jugador) {
        int precision = dado.girar(1,4);
        if (precision > 1){
            int daño = dado.girar(dañoMin,dañoMax);
            daño -= jugador.getArmadura().getDefensa();
            if (daño < 0)
            {
                daño = 0;
            }
            jugador.setVida(jugador.getVida()-daño);
            if (jugador.getVida() < 0) {
                jugador.setVida(0);
            }
            System.out.println("El " + nombre + " te golpea por " + daño + " puntos.");
            System.out.println("Tu vida es: " + jugador.getVida() + ".");
            if (jugador.getVida()==0) {
                System.out.println("Has muerto.");
            }
        }
        else {
            System.out.println("El " + nombre + " erra el golpe");
        }
        EvaluadorPreguntas.esperarTecla();
    }

    public void mostrarMonstruo() {
        System.out.println("El " + nombre + " tiene " + vida + " vida.\n");
    }

    public int getVidaOriginal() {
        return vidaOriginal;
    }
}
