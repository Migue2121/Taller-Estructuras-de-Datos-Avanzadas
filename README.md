# Taller Estructuras de Datos Avanzadas

<img src="https://user-images.githubusercontent.com/116528826/206042675-3efa56d6-42f3-48bd-88cb-7e546cc7aa5a.png" height="225"/>![image](https://user-images.githubusercontent.com/116528826/206045357-ed65e883-9fb1-4243-a453-391b6e21a76c.png)


El presente taller lo que busca es que atreves de diferentes problemas tomados del sitio web (Leetcode) implementemos estructuras de datos avanzadas de acuerdo a cada problema para encontrar la solución más óptimas. Se realiza un análisis de cada solución propuesta de acuerdo a la estructura implementada. 


# EJERCICIO  1
Insertador de árbol binario completo:   
Cuando se inserta un nuevo nodo en el árbol hay que tener en cuenta que cada nodo no puede tener más de dos hijos, por esta razón si un nodo ya tiene 2 hijos, el nuevo nodo nunca se podrá insertar como su hijo.Para localizar el lugar adecuado del árbol donde insertar el nuevo nodo se realizan comparaciones entre los nodos del árbol y el elemento a insertar. El primer nodo que se compara es la raíz, si el nuevo nodo es menor que la raíz, la búsqueda prosigue por el nodo izquierdo de éste. Si el nuevo nodo fuese mayor, la búsqueda seguiría por el hijo derecho de la raíz.

Vamos a verlo con un ejemplo sobre el siguiente árbol:
![WhatsApp Image 2022-12-06 at 7 34 25 PM](https://user-images.githubusercontent.com/116702376/206058336-915a42a7-7dd1-4761-85d2-a04d2c9a96b6.jpeg)

Se quiere insertar el elemento 6.

Lo primero es comparar el nuevo elemento con la raíz. Como 6 > 4, entonces la búsqueda prosigue por el lado derecho. Ahora el nuevo nodo se compara con el elemento 8. En este caso 6 < 8, por lo que hay que continuar la búsqueda por la rama izquierda. Como la rama izquierda de 8 no tiene ningún nodo, se cumple la condición de parada de la recursividad y se inserta en ese lugar el nuevo nodo.

![image](https://user-images.githubusercontent.com/116702376/206059288-4a541278-4c2d-43ec-9fbc-93699a7bde16.png)

# EJERCICIO 2
Binary Tree Inorder Traversal:

estudio en este metodo debemos tener en cuenta el recorrido de árboles se refiere al proceso de visitar de una manera sistemática, exactamente una vez, cada nodo en una estructura de datos de árbol.
empujar todos los hijos izquierdos de un Nodo en la pila, para que mi idea se vea clara:

1.Empujamos todos los hijos restantes de root en la pila hasta que no haya más nodos.

2.Luego saltamos de la pila a la que llamaríamos cur.

3.Agregar cura la lista de resultados

4.Llama recursivamente pushAllLeft()al curhijo derecho de 
![image](https://user-images.githubusercontent.com/104114772/206062599-cf0400ea-0183-417e-a80f-1f97c028d1ef.png)




# EJERCICIO 3
Validar árbol de búsqueda binaria: 
Un árbol de búsqueda binario válido (BST) tiene TODOS los hijos a la izquierda con valores menores que el nodo padre y TODOS los hijos a la derecha con valores mayores que el nodo padre.

1. Defina el valor mínimo y máximo que puede tener el nodo actual
2. Si el valor de un nodo no está dentro de estos límites, devuelve falso
3. Validar recursivamente los hijos izquierdos del nodo, con el límite máximo establecido en el valor del nodo
4. Validar recursivamente los hijos correctos del nodo, con el límite mínimo establecido en el valor del nodo
 

# EJERCICIO 4
Minimum Height Trees:

La distancia entre dos nodos es el número de aristas que conectan los dos nodos.
Sin embargo, en nuestro caso, dado que el gráfico de entrada puede formar un árbol desde cualquier nodo, como se especifica en el problema, solo podría haber una ruta entre dos nodos cualesquiera. Como resultado, no habría ambigüedad en la definición anterior de distancia .

La altura de un árbol se puede definir como la distancia máxima entre la raíz y todos los nudos de sus hojas.
![image](https://user-images.githubusercontent.com/104114772/206070381-1aba31e3-e91a-459c-9fbf-e20d92a0515e.png)

en el gráfico anterior, está claro que el nodo con el valor 1es el centroide del gráfico. Si elegimos el nodo 1como raíz para formar un árbol, obtendríamos un árbol con la altura mínima , en comparación con otros árboles que se forman con cualquier otro nodo.

Para el gráfico similar a un árbol, el número de centroides no es más de 2.

Si los nodos forman una cadena, es intuitivo ver que se cumple la declaración anterior, que se puede dividir en los siguientes dos casos:

Si el número de nodos es par, entonces habría dos centroides.
Si el número de nodos es impar, entonces solo habría un centroide

![image](https://user-images.githubusercontent.com/104114772/206070578-abcc02ea-b32a-4ab3-b97c-2691edef0b39.png)

Para el resto de los casos, podríamos probar por contradicción .
Si falta alguno de los bordes del triángulo, los 3 centroides se reducirían a un solo centroide.

![image](https://user-images.githubusercontent.com/104114772/206070797-07c01893-a583-408d-9bb5-b02ecb598f6f.png)

De manera similar, para cualquiera de los casos que tengan más de 2 centroides, estos deben formar un ciclo entre los centroides, lo cual se contradice con nuestra condición.

Una vez que recortamos la primera capa de los nodos de hoja , algunos de los nodos que no son de hoja se convertirían en nodos de hoja.
El proceso de recorte continúa hasta que solo quedan dos nodos en el gráfico, que son los centroides que estamos buscando.
El algoritmo anterior se asemeja al algoritmo de clasificación topológica que genera el orden de los objetos en función de sus dependencias.

![image](https://user-images.githubusercontent.com/104114772/206071090-6ce5d4e3-65cb-4291-9e55-9576569cd760.png)


Implementación

Dado el algoritmo anterior, podríamos implementarlo a través de la estrategia Breadth First Search , para recortar los nodos hoja capa por capa .
Inicialmente, construiríamos un gráfico con la lista de adyacencia de la entrada.
Luego creamos una cola que se usaría para contener los nodos hoja.
Al principio, ponemos todos los nodos hoja actuales en la cola.
Luego ejecutamos un ciclo hasta que solo queden dos nodos en el gráfico.

* analisis de complejidad 

Dejar∣ V ∣ |V|∣ V ∣sea el número de nodos en el gráfico, entonces el número de aristas sería∣ V ∣ − 1 |V| - 1∣ V ∣−1como se especifica en el problema.

Complejidad del tiempo:O ( ∣ V ∣ ) \mathcal{O}(|V|)O ( ∣ V ∣ )

Primero, se necesita∣ V ∣ − 1 |V|-1∣ V ∣−1iteraciones para que construyamos un gráfico, dadas las aristas.

Con el grafo construido, recuperamos los nodos hoja iniciales, lo que toma∣ V ∣ |V|∣ V ∣pasos.

Durante el proceso de recorte de BFS, eliminaremos casi todos los nodos (∣ V ∣ |V|∣ V ∣) y bordes (∣ V ∣ − 1 |V|-1∣ V ∣−1) desde los bordes. Por lo tanto, nos llevaría alrededor∣ V ∣ + ∣ V ∣ − 1 |V| + |V| - 1∣ V ∣+∣ V ∣−1operaciones para llegar a los centroides.

En resumen, la complejidad temporal total del algoritmo esO ( ∣ V ∣ ) \mathcal{O}(|V|)O ( ∣ V ∣ ).

Complejidad espacial:O ( ∣ V ∣ ) \mathcal{O}(|V|)O ( ∣ V ∣ )

Construimos el grafo con lista de adyacencia, que tiene∣ V ∣ |V|∣ V ∣nodos y∣ V ∣ − 1 |V|-1∣ V ∣−1bordes Por lo tanto, necesitaríamos∣ V ∣ + ∣ V ∣ − 1 |V| + |V|-1∣ V ∣+∣ V ∣−1espacio para la representación de la gráfica.

Además, usamos una cola para realizar un seguimiento de los nodos hoja. En el peor de los casos, los nodos tienen forma de estrella, con un centroide y el resto de los nodos como nodos hoja. En este caso, necesitaríamos∣ V ∣ − 1 |V|-1∣ V ∣−1espacio para la cola.

En resumen, la complejidad espacial general del algoritmo también esO ( ∣ V ∣ ) \mathcal{O}(|V|)O ( ∣ V ∣ ).


# EJERCICIO 5
# EJERCICIO 6
# EJERCICIO 7
# EJERCICIO 8
# EJERCICIO 9
# EJERCICIO 10
# AUTORES
# REFERENCIAS
