import java.util.Scanner;

//Desempeño n° 2 Arboles binarios
// Torres Facundo
public class Desempeño2AED4 {

	class Nodo {
		int info;
		Nodo izq, der;
	}
	
	Nodo raiz;
	
	
	public void insertar(int info) {
	    
	    if (existe(info)) {
	        System.out.println("El valor " + info + " ya existe en el árbol.");
	        return;
	    }
	    
	    
	    Nodo nuevo = new Nodo();
	    nuevo.info = info;
	    nuevo.izq = null;
	    nuevo.der = null;
	    
	    
	    if (raiz == null) {
	        raiz = nuevo;
	        System.out.println(info + " (nodo raíz del árbol)");
	        return;
	    }
	    
	   
	    Nodo reco = raiz;
	    while (true) {
	        if (info < reco.info) {
	           
	            if (reco.izq == null) {
	                reco.izq = nuevo;
	                System.out.println(info + " - por izquierda del nodo " + reco.info);
	                return;
	            }
	            reco = reco.izq; 
	        } else {
	            
	            if (reco.der == null) {
	                reco.der = nuevo;
	                System.out.println(info + " - por derecha del nodo " + reco.info);
	                return;
	            }
	            reco = reco.der; 
	        }
	    }
	}


	public boolean existe(int info) {
	    Nodo reco = raiz;
	    while (reco != null) {
	        if (info == reco.info) {
	            return true; 
	        } else if (info < reco.info) {
	            reco = reco.izq; 
	        } else {
	            reco = reco.der; 
	        }
	    }
	    return false; 
	}


	public void mostrarMayorMenorSubarbolIzquierdo() {
	    Nodo reco = raiz; 
	    
	    
	    if (reco == null) {
	        System.out.println("Árbol vacío.");
	        return;
	    }
	    
	    reco = reco.izq; 
	    
	  
	    if (reco == null) {
	        System.out.println("Subárbol izquierdo vacío.");
	        return;
	    }
	    
	
	    while (reco.der != null) {
	        reco = reco.der;
	    }
	    int mayorValor = reco.info;
	    
	    reco = raiz.izq; 
	
	    while (reco.izq != null) {
	        reco = reco.izq;
	    }
	    int menorValor = reco.info;
	    
	    
	    System.out.println("Mayor valor del subárbol izquierdo: " + mayorValor);
	    System.out.println("Menor valor del subárbol izquierdo: " + menorValor);
	}

	public void existePrimerosTresNiveles(int info) {
	    Nodo reco = raiz; 
	    int nivel = 1; 
	    boolean encontradoEnPrimerosTresNiveles = false; 

	    while (reco != null) {
	        if (info == reco.info && nivel <= 3) { 
	            System.out.println("El valor " + info + " se encuentra en el nivel " + nivel);
	            encontradoEnPrimerosTresNiveles = true; 
	            break;
	        } else {
	            if (info < reco.info) {
	                reco = reco.izq;
	                nivel = nivel + 1; 
	            } else {
	                reco = reco.der; 
	                nivel = nivel + 1; 
	            }
	        }
	    }

	    if (!encontradoEnPrimerosTresNiveles || nivel > 3) { 
	        System.out.println("El valor no existe en el árbol");
	    }
	}
	
	
	public int cantidadNodosHojaSubarbolIzquierdo() {
	    Nodo reco = raiz; 
	    
	   
	    if (reco == null || reco.izq == null) {
	        return 0;
	    }
	    
	    reco = reco.izq; 
	    
	    
	    return cantidadNodosHoja(reco);
	}
	

	private int cantidadNodosHoja(Nodo nodo) {
	    
	    if (nodo.izq == null && nodo.der == null) {
	        return 1; 
	    }
	    
	    int cantidad = 0; 
	    
	    
	    if (nodo.izq != null) {
	        cantidad += cantidadNodosHoja(nodo.izq); 
	    }
	    
	    if (nodo.der != null) {
	        cantidad += cantidadNodosHoja(nodo.der); 
	    }
	    
	    return cantidad;
	}


	public void borrarMayorSubarbolIzquierdo() {
	    if (raiz == null || raiz.izq == null) {
	        System.out.println("Subárbol izquierdo vacío. No se puede borrar ningún valor.");
	        return;
	    }

	    Nodo nodoPadre = null; 
	    Nodo nodoMayor = raiz.izq; 

	    
	    while (nodoMayor.der != null) {
	        nodoPadre = nodoMayor;
	        nodoMayor = nodoMayor.der; 
	    }

	    
	    if (nodoMayor.izq != null || nodoMayor.der != null) {
	        System.out.println("El nodo con el mayor valor en el subárbol izquierdo tiene hijos. No se puede borrar.");
	        return;
	    }

	    // Borrar el nodo mayor
	    if (nodoPadre != null) {
	        nodoPadre.der = null; 
	    } else {
	        raiz.izq = null; 
	    }

	    System.out.println("Se ha borrado el mayor valor del subárbol izquierdo.");
	}

	 public void imprimirActualizado() {
        System.out.println("Lista actualizada del árbol:");
        imprimir(raiz);
        System.out.println();
    }

    private void imprimir(Nodo nodo) {
        if (nodo != null) {
            imprimir(nodo.izq);
            System.out.print(nodo.info + " ");
            imprimir(nodo.der);
        }
    }
	

	public static void main(String[] args) {
		Desempeño2AED4 ab = new Desempeño2AED4();
		ab.insertar(10);
		ab.insertar(7);
		ab.insertar(9);
		ab.insertar(20);
		ab.insertar(15);
		
		ab.mostrarMayorMenorSubarbolIzquierdo();
		
		System.out.println("Ingrese un número que desee verificar en el arbol: ");
		Scanner dato = new Scanner(System.in); // para leer datos de entrada
		int num = dato.nextInt();
		ab.existePrimerosTresNiveles(num);
		
		System.out.println("----------------------------");
		
		System.out.println("La cantidad de nodos hoja en el subárbol izquierdo es: " + ab.cantidadNodosHojaSubarbolIzquierdo()); 
		
		System.out.println("----------------------------");
		
		ab.borrarMayorSubarbolIzquierdo();
		ab.imprimirActualizado();
	}

}
