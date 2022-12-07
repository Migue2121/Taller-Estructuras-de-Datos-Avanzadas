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
m



# EJERCICIO 3
Validar árbol de búsqueda binaria: 
Un árbol de búsqueda binario válido (BST) tiene TODOS los hijos a la izquierda con valores menores que el nodo padre y TODOS los hijos a la derecha con valores mayores que el nodo padre.

El algoritmo que fue realizado para validar el arbol de busqueda  consiste en:
1. Defina el valor mínimo y máximo que puede tener el nodo actual
2. Si el valor de un nodo no está dentro de estos límites, devuelve falso
3. Validar recursivamente los hijos izquierdos del nodo, con el límite máximo establecido en el valor del nodo
4. Validar recursivamente los hijos correctos del nodo, con el límite mínimo establecido en el valor del nodo

![image](https://user-images.githubusercontent.com/116702376/206065923-5e8dc5b9-6c12-4fb5-b192-2eaef84c60c6.png)

 
 

# EJERCICIO 4
# EJERCICIO 5
# EJERCICIO 6
# EJERCICIO 7
# EJERCICIO 8
# EJERCICIO 9
# EJERCICIO 10
# AUTORES
# REFERENCIAS
