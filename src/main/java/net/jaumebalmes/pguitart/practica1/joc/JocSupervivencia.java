package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.PilotaAmpliada;
import net.jaumebalmes.pguitart.practica1.figures.Circle;
import processing.core.PApplet;

import java.awt.*;

public class JocSupervivencia extends Joc {
    private boolean finalJoc = false;
    PilotaAmpliada [] listaPilotas = new PilotaAmpliada[10];

    public JocSupervivencia(PApplet canvas) {
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
            System.out.println(listaPilotas[i]);
                listaPilotas[i].dibuixa();
        }
        System.out.println(PilotaAmpliada.getContadorActivas());
        if (PilotaAmpliada.getContadorActivas()==1){
            System.out.println("HA terminado el juego");
            getCanvas().noLoop();
            getCanvas().background(getCanvas().loadImage("gameOver.jpg"));
        }
    }

    @Override
    public void prepararJoc() {
        for (int i = 0; i < listaPilotas.length ; i++) {
            //(float radi, Point point, Color color, int vX, int vY)
            listaPilotas[i]= new PilotaAmpliada((float)(Math.random()*(40-10)+10),new Point(((int)(Math.random()*getCanvas().width)+1),((int)(Math.random()*getCanvas().height)+1)),Color.BLACK,3,3);
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
        Joc joc = new JocSupervivencia(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
}
