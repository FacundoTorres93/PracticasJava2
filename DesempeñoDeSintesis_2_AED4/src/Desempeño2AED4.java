import java.util.Scanner;

//Desempe�o n� 2 Arboles binarios
// Torres Facundo
public class Desempe�o2AED4 {

	class Nodo {
		int info;
		Nodo izq, der;
	}
	
	Nodo raiz;
	
	
	public void insertar(int info) {
	    
	    if (existe(info)) {
	        System.out.println("El valor " + info + " ya existe en el �rbol.");
	        return;
	    }
	    
	    
	    Nodo nuevo = new Nodo();
	    nuevo.info = info;
	    nuevo.izq = null;
	    nuevo.der = null;
	    
	    
	    if (raiz == null) {
	        raiz = nuevo;
	        System.out.println(info + " (nodo ra�z del �rbol)");
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
	        System.out.println("�rbol vac�o.");
	        return;
	    }
	    
	    reco = reco.izq; 
	    
	  
	    if (reco == null) {
	        System.out.println("Sub�rbol izquierdo vac�o.");
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
	    
	    
	    System.out.println("Mayor valor del sub�rbol izquierdo: " + mayorValor);
	    System.out.println("Menor valor del sub�rbol izquierdo: " + menorValor);
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
	        System.out.println("El valor no existe en el �rbol");
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
	        System.out.println("Sub�rbol izquierdo vac�o. No se puede borrar ning�n valor.");
	        return;
	    }

	    Nodo nodoPadre = null; 
	    Nodo nodoMayor = raiz.izq; 

	    
	    while (nodoMayor.der != null) {
	        nodoPadre = nodoMayor;
	        nodoMayor = nodoMayor.der; 
	    }

	    
	    if (nodoMayor.izq != null || nodoMayor.der != null) {
	        System.out.println("El nodo con el mayor valor en el sub�rbol izquierdo tiene hijos. No se puede borrar.");
	        return;
	    }

	    // Borrar el nodo mayor
	    if (nodoPadre != null) {
	        nodoPadre.der = null; 
	    } else {
	        raiz.izq = null; 
	    }

	    System.out.println("Se ha borrado el mayor valor del sub�rbol izquierdo.");
	}

	 public void imprimirActualizado() {
        System.out.println("Lista actualizada del �rbol:");
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
		Desempe�o2AED4 ab = new Desempe�o2AED4();
		ab.insertar(10);
		ab.insertar(7);
		ab.insertar(9);
		ab.insertar(20);
		ab.insertar(15);
		
		ab.mostrarMayorMenorSubarbolIzquierdo();
		
		System.out.println("Ingrese un n�mero que desee verificar en el arbol: ");
		Scanner dato = new Scanner(System.in); // para leer datos de entrada
		int num = dato.nextInt();
		ab.existePrimerosTresNiveles(num);
		
		System.out.println("----------------------------");
		
		System.out.println("La cantidad de nodos hoja en el sub�rbol izquierdo es: " + ab.cantidadNodosHojaSubarbolIzquierdo()); 
		
		System.out.println("----------------------------");
		
		ab.borrarMayorSubarbolIzquierdo();
		ab.imprimirActualizado();
	}

}
