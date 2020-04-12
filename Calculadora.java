import java.util.*;
class Calculadora {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Inicio();
    }

    private static void Inicio(){

        //imprime a mensagem com as opcoes do menu principal
        Mensagem();

        //le a opcao escolhida pelo usuario e chama o metodo correspondente
        int x = sc.nextInt();
        if(x == 1) NumeroInteiro();
        if(x == 2) PontoFlutuante();
        if(x == 3) System.exit(0);

        System.out.println("\n \n");

        //apos realizada a operacao escolhida, retorna para o menu principal
        Inicio();

    }

    private static void Mensagem(){

        System.out.println("-----------------Calculadora de Numeros Binarios-----------------");
        System.out.println("Digite:");
        System.out.println("1 para realizar uma operacao com numeros inteiros;");
        System.out.println("2 para realizar uma operacao com numeros de ponto flutuante; ou");
        System.out.println("3 para sair do programa");
        System.out.println("------------------------------------------------------------------");
    }

    private static void NumeroInteiro(){

        //le todos os dados necessarios para realizar operacao com inteiro
        System.out.println("Digite a quantidade de bits da operacao desejada");
        int nbit = sc.nextInt();
        System.out.println("Digite o sinal da operacao (+ - / ou *)");
        String operacao = sc.next();
        System.out.println("Digite o sinal do primeiro numero (+ ou -)");
        String sinal = sc.next();
        System.out.println("Digite o valor em binario do primeiro numero (Ex 1001)");
        int numero = sc.nextInt();
        System.out.println("Digite o sinal do segundo numero (+ ou -)");
        String sinal2 = sc.next();
        System.out.println("Digite o valor em binario do segundo numero (Ex 1001)");
        int numero2 = sc.nextInt();

        //checa a operacao escolhida pelo usuario e chama o metodo correspondente
        if(operacao.equals("+")) System.out.println("Resultado: " + SomaInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("-")) System.out.println("Resultado: " + SubtracaoInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("*")) System.out.println("Resultado: " + MultiplicacaoInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("/")) System.out.println("Resultado: " + DivisaoInteiro(nbit, sinal, numero, sinal2, numero2));
    }

    private static void PontoFlutuante() {

        //le todos os dados necessarios para realizar operacao com ponto flutuante
        System.out.println("Digite o sinal da operacao (+ - / ou *)");
        String operacao = sc.next();
        System.out.println("Digite o sinal do primeiro numero (+ ou -)");
        String sinal = sc.next();
        System.out.println("Digite a mantissa do primeiro numero (Ex 1,010011)");
        Double mantissa = sc.nextDouble();
        System.out.println("Digite o expoente do primeiro numero em binario");
        int expoente = sc.nextInt();
        System.out.println("Digite o sinal do segundo numero (+ ou -)");
        String sinal2 = sc.next();
        System.out.println("Digite a mantissa do segundo numero (Ex 1,010011)");
        Double mantissa2 = sc.nextDouble();
        System.out.println("Digite o expoente do segundo numero em binario");
        int expoente2 = sc.nextInt();

        //checa a operacao escolhida pelo usuario e chama o metodo correspondente
        if(operacao.equals("+")) System.out.println(SomaFlutuante(sinal, mantissa , expoente, sinal2, mantissa2, expoente2));
        if(operacao.equals("-")) System.out.println(SubtracaoFlutuante(sinal, mantissa , expoente, sinal2, mantissa2, expoente2));
        if(operacao.equals("*")) System.out.println(MultiplicacaoFlutuante(sinal, mantissa , expoente, sinal2, mantissa2, expoente2));
        if(operacao.equals("/")) System.out.println(DivisaoFlutuante(sinal, mantissa , expoente, sinal2, mantissa2, expoente2));
    }

    private static String SomaInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        //caso algum dos numeros for negativo, realiza a subtracao
        if(sinal == "-") return SubtracaoInteiro(nbit, sinal2, numero2, sinal, numero);
        if(sinal2 == "-") return SubtracaoInteiro(nbit, sinal, numero, sinal2, numero2);
        
        //caso algum dos numeros for igual a zero, retorna o outro numero
        if(numero == 0) {

            String resultado = String.valueOf(numero2);                
            return PrintZeros(nbit, numero2) + resultado;
        }    
        if(numero2 == 0){

            String resultado = String.valueOf(numero);                
            return PrintZeros(nbit, numero) + resultado;
        } 

        //da linha 105 a 116, e feita a manipulacao dos numeros para transforma-los num array de char
        String tmp = Integer.toString(numero);
        char [] a = tmp.toCharArray();

        tmp = Integer.toString(numero2);
        char [] b = tmp.toCharArray();

        char [] c;

        //caso em que o primeiro numero possui mais bits que o segundo e, portanto, e necessario ajustar os bits do
        //segundo numero
        if(a.length > b.length || a.length == b.length) {

            c = new char [a.length];
            int k = a.length - b.length;

            for(int i = 0; i < k; i++) c[i] = '0';
            for(int j = k; j < c.length; j++) c[j] = b[j-k];
            b = new char [a.length+1]; //aloca o resultado
        }

        //caso em que o segundo numero possui mais bits que o primeiro e, portanto, e necessario ajustar os bits do
        //primeiro numero
        else {

            c = new char [b.length];
            int k = b.length - a.length;

            for(int i = 0; i < k; i++) c[i] = '0';
            for(int j = k; j < c.length; j++) c[j] = a[j-k];
        
            String temp = String.copyValueOf(b);
            a = temp.toCharArray();
            b = new char [a.length+1]; //aloca o resultado
            
        }

        char aux = '0'; //variavel que 'sobe'
        
        b[0] = '0';
        for(int m = (b.length - 1); m > 0; m--){

            //1+1 == 0  e sobe 1
            if(a[m-1] == c[m-1] && a[m-1] == '1') {

                b[m] = '0';
                aux = '1';
            }

            //0+0 == 0
            else if(a[m-1] == c[m-1] && a[m-1] == '0') b[m] = '0';

            //1+0 == 0+1 == 1
            else if((a[m-1] == '1' && c[m-1] == '0') || (c[m-1] == '1' && a[m-1] == '0')) b[m] = '1';
        
            //se tiver subido 1
            if(aux == '1') {

                if(m == 1) b[0] = '1';

                //se o numero a esquerda for 1, o ele passa a ser 0 e sobe 1 novamente
                else if(a[m-2] == '1') a[m-2] = '0'; 

                //caso contrario, ele passa a ser 1 e nao sobe nenhum valor
                else {
                    a[m-2] = '1';
                    aux = '0';
                }
            }

        }

        String resultado = String.copyValueOf(b);
        int soma = Integer.parseInt(resultado);      
        resultado = String.valueOf(soma);

        return PrintZeros(nbit,soma) + resultado;
    }

    private static String SubtracaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        return "aimeudeuscomoebomservidalouca";
    }

    private static String MultiplicacaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        //checa se a multiplicacao e por 0 ou 1
        if(numero2 == 0) return PrintZeros(nbit, 0) + "0";
        if(numero2 == 1) return PrintZeros(nbit, numero) + String.valueOf(numero);

        //transforma multiplicador e multiplicando em arrays de char e inicializa variaveis auxiliares
        char [] multiplicador = (String.valueOf(numero2)).toCharArray();
        char [] multiplicando = (String.valueOf(numero)).toCharArray();

        int soma = 0;
        String produto = "";

        //for para multiplicar bit a bit
        for(int i = multiplicador.length - 1; i > -1; i--){
            
            //se o multiplicador for = 1 realiza a multiplicacao, se nao, como o resultado e 0, nao faz nada
            if(multiplicador[i] == '1'){

                //variavel k significa a quantidade de 0 que sao necessarios add a direita do numero
                int k = multiplicador.length - i - 1;

                //cria um array com k indices a mais e completa os k indices a direita com 0
                char [] aux = new char [multiplicando.length + k];
                for(int j = aux.length - 1; j >= aux.length - k; j --) aux[j] = '0';
                for(int j = aux.length - k - 1; j > -1; j--) aux[j] = multiplicando[j];

                //soma o numero com a soma anterior
                int tmp = Integer.parseInt(String.copyValueOf(aux));
                produto = SomaInteiro(nbit, "+", soma, "+", tmp);

                soma = Integer.parseInt(produto);
            }

       }

       if(sinal == "+" && sinal2 == "-" || sinal == "-" && sinal2 == "+"); //retornar complemento de dois
       return produto;
    }

    private static String DivisaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        return "aimeudeuscomoebomservidalouca";
    }

    private static Double SomaFlutuante(String sinal, Double mantissa, int expoente, String sinal2, Double mantissa2, int expoente2){

        return 0.0;
    }

    private static Double SubtracaoFlutuante(String sinal, Double mantissa, int expoente, String sinal2, Double mantissa2, int expoente2){
        
        return 0.0;
    }

    private static Double MultiplicacaoFlutuante(String sinal, Double mantissa, int expoente, String sinal2, Double mantissa2, int expoente2){

        return 0.0;
    }

    private static Double DivisaoFlutuante(String sinal, Double mantissa, int expoente, String sinal2, Double mantissa2, int expoente2){
        
        return 0.0;
    }

    private static String PrintZeros(int nbit, int numero){

        //cria um array de char com o numero
        String aux = Integer.toString(numero);
        char [] valor = aux.toCharArray();
        
        //cria um array com a diferenca entre o numero de bits desejado e o numero de bits do valor em questao
        int k = nbit - valor.length;
        char [] tmp = new char [k];

        //preenche o array com zeros e retorna a string resultante
        for(int i = 0; i < k; i++) tmp[i] = '0';

        String zeros = String.copyValueOf(tmp);

        return zeros;
    }

    private static String CompDois(numero){
    
        char [] n = (String.valueOf(numero)).toCharArray();

        //Complemento de 1 (trocando bits de 0 para 1 e vice-versa)
        for(int i = 0; i < n.length; i++){ 

            if(n[i] == '0') n[i] = 1;
            else n[i] = 0;
        }

        char [] res = new char [n.length+1];
        char aux = '0';

        //somando o (complemento de 1) + 1
        for(int j = (n.length - 1); j > 0; j--){

            //0 + 1 = 1
            if(n[j-1]==0) res[j] = '1';

            //1 + 1 = 0 e sobe 1
            else if{ 

                res[j] = '0';
                aux = '1';
            }

            //se subir 1
            if(aux == '1'){

                //se último número à esquerda for 1 
                if(j == '1') res[0] = '1';

                //se o numero a esquerda for 1, ele passa a ser 0 e sobe 1 novamente
                else if(n[j-2] == '1') n[j-1] = '0';

                //caso contrario, ele passa a ser 1 e nao sobe nenhum valor
                else {
                    n[j-2] = '1';
                    aux = '0';
                }
            }
        }

        String resultado = String.copyValueOf(res);
        return resultado;
}


}
