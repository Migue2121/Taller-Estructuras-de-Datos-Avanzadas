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

1. Defina el valor mínimo y máximo que puede tener el nodo actual
2. Si el valor de un nodo no está dentro de estos límites, devuelve falso
3. Validar recursivamente los hijos izquierdos del nodo, con el límite máximo establecido en el valor del nodo
4. Validar recursivamente los hijos correctos del nodo, con el límite mínimo establecido en el valor del nodo
 

# EJERCICIO 4
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



# EJERCICIO 6
# EJERCICIO 7
# EJERCICIO 8
# EJERCICIO 9
# EJERCICIO 10
# AUTORES
# REFERENCIAS
