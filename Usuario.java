import java.util.LinkedList;

public class Usuario {

    public static void main(String [] args){

        LinkedList<Pessoa> p = new LinkedList<Pessoa>();     

        p.add(new Pessoa());
        p.add(new Pessoa());

        for(int i = 0; i < p.size(); i++){

            Pessoa pe = p.get(i);
            pe.setID(26+i);
            System.out.println(pe.getID());
        }        


    }

}
