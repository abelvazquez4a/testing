package net.jaumebalmes.pguitart.practica1.joc;

import java.util.Random;
import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figures.Circle;
import net.jaumebalmes.pguitart.practica1.figures.Rectangle;
import net.jaumebalmes.pguitart.practica1.figures.Shape;
import net.jaumebalmes.pguitart.practica1.figures.Triangle;
import processing.core.PApplet;

/**
 *
 * @author pere
 */
public class JocPlujaFormes extends Joc{
    //VALORS ESCOLLITS PER AL CANVAS
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int CANVAS_BACKGROUND = 0;
    private static final int MAX_FIGURES = 2000;//plouran 2000 figures
    
    private int nFigures = 0;
    private boolean finalJoc = false; 
    private boolean aturat = false; 
    
    final private static Random R = new Random();
    private Shape forma;    
    
    public JocPlujaFormes(PApplet papplet) {
        super(papplet);
    }
    
    @Override
    public void canvasDraw() {
        forma.dibuixa();
    }

    /**
     * Un exemple clar de polimorfisme.
     * forma és un objecte de tipus Shape.
     * Les instàncies de Circle, Rectangle i Triangle són Shapes.
     * Per tant, forma pot tenir una refència a un Circle, a un Rectangle 
     * o a un Triangle. (Curiosament Shape és abstracte i, per tant, forma 
     * no pot tenir cap referència a un Shape)
     * 
     * Notem que forma actua de manera diferent en funció de si és un Circle, 
     * un Triangle o un Rectangle.
     * Per exemple, forma.dibuixa() dibuixarà un cercle si és un Circle, un 
     * rectangle si és Rectangle i un cercle si és un Circle.
     * Aquesta és la definició de polimorfosme: un objecte que tot i se de tipus
     * Shape, actua de manera diferent si es un Circle, Rectangle o Triangle.
     */
    @Override
    public void jugada() {
        switch (R.nextInt(3)) {
            case 0: { //CERCLE
                forma = new Circle();
                break;
            }
            case 1: { //RECTANGLE
                forma = new Rectangle();
                break;
            }
            case 2: { //TRIANGLE
                forma = new Triangle();
                break;
            }
        }
        nFigures++;
        if (nFigures >= MAX_FIGURES){
            finalJoc();
        }
    }

    @Override
    public void prepararJoc() {
        
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void finalJoc() {
        getCanvas().noLoop();
        finalJoc = true;
    }

    /**
     * Prement una tecla la pluja de formes s'atura i, prement-ne una 
     * altra continua.
     * 
     */
    @Override
    public void keyPressed() {
        if (aturat && !finalJoc){
            getCanvas().loop();
            aturat = false;
        } else {
            getCanvas().noLoop();
            aturat = true;
        }
    }
    
     public static void main(String[] args) {
        String[] processingArgs = {"Pluja de Formes"};
        Canvas canvas = new Canvas();
        Joc joc = new JocPlujaFormes(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
   
    
}
