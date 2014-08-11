package br.com.br.gatend.GestaoCliente.v1.view;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class templateMB {
    public templateMB() {
        super();
    }

    public void sair() throws IOException {
        String ebs_url = System.getProperty("ebs_url");
        String targetURL = ebs_url + "/OA_HTML/OALogout.jsp?menu=Y";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(targetURL);
    }
}
