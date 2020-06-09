package net.jaumebalmes.pguitart.recu.figurasJoc;

import java.awt.*;
import java.util.Date;

public class PilotaAmpliada extends Pilota {
    boolean activa = false;
    Long fechaContagio = null;

    public Long getFechaContagio() {
        return fechaContagio;
    }

    public void setFechaContagio(Long fechaContagio) {
        if (this.fechaContagio==null){
            this.fechaContagio = fechaContagio;
        }
    }

    public PilotaAmpliada(float radi, Point point, Color color, int vX, int vY) {
        super(radi, point, color, vX, vY);
    }

    public PilotaAmpliada(int vX, int vY) {
        super(vX, vY);
    }

    @Override
    public void dibuixa() {
        super.dibuixa();
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void comprobarInmune(){
        if (this.getFechaContagio() != null) {
            if ((System.currentTimeMillis() - this.getFechaContagio()) > 5000) {
                this.setColor(Color.pink);
            }
        }
    }

    public boolean intersect(PilotaAmpliada altraPilota) {
        boolean intersect = false;
        double distancia = Math.sqrt(Math.pow((this.getPoint().getX() - altraPilota.getPoint().getX()), 2) + Math.pow((this.getPoint().getY() - altraPilota.getPoint().getY()), 2));
        double sumaRadis = altraPilota.getRadi() + this.getRadi();

        if (distancia <= sumaRadis) {
            intersect = true;
        }
        return intersect;
    }

    public void infectar (PilotaAmpliada altraPilota){

            int vXAltre = altraPilota.getvX();
            int vYAltre = altraPilota.getvY();
            int vYThis = this.getvY();
            int vXThis = this.getvX();


            this.setvX(vXAltre);
            this.setvY(vYAltre);
            altraPilota.setvX(vXThis);
            altraPilota.setvY(vYThis);

            if(altraPilota.getPoint().x>this.getPoint().x){
                this.setPoint(new Point(this.getPoint().x-3,this.getPoint().y-3));
            }else if(altraPilota.getPoint().x<this.getPoint().x){
                this.setPoint(new Point(this.getPoint().x+3,this.getPoint().y+3));
            }

            if (this.getColor() != altraPilota.getColor() && this.getColor() != Color.pink && altraPilota.getColor() != Color.pink) {
                altraPilota.setColor(Color.red);
                this.setColor(Color.red);
                this.setFechaContagio(System.currentTimeMillis());
                altraPilota.setFechaContagio(System.currentTimeMillis());
            }

    }

    public void infectar2(PilotaAmpliada altraPilota) {
        int vXAltre = altraPilota.getvX();
        int vXThis = this.getvX();

        /**
         * Si las dos bolas estan activas, significa que se han chocado
         * dos bolas que se mueven, cambia la velocidad de las dos.
         */
        if (this.isActiva()&&altraPilota.isActiva()) {
            this.setvX(vXAltre);
            altraPilota.setvX(vXThis);
            /**
             * Si no, se ha chocado con una bola estática,
             * solo cambiamos el eje X de la bola que se mueve.
             */
        }else{
            altraPilota.setvX(vXAltre*-1);
        }

        /**
         * Cambiamos el point de la bola que se mueve, pero no de la estatica.
         */
        if(this.getPoint().x>altraPilota.getPoint().x && altraPilota.isActiva()){
            altraPilota.setPoint(new Point(altraPilota.getPoint().x-3,altraPilota.getPoint().y-3));
        }else if(this.getPoint().x<altraPilota.getPoint().x && altraPilota.isActiva()){
            altraPilota.setPoint(new Point(altraPilota.getPoint().x+3,altraPilota.getPoint().y+3));
        }

        /**
         * Cambiamos el color de las bolas e inicializamos fecha de contagio.
         */
        if (this.getColor() != altraPilota.getColor() && this.getColor() != Color.pink && altraPilota.getColor() != Color.pink) {
            altraPilota.setColor(Color.red);
            this.setColor(Color.red);
            this.setFechaContagio(System.currentTimeMillis());
            altraPilota.setFechaContagio(System.currentTimeMillis());
        }
    }
}
