package unam.fes.aragon.tercerparcial.problemados;

public class InterAposPrueba {
    public static void main(String[] args) {
        InterfijaAPostfija test = new InterfijaAPostfija("53+2*");
        test.interfijaAPostfija();


        try {
            //test.prefija();
            //test.postfija();
            test.interfija();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
