package net.jaumebalmes.pguitart.recu.figurasJoc;

import net.jaumebalmes.pguitart.recu.figures.Circle;

import java.awt.*;

public class Pilota extends Circle {

    private int vX;
    private int vY;
    private int direccio=1;
    Long fechaContagio = null;

    public Pilota(float radi, Point point, Color color, int vX, int vY) {
        super(radi, point, color);
        this.vX = vX;
        this.vY = vY;
    }

    public Pilota(int vX, int vY) {
        this.vX = vX;
        this.vY = vY;
    }

    public Long getFechaContagio() {
        return fechaContagio;
    }

    public void setFechaContagio(Long fechaContagio) {
        if (this.fechaContagio==null){
            this.fechaContagio = fechaContagio;
        }
    }

    public int getDireccio() {
        return direccio;
    }

    public void setDireccio(int direccio) {
        this.direccio = direccio;
    }

    public int getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public int getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public void move() {

        if (this.getFechaContagio()!=null){

            if ((System.currentTimeMillis()-this.getFechaContagio())>5000){
                this.setColor(Color.pink);
            }
        }

        int posX = getPoint().x;
        int posY = getPoint().y;


        if (posX > (getCanvas().width - getRadi())) {
            vX=Math.abs(vX)*-1;
            direccio=Math.abs(direccio)*-1;
        }
        else if (posX < getRadi()){
            vX=Math.abs(vX);
            direccio=Math.abs(direccio);
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
