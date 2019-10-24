package net.jaumebalmes.pguitart.practica1.figurasJoc;

import net.jaumebalmes.pguitart.practica1.figures.Circle;

import java.awt.*;

public class Pilota extends Circle {

    private int vX;
    private int vY;


    public Pilota(int vX, int vY) {
        this.vX = vX;
        this.vY = vY;
    }

    public boolean isContinua() {
        return continua;
    }

    public void setContinua(boolean continua) {
        this.continua = continua;
    }

    public void move() {
        int posX = getPoint().x;
        int posY = getPoint().y;


        if (posX > (getCanvas().width - getRadi()) || posX < getRadi()) {
            vX *= -1;

        }

        if (posY > (getCanvas().height - getRadi()) || posY < getRadi()) {
            vY *= -1;
        }

        posX += vX;
        posY += vY;
        setPoint(new Point(posX, posY));

    }

}
