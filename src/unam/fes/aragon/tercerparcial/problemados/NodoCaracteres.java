package unam.fes.aragon.tercerparcial.problemados;

import unam.fes.aragon.dinamicas.arboles.NodoConObjetos;

import java.util.Objects;


/**
 * Las referencias a los nodos hijo (izquierdo, derecho) son manejados como objetos.
 * NodoCaracteres puede almacenar caracteres de cualquier tipo
 * @param <E>
 */
public class NodoCaracteres<E> {
    protected E dato;
    protected NodoCaracteres<E> izquierdo,derecho;
    protected String etiqueta;
    public NodoCaracteres() {
        izquierdo=derecho=null;
    }

    public NodoCaracteres(E dato, String etiqueta) {
        this(dato,null,null,etiqueta);
    }

    public NodoCaracteres(E dato, NodoCaracteres<E> izquierdo, NodoCaracteres<E> derecho, String etiqueta) {
        this.dato=dato;
        this.izquierdo=izquierdo;
        this.derecho=derecho;
        this.etiqueta=etiqueta;
    }
    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1=(Integer)this.dato;
            Integer dato2=(Integer)obj;
            if(dato1.equals(dato2)) {
                return true;
            }else {
                return false;
            }
        }
        NodoCaracteres other =(NodoCaracteres) obj;
        return Objects.equals(dato, other.dato);
    }

    public boolean mayor(Object obj) {
        boolean resultado=false;
        if(obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1=(Integer)this.dato; //40
            Integer dato2=(Integer)obj; //50
            //40<50
            if(dato1<dato2) {
                return true;
            }
        }
        return resultado;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
}

