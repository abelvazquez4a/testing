package net.jaumebalmes.pguitart.practica1.joc;

import net.jaumebalmes.pguitart.practica1.canvas.Canvas;
import net.jaumebalmes.pguitart.practica1.figurasJoc.PilotaAmpliada;
import processing.core.PApplet;

import java.awt.*;

public class JocAgario extends JocSupervivencia {
    private PilotaAmpliada miPilota = new PilotaAmpliada((float)60,new Point(getCanvas().mouseX,getCanvas().mouseY),Color.WHITE,5,5);;
    private boolean finalJoc = false;


    public JocAgario(PApplet canvas) {
        super(canvas);
    }

    @Override
    public void prepararJoc() {
        super.prepararJoc();
    }


    @Override
    public void jugada() {
        if (miPilota.isActiva()) {
            for (int i = 0; i < super.listaPilotas.length; i++) {
                if (miPilota.Intersect(super.listaPilotas[i]) && super.listaPilotas[i].isActiva()) {
                    miPilota.Join(super.listaPilotas[i]);
                }
            }
        }
        super.jugada();
    }

    @Override
    public void canvasSetup() {
        super.canvasSetup();
    }

    @Override
    public void canvasDraw() {
        miPilota.setPoint(new Point(getCanvas().mouseX,getCanvas().mouseY));
        super.canvasDraw();
        if(PilotaAmpliada.getContadorActivas()>1)miPilota.dibuixa();

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Agario"};
        Canvas canvas = new Canvas();
        Joc joc = new JocAgario(canvas);
        canvas.setJoc(joc);
        PApplet.runSketch(processingArgs, canvas);
    }


}
