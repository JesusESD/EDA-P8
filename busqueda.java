public boolean busqueda(Nodo raiz, int value){
        if(raiz.valor == value)
            return true;
        else{
            if(raiz.der != null)
                return busqueda(raiz.der, value);
            if(raiz.izq != null)
                return busqueda(raiz.izq, value);
        }
        return false;
    }
