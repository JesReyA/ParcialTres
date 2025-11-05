package unam.fes.aragon.tercerparcial.problemados;


import unam.fes.aragon.dinamicas.arboles.NodoConObjetos;
import unam.fes.aragon.dinamicas.cola.Cola;

/**
 * Clase utilizada para crear un arbol a partir de un nodo raiz
 * @param <E>
 */

public class ArbolBinarioOperadores<E> {
    protected  NodoCaracteres<E> raiz;

    public ArbolBinarioOperadores() {
        raiz = null;
    }

    public void recorridoAmplitud() throws Exception {
        NodoCaracteres<E> n = raiz;
        Cola<NodoCaracteres<E>> cola = new Cola<>();
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

    public void imprimir(NodoCaracteres<E> n) {
        System.out.println(n.dato + " " + n.etiqueta);
    }
}
