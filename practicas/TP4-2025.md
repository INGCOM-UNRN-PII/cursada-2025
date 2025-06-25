# TP4 - Archivos con arreglos

## Forma de entrega

- No olviden completar la plantilla con sus datos y agregar la descripción de cada función.
  Aunque `main` puede no tener este comentario, no está de más registrar que es lo que el
  `Scanner` recibe.
- Siempre que sea posible, los mensajes de commit deben ser descriptivos.
- Implementen un main que haga un uso de las funciones implementadas, pueden utilizar un `Scanner`.
- La entrada y salida debe estar separada de la función que cumple la consigna, salvo que la consigna lo pida.
- No olviden la utilización de auto-formato, las herramientas de corrección le prestan atención
  a este tema.
- Puede ser necesario cambiar y ajustar la documentación de las funciones pedidas.
- Es posible hacer cambios en la forma de las funciones a implementar, pero para esto, indiquenló explicitamente
  en el comentario de documentación.
- No olviden crear Tests.

Finalmente, pueden usar los atajos tienen los
atajos [SOS - 🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20)
para crear preguntas sobre los enunciados individuales, si es posible, no fusionen las preguntas, así es más fácil que
sus compañeros encuentren las respuestas, y pueden otorgarles mas puntos a quienes responden.

## Organización de los archivos

Vamos a aplicar un pequeño cambio en la forma de estructurar la práctica, ahora el grueso de lo que desarrollen,
estará en archivos que no contienen un `main`, por lo que su nombre cambia para reflejarlo.

1. En la clase `ar.unrn.Archivos`, enviar todas las funciones que interactuen con archivos, aquí se alojará lo más
   importante que deben de desarrollar.
2. En la clase `ar.unrn.Arreglos`, traigan las funciones de `ArregloApp`.
3. Y en la clase `ar.unrn.Ingreso`, las funciones para pedirle datos al usuario.

El objetivo de esta separación es mantener los respectivos `main` lo más simples posible.

## Funciones a desarrollar (en `Archivos`)

Resuelvan estas funciones usando New Style IO (lo que vimos en clases.)

### Cargar arreglo desde archivo [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Cargar%20arreglo%20desde%20archivo)

```java
/**
 * Carga un arreglo de enteros desde un archivo.
 *
 * @param archivo La ruta al archivo que contiene el arreglo.
 * @return Un arreglo de enteros con los datos leídos del archivo.
 * @throws IOException Sí ocurre un error durante la lectura del archivo.
 */
public static int[] cargar(Path archivo) throws IOException  
```

### [B] Escribir arreglo desde archivo [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Escribir%20arreglo%20desde%20archivo)

```java
/**
 * Guarda un arreglo de enteros en un archivo. Si el archivo ya existe, se sobrescribe.
 *
 * @param arreglo El arreglo de enteros que se desea guardar.
 * @param archivo La ruta del archivo donde se guardarán los datos.
 * @throws IOException Si ocurre un error durante la escritura en el archivo.
 */
public static int[] escribir(int[] arreglo, Path archivo) throws IOException  
```

### [C] **_{Opcional}_** Actualizar una posición del arreglo en archivo

[Botón 🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20%7BOpcional%7D%20Actualizar%20una%20posici%C3%B3n%20del%20arreglo%20en%20archivo)
de este ejercicio.

Esta función actualiza un valor específico dentro de un arreglo en archivo.

```java
/**
 * Actualiza un valor específico en una posición dada dentro de un arreglo almacenado en un archivo.
 *
 * @param posicion El índice (basado en cero) del elemento a actualizar.
 * @param valor El nuevo valor que se asignará al elemento.
 * @param archivo La ruta del archivo que contiene el arreglo.
 * @throws IOException Si ocurre un error al leer o escribir el archivo.
 * @throws IndexOutOfBoundsException Si la posición está fuera de los límites válidos del arreglo.
 */
public static void actualizar(int posicion, int valor, Path archivo) throws IOException;
```

Esta función se puede implementar de dos formas:

#### Opción 1

1. Cargar el arreglo,
2. Incorporar el cambio en el mismo.
3. Volver a escribir el arreglo completo.

#### Opción 2

Leer el archivo número por número y reemplazarlo cuando nos encontremos en la posición indicada.

Para evitar problemas y accidentes, usen solo rutas relativas a la ubicación del proyecto.
Para ello, **todas las llamadas** que involucren rutas deben comenzar con `"."`.

Las entradas y salidas de los programas a desarrollar deben ser simples, los tests son más importantes.

### La estructura del archivo

La idea es trabajar con archivos de texto que contengan números enteros (`int` o `long`).

El formato que deben tener, aunque es libre, se sugiere por simplicidad, a que el archivo se estructure
un número por línea e indicando al principio cuantos números contiene.

```
4
1
3
5
6
```

Esto sería el arreglo `{1, 3, 5, 6}`

### Extensión del archivo

Pueden utilizar `.txt`, pero también `.arreglo` que es más _bonito_.

### Programas a desarrollar

A diferencia de los prácticos anteriores, en este, los `main` van en archivos separados de las funciones
a implementar.

Importante, mantengan tan separado como sea posible lo que sea referido al arreglo en sí, de la parte de archivos.

#### [1] `MuestraApp`: Mostrar el arreglo [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Mostrar%20el%20arreglo)

Desarrollar un programa que muestre el arreglo contenido en un archivo, indicando:
- Si el archivo tiene la estructura correcta y si es posible cargarlo.
- Sí está ordenado y en qué dirección

Pueden usar `Files.probeContentType` para saber de qué tipo de archivo se trata y evitar aquellos que no
sean de texto.

**Salida de ejemplo**
```
{1, 3, 5, 6} -> ascendente
```

#### [2] `MezclaApp`: Randomizador [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Randomizador)

Desarrollar un programa que mezcle un arreglo contenido en un archivo.

### Opcionales

#### `LinealApp`: Generación lineal [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Generaci%C3%B3n%20lineal)

Desarrollar un programa que permita crear un archivo con un determinado rango de números, indicando el nombre del
archivo, el valor inicial, el incremento y la cantidad.

#### `RandomApp`: Generación aleatoria [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Generaci%C3%B3n%20aleatoria)

Desarrollar un programa que permita crear un archivo con una cantidad arbitraria de números, incluyendo opción
para fijar el rango de valores mínimo y máximo.

#### `OrdenaApp`: Ordenamiento de archivo [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP4%20-%20Ordenamiento%20de%20archivo)

El programa debe pedir el nombre de un archivo 'origen', la dirección en la que se ordenará y guardar su contenido
en uno que sea llamado de la misma forma pero agregando `_ordenado`.

