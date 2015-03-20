/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.ecosdeve4.model;

import com.ecos.ecosdeve4.exceptions.ExceptionApp;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * clase DistribuirTamanoLOC
 * 
 * calcula la distribucion de tabaño de LOC heredando operaciones matematicas de la clase CalcularMediaDesviacion
 * 
 * @author Dev
 */
public class DistribuirTamanoLOC extends CalcularMediaDesviacion {

    private List<String> clases = new ArrayList<String>();
    private List<BigDecimal> loc = new ArrayList<BigDecimal>();
    private List<BigDecimal> numeroMetodos = new ArrayList<BigDecimal>();
    private List<String> capitulos = new ArrayList<String>();
    private List<BigDecimal> paginas = new ArrayList<BigDecimal>();
    private List<BigDecimal> locXmetodos = new ArrayList<BigDecimal>();
    private List<BigDecimal> paginasXcapitulo = new ArrayList<BigDecimal>();

    /**
     * metodo DistribuirTamanoLOC
     * 
     * constructor de la clase con inicializacion de datos de prueba para la ejecucion de distribucion de tamaño de LOC
     * 
     */
    public DistribuirTamanoLOC() {
        clases.add("each_char");
        clases.add("string_read");
        clases.add("single_character");
        clases.add("each_line");
        clases.add("single_char");
        clases.add("tring_builder");
        clases.add("string_manager");
        clases.add("list_clump");
        clases.add("list_clip");
        clases.add("string_decrementer");
        clases.add("Char");
        clases.add("Character");
        clases.add("Converter");
        loc.add(new BigDecimal(18));
        loc.add(new BigDecimal(18));
        loc.add(new BigDecimal(25));
        loc.add(new BigDecimal(31));
        loc.add(new BigDecimal(37));
        loc.add(new BigDecimal(82));
        loc.add(new BigDecimal(82));
        loc.add(new BigDecimal(87));
        loc.add(new BigDecimal(89));
        loc.add(new BigDecimal(230));
        loc.add(new BigDecimal(85));
        loc.add(new BigDecimal(87));
        loc.add(new BigDecimal(558));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(5));
        numeroMetodos.add(new BigDecimal(4));
        numeroMetodos.add(new BigDecimal(4));
        numeroMetodos.add(new BigDecimal(4));
        numeroMetodos.add(new BigDecimal(10));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(3));
        numeroMetodos.add(new BigDecimal(10));
        capitulos.add("Preface");
        capitulos.add("Chapter 1");
        capitulos.add("Chapter 2");
        capitulos.add("Chapter 3");
        capitulos.add("Chapter 4");
        capitulos.add("Chapter 5");
        capitulos.add("Chapter 6");
        capitulos.add("Chapter 7");
        capitulos.add("Chapter 8");
        capitulos.add("Chapter 9");
        capitulos.add("Appendix A");
        capitulos.add("Appendix B");
        capitulos.add("Appendix C");
        capitulos.add("Appendix D");
        capitulos.add("Appendix E");
        capitulos.add("Appendix F");
        paginas.add(new BigDecimal(7));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(10));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(10));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(12));
        paginas.add(new BigDecimal(8));
        paginas.add(new BigDecimal(8));
        paginas.add(new BigDecimal(8));
        paginas.add(new BigDecimal(20));
        paginas.add(new BigDecimal(14));
        paginas.add(new BigDecimal(18));
        paginas.add(new BigDecimal(12));
    }

    /**
     * metodo carlcularMediaDesviacionLnX
     * 
     * asigna valor a el atributo list de la clase heredada CalcularMediaDesviacion añadiendo le la variacion de realizar el logaritmo en base 10 de la divicion de los parametros enviados loc y metodos
     * 
     * @param loc : lista de numero de lineas de codigo
     * @param metodos :lista numero de metodos
     * @throws Exception
     */
    public void carlcularMediaDesviacionLnX(List<BigDecimal> loc,List<BigDecimal> metodos) throws Exception {
        for (int x = 0; x < loc.size(); x++) {
            getList().add(new BigDecimal(Math.log(loc.get(x).divide(metodos.get(x), MathContext.DECIMAL64).doubleValue())));
        }
        try {
            calcularMedia();
            calculardesviacion();
        } catch (Exception ex) {
            throw new ExceptionApp("Error al calcular la media y desviacion " + ex.getMessage());
        }
    }
    
    /**
     * metodo carlcularMediaDesviacionLnX
     * 
     * asigna valor a el atributo list de la clase heredada CalcularMediaDesviacion añadiendo le la variacion de realizar el logaritmo en base 10 del numero de paginas
     * 
     * @param pag : lista de numero de paginas
     * @throws Exception
     */
    public void carlcularMediaDesviacionLnX(List<BigDecimal> pag) throws Exception {
        for (int x = 0; x < pag.size(); x++) {
            getList().add(new BigDecimal(Math.log(pag.get(x).doubleValue())));
        }
        try {
            calcularMedia();
            calculardesviacion();
        } catch (Exception ex) {
            throw new ExceptionApp("Error al calcular la media y desviacion " + ex.getMessage());
        }
    }
    
    /**
     * metodo calcularTamanosLoc
     * 
     * realiza las operaciones para calcular la distribucion de tamaño de LOC para la prueba propuesta
     * 
     * @throws Exception
     */
    public void calcularTamanosLoc()throws Exception{
        setList(new LinkedList<BigDecimal>());
        carlcularMediaDesviacionLnX(getLoc(),getNumeroMetodos());
        BigDecimal lnT=getMedia().subtract(getDesviacion().multiply(new BigDecimal(2)));
        locXmetodos.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().subtract(getDesviacion());
        locXmetodos.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia();
        locXmetodos.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().add(getDesviacion());
        locXmetodos.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().add(getDesviacion().multiply(new BigDecimal(2)));
        locXmetodos.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        setList(new LinkedList<BigDecimal>());
        carlcularMediaDesviacionLnX(getPaginas());
        lnT=getMedia().subtract(getDesviacion().multiply(new BigDecimal(2)));
        paginasXcapitulo.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().subtract(getDesviacion());
        paginasXcapitulo.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia();
        paginasXcapitulo.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().add(getDesviacion());
        paginasXcapitulo.add(new BigDecimal(Math.exp(lnT.doubleValue())));
        lnT=getMedia().add(getDesviacion().multiply(new BigDecimal(2)));
        paginasXcapitulo.add(new BigDecimal(Math.exp(lnT.doubleValue())));
    }

    /**
     *
     * @return
     */
    public List<BigDecimal> getLocXmetodos() {
        return locXmetodos;
    }

    /**
     *
     * @param locXmetodos
     */
    public void setLocXmetodos(List<BigDecimal> locXmetodos) {
        this.locXmetodos = locXmetodos;
    }

    /**
     *
     * @return
     */
    public List<String> getClases() {
        return clases;
    }

    /**
     *
     * @param clases
     */
    public void setClases(List<String> clases) {
        this.clases = clases;
    }

    /**
     *
     * @return
     */
    public List<BigDecimal> getLoc() {
        return loc;
    }

    /**
     *
     * @param loc
     */
    public void setLoc(List<BigDecimal> loc) {
        this.loc = loc;
    }

    /**
     *
     * @return
     */
    public List<BigDecimal> getNumeroMetodos() {
        return numeroMetodos;
    }

    /**
     *
     * @param numeroMetodos
     */
    public void setNumeroMetodos(List<BigDecimal> numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }

    /**
     *
     * @return
     */
    public List<String> getCapitulos() {
        return capitulos;
    }

    /**
     *
     * @param capitulos
     */
    public void setCapitulos(List<String> capitulos) {
        this.capitulos = capitulos;
    }

    /**
     *
     * @return
     */
    public List<BigDecimal> getPaginas() {
        return paginas;
    }

    /**
     *
     * @param paginas
     */
    public void setPaginas(List<BigDecimal> paginas) {
        this.paginas = paginas;
    }

    /**
     *
     * @return
     */
    public List<BigDecimal> getPaginasXcapitulo() {
        return paginasXcapitulo;
    }

    /**
     *
     * @param paginasXcapitulo
     */
    public void setPaginasXcapitulo(List<BigDecimal> paginasXcapitulo) {
        this.paginasXcapitulo = paginasXcapitulo;
    }
}
