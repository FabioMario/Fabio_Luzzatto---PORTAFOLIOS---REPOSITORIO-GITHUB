# Fabio_Luzzatto---PORTAFOLIOS---REPOSITORIO-GITHUB


## [Índice](#fabio-luzzatto---portafolios---repositorio-github)
+ [PDs para el Primer Parcial](#pds-para-el-primer-parcial)
	+ [Letra del Ejercicio](#letra-del-ejercicio)
	+ [Lista Enlazada](#lista-enlazada)
	+ [Pila](#pila)
	+ [Cola](#cola)
	+ [Ordenes de tiempo de ejecución](#ordenes-de-tiempo-de-ejecución)
+ [PDs para el Segundo Parcial](#pds-para-el-segundo-parcial)
	+ [Árboles](#árboles) 


## Letra del Ejercicio
Armar repositorio en github con una estructura de carpetas en el README para cada unidad temática o una página web estática utilizando Github Pages. Remitir un txt a esta entrega con el link al repositorio dando acceso público al mismo.

# PDs para el Primer Parcial

## Lista Enlazada
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


## Pila

principio de operación
En teoría, una pila puede contener cualquier cantidad de objetos, pero en la práctica es limitada. Los elementos solo se pueden colocar en la parte superior de la pila y solo se pueden leer desde allí. Los elementos se apilan uno encima del otro y se retiran de la pila en orden inverso. Esto también se conoce como el principio de último en entrar, primero en salir (LIFO - Last In First Out).

**Las siguientes operaciones están disponibles para este propósito:**
- push (apilar) empuja el objeto en la parte superior de la pila.
```java
    /**
     * Agrega un nuevo nodo a la pila.
     * @param valor a agregar.
     */
    public void apilar(int valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la pila esta vacia.
        if (esVacia()) {
            // Inicializa la pila con el nuevo valor.
            inicio = nuevo;
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño.
        tamanio++;
    } 
    /**
     * Elimina el elemento que se encuentra en el tope de la piala.
     */
    public void retirar(){
        if (!esVacia()) {
            // Asigna como primer nodo al siguiente de la pila.
            inicio = inicio.getSiguiente();
            // Decrementa el contador del tamaño de la pila
            tamanio--;
        }
    }
```
- pop (desapilar) devuelve y elimina el elemento superior de la pila.
```java
    /**
     * Elimina un nodo de la pila ubicado por su valor.
     * @param referencia valor de referencia para ubicar el nodo.
     */  
    public void remover(int referencia){
        // Consulta si el valor existe en la pila.
        if (buscar(referencia)) {
            // Crea una pila auxiliar para guardar los valores que se 
            // vayan desapilando de la pila original.
            Nodo pilaAux = null;
            // Recoore la pila hasta llegar al nodo que tenga el valor
            // igual que el de referencia.
            while(referencia != inicio.getValor()){
                // Crea un nodo temporal para agregarlos a la pila auxiliar.
                Nodo temp = new Nodo();
                // Ingresa el valor al nodo temporal.
                temp.setValor(inicio.getValor());
                // Consulta si la pila auxiliar no a sido inicializada.
                if(pilaAux == null){
                    // Inicializa la pila auxiliar.
                    pilaAux = temp;
                }
                // Caso contrario si la pila auxiliar ya contiene elementos
                // los agrega al inicio.
                else{
                    temp.setSiguiente(pilaAux);
                    pilaAux = temp;
                }
                // Elimina el nodo del tope de la pila hasta llegar al nodo
                // que se desea eliminar.
                retirar();
            }
            // Elimina el nodo que coincide con el de referencia.
            retirar();
            // Regresa los valores de la pila auxiliar a la pila original
            // mientras la pila auxiliar tenga elementos.
            while(pilaAux != null){
                // Utiliza el metodo apilar para regresar los elementos a 
                // la pila original.
                apilar(pilaAux.getValor());
                // Avansa al siguiente nodo de la pila auxiliar.
                pilaAux = pilaAux.getSiguiente();
            }
            // Libera la memoria utilizada por la pila auxiliar.
            pilaAux = null;
        }
    }    
```
Ejemplo de como funcionan los metodos push y pop:

![image](https://user-images.githubusercontent.com/67033535/166113187-5c1c390f-756a-41dd-9720-001011a33721.png)

- esVacia devuelve true si la pila está vacía y false en caso contrario.
```java
    /**
     * Consulta si la pila esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia(){
        return inicio == null;
    }
```

## Cola
Una cola es una estructura de datos abstracta que corresponde a una lista.
Dicha estructura de datos funciona de acuerdo con el principio de primero en entrar, primero en salir (FIFO - Fist In First Out). Esto limita aún más el acceso a estos elementos, ya que ahora solo se pueden acceder a ellos en el mismo orden en que fueron puestos en la cola.

Una cola tiene estos comandos básicos: 
- agregar, con el que añadimos un nuevo elemento.
```java
    public void agregar(Object obj) {
        Nodo nodo = new Nodo(obj, null);
        if (ultimo != null) {
            ultimo.setSiguiente(nodo);
        }
        ultimo = nodo;
        if (primero == null) {
            primero = ultimo;
        }
```
- quitar, con el que leemos y borramos el primer elemento.
```java
    public Object quitar() {
        Nodo resultado = primero;
        if (primero != null) {
            primero = primero.getSiguiente();
        }
        if (primero == null) {
            ultimo = null;
        }
        return resultado;
    }
```
- esVacia devuelve true si la pila está vacía y false en caso contrario.
```java
    public boolean estaVacia() {
        return primero == null;
    }
```
- display, con el que podemos leer el primer elemento sin borrarlo.
```java
    // dleer elemento de la cola
    public void display() {
      int i;
      if (estaVacia()) {
        System.out.println("Esta vacia");
      }
      else {
        // Muestra el elemento al principio de la cola
        System.out.println("\nFront index-> " + front);
  
        // Muestra elemento que no se encuentre ni al principio ni al final
        System.out.println("Items -> ");
        for (i = front; i <= rear; i++)
          System.out.print(items[i] + "  ");
  
        // Muestra el elemento al final de la cola
        System.out.println("\nRear index-> " + rear);
      }
    }
```

## Ordenes de tiempo de ejecución
En informática, el término tiempo de ejecución describe esencialmente el período de tiempo durante el cual una computadora ejecuta un programa, tanto en términos del tiempo requerido para completar una tarea como para describir que un programa se está ejecutando en un momento determinado.

Tiempo de ejecución como duración de la ejecución
El tiempo requerido para resolver una tarea a menudo solo puede determinarse mediante prueba y error. Cada comando de un programa en un lenguaje de programación de alto nivel es traducido por el compilador a un número previamente desconocido de comandos de máquina. Dependiendo del hardware, la ejecución de un comando puede provocar más retrasos, si por ejemplo los datos deben intercambiarse entre la memoria principal y la memoria caché o almacenarse desde el disco duro a la memoria.

Algunos ejemplos usando un programa que ordena <img src="https://render.githubusercontent.com/render/math?math=N"> números:

<img src="https://render.githubusercontent.com/render/math?math=O(N)"> describe el crecimiento lineal. Dicho programa solo realiza un número constante de pasos de cálculo para cada número ingresado. Si, por ejemplo, se ingresa el doble de números, el tiempo de ejecución también se duplica.

<img src="https://render.githubusercontent.com/render/math?math=O(N^{n})"> significa crecimiento cuadrático. El programa de clasificación hace un número constante de pases a través de la lista completa para cada número ingresado. Con el doble del tamaño de los datos de entrada, el tiempo de ejecución es aproximadamente cuatro veces mayor.

<img src="https://render.githubusercontent.com/render/math?math=O(2^{n})"> significa un crecimiento exponencial. El tiempo de ejecución se duplicaría (aproximadamente) con cada número adicional, lo que conduce a tiempos de ejecución extremadamente largos, incluso con tamaños de entrada relativamente pequeños.


# PDs para el Segundo Parcial

## Árboles
- Los Árboles son las estructuras de datos más utilizadas, pero también una de las más complejas, Los Árboles se caracterizan por almacenar sus nodos en forma jerárquica y no en forma lineal como las Listas Ligadas, Colas, Pilas, etc.
- El árbol es una estructura fundamental en las Ciencias de la computación.
- Casi todos los sistemas operativos almacenan los archivos en árboles o estructuras similares a árboles.
- Los árboles también se emplean en el diseño de compiladores, el procesamiento de textos y los algoritmos de búsqueda.

![image](https://user-images.githubusercontent.com/67033535/170891299-b29af31e-2c96-4382-8647-7f0ae91cc1ce.png)


**Datos importantes de los Árboles**

Para comprender mejor que es un árbol comenzaremos explicando cómo está estructurado.

+Nodos: Se le llama Nodo a cada elemento que contiene un Árbol.

+Nodo Raíz: Se refiere al primer nodo de un Árbol, Solo un nodo del Árbol puede ser la Raíz.

![image](https://user-images.githubusercontent.com/67033535/170891506-8afa7df7-c431-4628-8ed5-b7b69dbeee12.png)

+Nodo Padre: Se utiliza este término para llamar a todos aquellos nodos que tiene al menos un+ hijo.

+Nodo Hijo: Los hijos son todos aquellos nodos que tiene un padre.

![image](https://user-images.githubusercontent.com/67033535/170891512-cabf99fe-3960-412d-b24d-f4173609f674.png)

+Nodo Hermano: Los nodos hermanos son aquellos nodos que comparte a un mismo padre en común dentro de la estructura.

+Nodo Hoja: Son todos aquellos nodos que no tienen hijos, los cuales siempre se encuentran en los extremos de la estructura.

![image](https://user-images.githubusercontent.com/67033535/170891514-36b95a1d-ed6e-41dc-9698-42095afb55f9.png)

+Nodo Rama: Estos son todos aquellos nodos que no son la raíz y que además tiene al menos un hijo. 

+Altura: Le llamamos Altura al número máximo de niveles de un Árbol.

![image](https://user-images.githubusercontent.com/67033535/170891517-e50cfdb1-e94f-4ba6-b8d8-a40ab34d98d9.png)

+Tamaño/Peso: Conocemos como peso a el número de nodos que tiene un Árbol. Este factor es importante porque nos da una idea del tamaño del árbol y el tamaño en memoria que nos puede ocupar en tiempo de ejecución (Complejidad Espacial en análisis de algoritmos.)

![image](https://user-images.githubusercontent.com/67033535/170891520-54ec1ce7-0910-4e2a-af8d-a81d0739fd01.png)

+Orden: El Orden de un árbol es el número máximo de hijos que puede tener un Nodo.

![image](https://user-images.githubusercontent.com/67033535/170891525-11a568cb-3ddd-496f-888d-a528ae570f27.png)

+Grado: El grado se refiere al número mayor de hijos que tiene alguno de los nodos del Árbol y está limitado por el Orden, ya que este indica el número máximo de hijos que puede tener un nodo. 

![image](https://user-images.githubusercontent.com/67033535/170891529-89d388a5-3c27-4bff-a48f-a83fef3a3da0.png)





