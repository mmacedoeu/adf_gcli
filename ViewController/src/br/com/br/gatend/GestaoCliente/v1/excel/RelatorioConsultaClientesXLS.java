package br.com.br.gatend.GestaoCliente.v1.excel;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;
import br.com.br.gatend.GestaoCliente.v1.model.to.DadosClienteTO;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

public class RelatorioConsultaClientesXLS {
    
    HSSFRow linha; 
    HSSFCell celula;
    
    private static final String RAZAO_SOCIAL    = "Razão Social/Nome";
    private static final String TIPO_PESSOA     = "CPF/CNPJ/EST";
    private static final String CODIGO_R3       = "Cód. Cliente R3";
    private static final String LOGRADOURO      = "Logradouro";
    private static final String BAIRRO          = "Bairro";
    private static final String CIDADE          = "Cidade";
    private static final String ESTADO          = "Estado";
    private static final String ORIGEM          = "Origem";
    private static final String PERFIL          = "Perfil";
    private static final String PRINCIPAL       = "Principal";
    
        
    public HSSFWorkbook geraRelatorioConsultaClientes(DadosClienteTO dadosClienteTo) {
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet planilha = workbook.createSheet("Relatório de Consulta de Clientes");

        int row = 0;
        int cell = 0;

        HSSFRow linha = planilha.createRow(row);


        //CABEÇALHO. (linha 1)
        final String cabecalho = "RELATÓRIO DE CONSULTA DE CLIENTES";
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell, cabecalho, 12, true,
                                                       new CellRangeAddress(0, 0, 0, 9));
        // --------------------

        //LINHA EM BRANCO. (linha 2)
        row = row + 1;
        linha = planilha.createRow(row);
        RelatorioConsultaClientesXLS.populaCelulaMescladaExcel(workbook, planilha, linha, cell, "", "",
                                                               new CellRangeAddress(0, 0, 0, 9));

        //------- LABEL CABEÇALHO. ( A partir da Linha 3)
        row = row + 1;
        linha = planilha.createRow(row);
        
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell, RAZAO_SOCIAL, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 1, TIPO_PESSOA, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 2, CODIGO_R3, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 3, LOGRADOURO, 10, true, null, 800);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 4, BAIRRO, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 5, CIDADE, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 6, ESTADO, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 7, ORIGEM, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 8, PERFIL, 10, true, null, 500);
        RelatorioConsultaClientesXLS.populaHeaderExcel(workbook, planilha, linha, cell + 9, PRINCIPAL, 10, true, null, 500);


        //-----------------------

        //INSERÇÃO DOS DADOS
        
        if(isNotNull(dadosClienteTo.getDadosCliente())) {
            row = row + 1;
            for(DadosClienteTO dct : dadosClienteTo.getDadosCliente()) {

                linha = planilha.createRow(row++);
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell, "", JSFUtil.parseTexto(dct.getRazaoSocial()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 1, "", JSFUtil.parseTexto(dct.getTipoPessoa()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 2, "", JSFUtil.parseTexto(dct.getCodigoR3()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 3, "", JSFUtil.parseTexto(dct.getLogradouro()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 4, "", JSFUtil.parseTexto(dct.getBairro()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 5, "", JSFUtil.parseTexto(dct.getCidade()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 6, "", JSFUtil.parseTexto(dct.getEstado()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 7, "", JSFUtil.parseTexto(dct.getOrigem()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 8, "", JSFUtil.parseTexto(dct.getPerfil()));
                
                RelatorioConsultaClientesXLS.populaCelulaExcel(workbook, planilha, linha, cell + 9, "", JSFUtil.parseTexto(dct.getPrincipal()));
             
            }
        }

        return workbook;
    }
    
    public static String getPathRelatorioAcompanhamento(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM_yyyy__HH_mm_ss");
        StringBuilder pathRelatorio = new StringBuilder();
        pathRelatorio.append("relatorio_de_consulta_de_clientes");
        pathRelatorio.append("_" + sdf.format(data) + ".xls");
        return pathRelatorio.toString();
    }
    
    private static void populaHeaderExcel(HSSFWorkbook workbook, 
                                          HSSFSheet planilha, HSSFRow linha, int cell,
                                          String textoCelula, int fontSize, boolean isBgColor, CellRangeAddress mescla) {
        
        HSSFCell celula = linha.createCell(cell);

        HSSFCellStyle style = workbook.createCellStyle();
                
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) fontSize);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        
        celula.setCellValue(textoCelula);
        
        if(mescla!=null) {
            planilha.addMergedRegion(mescla);
        }

        //Estilo
        style.setFont(font);
        if (isBgColor) {
            style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        }
        celula.setCellStyle(style);

    }
    
    private static void populaHeaderExcel(HSSFWorkbook workbook, 
                                          HSSFSheet planilha, HSSFRow linha, int cell,
                                          String textoCelula, int fontSize, boolean isBgColor, CellRangeAddress mescla, int width) {
        
        HSSFCell celula = linha.createCell(cell);

        HSSFCellStyle style = workbook.createCellStyle();
                
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) fontSize);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        
        celula.setCellValue(textoCelula);
        
        if(mescla!=null) {
            planilha.addMergedRegion(mescla);
        }

        //Estilo
        style.setFont(font);
        if (isBgColor) {
            style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        }
        celula.setCellStyle(style);
        
        planilha.setColumnWidth(cell, textoCelula.length() * width);

    }
    
    private static void populaCelulaExcel(HSSFWorkbook workbook, HSSFSheet planilha, 
                                          HSSFRow linha, int cell,
                                          String label, String textoCelula) {
        
        
        HSSFCell celula = linha.createCell(cell);

        if(textoCelula.equals(null)) textoCelula = "";
            
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFRichTextString richText = new HSSFRichTextString(label + " " + textoCelula);
        richText.applyFont(0, label.length(), font);

        celula.setCellValue(richText);
        //planilha.setColumnWidth(cell, textoCelula.length() * 100);


    }
    
    private static void populaCelulaMescladaExcel(HSSFWorkbook workbook, HSSFSheet planilha, 
                                          HSSFRow linha, int cell,
                                          String label, String textoCelula, CellRangeAddress mescla) {
        
        
        HSSFCell celula = linha.createCell(cell);
        
        HSSFCellStyle style = workbook.createCellStyle();

        if(textoCelula.equals(null)) textoCelula = "";
            
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFRichTextString richText = new HSSFRichTextString(label + " " + textoCelula);
        richText.applyFont(0, label.length(), font);

        celula.setCellValue(richText);
          
        if(mescla != null) {
            planilha.addMergedRegion(mescla);
        }
        //planilha.setColumnWidth(numeroCelula, 50 * 310);


    }
    
    public static boolean isNotNull(Object objeto) {
        try {
            if (!objeto.equals(null)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false; 
    }
    
}
