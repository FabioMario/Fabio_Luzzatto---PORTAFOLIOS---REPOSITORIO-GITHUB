# Fabio_Luzzatto---PORTAFOLIOS---REPOSITORIO-GITHUB
Armar repositorio en github con una estructura de carpetas en el README para cada unidad temática o una página web estática utilizando Github Pages. Remitir un txt a esta entrega con el link al repositorio dando acceso público al mismo.

###Lista Enlazada
Una lista enlazada es una colección o secuencia de elementos dispuestos uno detrás de otro, en la que cada elemento se conecta al siguiente elemento por un “enlace” o “referencia”

```java
Nodo nodo1 = new Nodo (1, null); 
Nodo nodo2 = new Nodo (2, null); 
Nodo nodo3 = new Nodo (3, null);
public class Nodo {
  Int carga;
	Nodo prox
	public Nodo(){
		carga = 0;
		prox = null;
	}
	public Nodo(int carga, Nodo prox){
	this.carga = carga;
	this.prox = prox;
	}
	public String toString(){
		return carga + “”;
	} 
}
```
Para enlazar los nodos, hay que hacer que el primer nodo referencie al segundo y el segundo al tercero.
```java
nodo1.prox = nodo2; 
nodo2.prox = nodo3; 
nodo3.prox = null;
```
La referencia del tercer nodo es null, lo cual indica que es el final de la lista. 

Diagrama de estado:

![image](https://user-images.githubusercontent.com/67033535/166112565-05331976-4676-46c2-b7ef-6f977e112e04.png)

Para pasar la lista como parámetro a algun método hay que pasar una referencia al primer nodo.
Por ejemplo, el método imprimirLista toma un solo nodo como argumento, comenzando por el principio de la lista imprime cada nodo hasta llegar al final indicado por la referencia null.
```java
public static void imprimirLista (Nodo lista) {
  Nodo nodo = lista; 
  while (nodo != null) { 
    System.out.print (nodo); 
    nodo = nodo.prox; 
  } 
  System.out.println (); 
}

imprimirLista (nodo1);
```
La salida de este método es: 123
