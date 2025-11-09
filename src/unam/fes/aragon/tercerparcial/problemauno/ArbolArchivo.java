package unam.fes.aragon.tercerparcial.problemauno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArbolArchivo {
    public static void main(String[] args) {
        ManejoArchivos <String>  archivoIngresoDatosArbol = new ManejoArchivos<>();
        FileReader archivo;
        BufferedReader lector;
        String cadena;
        String[] datoIndividual;
        ArbolBinarioArreglo<Integer> arbolCreado = new ArbolBinarioArreglo<>();

        try{
            archivo = new FileReader("DatosArbol.txt");
            lector  = new BufferedReader(archivo);

            while ((cadena = lector.readLine()) != null){
                datoIndividual = cadena.split(" ");
                for (String s : datoIndividual) {
                    arbolCreado.insertar(Integer.parseInt(s));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        arbolCreado.recorridoAmplitudEnLista();
    }
}
