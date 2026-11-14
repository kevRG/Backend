package com.example.springb.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Cola<T> {

    private Node<T> frente;
    private Node<T> fin;
    private int tamanio;

    /** Agrega un elemento al final de la cola. */
    public void encolar(T dato) {
        Node<T> nuevo = new Node<>(dato);
        if (fin == null) {
            frente = nuevo;
        } else {
            fin.setNext(nuevo);
        }
        fin = nuevo;
        tamanio++;
    }

    /** Saca y regresa el elemento del frente, o null si la cola está vacía. */
    public T desencolar() {
        if (frente == null) {
            return null;
        }
        T dato = frente.getData();
        frente = frente.getNext();
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return dato;
    }

    /** Regresa el elemento del frente sin sacarlo, o null si la cola está vacía. */
    public T verFrente() {
        return frente == null ? null : frente.getData();
    }

    /**
     * Saca de la cola el primer elemento que cumpla la condición, sin importar su posición.
     * Se usa cuando un reporte se asigna directamente desde su detalle y deja de esperar turno.
     */
    public boolean eliminar(Predicate<T> condicion) {
        Node<T> anterior = null;
        Node<T> actual = frente;
        while (actual != null) {
            if (condicion.test(actual.getData())) {
                if (anterior == null) {
                    frente = actual.getNext();
                } else {
                    anterior.setNext(actual.getNext());
                }
                if (actual == fin) {
                    fin = anterior;
                }
                tamanio--;
                return true;
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return false;
    }

    public int tamanio() {
        return tamanio;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    /** Convierte la cola a java.util.List (del frente al final) para responder con JSON. */
    public List<T> toList() {
        List<T> lista = new ArrayList<>(tamanio);
        Node<T> actual = frente;
        while (actual != null) {
            lista.add(actual.getData());
            actual = actual.getNext();
        }
        return lista;
    }
}
