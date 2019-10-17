package arboles;

public class ArbolBusq extends ArbolBin {
    
    public ArbolBusq(int val){
        super(val);
    }
    
    public void insert(int val){
        Nodo y = null;
        Nodo x = root;
        Nodo z = new Nodo(val);
        while(x != null){
            y = x;
            if(val < x.valor)
                x = x.izq;
            else
                x = x.der;
        }
        z.pad = y;
        if(y==null)
            root = z;
        else
            if (val < y.valor)
                y.izq = z;
            else
                y.der = z;
    }
    
    public Nodo delete(int val){
        Nodo z = busqueda(val);
        
        Nodo x;
        Nodo y;
        
        if(z.izq == null || z.der == null)
            y = z;
        else
            y = successor(z);
        if(y.izq != null)
            x = y.izq;
        else
            x = y.der;
        if(x != null)
            x.pad = y.pad;
        if(y.pad == null)
            root = x;
        else
            if(y == y.pad.izq)
                y.pad.izq = x;
            else
                y.pad.der = x;
        if(y != z){
            z.valor = y.valor;
            //z.der = y.der;
            //z.izq = y.izq;
            //z.pad = y.pad;
        }
        
        return y;
    }
    
    public Nodo busqueda(int x){
        Nodo r = root;
        
        while(r != null && r.valor != x){
            if(r.valor > x)
                r = r.izq;
            else
                r = r.der;
        }
        
        return r;
    }
    
    public Nodo successor(Nodo x){
        if(x.der != null)
            return minimum(x.der);
        Nodo y = x.pad;
        while(y!= null && x == y.der){
            x = y;
            y = y.pad;
        }
        return y;
    }
    
    public Nodo minimum(Nodo x){
        while(x.izq != null)
            x = x.izq;
        return x;
    }
    
}
