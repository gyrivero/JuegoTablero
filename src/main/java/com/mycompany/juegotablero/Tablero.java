package com.mycompany.juegotablero;

import com.mycompany.juegotablero.objetos.Armas;
import com.mycompany.juegotablero.evaluadores.EvaluadorPreguntas;

public class Tablero {
    private static int casillaFinal = 34;
    private boolean hayMonstruo = false;
    private Monstruos monstruo;
    private Dado dado = new Dado();

    public Monstruos getMonstruo() {
        return monstruo;
    }

    public boolean isHayMonstruo() {
        return hayMonstruo;
    }

    public void setHayMonstruo(boolean hayMonstruo) {
        this.hayMonstruo = hayMonstruo;
    }

    public static int getCasillaFinal() {
        return casillaFinal;
    }

    public void activarCasilla(int casilla, Jugador jugador){
        System.out.println("Estas en la casilla " + casilla + ".\n");
        switch (casilla){
            case 1:
                encontrarPocion(jugador,1);
                encontrarArma(jugador,Armas.DAGA);
                encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
                break;
            case 2:
                encontrarMonstruo(jugador,Monstruos.GOBLIN);
                break;
            case 3:
                encontrarPocion(jugador,1);
                encontrarArma(jugador,Armas.DAGA);
                break;
            case 4:
                encontrarMonstruo(jugador ,Monstruos.GOBLIN);
                saqueoMonstruo(monstruo,jugador);
                encontrarArma(jugador,Armas.DAGA);
                break;
            case 5:
                encontrarMonstruo(jugador, Monstruos.GOBLIN);
                break;
            case 6:
                encontrarPocion(jugador,1);
                encontrarArma(jugador,Armas.DAGA);
                break;
            case 7:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                break;
            case 8:
                encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
                encontrarArma(jugador,Armas.ESPADA);
                break;
            case 9:
                encontrarArma(jugador,Armas.ESPADA);
                break;
            case 10:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                break;
            case 11:
                encontrarPocion(jugador,1);
                break;
            case 12:
                encontrarArma(jugador,Armas.ESPADA);
                encontrarPocion(jugador,1);
                break;
            case 13:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                break;
            case 14:
                encontrarMonstruo(jugador, Monstruos.GOBLIN);
                break;
            case 15:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                saqueoMonstruo(monstruo,jugador);
                encontrarArmadura(jugador,Armaduras.COTA_DE_MALLAS);
                break;
            case 16:
                encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
                break;
            case 17:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                break;
            case 18:
                encontrarPocion(jugador,1);
                break;
            case 19:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                saqueoMonstruo(monstruo,jugador);
                encontrarCofre(jugador);
                break;
            case 20:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                saqueoMonstruo(monstruo,jugador);
                encontrarArma(jugador,Armas.MANDOBLE);
                encontrarArmadura(jugador,Armaduras.COTA_DE_MALLAS);
                break;
            case 21:
                encontrarArma(jugador,Armas.ESPADA);
                break;
            case 22:
                encontrarArma(jugador,Armas.MANDOBLE);
                break;
            case 23:
                encontrarMonstruo(jugador, Monstruos.GOBLIN);
                saqueoMonstruo(monstruo,jugador);
                encontrarPocion(jugador,1);
                break;
            case 24:
                encontrarMonstruo(jugador, Monstruos.GOBLIN);
                break;
            case 25:
                encontrarArmadura(jugador,Armaduras.COTA_DE_MALLAS);
                break;
            case 26:
                encontrarMonstruo(jugador, Monstruos.LOBO);
                saqueoMonstruo(monstruo,jugador);
                encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
                encontrarPocion(jugador,2);
                break;
            case 27:
                encontrarArma(jugador,Armas.MANDOBLE);
                encontrarPocion(jugador,1);
                break;
            case 28:
                encontrarCofre(jugador);
                break;
            case 29:
                encontrarMonstruo(jugador, Monstruos.ORCO);
                saqueoMonstruo(monstruo,jugador);
                encontrarCofre(jugador);
                break;
            case 30:
                encontrarMonstruo(jugador, Monstruos.ORCO);
                saqueoMonstruo(monstruo,jugador);
                encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
                break;
            case 31:
                encontrarArma(jugador,Armas.MANDOBLE);
                encontrarArmadura(jugador,Armaduras.COTA_DE_MALLAS);
                break;
            case 32:
                encontrarCofre(jugador);
                break;
            case 33:
                encontrarCueva(jugador);
                break;
            case 34:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 35:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 36:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 37:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 38:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 39:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 40:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 41:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 42:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 43:
                encontrarCofre(jugador);
                break;
            case 44:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 45:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 46:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 47:
                encontrarCofre(jugador);
                break;
            case 48:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 49:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 50:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 51:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 52:
                encontrarCueva(jugador);
                break;
            case 53:
                encontrarCofre(jugador);
                break;
            case 54:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 55:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 56:
                encontrarMonstruo(jugador,Monstruos.ORCO);
                break;
            case 57:
                encontrarCofre(jugador);
                break;
            case 58:
                encontrarCueva(jugador);
                break;
            case 59:
                encontrarCueva(jugador);
                break;
            case 60:
                encontrarCueva(jugador);
                break;
        }
    }

    public void encontrarMonstruo(Jugador jugador, Monstruos monstruo) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        this.hayMonstruo = true;
        this.monstruo = monstruo;
        this.monstruo.setVida(monstruo.getVidaOriginal());
        System.out.println("Te encuentras un " + this.monstruo.getNombre() + ".");
        EvaluadorPreguntas.esperarTecla();
        Juego.faseAtaque(jugador, monstruo);
    }

    public void encontrarArma(Jugador jugador, Armas arma) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        System.out.println("Encuentras 1 " + arma.getNombre() + " (" + arma.getMin() + "-" + arma.getMax() + ").");
        System.out.println("Tu arma actual es: " + jugador.getArma().getNombre() + " (" + jugador.getArma().getMin() + "-" + jugador.getArma().getMax() + ").");
        System.out.println("\nQueres agarrar el arma? " + arma.getNombre() + ".");
        if (EvaluadorPreguntas.preguntarSiNo()) {
            jugador.setArma(arma);
            System.out.println("Cambiaste de arma.");
            return;
        }
        System.out.println("Mantenes el mismo arma.");
    }
    public void encontrarArmadura(Jugador jugador, Armaduras armadura) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        System.out.println("Encuentras 1 " + armadura.nombre + " (" + armadura.defensa + ").");
        System.out.println("Tu armadura actual es: " + jugador.getArmadura().nombre + "(" + jugador.getArmadura().defensa + ").");
        System.out.println("\nQueres agarrar la armadura? " + armadura.nombre + ".");
        if (EvaluadorPreguntas.preguntarSiNo()) {
            jugador.setArmadura(armadura);
            System.out.println("Cambiaste de armadura.");
            return;
        }
        System.out.println("Mantenes la misma armadura.");
    }

    public void encontrarPocion(Jugador jugador,int cantidadDePociones) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        jugador.setPociones(jugador.getPociones()+cantidadDePociones);
        if (cantidadDePociones>1){
            System.out.println("Encuentras " + cantidadDePociones + " pociones.");
            return;
        }
        System.out.println("Encuentras " + cantidadDePociones + " pocion.");
        EvaluadorPreguntas.esperarTecla();
    }

    public void encontrarCofre(Jugador jugador) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        System.out.println("Encuentras un cofre abandonado y revisas que hay dentro.");
        EvaluadorPreguntas.esperarTecla();
        int opcion = dado.girar(1,100);
        if (opcion >= 1 && opcion <= 60) {
            encontrarPocion(jugador,1);
        }
        else if (opcion >= 61 && opcion <= 90) {
            encontrarPocion(jugador,2);
        }
        else if (opcion >= 91 && opcion <= 97) {
            encontrarPocion(jugador,3);
        }
        else {
            encontrarPocion(jugador,4);
        }
        opcion = dado.girar(1,100);
        if (opcion >= 1 && opcion <= 50) {
            encontrarArma(jugador,Armas.DAGA);
        }
        else if (opcion >= 51 && opcion <= 83) {
            encontrarArma(jugador,Armas.ESPADA);
        }
        else if (opcion >= 84 && opcion <= 94) {
            encontrarArma(jugador,Armas.MANDOBLE);
        }
        else if (opcion >= 95 && opcion <= 99) {
            encontrarArma(jugador,Armas.ESPADA_DE_PLATA);
        }
        else {
            encontrarArma(jugador,Armas.ESPADA_LEGENDARIA);
        }
        opcion = dado.girar(1,100);
        if (opcion >= 1 && opcion <= 70) {
            encontrarArmadura(jugador,Armaduras.ARMADURA_DE_CUERO);
        }
        else if (opcion >= 71 && opcion <= 92) {
            encontrarArmadura(jugador,Armaduras.COTA_DE_MALLAS);
        }
        else if (opcion >= 93 && opcion <= 99) {
            encontrarArmadura(jugador,Armaduras.ARMADURA_DE_PLACAS_COMPLETAS);
        }
        else {
            encontrarArmadura(jugador,Armaduras.ARMADURA_DE_ESCAMAS_DE_DRAGON);
        }
    }

    public void encontrarCueva(Jugador jugador) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        System.out.println("Te adentras en una cueva oscura.");
        for (int i = 0; i < 3; i++) {
            int opcion = dado.girar(1,100);
            if (opcion >= 1 && opcion <= 50) {
                encontrarMonstruo(jugador, Monstruos.GOBLIN);
            }
            else if (opcion >= 51 && opcion <= 83) {
                encontrarMonstruo(jugador, Monstruos.LOBO);
            }
            else if (opcion >= 84 && opcion <= 94) {
                encontrarMonstruo(jugador, Monstruos.ORCO);
            }
            else if (opcion >= 95 && opcion <= 99) {
                encontrarMonstruo(jugador, Monstruos.OGRO);
            }
            else {
                encontrarMonstruo(jugador, Monstruos.DRAGON);
            }
        }
        encontrarCofre(jugador);
    }

    public void saqueoMonstruo(Monstruos monstruo,Jugador jugador) {
        if (chequearMuerto(jugador))
        {
            return;
        }
        System.out.println("El " + monstruo.getNombre() + " ha dejado algo.\n");
    }

    public boolean chequearMuerto(Jugador jugador) {
        if (jugador.getVida()<=0) {
            return true;
        }
        return false;
    }
}
