package unam.fes.aragon.tercerparcial.problemauno;


import unam.fes.aragon.dinamicas.cola.Cola;
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

    //recorridos
    public void recorridoAmplitudEnLista(){

        // La cola almacenará los ÍNDICES que debemos visitar.
        Cola<Integer> cola = new Cola<>();


        // 1. Verificar si el árbol existe y tiene raíz.
        if (arbolBinario == null || arbolBinario.estaVacia() ||arbolBinario.obtenerNodo(0) == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        // 2. Empezamos por la raíz (índice 0)
        cola.insertar(0);

        while (!cola.estaVacia()) {
            // 3. Extraer el ÍNDICE del siguiente nodo a procesar
            int indiceActual = cola.extraer();

            // 4. Procesar (imprimir) el valor en ese índice
            // (Ya sabemos que no es null gracias a las revisiones de abajo)
            E valor = arbolBinario.obtenerNodo(indiceActual);
            imprimir(valor);

            // 5. Calcular los índices de los hijos
            int indiceIzquierdo = (2 * indiceActual) + 1;
            int indiceDerecho = (2 * indiceActual) + 2;

            // 6. Encolar al hijo izquierdo SI EXISTE
            if (indiceIzquierdo < arbolBinario.getLongitud() && arbolBinario.obtenerNodo(indiceIzquierdo) != null) {
                cola.insertar(indiceIzquierdo);
            }

            // 7. Encolar al hijo derecho SI EXISTE
            if (indiceDerecho < arbolBinario.getLongitud() && arbolBinario.obtenerNodo(indiceDerecho) != null) {
                cola.insertar(indiceDerecho);
            }
        }
    }


    private void imprimir(E valor) {
        System.out.print(valor + " ");
    }



    public void imprimir(){
        arbolBinario.imprimirLista();
    }
}
