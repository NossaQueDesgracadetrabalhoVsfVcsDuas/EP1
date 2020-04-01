public class Lugar {

private int x;
private int y;
private int qtd;

    public Lugar(int x, int y){

        setCoord(x,y);
        this.qtd = 0;
    }  
 
    protected void setCoord(int x, int y){

        this.x = x;
        this.y = y;
    }  

    protected void setQtd() {
        qtd++;
    }
 
    protected String getCoord(){
        return x + "," + y;
    } 
 
    protected int getQtd(){
        return qtd;
    }   

}

  
