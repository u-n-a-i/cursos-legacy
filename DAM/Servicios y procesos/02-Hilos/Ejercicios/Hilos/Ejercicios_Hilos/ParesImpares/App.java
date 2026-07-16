public class App {
    public static void main(String[] args) {
        Pares hiloPares1 = new Pares("Par 1");
        Pares hiloPares2 = new Pares("Par 2");
        Impares hiloImpares1 = new Impares("Impar 1");
        Impares hiloImpares2 = new Impares("Impar 2");

        hiloPares1.start();
        hiloPares2.start();
        hiloImpares1.start();
        hiloImpares2.start();

    }

}
