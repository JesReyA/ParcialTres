package unam.fes.aragon.tercerparcial.problemados;

import unam.fes.aragon.dinamicas.arboles.ArbolBinarioOrden;
import unam.fes.aragon.dinamicas.pilas.Pila;

public class InterfijaAPostfija {
    private String cadenaPostfija;
    Pila<ArbolBinarioOrden<Character>> subarboles = new Pila<>();

    public InterfijaAPostfija(String cadenaPostfija) {
        this.cadenaPostfija = cadenaPostfija;
    }

    public String getCadenaPostfija() {
        return cadenaPostfija;
    }

    public void setCadenaPostfija(String cadenaPostfija) {
        this.cadenaPostfija = cadenaPostfija;
    }

    public void interfijaAPostfija(){
        char [] cadenaCaracteres = cadenaPostfija.toCharArray();
        System.out.println(cadenaPostfija.length());
        for(int i = 0; i<= cadenaCaracteres.length -1; i++){
            Character caracterALeer = cadenaCaracteres[i];
           switch (cadenaCaracteres[i]){
               case '+':
                   break;
               case '-':
                   break;

               case '*':
                   break;

               case '/':
                   break;
               default:
                   ArbolBinarioOrden<Character> subarbolLocal = new ArbolBinarioOrden<>();
                   subarbolLocal.insertar(caracterALeer);
                   subarboles.insertar(subarbolLocal);
                   break;
           }

        }
    }

//    private ArbolBinarioOrden<Character> crearSubarbol(Character caracter){
//        ArbolBinarioOrden<Character> subarbol = new ArbolBinarioOrden<>();
//
//        return
//    }

}
