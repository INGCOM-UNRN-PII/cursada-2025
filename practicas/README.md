# Consignas Practicas 2025

La base de los repositorios de las practicas es el [proyecto-gradle](https://github.com/INGCOM-UNRN-PII/proyecto-gradle) que tiene toda la configuración base de compilación y verificación utilizada en el cuatrimestre.

## TP1-2025 - Verificación y primeros pasos

Este Trabajo Práctico es simple, está para verificar la instalación de las herramientas y que todo esté funcionando.

Es necesario tener instalado y funcionando `git`, el Java Development Kit `jdk` y el IntelliJ Idea Community Edition.

[TP1-2025](TP1-2025.md)

## TP2-2025 - Java desde C

Aprovechando que la sintaxis base de Java es prácticamente la misma que la de C, reciclaremos algunos ejercicios de Programación 1, como para tener el primer contacto con el lenguaje.

Esta práctica no está pensada para el uso de la librería de Java, más allá de [`java.util.Scanner`](https://docs.oracle.com/javase/17/docs/api/java/util/Scanner.html)

Todos los ejercicios están planteados desde la función que resuelve la consigna. Todos deben ir acompañados de un `main` dentro del mismo archivo como programa que les dé uso de manera interactiva empleando `Scanner`.

[TP2-2025](TP2-2025.md)

## TP3-2025 - Arreglos I y Excepciones

En `IngresoApp`, crear las siguientes funciones para solicitar un número al usuario y un número comprendido entre un mínimo y un maximo.

 * Solicita al usuario un número entero, repitiendo la solicitud hasta un máximo de 'intentos' veces.

En la clase `ArregloApp`, se pide implementar un conjunto de funciones para trabajar con arreglos de números enteros.
Pueden utilizar la funcionalidad presente en  [
`java.util.Arrays`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html) pero vean de
utilizarla lo menos posible de manera directa en su código.

Utilicen `ArregloException` para indicar fallos que su código produzca, eviten las fallas 'naturales' como los accesos
fuera de lugar, pero lanzen esta excepción en su lugar. (No es correcto atajar y lanzar, por razones que veremos más
adelante).

[TP3-2025](TP3-2025.md)

## TP4-2025 - Arreglos II y Archivos

La resolución de funciones pedidas es usando New Style IO.

[TP4-2025](TP4-2025.md)

## TP5-2025 - Analisis OOP - Pensamiento en clases y objetos

Como para ir introduciéndonos en los conceptos de clases y objetos a través del análisis de diferentes contextos, pero también para ir viendo cómo otras personas ven la misma cosa.

[TP5-2025](TP5-2025.md)

## TP6-2025 - Objetos I

Arreglos III - El objetivo de este ejercicio es diseñar e implementar una clase llamada `ArregloConvencional` que encapsule el
comportamiento fundamental de un arreglo unidimensional de enteros (`int`). Esta clase servirá como base para explorar
conceptos más avanzados en futuros trabajos prácticos.

Rango - El objetivo de este ejercicio es implementar una clase llamada `Rango` similar a `range()` de Python.
Esta clase permitirá generar secuencias de números enteros dentro de un intervalo definido, con la
posibilidad de especificar un paso (incremento).

[TP6-2025](TP6-2025.md)

## TP7-2025 - Calculadora OOP

Siguiendo lo que estuvimos viendo en clases como base. Su trabajo ahora es completar todo lo que falta
y algunas operaciones adicionales.

Observen especial atención al código duplicado, que es una oportunidad para cambiar código de lugar y
aprovechar la jerarquía de clases.

[TP7-2025](TP7-2025.md)

## TP8-2025 - Arreglos IV - Genericos y Comparables

Creen una clase `ArregloGenérico` con el mismo comportamiento base que el `ArregloConvencional` (TP6) y que pueda almacenar cualquier tipo de referencia de tipo `T`.

Crear una clase, llamada `ArregloDinamico` que extienda el arreglo del punto anterior para que el mismo funcione como el explicado en clase.

Crear una clase de `ArregloDinamico` llamada `ArregloOrdenable` que acepte elementos `Comparable`

Crear una clase de `ArregloOrdenable` llamada `ArregloOrdenado`

[TP8-2025](TP8-2025.md)

## TP9-2025 - Patrones de diseño

Arreglos como `Indexable` para luego aplicar los patrones de diseño Decorator, Strategy, Observer y Visitor.

[TP9-2025](TP9-2025.md)

Las interfaces en [TP9-interfaces](./TP9-interfaces/) contienen documentación detallada de como utilizarlas.

[Implementación de patrones](TP9-2025-patrones.md)

