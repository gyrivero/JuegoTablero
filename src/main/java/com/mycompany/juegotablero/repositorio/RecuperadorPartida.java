/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juegotablero.repositorio;

import com.mycompany.juegotablero.Juego;
import com.mycompany.juegotablero.Jugador;
import com.mycompany.juegotablero.objetos.Armaduras;
import com.mycompany.juegotablero.objetos.Armas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Gonza
 */
public class RecuperadorPartida {
    private Connection conexion;    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public RecuperadorPartida(Connection conexion) {
        this.conexion = conexion;
    }
    
    public boolean chequearDatos() {
        try {
            String query = "SELECT * FROM datos";
                ps = conexion.prepareStatement(query);                
                rs = ps.executeQuery();
                if (!rs.next()) {
                    System.out.println("No hay datos guardados!\n");
                    return false;
                }
                return true;
        } catch (Exception e) {
            System.out.println("No se pudo chequar!");
        }
        return false;
    }
    
    public void recuperarJugadores(Juego juego) {
        try {
            String query="SELECT * FROM jugadores";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            int index = 0;
            
            while (rs.next()) {                
                juego.getJugadores().add(new Jugador());
                juego.getJugadores().get(index).setNombre(rs.getString("Nombre"));
                juego.getJugadores().get(index).setVida(rs.getInt("Vida"));
                juego.getJugadores().get(index).setPosicion(rs.getInt("Posicion"));
                juego.getJugadores().get(index).setPociones(rs.getInt("Pociones"));
                juego.getJugadores().get(index).setArma(Armas.valueOf(rs.getString("Arma")));
                juego.getJugadores().get(index).setArmadura(Armaduras.valueOf(rs.getString("Armadura")));
                juego.getJugadores().get(index).setId(rs.getInt("Id"));
                index += 1;
            }
            System.out.println("Jugadores recuperados correctamente!\n");            
        } catch (Exception e) {
            System.out.println("No se han podido recueperar los jugadores!");
            e.printStackTrace();
        }
    }
    
    public void recuperarDatos(Juego juego) {
        try {
            String query="SELECT * FROM datos";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                juego.setRonda(rs.getInt("Ronda"));
                juego.setCantidadJugadores(rs.getInt("Cantidad_jugadores"));
                juego.setMomentoDeRonda(rs.getInt("Momento_ronda"));
            }
            System.out.println("Datos recuperados correctamente!\n");            
        } catch (Exception e) {
            System.out.println("No se han podido recueperar los datos!");
            e.printStackTrace();
        }
    }
}
