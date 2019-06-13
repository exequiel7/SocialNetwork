package InicioSesion.Entities;

import SocialNetwork.ConexionDB.MySqlConexion;
import java.sql.Connection;
import java.sql.Date;

public class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private Date nacimiento;
    private int idusuario;
    private int cantidadAmigos;
    private String login;
    private String password;
    private String estado;

    public Usuario() {
        nombre = "";
        apellido = "";
        nacimiento = null;
        idusuario = 0;
        cantidadAmigos = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getCantidadAmigos() {
        return cantidadAmigos;
    }

    public void setCantidadAmigos(int cantidadAmigos) {
        this.cantidadAmigos = cantidadAmigos;
    }
}
