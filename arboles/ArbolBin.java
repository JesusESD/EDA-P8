package arboles;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolBin {
    Nodo root;
    
    public ArbolBin(){
        root = null;
    }
    
    public ArbolBin(int val){
        root = new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root = root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
        if(lado==0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }
    
    public void breadthFirst(){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                visit(r);
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der != null)
                    queue.add(r.der);
            }
        }
    }
    
    public boolean busqueda(int value){
        Nodo r = root;
        return buscar(r,value);
    }
    private boolean buscar(Nodo raiz, int value){
        if(raiz.valor == value)
            return true;
        else{
            if(raiz.der != null)
                return buscar(raiz.der, value);
            if(raiz.izq != null)
                return buscar(raiz.izq, value);
        }
        return false;
    }
    
}
