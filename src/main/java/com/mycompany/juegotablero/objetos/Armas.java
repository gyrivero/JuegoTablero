package com.mycompany.juegotablero.objetos;

public enum Armas {
    PUÑOS("Puños",0,3),
    DAGA("Daga",1,4),
    ESPADA("Espada",3,6),
    MANDOBLE("Mandoble",5,8),
    ESPADA_DE_PLATA("Espada de Plata",8,10),
    ESPADA_LEGENDARIA("Espada Legendaria", 12,18);
   
    String nombre;
    int min;
    int max;    

    public String getNombre() {
        return nombre;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
        
    Armas(String nombre, int min, int max) {        
        this.nombre = nombre;
        this.min = min;
        this.max = max;
    }

}
