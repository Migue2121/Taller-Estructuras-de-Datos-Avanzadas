# Taller Estructuras de Datos Avanzadas

<img src="https://user-images.githubusercontent.com/116528826/206042675-3efa56d6-42f3-48bd-88cb-7e546cc7aa5a.png" width="225" height="225"/><img src="https://user-images.githubusercontent.com/116528826/206077132-98068585-6729-439f-b212-a1fea3fb7c4b.png"
height="225"/><img src="https://codeforces.org/s/96362/images/codeforces-sponsored-by-ton.png"
width="225" height="225"/>![image](https://user-images.githubusercontent.com/116528826/206045357-ed65e883-9fb1-4243-a453-391b6e21a76c.png)

El presente taller lo que busca es que atreves de diferentes problemas tomados de los sitio web(Leetcode,codeForce,AtCoder) implementemos estructuras de datos avanzadas, de acuerdo a cada problema para encontrar la solución más óptimas. Se realiza un análisis de cada solución propuesta de acuerdo a la estructura implementada.


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
 ![image](https://user-images.githubusercontent.com/116702376/206073892-cf51c089-8974-4512-b3e9-de34d439ceac.png)


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
Target : color verde
Nodo auxiliar : color naranja
Nodos recorridos: color amarillo

Primero se tiene un árbol original en el que se quiere trabajar.

![Captura de pantalla_20221206_080655](https://user-images.githubusercontent.com/113552219/206062685-cae60e26-80c6-4366-8c04-e73016afc368.png)

Y un árbol clon del árbol original.

![image](https://user-images.githubusercontent.com/113552219/206062745-e65dbd9f-71f3-4bfe-a588-f556a913c541.png)

Se asigna un nodo ha ser buscado (Ej: 6) , este es el nodo target.

![Captura de pantalla_20221206_092838](https://user-images.githubusercontent.com/113552219/206062830-37308545-3be3-46e7-8e20-117996eb47c5.png)

Se debe buscar el valor del nodo target en el árbol clon, se empieza a recorrer por niveles el árbol clon nodo por nodo comparando sus valores, hasta que el valor del nodo target sea el mismo valor de algún nodo del árbol clon.

![image](https://user-images.githubusercontent.com/113552219/206062925-2c012864-0fd2-4402-8a50-108f4a1cb933.png)

Empieza el recorrido en el nodo raíz.

![Captura de pantalla_20221206_094251](https://user-images.githubusercontent.com/113552219/206062999-a8610f3a-25d7-460c-ae8d-a1ab302c78a3.png)

y se comparan los valores del nodo target y el nodo raíz.

![Captura de pantalla_20221206_100040](https://user-images.githubusercontent.com/113552219/206063123-00c7142d-6ce3-4b83-8b93-7cc0bfb036e5.png)

![image](https://user-images.githubusercontent.com/113552219/206063187-569e4044-f110-4780-ae92-a7f3adc70f8c.png)

entra la siguiente condición en la que si los nodos hijos no existen retorna null.

![Captura de pantalla_20221206_100520](https://user-images.githubusercontent.com/113552219/206063281-659d694c-fbc6-4911-afde-4d46b9ce255c.png)

como no se cumple la condición se sigue el recorrido en el orden mencionado anteriormente.

![Captura de pantalla_20221206_101202](https://user-images.githubusercontent.com/113552219/206063334-7cad9df2-8dc6-4c05-9eac-6b0ee9be43f4.png)

![Captura de pantalla_20221206_101436](https://user-images.githubusercontent.com/113552219/206063365-aa5235e0-1ed7-4e9e-a87f-b7d351b1614e.png)

Se comparan los valores de los nodos.

![image](https://user-images.githubusercontent.com/113552219/206063448-f156eba0-607e-4c84-9131-613637e4ceac.png)

como no se cumple la condición, sigue el recorrido.

![Captura de pantalla_20221206_101858](https://user-images.githubusercontent.com/113552219/206063487-6d15074d-737e-4b2b-9949-4dac02cff9f3.png)

![Captura de pantalla_20221206_101925](https://user-images.githubusercontent.com/113552219/206063562-d93b0204-e98b-47a3-aa96-f4c4bdb3956a.png)

luego vuelve a empezar el recorrido, ahora como nodo raíz el indicado en la figura anterior.

![Captura de pantalla_20221206_100040](https://user-images.githubusercontent.com/113552219/206063630-5a40ffef-afe6-4043-98bf-d6356ca6e67b.png)

![image](https://user-images.githubusercontent.com/113552219/206063716-8eee4abf-0590-468e-8f1c-3763276b2cee.png)

como no se cumple la condición sigue el recorrido.

![Captura de pantalla_20221206_101202](https://user-images.githubusercontent.com/113552219/206063817-bff638e1-463d-4286-831e-5d7321e7d9d6.png)

![Captura de pantalla_20221206_102343](https://user-images.githubusercontent.com/113552219/206063977-dc2d163e-9ea5-4bd1-88fc-63f7669c1b9c.png)


se comparan los valores de los nodos

![image](https://user-images.githubusercontent.com/113552219/206064032-b3c8b5e0-be03-475b-9b51-496d555d2197.png)

como se cumple la condición, retorna el resultado (res = 6).

![Captura de pantalla_20221206_102638](https://user-images.githubusercontent.com/113552219/206064069-47e754b0-70f6-414f-9700-56cffe85aa8e.png)

Se encuentra el valor y se imprime el valor del nodo.

![image](https://user-images.githubusercontent.com/113552219/206065004-f8f67a97-6657-4abe-a5c8-a16a209c772c.png)

# EJERCICIO 6
Find if Path Exists in Graph:
en el siguiente ejercicio nos daba como entrada un arreglos de arreglos donde estos últimos contienen parejas de números las cuales serán nuestros nodos, contaremos con un nodo inicio y un nodo destino los cuales serán números; teniendo en cuenta cuenta que nuestro inicio será 0 y nuestro destino será cualquier número del array que mayor a 0, donde secuencialmente tendremos que seguir un camino desde nuestro inicio hasta el destino.

Tenemos un gráfico bidireccional en este problema, la tarea es: para los dos nodos sourcey destinationen este gráfico, debemos verificar si existe una ruta desde sourcea destination.
![image](https://user-images.githubusercontent.com/104114772/206078911-f2ffec2a-244c-4352-8057-689489f7f146.png)

*En el primer gráfico, existe un camino de 0a 2.

*En el segundo gráfico, no podemos encontrar un camino de 0a 7.

Ahora, tenemos que verificar si existe una ruta entre dos nodos dados. Una cosa más para notar, ya que tenemos que verificar si existe una ruta entre dos nodos dados, esto también sugiere que dos nodos deben estar conectados , por lo tanto, este problema también se puede resolver usando Disjoint Set Union , donde verificamos si ambos nodos pertenecen al mismo grupo o no.

# EJERCICIO 7

Nodo auxiliar : color naranja
Nodos recorridos: color amarillo
terminado : color verde

Se recibe como input un arreglo organizado de mayor a menor ( requisito obligatorio) .
Estos son los puntajes de la competición de los atletas. Estos elementos deben ser únicos (no repetidos).

![image](https://user-images.githubusercontent.com/113552219/206065172-c18f2742-b430-43bb-8b42-80d2a3c2d4c8.png)
![image](https://user-images.githubusercontent.com/113552219/206065202-7222c191-3bbb-4a25-8ecb-a9fc06c6f59d.png)

Se crea un arreglo vacío con el mismo tamaño de los puntajes (estos serán los premios de cada participante).

![image](https://user-images.githubusercontent.com/113552219/206065244-cb0a17e6-cd16-4039-b687-ebfbfa6d2a91.png)

![image](https://user-images.githubusercontent.com/113552219/206065267-6ddc37a1-81f8-4915-8901-bbaa326a65ef.png)

La siguiente tabla muestra la rúbrica de calificaciones.

![image](https://user-images.githubusercontent.com/113552219/206065328-85a6747b-72b7-4d15-bd96-51d8192822af.png)

Se recorre el arreglo con los puntajes y por cada posición recorrida se le asigna el valor al nuevo arreglo vacío según la tabla.

![image](https://user-images.githubusercontent.com/113552219/206065362-e0fa4e9b-abf8-46b2-8ac5-214442c85bbf.png)

Para realizar este proceso se compara el puntaje obtenido, con el resto de puntajes, y en la posición que quede este, se le asigna su valor correspondiente. 

![image](https://user-images.githubusercontent.com/113552219/206065417-3e45af9a-cac3-49bb-bfa7-92b1f5936378.png)

![image](https://user-images.githubusercontent.com/113552219/206065448-a577c05b-d2a1-456a-bda5-82adb39113ac.png)

![image](https://user-images.githubusercontent.com/113552219/206065461-943b1559-0f15-4f4f-ac3b-049aa9bc987c.png)

                                               …

![image](https://user-images.githubusercontent.com/113552219/206065528-839df159-7ae5-494a-8201-cdd4edef4307.png)

En este caso este es el puntaje mayor, por lo cual se le asigna su valor correspondiente según la tabla (Gold Medal).

![image](https://user-images.githubusercontent.com/113552219/206065580-27b05553-ec77-4920-95f6-a56070eef198.png)

![image](https://user-images.githubusercontent.com/113552219/206065600-80a0657c-68b2-47f1-91ce-1fec38f15395.png)

Esto se repite por todo el arreglo de la siguiente manera:

![image](https://user-images.githubusercontent.com/113552219/206065633-d167754b-aa80-4a10-9a26-43c2609e58da.png)

![image](https://user-images.githubusercontent.com/113552219/206065647-fbc49fac-2822-4c8d-bcad-9ce462c8d5fe.png)

Se asigna el valor de silver medal por ser equivalente a dos.

![image](https://user-images.githubusercontent.com/113552219/206065675-d0ceaf37-c41c-4480-8f37-1306009b80c9.png)

![image](https://user-images.githubusercontent.com/113552219/206065783-8bda356a-f594-4808-81be-61d926638abd.png)

![image](https://user-images.githubusercontent.com/113552219/206065805-deadcf02-6b10-4a50-b11b-a90abfd6b24c.png)

Se asigna el valor de bronze medal por ser equivalente a tres.

![image](https://user-images.githubusercontent.com/113552219/206065820-85f3ca17-cc48-4d8c-8896-e94b7f4e6787.png)

![image](https://user-images.githubusercontent.com/113552219/206065845-05685b12-48ff-4a4c-aa90-b076c12cc6ba.png)

Asi se continua por todo el recorrido asignando el valor del nodo de la posicion n.

![image](https://user-images.githubusercontent.com/113552219/206065968-89f957ec-fbc9-4948-8fec-54f4c7c9fb98.png)

![image](https://user-images.githubusercontent.com/113552219/206065983-31424e4e-6f5b-4de4-b336-aa26c1df1c46.png)

![image](https://user-images.githubusercontent.com/113552219/206065995-af041092-5233-47f2-aba4-5056a64888bd.png)
# EJERCICIO 8
Operaciones de montón:
Para dar solucion a este ejercicio podemos realiarlo mediante una cola de prioridad. Una cola de prioridad es una estructura de datos que permite al menos las siguientes dos operaciones: insertar, que añade elementos a la cola, y eliminar mínimo, que busca, devuelve y elimina el elemento mínimo de la cola.

![image](https://user-images.githubusercontent.com/116702376/206077069-f40e483a-c4b0-4e96-b19a-769be8dcecd2.png)

C´omo a˜nadir un nuevo elemento? Una posibilidad  consiste en colocar el nuevo elemento como ultimo elemento del monticulo , justo a la derecha del
ultimo o como primero de un nuevo nivel. Para ello hay que localizar al padre de la primera hoja y sustituirla por un nuevo nodo con el elemento a insertar. A continuaci´on hay que reestablecer el orden de montıculo empleando para ello un procedimiento flotar, que trabaja de manera similar pero a la inversa de hundir: el nodo en curso se compara con su nodo padre y se realiza el intercambio si ´este es mayor que el padre, iterando este paso mientras sea necesario.

1. A[1] contiene la ra´ız
2.  Si 2i ≤ n entonces A[2i] contiene al hijo izquierdo  del elemento en A[i] y si 2i + 1 ≤ n entonces A[2i+1] contiene al hijo derecho de A[i].
3.  Si i div 2 ≥ 1 entonces A[i div 2] contiene al padre de A[i].

# EJERCICIO 9
Contar enteros distintos.

El ejercicio nos pide como dato de entrada una secuencia de enteros N, y se espera en su salida que imprima la cantidad de enteros diferentes que existen en la secuencia mencionada anteriormente.

![image](https://user-images.githubusercontent.com/113552219/206086298-6b4bb432-43e9-4ea5-bcfe-ea2adc174ee1.png)

-la secuencia de numeros deben ser entre 1 a 1000.
-todos los valores deben ser enteros.
-ai debe ser entre 1 a 10 elevado a la 9.

El input se debe ingresar de la siguiente manera.

![image](https://user-images.githubusercontent.com/113552219/206087172-6452f2c8-f90d-4057-85d2-efa121414f35.png)

y el output deberia mostrar.

![image](https://user-images.githubusercontent.com/113552219/206087255-7b5ea2db-6bc0-48d0-9cdf-82c4cabcf0cf.png)


# AUTORES
# REFERENCIAS
