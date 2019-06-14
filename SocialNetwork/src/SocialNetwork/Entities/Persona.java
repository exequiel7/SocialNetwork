
package SocialNetwork.Entities;


public class Persona extends Usuario{
    private String login;
    private String password;
    private String estado;

    public Persona() {
        this.login = login="";
        this.password = "";
        this.estado = "";
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
}
