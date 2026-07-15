package clases_integradas;

public class ClaseMath {
    public static void main(String[] args) {
        /*
        La clase `Math` en Java es una clase utilitaria que proporciona métodos estáticos para realizar operaciones
        matemáticas comunes, como cálculos trigonométricos, exponenciales, logarítmicos, redondeo y más.
         */

        System.out.println("Valor de PI: " + Math.PI);
        System.out.println("Valor de E: " + Math.E);
        System.out.println(Math.abs(-10.95));
        System.out.println(Math.max(404, 77));
        System.out.println(Math.min(404, 77));
        System.out.println(Math.round(20.55));
        System.out.println(Math.ceil(20.55));
        System.out.println(Math.floor(20.55));
        System.out.println(Math.pow(4, 2));
        System.out.println(Math.random()); // Entre 0.0 y 1.0
        System.out.println((int) (Math.random() * 11)); // Entre 0 y 10

    }
}
