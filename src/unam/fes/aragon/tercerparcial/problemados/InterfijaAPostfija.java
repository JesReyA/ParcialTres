package unam.fes.aragon.tercerparcial.problemados;

import unam.fes.aragon.dinamicas.arboles.ArbolBinarioOrden;
import unam.fes.aragon.dinamicas.cola.Cola;
import unam.fes.aragon.dinamicas.pilas.Pila;

public class InterfijaAPostfija {
    private String cadenaPostfija;
   // Pila<ArbolBinarioOperadores<Character>> subarboles = new Pila<>();
    Pila<NodoCaracteres<Character>> nodos = new Pila<>();
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

        NodoCaracteres<Character> operandoDerecho;
        NodoCaracteres<Character> operandoIzquierdo;
        NodoCaracteres<Character> subarbolTemporal;

        for(int i = 0; i<= cadenaCaracteres.length -1; i++){

            Character caracterALeer = cadenaCaracteres[i];
            NodoCaracteres<Character> nodoActual= new NodoCaracteres<>(caracterALeer, "");

            switch (caracterALeer){

                case '+':
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;
                case '-':
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                case '*':
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                case '/':
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                default:
                    NodoCaracteres<Character> nodoTemporal = new NodoCaracteres<>(caracterALeer, "");
                    nodos.insertar(nodoTemporal);
                    break;
            }

        }
    }
    private NodoCaracteres<Character> crearSubarbol(NodoCaracteres<Character> raiz, NodoCaracteres<Character> hijoIzquierdo, NodoCaracteres<Character> hijoDerecho){
        raiz.derecho = hijoDerecho;
        raiz.izquierdo = hijoIzquierdo;
        return raiz;
    }

//    public void imprimir(){
//        nodos.
//    }

    public void recorridoAmplitud() throws Exception {
        NodoCaracteres<Character> n = nodos.extraer();
        Cola<NodoCaracteres<Character>> cola = new Cola<>();
        if (n != null) {
            cola.insertar(n);
            while (!cola.estaVacia()) {
                n = cola.extraer();
                imprimir(n);
                if (n.izquierdo != null) {
                    cola.insertar(n.izquierdo);
                }
                if (n.derecho != null) {
                    cola.insertar(n.derecho);
                }
            }
        }
    }

    public void imprimir(NodoCaracteres<Character> n) {
        System.out.println(n.dato + " " + n.etiqueta);
    }


}
