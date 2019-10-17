package arboles;


public class Nodo {
    int valor;
    
    Nodo izq = null;
    Nodo der = null;
    Nodo pad = null;
    
    public Nodo(){
        pad=izq=der=null;
    }
    public Nodo(int data){
        this(data,null,null,null);
    }
    
    public Nodo(int data, Nodo lt, Nodo rt, Nodo pd){
        valor = data;
        izq = lt;
        der = rt;
        pad = pd;
    }
    public void setIzq(Nodo izq){
        this.izq = izq;
    }
    public void setDer(Nodo der){
        this.der = der;
    }
    
    public void setPad(Nodo pad){
        this.pad = pad;
    }
}
