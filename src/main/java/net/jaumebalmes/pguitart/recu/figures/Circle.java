/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.recu.figures;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author pguitart
 */
public class Circle extends Shape {

    final public static int MIN_RADI = Shape.MIN_MIDA / 2;
    //La longitud màxima del radi és la vintena part de la mitjana de l'amplada i la llargada.
    final public static int MAX_RADI = (getCanvas().width + getCanvas().height) / 2 / Shape.N_MIN_FIGURES / 2;

    private float radi;

    public Circle(float radi, Point point, Color color) {
        super(point, color);
        this.radi = radi;
    }

    /**
     * Constructor d'un cercle amb tots els valors a l'atzar.
     */
    public Circle() {
        super(MAX_RADI, MAX_RADI);
        radi = (float) Math.random() * (MAX_RADI - MIN_RADI + 1) + MIN_RADI;
        //radi = Math.random() * midaMarc????
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radi=" + radi +
                " x=" + getPoint().getX()+
                " y=" + getPoint().getY()+
                '}';
    }

    /**
     *
     * @return PI * radi²
     */
    @Override
    public double area() {
        return Math.PI * radi * radi;
    }

    /**
     *
     * @return PI * diametre
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radi;

    }

    @Override
    public void dibuixa() {
        getCanvas().fill(getColor().getRGB());
        getCanvas().ellipse(
                (float) getPoint().getX(),
                (float) getPoint().getY(),
                2 * radi,
                2 * radi
        );
    }

    public float getRadi() {
        return radi;
    }

    public void setRadi(float radi) {
        this.radi = radi;
    }

}