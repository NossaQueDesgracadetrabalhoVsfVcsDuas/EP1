public class Pessoa {

private int id;
private Lugar origem;
private Lugar destino;
private Lugar transf;
private Lugar transf2;
private Lugar transf3;

    public Pessoa() {

        this.id = 0;
        origem = new Lugar(0,0);
        destino = new Lugar(0,0);
        transf = new Lugar(0,0);
        transf2 = new Lugar(0,0);
        transf3 = new Lugar(0,0);
    }    
  
 
 
    public void setID(int id) {

        this.id = id;
    }

    public  void setOrigem(int x, int y) {

        origem.setCoord(x,y);
    }

    public void setDestino(int x, int y) {

        destino.setCoord(x,y);
    }

    public void setTransf(int x, int y) {

        transf.setCoord(x,y);
    }

    public void setTransf2(int x, int y) {

        transf2.setCoord(x,y);
    }

    public void setTransf3(int x, int y) {

        transf3.setCoord(x,y);
    }
 
    public int getID() {
        return id;
    } 

    public String getOrigem() {
        return origem.getCoord();
    } 

    public String getDestino() {
        return destino.getCoord();
    } 

    public String getTransf() {
        return transf.getCoord();
    } 

    public String getTransf2() {
        return transf2.getCoord();
    } 

    public String getTransf3() {
        return transf3.getCoord();
    } 
 
 
}
