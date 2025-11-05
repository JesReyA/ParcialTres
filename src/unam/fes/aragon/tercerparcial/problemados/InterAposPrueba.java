package unam.fes.aragon.tercerparcial.problemados;

public class InterAposPrueba {
    public static void main(String[] args) {
        InterfijaAPostfija test = new InterfijaAPostfija("53+2*");
        test.interfijaAPostfija();


        try {
            test.recorridoAmplitud();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
