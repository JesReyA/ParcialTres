package unam.fes.aragon.tercerparcial.problemauno;

import unam.fes.aragon.dinamicas.listasimple.ListaSimple;

public class ArbolBinarioArreglo<E>{
    ListaSimple<E> arbolBinario = new ListaSimple<>();
    private Integer indice;

    public ArbolBinarioArreglo(){
        indice = 0;
    }

    public void insertar(E dato){
        if(arbolBinario.estaVacia()){
            arbolBinario.agregarEnCola(dato);
        }
        else{
            indice = 0;
            while(true){
                verificarLongitud(indice);
                E actual = arbolBinario.obtenerNodo(indice);
                if(actual == null){
                    break;
                }
                if ((Integer)dato > (Integer) actual) {
                    indice = (2 * indice) + 2; // Derecha
                } else {
                    indice = (2 * indice) + 1; // Izquierda
                }

            }
            arbolBinario.asignar(dato, indice);
        }
    }

    public void verificarLongitud(Integer indice){
            while (arbolBinario.getLongitud() <= indice) {
                arbolBinario.agregarEnCola(null);
            }
    }

    public void inorder(){

    }

    public void imprimir(){
        arbolBinario.imprimirLista();
    }
}
