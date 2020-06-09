package net.jaumebalmes.pguitart.recu.joc;

import net.jaumebalmes.pguitart.recu.canvas.Canvas;
import net.jaumebalmes.pguitart.recu.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;

public class RecuPereSebastian3 extends Joc {

    PilotaAmpliada[] listaPilotas = new PilotaAmpliada[300];

    public RecuPereSebastian3(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void canvasDraw() {
        getCanvas().background(240, 248, 255);
        for (int i = 0; i < listaPilotas.length; i++) {
            listaPilotas[i].dibuixa();
        }
    }

    @Override
    public void prepararJoc() {
        /**
         * Crea pelotas
         */
        for (int i = 0; i < listaPilotas.length; i++) {
            listaPilotas[i] = new PilotaAmpliada(6f, new Point(((int) (Math.random() * getCanvas().width) + 1),
                    ((int) (Math.random() * getCanvas().height) + 1)), Color.GRAY, 2, 2);
        }

        for (int i = 0; i < listaPilotas.length; i++) {
            for (int j = 1; j < listaPilotas.length; j++) {
                if (i != j) {
                    while (listaPilotas[i].intersect(listaPilotas[j])) {
                        listaPilotas[i].setPoint(new Point(((int) (Math.random() * getCanvas().width) + 1),
                                ((int) (Math.random() * getCanvas().height) + 1)));
                    }
                }
            }
        }
        activarUnaCuartaPart(listaPilotas);
        listaPilotas[0].setColor(Color.red);
        listaPilotas[0].setFechaContagio(System.currentTimeMillis());
    }
    public void activarUnaCuartaPart(PilotaAmpliada [] lista){
        int cuartaPart = ((lista.length*25)/100);
        for (int i = 0; i < cuartaPart; i++) {
            lista[i].setActiva(true);
        }
    }

    @Override
    public void jugada() {
        for (int i = 0; i < listaPilotas.length; i++) {
            for (int j = 0; j < listaPilotas.length; j++) {
                if (listaPilotas[i].intersect(listaPilotas[j]) && i != j) {
                    listaPilotas[i].infectar2(listaPilotas[j]);
                }
            }
            listaPilotas[i].comprobarInmune();
            if (listaPilotas[i].isActiva()){
                listaPilotas[i].move();
            }
        }
    }

    @Override
    public void finalJoc() {

    }

    @Override
    public void keyPressed() {

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Recu Sebas"};
        Canvas canvas = new Canvas();
        Joc joc = new RecuPereSebastian3(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
}

