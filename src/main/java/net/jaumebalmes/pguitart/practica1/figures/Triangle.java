/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.practica1.figures;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author pere
 */
public class Triangle extends Shape {

    final public int MAX_MIDA_ALTURA = getCanvas().width / Shape.N_MIN_FIGURES;
    final public int MAX_MIDA_BASE = getCanvas().width / Shape.N_MIN_FIGURES;
    final private float base;
    final private float altura;
    final private float angle; //Angle de rotació de la imatge en radians

    public Triangle(float base, float altura, Point point, Color color) {
        super(point, color);
        this.base = base;
        this.altura = altura;
        angle = setAngle();

    }

    public Triangle() {
        super();
        base = MIN_MIDA + RANDOM.nextInt(MAX_MIDA_BASE - MIN_MIDA);
        altura = MIN_MIDA + RANDOM.nextInt(MAX_MIDA_ALTURA - MIN_MIDA);
        angle = setAngle();
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public double perimeter() {
        return base + 2 * (Math.sqrt(base * base + altura * altura));
    }

    /**
     * La figura té el punt superior
     */
    @Override
    public void dibuixa() {
        getCanvas().fill(getColor().getRGB());
        getCanvas().rotate(angle);
        getCanvas().triangle((float) getPoint().getX(), (float) getPoint().getY(),
                (float) getPoint().getX() - base / 2, (float) getPoint().getY() + altura,
                (float) getPoint().getX() + base / 2, (float) getPoint().getY() + altura);

    }

    private float setAngle() {
        return getCanvas().radians(RANDOM.nextInt(360));
    }

}
