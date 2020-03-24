package com.mycompany.juegotablero;

import com.mycompany.juegotablero.objetos.Armas;
import com.mycompany.juegotablero.evaluadores.EvaluadorPreguntas;
import javafx.scene.control.Tab;

import java.util.Objects;

public class Jugador {
    final int vidaMaxima = 20;
    private String nombre;
    private int vida;
    private Dado dado = new Dado();
    private Armas arma;
    private Armaduras armadura;
    private int posicion;
    private int pociones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return vidaMaxima == jugador.vidaMaxima &&
                vida == jugador.vida &&
                posicion == jugador.posicion &&
                pociones == jugador.pociones &&
                Objects.equals(nombre, jugador.nombre) &&
                Objects.equals(dado, jugador.dado) &&
                arma == jugador.arma &&
                armadura == jugador.armadura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vidaMaxima, nombre, vida, dado, arma, armadura, posicion, pociones);
    }

    public Jugador(String nombre) {
        this.posicion = 0;
        this.nombre = nombre;
        this.vida = vidaMaxima;
        this.arma = Armas.PUÑOS;
        this.armadura = Armaduras.ROPA;
        this.pociones = 0;
    }

    public int getPociones() {
        return pociones;
    }

    public void setPociones(int pociones) {
        this.pociones = pociones;
    }

    public Armaduras getArmadura() {
        return armadura;
    }

    public void setArmadura(Armaduras armadura) {
        this.armadura = armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Armas getArma() {
        return arma;
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void revisarEstadisticas() {
        System.out.println("Arma: " + arma.getNombre() + " (" + arma.getMin() + "-" + arma.getMax() + ")" + " - Armadura: " + armadura.nombre + " (" + armadura.defensa + ")" + " - Pociones: " + pociones + ".");
        System.out.println("Vida: " + vida + ".");
        System.out.println("Posicion: " + posicion + ".");
        System.out.println();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void tomarPocion() {
        if (pociones > 0 && vida < vidaMaxima) {
            vida += 5;
            pociones -= 1;
            if (vida > vidaMaxima) {
                vida = vidaMaxima;
            }
            System.out.println("Has tomado 1 pocion. Tu vida actual es: " + vida + ".");
            System.out.println();
            return;
        }
        if (pociones <= 0){
            System.out.println("No tienes pociones!");
            System.out.println();
        }
        else {
            System.out.println("Tienes la vida al maximo!");
            System.out.println();
        }
    }

    public void moverse(Tablero tablero){
        System.out.println("Presionar alguna tecla para tirar el dado.");
        EvaluadorPreguntas.esperarTecla();
        int resultado = dado.girar(1,6);
        System.out.println("Has sacado " + resultado + ".");
        posicion += resultado;
        if (posicion > Tablero.getCasillaFinal()){
            posicion = Tablero.getCasillaFinal();
        }
        tablero.activarCasilla(posicion,this);
    }

    public void atacar(Monstruos monstruo) {
        int precision = dado.girar(1,4);
        if (precision>1) {
            int daño = dado.girar(arma.getMin(),arma.getMax());
            monstruo.setVida(monstruo.getVida()-daño);
            if (monstruo.getVida() < 0) {
                monstruo.setVida(0);
            }
            System.out.println("Golpeas por " + daño + " puntos.");
        }
        else {
            System.out.println("Erras el golpe.");
        }
        System.out.println("La vida del " + monstruo.getNombre() + " es: " + monstruo.getVida() + ".");
        EvaluadorPreguntas.esperarTecla();
    }

    public void atacar(Jugador jugador,int probabilidad) {
        int precision = dado.girar(1,10);
        if (precision <= 6) {
            int daño = dado.girar(arma.getMin(),arma.getMax());
            daño -= jugador.getArmadura().defensa;
            if (daño < 0)
            {
                daño = 0;
            }
            jugador.setVida(jugador.getVida()-daño);
            if (jugador.getVida() < 0) {
                jugador.setVida(0);
            }
            System.out.println("Golpeas por " + daño + " puntos.");
        }
        else {
            System.out.println("Erras el golpe.");
        }
        System.out.println("La vida del " + jugador.getNombre() + " es: " + jugador.getVida() + ".");
        EvaluadorPreguntas.esperarTecla();
    }

    public void atacarJugador(Jugador jugador) {
        System.out.println("Estas en la misma casilla que: " + jugador.getNombre() + ".");
        System.out.println("\nQuieres intentar de darle un golpe?");
        System.out.println("Si lo intentas, el tambien podra intentar darte uno.");
        if (EvaluadorPreguntas.preguntarSiNo()) {
            atacar(jugador,6);
            System.out.println("Turno de ataque de " + jugador.getNombre() + ".");
            jugador.atacar(this,3);
            return;
        }
        System.out.println("No atacas al jugador.");
        EvaluadorPreguntas.esperarTecla();
    }
}
