package arboles;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        ArbolBin arbol;
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1, n7, n9, null);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        arbol = new ArbolBin(n1);
        arbol.add(n7, n15, 0);
        arbol.add(n7, n8, 1);
        arbol.add(n9, n4, 0);
        arbol.add(n9, n2, 1);
        arbol.add(n15, n16, 1);
        arbol.add(n8, n3, 0);
        arbol.breadthFirst();
        System.out.println("Buscando a 2: " + arbol.busqueda(2).valor);
        arbol.prefija();
        arbol.infija();
        arbol.posfija();
        //System.out.println(arbol.deepest().valor + " "+ arbol.max);
        
        System.out.println("");
        arbol.breadthFirst();
        System.out.println("");
        arbol.delete(7);
        arbol.breadthFirst();
        System.out.println("");
        arbol.delete(16);
        arbol.breadthFirst();
        
        System.out.println("");
        arbol.delete(2);
        arbol.breadthFirst();


/*
        ArbolBusq abb = new ArbolBusq(8);
        //abb.breadthFirst();
        abb.insert(3);
        abb.insert(10);
        abb.insert(1);
        abb.insert(6);
        abb.insert(14);
        abb.insert(4);
        abb.insert(7);
        abb.insert(13);
        abb.breadthFirst();
        abb.prefija();
        Nodo b = abb.busqueda(13);
        System.out.println(b.valor + "," + b.pad.valor);
        Nodo nuev = abb.delete(7);
        //System.out.println(nuev.valor);
        abb.breadthFirst();
        nuev = abb.delete(6);
        System.out.println("");
        abb.breadthFirst();
        */
    }
}
