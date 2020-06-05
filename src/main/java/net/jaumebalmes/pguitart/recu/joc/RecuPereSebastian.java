package net.jaumebalmes.pguitart.recu.joc;

import net.jaumebalmes.pguitart.recu.canvas.Canvas;
import net.jaumebalmes.pguitart.recu.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;

public class RecuPereSebastian extends Joc {
    private boolean finalJoc = false;
    PilotaAmpliada [] listaPilotas = new PilotaAmpliada[5];

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
        int posicioY = getCanvas().height/2;
        int posicioX = getCanvas().width;
        listaPilotas[0]=(new PilotaAmpliada(20f,new Point(new Point(30,posicioY)),Color.red,1,0));
        listaPilotas[1]=(new PilotaAmpliada(20f,new Point(numero(20,posicioX),posicioY),Color.gray,0,0));
        listaPilotas[2]=(new PilotaAmpliada(20f,new Point(numero(40,posicioX),posicioY),Color.gray,0,0));
        listaPilotas[3]=(new PilotaAmpliada(20f,new Point(numero(60,posicioX),posicioY),Color.gray,0,0));
        listaPilotas[4]=(new PilotaAmpliada(20f,new Point(numero(80,posicioX),posicioY),Color.gray,0,0));
    }
    public int numero (int porcentaje,int total){
        return ((porcentaje*total)/100);
    }
    @Override
    public void jugada() {
        for (int i = 0; i < listaPilotas.length; i++) {
            if (listaPilotas[i].isActiva()) {
                for (int j = 0; j < listaPilotas.length; j++) {
                        if (listaPilotas[i].Intersect(listaPilotas[j]) ) {
                            listaPilotas[i].Join(listaPilotas[j]);
                        }
                }
                if( listaPilotas[i].isActiva()){
                    listaPilotas[i].move();
                }
            }
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
