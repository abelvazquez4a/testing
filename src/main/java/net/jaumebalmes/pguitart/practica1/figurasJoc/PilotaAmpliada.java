package net.jaumebalmes.pguitart.practica1.figurasJoc;

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
        if (this.activa){
            System.out.println("dibujando pelota "+this);
            super.dibuixa();
        }
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
        Color color=null;
        if (altraPilota.getRadi()>this.getRadi()) {
            color = altraPilota.getColor();
            this.setActiva(false);
            altraPilota.setRadi(this.getRadi()+altraPilota.getRadi());
            this.setColor(color);
        }
        else if (altraPilota.getRadi()<this.getRadi()){
            color = this.getColor();
            altraPilota.setActiva(false);
            this.setRadi(this.getRadi()+altraPilota.getRadi());
            this.setColor(color);
        }
    }
}
