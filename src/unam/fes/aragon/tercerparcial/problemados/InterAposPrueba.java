
package unam.fes.aragon.tercerparcial.problemados;

public class InterAposPrueba {
    public static void main(String[] args) {
        InterfijaAPostfija test = new InterfijaAPostfija("10 5 8 * + 4 2 / - 6 20 * 7 / + 3 - 9 - ");

            test.construirArbol();


            test.prefija();
            test.postfija();
            test.interfija();

            System.out.println(test.getExpresionInterfija());
            System.out.println(test.getExpresionPrefija());
            System.out.println(test.getExpresionPostfija());

            System.out.println(test.evaluarExpresion());



    }
}
