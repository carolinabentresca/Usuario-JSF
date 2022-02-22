package bean;

import dao.UsuarioDao;
import dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario us;

    public UsuarioBean() {
        us = new Usuario();
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public String validar() {
        Usuario u;
        String result = "";
        UsuarioDao dao = new UsuarioDao();
        try {
            u = dao.validar(us);
            if (u != null) {
                result = "admin";
            } else {
                result = null;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    public String registrar() {
        Usuario u;
        String result = "";
        UsuarioDao dao = new UsuarioDao();
        try {
            u = dao.registrar(us);
            if (u != null) {
                result = "index.xhtml";
            } else {
                result = null;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

}
