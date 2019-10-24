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


    public void move (){
        int posX=getPoint().x;
        int posY=getPoint().y;



        if (posX>(getCanvas().width - getRadi())) {
            vX=-vX;

        }
        else if(posX<getRadi() ){
            vX=Math.abs(vX);

        }
        if (posY>(getCanvas().height - getRadi())) {
            vY=-vY;
        }
        else if(posY<getRadi() ){
            vY=Math.abs(vY);
        }

        posX+=vX;
        posY+=vY;
        setPoint(new Point(posX,posY));

    }

    /*metodo move agafa posicio get point

    int velocitatX= 5;
    int velocitatY=3;

    x=getPoint().getX;
    y=getPOint().getY;

    posX+=velocitatX;
    posY+=velocitatY;

    setPoint(new Point(posX,posY);
     */
}
