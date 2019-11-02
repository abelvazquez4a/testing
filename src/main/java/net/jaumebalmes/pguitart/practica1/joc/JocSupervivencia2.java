package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class JocSupervivencia2 extends Joc {
    private boolean finalJoc = false;
    PilotaAmpliada [] listaPilotas = new PilotaAmpliada[6];

    public JocSupervivencia2(PApplet canvas) {
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
            listaPilotas[i]= new PilotaAmpliada(5,5);
            System.out.println("creada pelota "+listaPilotas[i]);
        }
    }

    @Override
    public void jugada() {
        for (int i = 0; i < listaPilotas.length; i++) {
            if (listaPilotas[i].isActiva()) {
                for (int j = 0; j < listaPilotas.length; j++) {
                        if (listaPilotas[i].Intersect(listaPilotas[j]) && listaPilotas[j].isActiva()) {
                            listaPilotas[i].Join(listaPilotas[j]);

                        }
                }
                listaPilotas[i].move();

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
        String[] processingArgs = {"Pluja de Formes"};
        Canvas canvas = new Canvas();
        Joc joc = new JocSupervivencia2(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
}
