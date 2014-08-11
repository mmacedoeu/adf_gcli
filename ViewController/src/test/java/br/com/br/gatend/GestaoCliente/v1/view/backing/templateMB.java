package br.com.br.gatend.GestaoCliente.v1.view.backing;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class templateMB {
    public templateMB() {
    }

    public void sair() throws IOException {

        String ebs_url = System.getProperty("ebs_url");
        String targetURL = ebs_url + "/OA_HTML/OALogout.jsp?menu=Y";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ectx = fc.getExternalContext();       
        HttpSession session = (HttpSession)ectx.getSession(false);
        try {
            session.invalidate();           
            ectx.redirect(targetURL);
            fc.responseComplete();
        } catch (Exception exp) {
            ectx.redirect(targetURL);
            fc.responseComplete();
        }
        
    }
}
