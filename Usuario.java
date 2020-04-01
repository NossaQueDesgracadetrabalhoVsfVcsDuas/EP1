public class Usuario  {

    public static void main(String [] args){

        Pessoa[] p = new Pessoa[3];
        Lugar[] l = new Lugar[2];

        for(int a = 0; a < p.length; a++){
            p[a] = new Pessoa();
        }

        for(int b = 0; b < l.length; b++){
            l[b] = new Lugar(0,0);
        }

        
        p[0].setID(27);
        p[0].setOrigem(8, 4);
        p[0].setDestino(5, 4);
        p[0].setTransf(7, 9);

        p[1].setID(11);
        p[1].setOrigem(5, 2);
        p[1].setDestino(5, 4);
        p[1].setTransf(3, 87);
        p[1].setTransf2(4, 31);
        p[1].setTransf3(7, 8);

        p[2].setID(14);
        p[2].setOrigem(2, 6);
        p[2].setDestino(5, 4);
        p[2].setTransf3(84, 1);

        
        l[0].setCoord(5, 4);
        l[1].setCoord(27, 8);
        l[0].setQtd();

        for(int i = 0; i < p.length; i++){
            System.out.println(p[i].getID());
            System.out.println(p[i].getOrigem());
            System.out.println(p[i].getDestino());
            System.out.println(p[i].getTransf());
            System.out.println(p[i].getTransf2());
            System.out.println(p[i].getTransf3());
        }

        for(int j = 0; j < l.length; j++){
            System.out.println(l[j].getCoord());
            System.out.println(l[j].getQtd());
        }
        


    }




}
