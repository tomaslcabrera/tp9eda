package tp9;

public class Lista {
    private class Nodo {
        private String numero;
        private Nodo nodoSiguiente = null;

        public Nodo(String numero) {
            this.numero = numero;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public Nodo getNodoSiguiente() {
            return nodoSiguiente;
        }

        public void setNodoSiguiente(Nodo nodoSiguiente) {
            this.nodoSiguiente = nodoSiguiente;
        }
    }

    private Nodo frente;
    private Nodo ultimo;
    private int tamaño = 0;

    public static Lista listaVacia() {
        return new Lista();
    }

    public boolean esListaVacia() {
        return frente == null;
    }

    public int cantidad() {
        return tamaño;
    }

    public String primero() {
        if (esListaVacia()) {
            return null;
        }
        return this.frente.getNumero();
    }

    public void agregarUltimo(String num) {
        Nodo nodoNuevo = new Nodo(num);
        if (esListaVacia()) {
            this.frente = nodoNuevo;
            this.ultimo = nodoNuevo;

        } else {
            this.ultimo.setNodoSiguiente(nodoNuevo);
            this.ultimo = nodoNuevo;
        }
        this.tamaño++;
    }

    public void borrarPrimero() {
        if (this.frente != null) {
            this.frente = this.frente.getNodoSiguiente();
        }
        if (this.tamaño == 1) {
            this.ultimo = null;
        }
        this.tamaño--;
    }

    //O(n*Log n)
    public Lista mergeLista() {
        Lista izq, der;
        
        if (this.tamaño <= 1) {
            return this;
        } else {
            izq = Lista.listaVacia();
            der = Lista.listaVacia();
            this.dividirLista(izq, der);
            return combinarLista(izq.mergeLista(), der.mergeLista());
        }
    }

    //O(n)
    public void dividirLista(Lista izq, Lista der) {
        int n = this.cantidad(), aux = 0;

        while (!this.esListaVacia()) {
            if (aux < n / 2) {
                izq.agregarUltimo(this.frente.getNumero());
            } else {
                der.agregarUltimo(this.frente.getNumero());
            }
            this.borrarPrimero();
            aux++;
        }
    }

    //O(n) 
    public Lista combinarLista(Lista izq, Lista der) {
        Lista nuevaLista = Lista.listaVacia();

        while (!izq.esListaVacia() && !der.esListaVacia()) {

            if (izq.frente.getNumero().compareTo(der.frente.getNumero())<0) {
                nuevaLista.agregarUltimo(izq.frente.getNumero());
                izq.borrarPrimero();
            } else {
                nuevaLista.agregarUltimo(der.frente.getNumero());
                der.borrarPrimero();
            }
        }
        
        while (der.esListaVacia() && !izq.esListaVacia()) {
            nuevaLista.agregarUltimo(izq.frente.getNumero());
            izq.borrarPrimero();
        }
        
        while (izq.esListaVacia() && !der.esListaVacia()) {
            nuevaLista.agregarUltimo(der.frente.getNumero());
            der.borrarPrimero();
        }
        return nuevaLista;
    }
    
    public void mostrar() {
        Nodo nodoAux = this.frente;
        while (nodoAux != null) {
            System.out.println(nodoAux.getNumero());
            nodoAux = nodoAux.getNodoSiguiente();
        }
    }
}
