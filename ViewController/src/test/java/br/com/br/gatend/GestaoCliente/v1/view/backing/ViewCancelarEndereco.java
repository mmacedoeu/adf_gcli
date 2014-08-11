package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.html.HtmlOutputLabel;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichSeparator;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.OperationBinding;

public class ViewCancelarEndereco extends ViewCancelar {
  /*  private RichPanelBox pbEnd1;
    private RichPanelGridLayout pglEnd1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichInputText it1;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichGridRow gr4;
    private RichGridCell gc2;
    private RichGridRow gr2;
    private RichGridCell gc4;
    private RichInputText it3;
    private RichGridCell gc5;
    private HtmlOutputLabel ol1;
    private RichGridCell gc6;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private HtmlOutputLabel ol2;
    private HtmlOutputLabel ol3;
    private HtmlOutputLabel ol4;
    private RichGridRow gr5;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichInputText it5;
    private RichInputText it6;
    private HtmlOutputLabel ol5;
    private HtmlOutputLabel ol6;
    private RichGridRow gr6;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichGridRow gr7;
    private RichGridCell gc21;
    private RichGridCell gc22;
    private RichGridRow gr8;
    private RichGridCell gc27;
    private RichGridCell gc28;
    private RichGridRow gr9;
    private RichGridCell gc33;
    private RichGridCell gc34;
    private RichInputText it8;
    private RichInputText it10;
    private HtmlOutputLabel ol8;
    private HtmlOutputLabel ol9;
    private HtmlOutputLabel ol10;
    private HtmlOutputLabel ol11;
    private RichInputText it4;
    private RichInputText it12;
    private RichGridCell gc19;
    private RichGridCell gc20;
    private RichInputText it2;
    private HtmlOutputLabel ol12;
    private RichSelectOneChoice soc1;
    private RichSelectItem si1;
    private RichSelectItem si2;
    private RichSelectOneChoice soc2;
    private RichSelectItem si3;
    private RichSelectItem si4;
    private RichSeparator s1;
    private RichGridRow gr10;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private RichButton b1;
    private RichButton b2;
    private RichPopup p1;
    private RichPanelWindow pw1;
    private RichPanelHeader ph1;
    private RichOutputFormatted of1;
    private RichSeparator sEnd1;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr11;
    private RichGridCell gc17;
    private RichGridCell gc18;
    private RichButton b3;
    private RichButton b4;
    private RichSpacer s3;
    private RichInputText it7;
    private RichInputText it9;


    public RichPanelBox getPbEnd1() {
        return pbEnd1;
    }

    public void setPbEnd1(RichPanelBox pbEnd1) {
        this.pbEnd1 = pbEnd1;
    }

    public RichPanelGridLayout getPglEnd1() {
        return pglEnd1;
    }

    public void setPglEnd1(RichPanelGridLayout pglEnd1) {
        this.pglEnd1 = pglEnd1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }


    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

   
    public HtmlOutputLabel getOl3() {
        return ol3;
    }

    public void setOl3(HtmlOutputLabel ol3) {
        this.ol3 = ol3;
    }

    public HtmlOutputLabel getOl4() {
        return ol4;
    }

    public void setOl4(HtmlOutputLabel ol4) {
        this.ol4 = ol4;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public HtmlOutputLabel getOl5() {
        return ol5;
    }

    public void setOl5(HtmlOutputLabel ol5) {
        this.ol5 = ol5;
    }

    public HtmlOutputLabel getOl6() {
        return ol6;
    }

    public void setOl6(HtmlOutputLabel ol6) {
        this.ol6 = ol6;
    }

    public RichGridRow getGr6() {
        return gr6;
    }

    public void setGr6(RichGridRow gr6) {
        this.gr6 = gr6;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridRow getGr7() {
        return gr7;
    }

    public void setGr7(RichGridRow gr7) {
        this.gr7 = gr7;
    }

    public RichGridCell getGc21() {
        return gc21;
    }

    public void setGc21(RichGridCell gc21) {
        this.gc21 = gc21;
    }

    public RichGridCell getGc22() {
        return gc22;
    }

    public void setGc22(RichGridCell gc22) {
        this.gc22 = gc22;
    }

    public RichGridRow getGr8() {
        return gr8;
    }

    public void setGr8(RichGridRow gr8) {
        this.gr8 = gr8;
    }

    public RichGridCell getGc27() {
        return gc27;
    }

    public void setGc27(RichGridCell gc27) {
        this.gc27 = gc27;
    }

    public RichGridCell getGc28() {
        return gc28;
    }

    public void setGc28(RichGridCell gc28) {
        this.gc28 = gc28;
    }

    public RichGridRow getGr9() {
        return gr9;
    }

    public void setGr9(RichGridRow gr9) {
        this.gr9 = gr9;
    }

    public RichGridCell getGc33() {
        return gc33;
    }

    public void setGc33(RichGridCell gc33) {
        this.gc33 = gc33;
    }

    public RichGridCell getGc34() {
        return gc34;
    }

    public void setGc34(RichGridCell gc34) {
        this.gc34 = gc34;
    }

    public RichInputText getIt8() {
        return it8;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public HtmlOutputLabel getOl8() {
        return ol8;
    }

    public void setOl8(HtmlOutputLabel ol8) {
        this.ol8 = ol8;
    }

    public HtmlOutputLabel getOl9() {
        return ol9;
    }

    public void setOl9(HtmlOutputLabel ol9) {
        this.ol9 = ol9;
    }

    public HtmlOutputLabel getOl10() {
        return ol10;
    }

    public void setOl10(HtmlOutputLabel ol10) {
        this.ol10 = ol10;
    }

    public HtmlOutputLabel getOl11() {
        return ol11;
    }

    public void setOl11(HtmlOutputLabel ol11) {
        this.ol11 = ol11;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichGridCell getGc19() {
        return gc19;
    }

    public void setGc19(RichGridCell gc19) {
        this.gc19 = gc19;
    }

    public RichGridCell getGc20() {
        return gc20;
    }

    public void setGc20(RichGridCell gc20) {
        this.gc20 = gc20;
    }

    public HtmlOutputLabel getOl12() {
        return ol12;
    }

    public void setOl12(HtmlOutputLabel ol12) {
        this.ol12 = ol12;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectItem getSi4() {
        return si4;
    }

    public void setSi4(RichSelectItem si4) {
        this.si4 = si4;
    }

    public RichGridRow getGr10() {
        return gr10;
    }

    public void setGr10(RichGridRow gr10) {
        this.gr10 = gr10;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichSeparator getSEnd1() {
        return sEnd1;
    }

    public void setSEnd1(RichSeparator sEnd1) {
        this.sEnd1 = sEnd1;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
    }

    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichGridRow getGr11() {
        return gr11;
    }

    public void setGr11(RichGridRow gr11) {
        this.gr11 = gr11;
    }

    public RichGridCell getGc17() {
        return gc17;
    }

    public void setGc17(RichGridCell gc17) {
        this.gc17 = gc17;
    }

    public RichGridCell getGc18() {
        return gc18;
    }

    public void setGc18(RichGridCell gc18) {
        this.gc18 = gc18;
    }

    public RichButton getB3() {
        return b3;
    }

    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB4() {
        return b4;
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    } */
}
