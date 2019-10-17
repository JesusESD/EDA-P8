class Nodo:
    def __init__(self, valor):
        self.hijoIzq = None
        self.hijoDer = None
        self.val = valor


class Arbol:
    def __init__(self):
        self.raiz = None

    def obtenerRaiz(self):
        return self.raiz

    def agregar(self, val):
        if(self.raiz == None):
            self.raiz = Nodo(val)
        else:
            self.agregarNodo(val, self.raiz)

    def agregarNodo(self, val, nodo):
        if(val < nodo.val):
            if(nodo.hijoIzq != None):
                self.agregarNodo(val, nodo.hijoIzq)
            else:
                nodo.hijoIzq = Nodo(val)
        else:
            if(nodo.hijoDer != None):
                self.agregarNodo(val, nodo.hijoDer)
            else:
                nodo.hijoDer = Nodo(val)

    def preorden(self, nodo):
        if(nodo != None):
            print(str(nodo.val))
            if nodo.hijoIzq != None:
                self.preorden(nodo.hijoIzq)
            if nodo.hijoDer != None:
                self.preorden(nodo.hijoDer)

    def imprimePreorden(self):
        if(self.raiz != None):
            self.preorden(self.raiz)

    def busqueda(self, nodo, valor):
        if(nodo.val == valor):
            return True
        if valor < nodo.val:
            return self.busqueda(nodo.hijoIzq, valor)
        else:
            return self.busqueda(nodo.hijoDer, valor)
        return False


class Controladora:
    def main(self):
        print("Grafo")
        arbol = Arbol()
        arbol.agregar(8)
        arbol.agregar(3)
        arbol.agregar(10)
        arbol.agregar(1)
        arbol.agregar(6)
        arbol.agregar(14)
        arbol.agregar(4)
        arbol.agregar(7)
        arbol.agregar(13)
        arbol.imprimePreorden()
        print("Resultado de búsqueda")
        print(arbol.busqueda(arbol.raiz, 13))


obj = Controladora()
obj.main()