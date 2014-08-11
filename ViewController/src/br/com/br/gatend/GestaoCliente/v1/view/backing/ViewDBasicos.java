package br.com.br.gatend.GestaoCliente.v1.view.backing;


import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;



import javax.faces.event.ValueChangeEvent;


import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;





public class ViewDBasicos {


   

    public void habilitaGerDir(ValueChangeEvent evt) {

        if (evt.getNewValue().equals("C")) {
            ((RichSelectOneChoice)JSFUtil.findComponentInRoot("soc2")).setDisabled(true);

        }else if (evt.getNewValue().equals("P")) {
            ((RichSelectOneChoice)JSFUtil.findComponentInRoot("soc2")).setDisabled(false);
            
        }
    }
    public void alteraCpfCnpjId(ValueChangeEvent evt) {
       
        if (evt.getNewValue().equals("1")) {
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol3")).setValue("CPF:");
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol6")).setValue("Nome:");
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol8")).setVisible(true);
            ((RichSelectOneChoice)JSFUtil.findComponentInRoot("soc3")).setVisible(true);

        }else if (evt.getNewValue().equals("2")) {
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol3")).setValue("CNPJ:");
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol6")).setValue("Raz\u00e3o Social:");
            ((RichOutputLabel)JSFUtil.findComponentInRoot("ol8")).setVisible(false);
            ((RichSelectOneChoice)JSFUtil.findComponentInRoot("soc3")).setVisible(false);
            
        }
        else if (evt.getNewValue().equals("3")) {
                    ((RichOutputLabel)JSFUtil.findComponentInRoot("ol3")).setValue("ID Estrangeiro:");
                    ((RichOutputLabel)JSFUtil.findComponentInRoot("ol6")).setValue("Nome:");
                    ((RichOutputLabel)JSFUtil.findComponentInRoot("ol8")).setVisible(false);
                    ((RichSelectOneChoice)JSFUtil.findComponentInRoot("soc3")).setVisible(false);
        }
    }


   
}
