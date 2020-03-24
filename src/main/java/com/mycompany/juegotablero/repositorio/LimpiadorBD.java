/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juegotablero.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gonza
 */
public class LimpiadorBD {
    private Connection conexion;
    PreparedStatement ps = null; 
    
    public LimpiadorBD(Connection conexion) {
        this.conexion = conexion;
    }  
    
    public void LimpiarBD() {
        try {
            String query = "TRUNCATE TABLE datos";
            ps = conexion.prepareStatement(query);            
            ps.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("No se han podido borrar los datos de la partida anterior!");
            e.printStackTrace();
        }
        
        try {
            String query = "TRUNCATE TABLE jugadores";
            ps = conexion.prepareStatement(query);            
            ps.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("No se han podido borrar los jugadores de la partida anterior!");
            e.printStackTrace();
        }
    }
}
