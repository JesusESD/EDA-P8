public class Ejercicio1 {
    public static void main(String[] args) {
        ArbolBin arbol;
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1, n7, n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        arbol = new ArbolBin;
        arbol.add(n7, n15, 0);
        arbol.add(n7, n8, 1);
        arbol.add(n9, n4, 0);
        arbol.add(n9, n2, 1);
        arbol.add(n15, n16, 1);
        arbol.add(n8, n3, 0);
        arbol.breadthFirst();
    }
}
