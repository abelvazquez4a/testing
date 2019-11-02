package net.jaumebalmes.pguitart.practica1.figurasJoc;

import net.jaumebalmes.pguitart.practica1.figures.Circle;

import java.awt.*;

public class Pilota extends Circle {

    private int vX;
    private int vY;

    public Pilota(float radi, Point point, Color color, int vX, int vY) {
        super(radi, point, color);
        this.vX = vX;
        this.vY = vY;
    }

    public Pilota(int vX, int vY) {
        this.vX = vX;
        this.vY = vY;
    }


    public void move() {
        int posX = getPoint().x;
        int posY = getPoint().y;


        if (posX > (getCanvas().width - getRadi())) {
            vX=Math.abs(vX)*-1;

        }
        else if (posX < getRadi()){
            vX=Math.abs(vX);
        }

        if (posY > (getCanvas().height - getRadi())) {
            vY=Math.abs(vY)*-1;
        }
        else if (posY < getRadi()){
            vY=Math.abs(vY);
        }

        posX += vX;
        posY += vY;
        setPoint(new Point(posX, posY));

    }

}
