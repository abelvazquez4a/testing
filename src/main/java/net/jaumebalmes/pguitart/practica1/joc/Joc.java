package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import processing.core.PApplet;

/**
 *
 * @author pere
 */
public abstract class Joc {
//<editor-fold defaultstate="collapsed" desc="VALORS_CANVAS_DEFECTE">
    final static public int DEFAULT_CANVAS_WIDTH = 600;
    final static public int DEFAULT_CANVAS_HEIGHT = 400;
    final static public int DEFAULT_CANVAS_BACKGROUND = 0;
//</editor-fold>
    
    private static PApplet canvas; //Processing
    private final int width;
    private final int height;
    private final int background;
    private boolean jocFinalitzat = false;
    
//<editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    /**
     * Constructor amb valors Canvas per defecte.
     * Notem que és el joc qui sap el Canvas.
     * De manera natural, Shape agafarà el canvas del joc
     * @param canvas de Processing on es mostrarà el joc
     */
    public Joc(PApplet canvas) {
        this(canvas,
                DEFAULT_CANVAS_WIDTH,
                DEFAULT_CANVAS_HEIGHT,
                DEFAULT_CANVAS_BACKGROUND);
    }
    
    /**
     *
     * @param canvas de Processing on es mostrarà el joc
     * @param width amplada del canvas
     * @param height alçada del canvas
     * @param background color de fons del canvas
     */
    public Joc(PApplet canvas, int width, int height, int background) {
        Joc.canvas = canvas;
        this.width = width;
        this.height = height;
        this.background = background;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="PRESENTACIO_DEL_JOC">
    /**
     * Aquest mètode s'ha de cridar a settings de processing.
     */
    public void canvasSettings(){
        canvas.size(width, height);
    }
    
    /**
     * Que mostrem al canvas abans de començar a jugar-
     * Es crida al setup de Processing.
     */
    public abstract void canvasSetup();
    
    /**
     * Mostra tots els canvis que hi ha hagut en una jugada.
     * Es crida a draw de processing, després de jugar.
     */
    public abstract void canvasDraw();
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="DINAMICA DEL JOC">
    /**
     * Tot el que necessitem per al joc.
     */
    public abstract void prepararJoc();
    
    /**
     * Controla tot el que és necessari per a fer una jugada, depenent del joc.
     * Es crida a draw de Processing.
     */
    public abstract void jugada();
    
    /**
     * Acaba el joc.
     * Mostra la pantalla o opcions de final, si n'hi ha.
     * S'ha de cridar des de draw
     */
    public abstract void finalJoc();
    
    /**
     * Event per si volem controlar alguna tecla.
     * De moment, només es fa servir per JocDeFormes.
     */
    public abstract void keyPressed();
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GETTERS/SETTERS">
    public static PApplet getCanvas() {
        return canvas;
    }
    
    public int getBackground() {
        return background;
    }
    
    /**
     * Indica si el joc ha acabat. Permet cridar finalJoc des de draw. 
     * @return Ha acabat el joc?
     */
    public boolean isJocFinalitzat() {
        return jocFinalitzat;
    }
    
    /**
     * Permet indicar a draw que el joc ha acabat.
     * @param jocFinalitzat Ha acabat el joc?
     */
    public void setJocFinalitzat(boolean jocFinalitzat) {
        this.jocFinalitzat = jocFinalitzat;
    }
//</editor-fold>
    
    


}
