/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juegotablero.repositorio;

import com.mycompany.juegotablero.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gonza
 */
public class GrabadorPartida {
    private Connection conexion;
    PreparedStatement ps = null;

    public GrabadorPartida(Connection conexion) {
        this.conexion = conexion;
    }  
    
    public void grabarJugadores(Jugador jugador) {
        try {
            String query = "INSERT INTO jugadores (Nombre, Vida, Posicion, Pociones, Arma, Armadura,Id) VALUES (?,?,?,?,?,?,?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, jugador.getNombre());
            ps.setInt(2, jugador.getVida());
            ps.setInt(3, jugador.getPosicion());
            ps.setInt(4, jugador.getPociones());
            ps.setString(5, jugador.getArma().name());
            ps.setString(6, jugador.getArmadura().name());
            ps.setInt(7,jugador.getId());            
            ps.executeUpdate();
            System.out.println("Jugador: " + jugador.getNombre() + " guardado correctamente!\n");
        } catch (SQLException e) {
            System.out.println("Jugador: " + jugador.getNombre() + " no se ha podido guardarse!");
            e.printStackTrace();           
        }
    }
    
    public void grabarDatos(int ronda, int cantidadJugadores, int momentoDeRonda) {
        try {
            String query = "INSERT INTO datos (Ronda, Cantidad_jugadores, Momento_ronda) VALUES (?,?,?)";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, ronda);
            ps.setInt(2, cantidadJugadores);
            ps.setInt(3, momentoDeRonda);
            ps.executeUpdate();
            System.out.println("Datos de la partida guardados correctamente!\n");
        } catch (SQLException e) {
            System.out.println("No se han podido guardar los datos de la partida!");
            e.printStackTrace();
        }
    }
    
        
}
