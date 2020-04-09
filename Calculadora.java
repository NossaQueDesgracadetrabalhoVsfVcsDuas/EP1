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
        if(operacao.equals("+")) System.out.println(SomaInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("-")) System.out.println(SubtracaoInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("*")) System.out.println(MultiplicacaoInteiro(nbit, sinal, numero, sinal2, numero2));
        if(operacao.equals("/")) System.out.println(DivisaoInteiro(nbit, sinal, numero, sinal2, numero2));
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

    private static int SomaInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        //caso algum dos numeros for negativo, realiza a subtracao
        if(sinal == "-") return SubtracaoInteiro(nbit, sinal2, numero2, sinal, numero);
        if(sinal2 == "-") return SubtracaoInteiro(nbit, sinal, numero, sinal2, numero2);
        
        //caso algum dos numeros for igual a zero, retorna o outro numero
        if(numero == 0) {

            System.out.print("Resultado: " + PrintZeros(nbit, numero2));
            return numero2;
        }    
        if(numero2 == 0){

            System.out.print("Resultado: " + PrintZeros(nbit, numero));
            return numero;
        } 

        //da linha 105 a 116, e feita a manipulacao dos numeros para transforma-los num array de char
        String tmp = Integer.toString(numero);
        char [] a = tmp.toCharArray();

        tmp = Integer.toString(numero2);
        char [] b = tmp.toCharArray();

        char [] c = new char [a.length];

        int k = a.length - b.length;

        for(int i = 0; i < k; i++) c[i] = '0';
        for(int j = k; j < c.length; j++) c[j] = b[j-k];

        char aux = '0'; //variavel que 'sobe'

        b = new char [a.length]; //aloca o resultado

        for(int m = (b.length - 1); m > -1; m--){

            //1+1 == 0  e sobe 1
            if(a[m] == c[m] && a[m] == '1') {

                b[m] = '0';
                aux = '1';
            }

            //0+0 == 0
            else if(a[m] == c[m] && a[m] == '0') b[m] = '0';

            //1+0 == 0+1 == 1
            else if((a[m] == '1' && c[m] == '0') || (c[m] == '1' && a[m] == '0')) b[m] = '1';
        
            //se tiver subido 1
            if(aux == '1') {

                //se o numero a esquerda for 1, o ele passa a ser 0 e sobe 1 novamente
                if(a[m-1] == '1') a[m-1] = '0'; 

                //caso contrario, ele passa a ser 1 e nao sobe nenhum valor
                else {
                    a[m-1] = '1';
                    aux = '0';
                }
            }

        }

        String resultado = String.copyValueOf(b);
        int soma = Integer.parseInt(resultado);      
        System.out.print("Resultado: " + PrintZeros(nbit, soma));

        return soma;
    }

    private static int SubtracaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        return 0;
    }

    private static int MultiplicacaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        return 0;
    }

    private static int DivisaoInteiro(int nbit, String sinal, int numero, String sinal2, int numero2) {

        return 0;
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



}