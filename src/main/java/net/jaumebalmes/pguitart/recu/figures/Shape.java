package net.jaumebalmes.pguitart.recu.figures;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import net.jaumebalmes.pguitart.recu.joc.Joc;
import processing.core.PApplet;

/**
 * Es una classe abstracta: no permet instanciar objectes.
 * No té sentit instanciar una forma si no sabem quina forma concreta és:
 * Cercle, Rectangle, ...
 * 
 * @author pguitart
 */
public abstract class Shape {
    final public static int MIN_MIDA = 20; //mida mínima d'una figura
    final public static int N_MIN_FIGURES = 5; 
    //serveix per fer figures proporcionals a les dimensions del canvas
    
    private Point point; //Posició on es troba la forma.
    private Color color; //De quin color és la forma
    
    /* les formes es dibuixaran al canvas del joc*/
    /* facilita l'accés (per no haver de pojar Joc.getCanvas() cada vegada*/
    private static PApplet canvas = Joc.getCanvas();
    
    static final protected Random RANDOM = new Random(); //generador valors aleatoris
    // És protected per que el puguin fer servir també les classes derivades

    /**
     * Constructor general
     * @param point La posició de la forma (al canvas de processing)
     * @param color El color de la forma
     */
    public Shape(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

         /**
     * Constructor amb color i posició a l'atzar al canvas - margin
     * @param margin_x
     * @param margin_y
     */
    public Shape(int margin_x, int margin_y) {
        point = new Point(
                RANDOM.nextInt(canvas.width - 2*margin_x) + margin_x,
                RANDOM.nextInt(canvas.height - 2 * margin_y) + margin_y);
        color = new Color(
                RANDOM.nextInt(256), 
                RANDOM.nextInt(256), 
                RANDOM.nextInt(256));
    }

    
    /**
     * Constructor amb color i posició a l'atzar
     */
    public Shape() {
        point = new Point(
                RANDOM.nextInt(canvas.width),
                RANDOM.nextInt(canvas.height));
        color = new Color(
                RANDOM.nextInt(256), 
                RANDOM.nextInt(256), 
                RANDOM.nextInt(256));
    }
        
    
    /**
     *
     * @return el canvas
     */
    public static PApplet getCanvas() {
        return Shape.canvas;
    }
        
    /**
     * És un mètode abstracte. 
     * Obliga a cada subclasse a tenir la seva pròpia implementació. 
     * 
     * @return l'area de la figura.
     */
    public abstract double area();

    public abstract double perimeter();

    public abstract void dibuixa();
    

//<editor-fold defaultstate="collapsed" desc="GETTERS/SETTERS">
    public Point getPoint() {
        return point;
    }
    
    public void setPoint(Point point) {
        this.point = point;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "point=" + point +
                ", color=" + color +
                '}';
    }
//</editor-fold>    
    
}
