/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.practica1.figures;

import java.awt.Color;
import java.awt.Point;
import static net.jaumebalmes.pguitart.practica1.figures.Shape.getCanvas;

/**
 *
 * @author pere
 */
public class Rectangle extends Shape{
    final static public int MAX_MIDA_ALTURA = getCanvas().width / Shape.N_MIN_FIGURES;
    final static public int MAX_MIDA_BASE = getCanvas().height / Shape.N_MIN_FIGURES;
    private float base;
    private float altura;
    

    public Rectangle(float base, float altura, Point point, Color color) {
        super(point, color);
        this.base = base;
        this.altura = altura;
    }

    public Rectangle() {
        super();
        base = RANDOM.nextInt(MAX_MIDA_BASE - MIN_MIDA) + MIN_MIDA; 
        altura = MIN_MIDA + RANDOM.nextInt(MAX_MIDA_ALTURA - MIN_MIDA); 
    }
    

    @Override
    public double area() {
        return (base * altura);
    }

    @Override
    public double perimeter() {
        return (base + altura) * 2;
    }

    /**
     * La figura té el punt superior
     */
    @Override
    public void dibuixa() {
        getCanvas().fill(getColor().getRGB());
        getCanvas().rect((float) getPoint().getX(), (float) getPoint().getY(),
                base, altura);
             
    }
    
    
}
