package unam.fes.aragon.tercerparcial.problemados;

import unam.fes.aragon.dinamicas.cola.Cola;
import unam.fes.aragon.dinamicas.pilas.Pila;

public class InterfijaAPostfija {
    private String cadenaPostfija;
    Pila<NodoCaracteres<String>> nodos = new Pila<>();

    StringBuilder expresionPostfija = new StringBuilder();
    StringBuilder expresionInterfija = new StringBuilder();
    StringBuilder expresionPrefija = new StringBuilder();

    public InterfijaAPostfija(String cadenaPostfija) {
        this.cadenaPostfija = cadenaPostfija;
    }



    public void construirArbol(){
        String [] cadenaCaracteres = cadenaPostfija.split(" ");

        NodoCaracteres<String> operandoDerecho;
        NodoCaracteres<String> operandoIzquierdo;
        NodoCaracteres<String> subarbolTemporal;

        for(int i = 0; i<= cadenaCaracteres.length -1; i++){

            String caracterALeer = cadenaCaracteres[i];
            NodoCaracteres<String> nodoActual= new NodoCaracteres<>(caracterALeer, "");

            switch (caracterALeer){

                case "+":
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;
                case "-":
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                case "*":
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                case "/":
                    operandoDerecho = nodos.extraer();
                    operandoIzquierdo = nodos.extraer() ;
                    subarbolTemporal = crearSubarbol(nodoActual, operandoIzquierdo, operandoDerecho);
                    nodos.insertar(subarbolTemporal);
                    break;

                default:
                    NodoCaracteres<String> nodoTemporal = new NodoCaracteres<>(caracterALeer, "");
                    nodos.insertar(nodoTemporal);
                    break;
            }

        }
    }
    private NodoCaracteres<String> crearSubarbol(NodoCaracteres<String> raiz, NodoCaracteres<String> hijoIzquierdo, NodoCaracteres<String> hijoDerecho){
        raiz.derecho = hijoDerecho;
        raiz.izquierdo = hijoIzquierdo;
        return raiz;
    }

    public void imprimirArbol() {
        NodoCaracteres<String> n = nodos.elementoSuperior();
        Cola<NodoCaracteres<String>> cola = new Cola<>();
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


    /**
     * Los siguientes tres metodos prefija, interfija y postfija
     * crean un StringBuilder utilizando los valores contenidos
     * en el arbol contruido
     */

    public void prefija(){
        NodoCaracteres<String> raiz = nodos.elementoSuperior();
        preorden(raiz);
    }

    public void interfija(){
        NodoCaracteres<String> raiz = nodos.elementoSuperior();
        orden(raiz);
    }

    public void postfija(){
        NodoCaracteres<String> raiz = nodos.elementoSuperior();
        postorden(raiz);
    }

    public double evaluarExpresion(){
        postfija();
        String expresionAEvaluar = expresionPostfija.toString();
        Pila < Double> pila = new Pila<>();
        String[] caracteres = expresionAEvaluar.split(" ");
        int contador = 0;

        while (contador < caracteres.length){
            String simbolo = caracteres[contador];
            if(!simbolo.equals("+") && !simbolo.equals("-") && !simbolo.equals("*") && !simbolo.equals("/")){
                pila.insertar(Double.parseDouble(simbolo));
            }else {
                double operando1 = pila.extraer();
                double operando2 = pila.extraer();
                double valor = 0;

                switch (simbolo){
                    case "+":
                        valor = operando2 + operando1;
                        break;

                    case "-":
                        valor = operando2 - operando1;
                        break;

                    case "*":
                        valor = operando2 * operando1;
                        break;

                    case "/":
                        valor= operando2 / operando1;
                        break;
                }
                pila.insertar(valor);
            }
            contador++;
        }
        return ( pila.extraer());
    }


    /**
     * Tres maneras distintas de recorrer un arbol
     */
    private void preorden(NodoCaracteres<String> n) {
        if (n != null) {
            expresionPrefija.append(n.getDato()).append(" ");
            preorden(n.izquierdo);
            preorden(n.derecho);
        }
    }

    private void orden(NodoCaracteres<String> n) {
        if (n != null) {
            orden(n.izquierdo);
            expresionInterfija.append(n.getDato()).append(" ");
            orden(n.derecho);
        }
    }

    private void postorden(NodoCaracteres<String> n) {
        if (n != null) {
            postorden(n.izquierdo);
            postorden(n.derecho);
            expresionPostfija.append(n.getDato()).append(" ");
        }
    }

    private void imprimir(NodoCaracteres<String> n) {
        System.out.println(n.dato + " " + n.etiqueta);
    }

    public StringBuilder getExpresionPostfija() {
        return expresionPostfija;
    }

    public void setExpresionPostfija(StringBuilder expresionPostfija) {
        this.expresionPostfija = expresionPostfija;
    }

    public String getCadenaPostfija() {
        return cadenaPostfija;
    }

    public void setCadenaPostfija(String cadenaPostfija) {
        this.cadenaPostfija = cadenaPostfija;
    }

    public StringBuilder getExpresionInterfija() {
        return expresionInterfija;
    }

    public void setExpresionInterfija(StringBuilder expresionInterfija) {
        this.expresionInterfija = expresionInterfija;
    }

    public StringBuilder getExpresionPrefija() {
        return expresionPrefija;
    }

    public void setExpresionPrefija(StringBuilder expresionPrefija) {
        this.expresionPrefija = expresionPrefija;
    }
}
