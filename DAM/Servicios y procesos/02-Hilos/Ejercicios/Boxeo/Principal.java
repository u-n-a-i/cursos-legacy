public class Principal {
    public static void main(String[] args) {
        Ring ring = new Ring();
        Boxeador b1 = new Boxeador("Bivol", ring);
        Boxeador b2 = new Boxeador("Canelo", ring);

        b1.start();
        b2.start();

        try {
            b1.join();
            b2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- Resultado ---");
        System.out.println(b1.getName() + " (" + b1.getGolpesPropios() + " golpes)");
        System.out.println(b2.getName() + " (" + b2.getGolpesPropios() + " golpes)");

        if (b1.getGolpesPropios() > b2.getGolpesPropios()) {
            System.out.println("Ganador: " + b1.getName());
        } else if (b2.getGolpesPropios() > b1.getGolpesPropios()) {
            System.out.println("Ganador: " + b2.getName());
        } else {
            System.out.println("Empate");
        }
    }

}
