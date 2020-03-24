/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juegotablero.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gonza
 */
public class Conexion {
    public static Connection getConnection() {
        try {            
            Connection coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego_tablero","root","");
            return coneccion;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Fallo de conexion a DB");
        }
        finally {
            
        }
    }    
}
