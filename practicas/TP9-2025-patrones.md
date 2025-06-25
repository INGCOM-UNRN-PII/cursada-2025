# Patrones de diseño GoF en Secuencias

Este listado es una enumeración de los patrones de diseño GoF a modo de ejemplo de
como pueden ser utilizados para mejorar una estructura de datos que almacena valores
preservando el orden como arreglos o listas enlazadas.

## Patrones Creacionales

1. **Singleton**\
   *Consigna:* Implementa una clase `IndexableLogger` como un singleton que registra cada
   acceso y modificación a cualquier instancia de `Indexable`. Asegúrate de que solo
   exista una instancia global del logger.

2. **Factory Method**\
   *Consigna:* Define un `IndexableFactory` que permita crear instancias de distintas
   implementaciones de `Indexable` (por ejemplo, fija o aleatoria) sin especificar las
   clases concretas en el cliente.

3. **Abstract Factory**\
   *Consigna:* Diseña una `CollectionFactory` que pueda producir de forma coherente pares
   de `Indexable` y `Expandable` compatibles entre sí (por ejemplo, versión segura para
   múltiples hilos o versión optimizada para memoria).

4. **Builder**\
   *Consigna:* Implementa un `IndexableBuilder` que permita construir paso a paso un
   `Expandable` con elementos iniciales, validaciones y configuración de capacidad.
   Puede recibir un `Rango` del TP6.

5. **Prototype**\
   *Consigna:* Crea una implementación de `Indexable` que sea clonable, y permite duplicar
   el estado completo de una colección con el patrón Prototype. Incluye una operación
   `clone()`.

## Patrones Estructurales

1. **Adapter**\
   *Consigna:* Adapta una estructura `List<T>` de Java para que se comporte como un
   `Indexable` usando el patrón Adapter. No modifiques la clase `List` original.

2. **Bridge**\
   *Consigna:* Separa la abstracción de un `Expandable` de su implementación de
   almacenamiento (`ArrayStorage`, `LinkedStorage`, etc.) mediante el patrón Bridge.

3. **Composite**\
   *Consigna:* Implementa una clase `CompositeIndexable` que contenga múltiples
   `Indexable` y permita tratarlas como una sola colección unificada.

4. **Decorator**\
   *Consigna:* Diseña un decorador `IndexableLoggerDecorator` que extienda cualquier
   instancia de `Indexable` para registrar cada operación sin modificar la implementación
   original.

5. **Facade**\
   *Consigna:* Crea una fachada `ArrayUtilsFacade` que brinde operaciones de alto nivel (
   como ordenar, invertir, mezclar) sobre `Indexable` y `Expandable`, ocultando la lógica
   subyacente.

6. **Flyweight**\
   *Consigna:* Implementa un sistema que comparta internamente datos repetidos en
   múltiples `Indexable` usando el patrón Flyweight para optimizar memoria.

7. **Proxy**\
   *Consigna:* Crea un `SecureIndexableProxy` que controle el acceso a un `Indexable`
   real, verificando permisos antes de permitir lectura o escritura.

## Patrones de Comportamiento

1. **Chain of Responsibility**\
   *Consigna:* Implementa una cadena de validadores que verifiquen los valores insertados
   en un `Expandable` (por ejemplo: no nulos, dentro de rango, únicos).

2. **Command**\
   *Consigna:* Diseña comandos (`AddCommand`, `RemoveCommand`, `SetCommand`) que operen
   sobre `Expandable`, permitiendo deshacer y rehacer operaciones.

3. **Interpreter**\
   *Consigna:* Construye un intérprete para evaluar expresiones que manipulen
   `Indexable` (por ejemplo: "SET 2 10; GET 2; LENGTH;").

4. **Iterator**\
   *Consigna:* Implementa un iterador personalizado para `Indexable` que permita recorrer
   elementos en distintos modos (ascendente, descendente, pares solamente).

5. **Mediator**\
   *Consigna:* Desarrolla un mediador que coordine la sincronización de múltiples
   `Expandable` entre sí (por ejemplo, reflejando cambios entre arreglos relacionados).

6. **Memento**\
   *Consigna:* Permite guardar y restaurar el estado completo de un `Expandable` usando el
   patrón Memento, para implementar una función de "deshacer".

7. **Observer**\
   *Consigna:* Implementa un sistema en el que observadores se suscriben a cambios en un
   `Expandable`, reaccionando cuando se agregan, modifican o eliminan elementos.

8. **State**\
   *Consigna:* Modela un `Expandable` que cambia de comportamiento según su estado
   interno (por ejemplo: modo lectura, escritura, bloqueado).

9. **Strategy**\
   *Consigna:* Permite que un `Expandable` utilice diferentes estrategias para ordenar sus
   elementos (`AscendingSortStrategy`, `RandomShuffleStrategy`, etc.).

10. **Template Method**\
    *Consigna:* Crea una clase abstracta que implemente una plantilla para procesar
    elementos de `Indexable` (por ejemplo: recorrer, filtrar y mostrar), delegando los
    pasos concretos.

11. **Visitor**\
    *Consigna:* Implementa el patrón Visitor para aplicar operaciones sobre cada elemento
    de un `Indexable` sin modificar su estructura (por ejemplo, calcular suma, imprimir,
    convertir).