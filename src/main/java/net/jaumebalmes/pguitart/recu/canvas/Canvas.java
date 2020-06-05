/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.recu.canvas;

import net.jaumebalmes.pguitart.recu.joc.Joc;
import processing.core.PApplet;

/**
 * Genera una pluja de rectangles, cercles i triangles en una tela (Canvas) de
 * Processing.
 *
 * @author pguitart
 */
public class Canvas extends PApplet {

    private Joc joc;

    public void setJoc(Joc joc) {
        this.joc = joc;
    }

    /**
     * Només s'executa una vegada.
     */
    @Override
    public void setup() {
        frameRate(144);
        joc.prepararJoc();
        joc.canvasSetup();
    }

    /**
     * Necessari per a definir la mida del canvas
     * associada a cada joc
     */
    @Override
    public void settings() {

        joc.canvasSettings();
    }

    /**
     * S'executa diverses vegades per segon (frameRate)
     */
    @Override
    public void draw() {
        if (!joc.isJocFinalitzat()){
            joc.jugada();
            joc.canvasDraw();
        } else {
            joc.finalJoc();
        }
    }
    
    @Override
    public void keyPressed(){
        joc.keyPressed();
    }
    


}
