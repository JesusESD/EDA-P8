/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.Scanner;
/**
 *
 * @author Patch
 */
public class Menu {
    public void mainMenu(){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de árbol deseas emplear?");
        System.out.println("1.- Árbol binario");
        System.out.println("2.- Árbol binario de búsqueda");
        op = sc.nextInt();
        switch(op){
            case 1:
                menuArbolBinario();
                break;
            case 2:
                break;
        }
    }
    public void menuArbolBinario(){
        int op1 = 1, clave, clave2, iter = 0, lado;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("¿Cuál es la raíz de tu árbol?");
        clave = sc1.nextInt();
        Nodo parent = new Nodo(clave);
        ArbolBin aB = new ArbolBin(parent);
        do{
            System.out.println("¿Qué desea realizar?");
            System.out.println("0.- Terminar la ejecución");
            System.out.println("1.- Agregar nodo");
            System.out.println("2.- Buscar nodo");
            System.out.println("3.- BFS");
            System.out.println("4.- Notación Prefija");
            System.out.println("5.- Notación Infija");
            System.out.println("6.- Notación Postfija");
            op1 = sc1.nextInt();
            switch(op1){
                case 0:
                    break;
                case 1:
                    if(iter == 0)
                        agregarInicial(aB);
                    else{
                        System.out.println("¿Cuál es la clave de su nodo?");
                        clave = sc1.nextInt();
                        System.out.println("¿Cuál es el padre de su nodo?");
                        clave2 = sc1.nextInt();
                        System.out.println("¿Su hijo es izquierdo (0) o derecho (1)?");
                        lado = sc1.nextInt();
                        aB.add(aB.busqueda(clave2), new Nodo(clave), lado);
                    }
                    break;
                case 2:
                    System.out.println("¿Qué clave desea buscar?");
                    clave = sc1.nextInt();
                    if(aB.busqueda(clave) != null)
                        System.out.println("La clave existe dentro del árbol");
                    else
                        System.out.println("La clave no existe dentro del árbol");
                    break;
                case 3:
                    aB.breadthFirst();
                    break;
                case 4:
                    aB.prefija();
                    break;
                case 5:
                    aB.infija();
                    break;
                case 6:
                    aB.posfija();
                    break;
                default:
                    break;
            }
            iter++;
        }while(op1 != 0);
    }
    public void agregarInicial(ArbolBin aB){
        Scanner sc1 = new Scanner(System.in);
        int clave, lado, hermano;
        String bro;
        System.out.println("Estos nodos son hijos de la raíz");
        System.out.println("¿Cuál es la clave de su nodo?");
        clave = sc1.nextInt();
        Nodo son = new Nodo(clave);
        System.out.println("¿Su nodo es hijo izquierdo (0) o derecho (1)?");
        lado = sc1.nextInt();
        aB.add(aB.root, son, lado);
        System.out.println("¿Su nodo tiene hermano? \n1.- Sí \n2.- No");
        bro = sc1.next();
        if("1".equals(bro)){
            System.out.println("¿Cuál es la clave del nodo hermano?");
            hermano = sc1.nextInt();
            if(lado == 0)
                aB.add(aB.root, new Nodo(hermano), 1);
            else
                aB.add(aB.root, new Nodo(hermano), 0);
        }
    }
}
