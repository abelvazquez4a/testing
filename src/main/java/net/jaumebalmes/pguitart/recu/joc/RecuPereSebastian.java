package net.jaumebalmes.pguitart.recu.joc;

import net.jaumebalmes.pguitart.recu.canvas.Canvas;
import net.jaumebalmes.pguitart.recu.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;

public class RecuPereSebastian extends Joc {
    private boolean finalJoc = false;
    PilotaAmpliada [] listaPilotas = new PilotaAmpliada[50];

    public RecuPereSebastian(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void canvasDraw() {
        getCanvas().background(240,248,255);
        for (int i = 0; i < listaPilotas.length ; i++) {
                listaPilotas[i].dibuixa();
        }
    }

    @Override
    public void prepararJoc() {
        for (int i = 0; i < listaPilotas.length ; i++) {
            listaPilotas[i]= new PilotaAmpliada(10f,new Point(((int)(Math.random()*getCanvas().width)+1),((int)(Math.random()*getCanvas().height)+1)),Color.GRAY,1,1);
        }
        for (int i = 0; i <listaPilotas.length ; i++) {
            for (int j = 1; j < listaPilotas.length; j++) {
                if (i!=j){
                    while (listaPilotas[i].Intersect2(listaPilotas[j])){
                        listaPilotas[i].setPoint(new Point(((int)(Math.random()*getCanvas().width)+1),((int)(Math.random()*getCanvas().height)+1)));
                    }
                }
            }
        }

        listaPilotas[0].setColor(Color.red);
        listaPilotas[0].setFechaContagio(System.currentTimeMillis());
    }
    public int numero (int porcentaje,int total){
        return ((porcentaje*total)/100);
    }

    @Override
    public void jugada() {
        for (int i = 0; i < listaPilotas.length; i++) {
               for (int j = 0; j < listaPilotas.length; j++) {
                   if (listaPilotas[i].Intersect(listaPilotas[j])&&i!=j) {
                       listaPilotas[i].Join(listaPilotas[j]);
                   }
               }
               listaPilotas[i].move();
        }
    }

    @Override
    public void finalJoc() {
    }

    @Override
    public void keyPressed() {
        finalJoc=true;
    }

    public static void main(String[] args) {
        String[] processingArgs = {"Recu Sebas"};
        Canvas canvas = new Canvas();
        Joc joc = new RecuPereSebastian(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
}
