package tp9;

public class Tp9 {
    public static void main(String[] args) {
        Lista listaNueva=Lista.listaVacia();
        
        listaNueva.agregarUltimo("z");
        listaNueva.agregarUltimo("x");
        listaNueva.agregarUltimo("a");
        listaNueva.agregarUltimo("b");
        listaNueva.agregarUltimo("1");
        
        System.out.println("Lista previo mezclarLista");
        listaNueva.mostrar();

        listaNueva=listaNueva.mergeLista();
        System.out.println("Lista final");
        listaNueva.mostrar();
    }
    
}
