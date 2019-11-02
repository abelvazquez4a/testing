package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;

public class JocSupervivencia extends Joc {
//    private ArrayList<PilotaAmpliada> listaPilotas = new ArrayList<>();
    private boolean finalJoc = false;


    public JocSupervivencia(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void canvasSetup() {
        getCanvas().background(getBackground());
    }

    @Override
    public void canvasDraw() {
        getCanvas().background(getBackground());
    }

    @Override
    public void prepararJoc() {

    }

    @Override
    public void jugada() {
//        for (PilotaAmpliada pilotaAmpliada:listaPilotas) {
//            for (int i = 0; i < listaPilotas.size(); i++) {
//                if (pilotaAmpliada.Intersect(listaPilotas.get(i))){
//                    pilotaAmpliada.Join(listaPilotas.get(i));
//                }
//            }
//            pilotaAmpliada.dibuixa();
//        }


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
