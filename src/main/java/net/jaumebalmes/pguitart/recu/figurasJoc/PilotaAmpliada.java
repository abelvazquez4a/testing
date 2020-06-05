package net.jaumebalmes.pguitart.recu.figurasJoc;

import java.awt.*;

public class PilotaAmpliada extends Pilota  {
    boolean activa=true;


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

    public boolean Intersect(PilotaAmpliada altraPilota){
        boolean intersect=false;
        double distancia = Math.sqrt(Math.pow((this.getPoint().getX()-altraPilota.getPoint().getX()),2)+Math.pow((this.getPoint().getY()-altraPilota.getPoint().getY()),2));
        double sumaRadis = altraPilota.getRadi()+this.getRadi();

        if (distancia<sumaRadis){
            intersect=true;
        }
        return intersect;
    }

    public void Join (PilotaAmpliada altraPilota){
         if (this.getColor()!=altraPilota.getColor()){
            this.setActiva(true);
            this.setvX(1);
            altraPilota.setvX(0);
            this.setPoint(new Point(this.getPoint().x+2,this.getPoint().y));
            altraPilota.setActiva(false);
            altraPilota.setColor(Color.red);
            this.setColor(Color.red);
        }
        else if (this.getDireccio()!=altraPilota.getDireccio()){
            if (this.getDireccio()==-1) {
                altraPilota.setDireccio(this.getDireccio());
                altraPilota.setActiva(true);
                altraPilota.setvX(Math.abs(this.getvX()) * -1);
                this.setvX(0);
                altraPilota.setPoint(new Point(altraPilota.getPoint().x + 2, altraPilota.getPoint().y));
                this.setActiva(false);
            }
           else if (this.getDireccio()==1) {
                altraPilota.setDireccio(this.getDireccio());
                altraPilota.setActiva(true);
                altraPilota.setvX(Math.abs(this.getvX()));
                this.setvX(0);
                altraPilota.setPoint(new Point(altraPilota.getPoint().x + 2, altraPilota.getPoint().y));
                this.setActiva(false);
            }
        }
    }
}
