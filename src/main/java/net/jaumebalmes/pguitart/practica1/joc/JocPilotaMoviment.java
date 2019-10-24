package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.Pilota;
import net.jaumebalmes.pguitart.practica1.figures.Circle;
import net.jaumebalmes.pguitart.practica1.figures.Shape;
import processing.core.PApplet;

public class JocPilotaMoviment extends Joc {
    private Pilota pilota;

    public JocPilotaMoviment(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void canvasDraw() {
        pilota.dibuixa();
    }

    @Override
    public void prepararJoc() {
        pilota = new Pilota(5,5);
    }

    @Override
    public void jugada() {
        pilota.move();
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
