/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion.Config;

import InicioSesion.View.InicioSesionView;
import SocialNetwork.ConexionDB.MySqlConexion;
import java.sql.Connection;

/**
 *
 * @author deferrari.exequiel
 */
public class Variables {
    public static InicioSesionView inicioSesionView;
    public static MySqlConexion mysql = new MySqlConexion();
}
