# TP6 - Objetos I

## Forma de entrega

- No olviden completar la plantilla con sus datos y agregar la descripción de cada función.
  Aunque `main` puede no tener este comentario, no está de más registrar que es lo que el
  `Scanner` recibe.
- Siempre que sea posible, los mensajes de commit deben ser descriptivos.
- Implementen un main que haga un uso de las funciones implementadas, pueden utilizar un `Scanner`.
- La entrada y salida debe estar separada de la función que cumple la consigna, salvo que la consigna lo pida.
- No olviden la utilización de auto-formato, las herramientas de corrección le prestan atención
  a este tema.
- Puede ser necesario completar, cambiar y ajustar la documentación de las funciones pedidas.
- Es posible hacer cambios en la forma de las funciones a implementar, pero para esto, indiquenló explicitamente
  en el comentario de documentación.
- No olviden crear Tests.

Finalmente, pueden usar los atajos tienen los
atajos [SOS - 🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP6%20-%20)
para crear preguntas sobre los enunciados individuales, si es posible, no fusionen las preguntas, así es más fácil que
sus compañeros encuentren las respuestas, y pueden otorgarles mas puntos a quienes responden.

## Arreglos II [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP6%20-%20Arreglos)

El objetivo de este ejercicio es diseñar e implementar una clase llamada `ArregloConvencional` que encapsule el
comportamiento fundamental de un arreglo unidimensional de enteros (`int`). Esta clase servirá como base para explorar
conceptos más avanzados en futuros trabajos prácticos.

Aquí, daremos forma de clase a las funciones implementadas en el TP3.

### Generalidades

- No está previsto que utilicen `java.util.Arrays`, pero pueden darle uso para construir tests.

- Utilicen el paquete `ar.unrn.arreglos`.

- Utilicen `ArregloMainApp` para crear un `main` simple que le de uso a las clases creadas.

- Aunque es técnicamente legal en Java, nuestro ArregloBase no admite que su tamaño sea cero, para lo
  cual se lanzará `ArregloException`

### Excepciones

Las excepciones lanzadas por esta clase deben ser derivadas de `ArregloExcepcion`, creen nuevos tipos para representar
situaciones más concretas que simplemente 'fallo de arreglo'.

No está permitido lanzar `ArregloExcepcion` directamente, es necesario que sea una clase específica.

Por ejemplo, los métodos que reciben una posición, deben lanzar `IndiceFueraDelArregloException`.

### Constructores

- Constructor con tamaño
- Constructor con tamaño y valor de relleno.
- Constructor que reciba un arreglo `int[]` preservando el encapsulamiento.

### Métodos a implementar

Vean de reducir la duplicación de código tanto como sea posible.

* `obtener`, equivalente a `[]` del lado derecho.
* `modificar`, equivalente a `[]` del lado izquierdo.
* `comoArreglo` que devuelve un `[]` con el contenido del `ArregloBase`
* `largo`, equivalente a `length`
* `equals` / `hashCode` aplicando el protocolo entre ambos.
* `toString`, entre llaves y separados por comas. (x ej. `{1, 2, 3}`)
* `ordenar`, que ordena el arreglo
* `encontrar`, que indica la primera posición en la que se encuentra un valor.

## Tiempo Sexagesimal [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP6%20-%20Tiempo)

Diseña e implementa una clase llamada `Hora` que represente y manipule unidades de tiempo en formato sexagesimal (horas,
minutos, segundos).

### Representación Interna:

- Utiliza tres atributos privados de tipo `short` para almacenar los minutos y los segundos, con las horas como tipo
  `int`.
- Asegúrate de que los valores de minutos y segundos se mantengan dentro del rango válido (0-59).
- Cuando se reciban segundos exclusivamente, utiliza tipo `long`.
- La clase debe ser construida para funcionar de manera inmutable.

### Excepciones

Creen como mínimo una excepción (`HoraExcepcion`) para agrupar los potenciales problemas de los métodos de esta clase.

### Constructores:

- Implementa los siguientes constructores:
- Un constructor default que inicialice la hora a `00:00:00`.
- Un constructor que reciba las horas, los minutos y los segundos como argumentos enteros. Realiza la validación
  necesaria para asegurar que los minutos y segundos estén dentro del rango correcto. Si se proporcionan valores
  inválidos, lanza una excepción.
- Un constructor que reciba la hora total en segundos como argumento.

### Método `toString()`

Implementa el método `toString()` para que devuelva una representación legible de la hora en formato "HH:MM:SS"
(por ejemplo, `"09:30:45"`).

### Método de Comparación (`compareTo()`):

- Implementa un método `compareTo(Hora otraHora)` que compare la instancia actual de `Hora` con otra instancia (
  `otraHora`). El método debe retornar:
- Un valor negativo si la hora actual es menor que `otraHora`.
- Cero si las dos horas son iguales.
- Un valor positivo si la hora actual es mayor que `otraHora`.

### Métodos de Operaciones Aritméticas:

- Implementa los siguientes métodos:
- `sumar(Hora otraHora)`: Retorna una nueva instancia de `Hora` que representa la suma de la hora actual y
  `otraHora`. Asegúrate de manejar correctamente el acarreo de segundos a minutos y de minutos a horas.
- `restar(Hora otraHora)`: Retorna una nueva instancia de `Hora` que representa la resta de `otraHora` a la hora
  actual. Considera cómo manejar el caso en que la hora actual es menor que `otraHora` (podrías retornar una nueva
  hora con valores negativos o lanzar una excepción, documentando claramente la elección).

### Métodos de Conversión:

- `aSegundos()`: Retorna un valor entero que representa la hora actual convertida a la cantidad total de segundos.
- `desdeSegundos(int totalSegundos)`: Un método estático que recibe una cantidad total de segundos como argumento y
  retorna una nueva instancia de `Hora` correspondiente. Asegúrate de manejar correctamente la conversión a horas,
  minutos y segundos.

### Métodos `equals()` y `hashCode()`:

- Implementa correctamente los métodos `equals(Object otroObjeto)` y `hashCode()` para permitir la comparación
  significativa de objetos de esta clase.
- Dos objetos `Hora` se consideran iguales si tienen los mismos valores de horas, minutos y segundos.

### Opcionales

- Podrías considerar la implementación de métodos para sumar o restar una cantidad específica de segundos, minutos u
  horas directamente a un objeto `Hora`.
- Implementa una sobrecarga del método `toString()` para ofrecer formatos alternativos si se considera útil.
  (por ejemplo, incluyendo solo horas y minutos).

## Rango [🆘](https://github.com/orgs/INGCOM-UNRN-PII/discussions/new?category=preguntas-y-respuestas&title=TP6%20-%20Rango)

El objetivo de este ejercicio es implementar una clase llamada `Rango` similar a `range()` de Python.
Esta clase permitirá generar secuencias de números enteros dentro de un intervalo definido, con la
posibilidad de especificar un paso (incremento).

La clase `Rango` debe proporcionar la siguiente funcionalidad, similar a la de `range()` en Python:

Aceptando valores negativos donde sea apropiado

### Representación Interna:

- Utiliza tres atributos privados de tipo entero:
    - `inicio`: El valor inicial de la secuencia (inclusivo).
    - `fin`: El valor final de la secuencia (exclusivo).
    - `paso`: El incremento entre los números de la secuencia.

### Constructores:

- Constructor con un Argumento (`fin`):
    - Un constructor público que reciba un entero `fin`.
    - Debe inicializar la secuencia comenzando en `inicio = 0`, terminando en `fin` (exclusivo) y con un `paso = 1`.
    - Ejemplo de uso: `new Rango(5)` debería generar la secuencia 0, 1, 2, 3, 4.

- Constructor con dos Argumentos (`inicio`, `fin`):

    - Un constructor público que reciba dos enteros: `inicio` y `fin`.
    - Debe inicializar la secuencia comenzando en `inicio`, terminando en `fin` (exclusivo) y con un `paso = 1`.
    - Ejemplo de uso: `new Rango(2, 7)` debería generar la secuencia 2, 3, 4, 5, 6.

- Constructor con tres Argumentos (`inicio`, `fin`, `paso`):

    - Un constructor público que reciba tres enteros: `inicio`, `fin` y `paso`.
    - Debe inicializar la secuencia con los valores proporcionados.
    - Realiza las siguientes validaciones:
        - Si el `paso` es cero, debe lanzar una excepción, ya que esto resultaría en una secuencia infinita.

### Métodos

No está permitido convertir a arreglo para implementar las operaciones individuales.

- `contiene`, que retorna un valor lógico indicando si un número pertenece o no al rango.
- `comoArreglo`, debe de retornar un arreglo con la secuencia construida.
- `longitud`, que devuelve cuantos elementos contiene la secuencia.
- `obtiene`, que retorna el i-esimo valor de la secuencia.
- `toString`, que genera una representación de la secuencia contenida.

### Métodos `equals()` y `hashCode()`:

- Implementa correctamente los métodos `equals(Object otroObjeto)` y `hashCode()` para permitir la comparación
  significativa de objetos de esta clase.