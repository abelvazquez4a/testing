package net.jaumebalmes.pguitart.recu.figurasJoc;

import java.awt.*;
import java.util.Date;

public class PilotaAmpliada extends Pilota {
    boolean activa = true;
    Long fechaContagio = null;


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


    public boolean Intersect(PilotaAmpliada altraPilota) {
        boolean intersect = false;
        double distancia = Math.sqrt(Math.pow((this.getPoint().getX() - altraPilota.getPoint().getX()), 2) + Math.pow((this.getPoint().getY() - altraPilota.getPoint().getY()), 2));
        double sumaRadis = altraPilota.getRadi() + this.getRadi();

        if (distancia <= sumaRadis) {
            intersect = true;
        }
        return intersect;
    }
    public boolean Intersect2(PilotaAmpliada altraPilota) {
        boolean intersect = false;
        double distancia = Math.sqrt(Math.pow((this.getPoint().getX() - altraPilota.getPoint().getX()), 2) + Math.pow((this.getPoint().getY() - altraPilota.getPoint().getY()), 2));
        double sumaRadis = altraPilota.getRadi() + this.getRadi();

        if (distancia <= sumaRadis+50) {
            intersect = true;
        }
        return intersect;
    }

    public void Join(PilotaAmpliada altraPilota) {

        int vXAltre = altraPilota.getvX();
        int vYAltre = altraPilota.getvY();
        int vXThis = this.getvX();
        int vYThis = this.getvY();


        this.setvX(vXAltre);
        this.setvY(vYAltre);
        altraPilota.setvX(vXThis);
        altraPilota.setvY(vYThis);

        if(altraPilota.getPoint().x>this.getPoint().x){
            this.setPoint(new Point(this.getPoint().x-3,this.getPoint().y-3));
        }else if(altraPilota.getPoint().x<this.getPoint().x){
            this.setPoint(new Point(this.getPoint().x+3,this.getPoint().y+3));
        }
        /*
        if(vXAltre>0){
            this.setPoint(new Point(this.getPoint().x-1,this.getPoint().y-1));

        }else if (vXAltre<0){
            this.setPoint(new Point(this.getPoint().x+1,this.getPoint().y+1));
        }
      if(vXThis<0){
            altraPilota.setPoint(new Point(altraPilota.getPoint().x-1,altraPilota.getPoint().y-1));
        }else if (vXThis>0){
            altraPilota.setPoint(new Point(altraPilota.getPoint().x+1,altraPilota.getPoint().y+1));
        }*/


        if (this.getColor() != altraPilota.getColor() && this.getColor() != Color.pink && altraPilota.getColor() != Color.pink) {
            altraPilota.setColor(Color.red);
            this.setColor(Color.red);
            this.setFechaContagio(System.currentTimeMillis());
            altraPilota.setFechaContagio(System.currentTimeMillis());
        }
    }
}
