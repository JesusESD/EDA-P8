package arboles;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolBin {
    Nodo root;
    int deep=-1;
    int max=-1;
    
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
        hijo.pad = padre;
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
    
    public Nodo busqueda(int x){
        return buscar(root, x);
    }
      
    
    private Nodo buscar(Nodo n, int x){
        if(n == null)
            return null;
        
        if (n.valor == x)
            return n;
        
        Nodo busq = null;
        busq = buscar(n.izq, x); //busca en el subárbol derecho
        if(busq == null)
            busq = buscar(n.der, x); //busca en el subárbol izquierdo
        
        return busq; //si se encuentra en cualquiera de los subárboles se regresará true
    }
    
    public Nodo deepest(){
        findDeep(root, 0);
        Nodo r = busqueda(deep);
        deep = max = -1;
        return r;
    }
    
      
    private void findDeep(Nodo n, int l){
      if(n != null){
          findDeep(n.izq, ++l);
          if(l > max){
              deep = n.valor;
              max = l;
          }
          findDeep(n.der, l);
      }    
    }
    
    public Nodo delete(int x){
        Nodo z = busqueda(x);
        Nodo aux = deepest();
        //System.out.println(aux.valor);
        z.valor = aux.valor;
        
        if(aux.pad.izq == aux)
            aux.pad.izq = null;
        else
            aux.pad.der = null;
        return aux;
    }

    
    public void prefija(){
        System.out.println("Notación prefija");
        System.out.print("[ ");
        preOrden(root);
        System.out.println(" ] ");
    }
    
    private void preOrden(Nodo n){
        if(n != null){
            System.out.print(n.valor + " ");
            preOrden(n.izq);
            preOrden(n.der);
        }
    }
    
    public void infija(){
        System.out.println("Notación infija");
        System.out.print("[ ");
        inOrden(root);
        System.out.println(" ] ");
    }
    
    private void inOrden(Nodo n){
        if(n != null){
            inOrden(n.izq);
            System.out.print(n.valor + " ");
            inOrden(n.der);
        }   
    }
    
    public void posfija(){
        System.out.println("Notación posfija");
        System.out.print("[ ");
        posOrden(root);
        System.out.println(" ] ");
    }
    
    private void posOrden(Nodo n){
        if(n!= null){
            posOrden(n.izq);
            posOrden(n.der);
            System.out.print(n.valor + " ");
        }
    }
    
}
