# TP 10 - Arreglos IV - Patrones de diseño

_Too fast too arreglos_

## Forma de entrega
En orden de importancia

1. Reglas de estilo
2. Autoformato
3. Checkstyle
4. PMD

## Organización

La organización de las clases debe ser:

1. La raíz debe ser `ar.unrn.secuencias`
2. Creen un paquete por patrón; por ejemplo `ar.unrn.secuencias.decoradores`
3. Revisen las excepciones que están en el paquete `ar.unrn.secuencias.excepciones` y
   creen las que sean necesarias

## `Indexable`s

### `ArregloBase`

La implementación base de este arreglo, es la de `ArregloGenerico` del TP9, la misma debe
implementar las interfaces:

- Indexable
- Iterable
  E implementar un `toString` que indique cuál es el nombre de la clase, algo como
  `ArregloBase={1,2,3,4,5}:5`, con el contenido y largo.

Como esta clase es la base de todas las demás, déjenla en la raíz de `ar.unrn.secuencias`.

## Patrones

Implementen cada patron en un paquete separado para agrupar las clases que sean
necesarias.

### Decoradores

Es recomendable crear una clase abstracta `SecuenciableDecorable` implementando la
interfaz, para simplificar la implementación de los decoradores individuales.

#### Decoradores a implementar

1. Registro de operaciones, implementar un decorador que envíe por consola que cambio
   sufrió el arreglo decorado.
2. Arreglo de solo lectura, implementar un arreglo decorado` que impida cambios en las
   instancias de
   valores que contenga.

### Estrategias

Crear una clase de `ArregloBase`, llamada `ArregloOrdenable` que implemente la interfaz
`Ordenable` en la que sea posible cambiar el algoritmo de ordenamiento en tiempo de
ejecución.

```java
public interface Ordenador<T extends Comparable<T>> {
    void ordenar(Indexable<T> arreglo);
}
```

Y la llamada al algoritmo quedaría como, observen que, a pesar de llamarse igual, no
reciben los mismos argumentos, la implementación sería algo como:

```java
public class ArregloOrdenable<T extends Comparable<T>> extends Arreglo<T> {
    //... resto del código
    void ordenar() {
        this.estrategia.ordenar(this);
    }
}
```

Este algoritmo debe de permitir la utilización de un `Comparator` pasado como argumento.

#### Algoritmos de ordenamiento

Implementen, a elección, por lo menos un algoritmo aparte de Burbuja.

### Observador

La idea de este patron, es la generación de eventos y responder ante ellos.

Crear un Decorator para `Indexable` llamado `IndexableObservable` en el que podamos
subscribirnos a los cambios en su contenido.

#### Observadores a implementar

1. Uno que muestre por pantalla el cambio hecho (sí, con `print`).
2. Uno que replique el mismo cambio en otro `Indexable` del mismo tamaño.

### Visitor

Crear un Decorator para `Indexable` que implemente `Visitable`;

#### Visitantes a implementar

1. Un visitor para sumar los números `Integer` contenidos en el `IndexableVisitable`
2. Un visitor para construir una cadena con el contenido del `IndexableVisitable`, esta
   cadena se construye con los `toString`, un separador y cabecera que puede indicarse
   cuando es llamado.

# Opcionales

## Decorador de validación

Validador de elementos, implementar un decorador que reciba un `Validador` e indique el
primer elemento que no cumple con la regla.
A. Crear un validador para rechazar valores `null`
B. Crear un `Validador<Integer>` para marcar los valores por debajo de un límite.

## Otros patrones

Implementen más patrones utilizando el documento `patrones.md` como guía de como puede ser
implementado, algunas de las consignas de esta práctica salen de ese listado, por lo que
verán duplicados.

El práctico tiene una enorme cantidad de interfaces que _al final_ no se usan, están para
que sirvan de ejemplo de como crear interfaces siguiendo el principio SRP -
Responsabilidad Única.

Pueden crear implementaciones de ellas, como por ejemplo, `Subdividible`, `Invertible` y
`Dispensable`.

## `ArregloDinamico` como `Expandable`

Conviertan el `ArregloDinamico` del TP8 en un `Expandable` cosa de que, no sea necesario
modificar el código existente para que puedan hacer uso de los patrones definidos.

Pueden traer las otras versiones del `ArregloDinamico`.

## `ListaEnlazada`

Creen un `Indexable` y `Expandable` como la estructura Lista Enlazada. Tengan en cuenta
que la noción de `Nodo`, es parte de la implementación y como tal, no debe de existir
fuera de la misma.
