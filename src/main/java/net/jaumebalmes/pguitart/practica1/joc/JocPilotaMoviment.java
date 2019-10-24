package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.Pilota;
import net.jaumebalmes.pguitart.practica1.figures.Circle;
import net.jaumebalmes.pguitart.practica1.figures.Shape;
import processing.core.PApplet;

import java.util.ArrayList;

public class JocPilotaMoviment extends Joc {
    static boolean continua=true;
    private ArrayList<Pilota> listaPilotas = new ArrayList<>();



    public JocPilotaMoviment(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void canvasDraw() {
        if (this.continua) {
            getCanvas().background(240,248,255);
        }
        for (Pilota pilota:listaPilotas
             ) {pilota.dibuixa();

        }

    }

    @Override
    public void prepararJoc() {
        for (int i = 0; i < 40; i++) {
            listaPilotas.add(new Pilota((int)(Math.random()*15),(int)(Math.random()*15)));
        }
    }

    @Override
    public void jugada() {
        for (Pilota pilota:listaPilotas
             ) {
            pilota.move();
        }
    }

    @Override
    public void finalJoc() {

    }

    @Override
    public void keyPressed() {

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Pluja de Formes"};
        Canvas canvas = new Canvas();
        Joc joc = new JocPilotaMoviment(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }
}
