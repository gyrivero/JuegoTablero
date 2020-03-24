package com.mycompany.juegotablero.objetos;

public enum Armaduras {
    ROPA("Ropa",0),
    ARMADURA_DE_CUERO("Armadura de Cuero",1),
    COTA_DE_MALLAS("Cota de Mallas",3),
    ARMADURA_DE_PLACAS_COMPLETAS("Armadura de Placas Completas",5),
    ARMADURA_DE_ESCAMAS_DE_DRAGON("Armadura de Escamas de Dragon",8);
   
    String nombre;
    int defensa;    

    public String getNombre() {
        return nombre;
    }

    public int getDefensa() {
        return defensa;
    }    

    Armaduras(String nombre, int defensa) {        
        this.nombre = nombre;
        this.defensa = defensa;
    }
}
