package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.ElementoInvalidoException;
import ar.unrn.secuencias.excepciones.IndiceFueraDeRangoException;

/**
 * Define un contrato para estructuras de datos que representan una secuencia
 * ordenada y genérica de elementos, los cuales son accesibles y modificables
 * a través de un índice numérico.
 * <p>
 * Esta interfaz está diseñada para ser la base de diversas implementaciones
 * de secuencias, como podrían ser arreglos de tamaño fijo, listas dinámicas,
 * o incluso vistas especializadas sobre otras estructuras de datos.
 * </p>
 * <p>
 * Se espera que todas las implementaciones utilicen un <strong>índice base cero</strong>,
 * lo que significa que el primer elemento se encuentra en el índice 0 y el último
 * en el índice {@code largo() - 1}.
 * </p>
 * <p>
 * Las implementaciones deben definir claramente su política respecto a los
 * elementos {@code null}: si son permitidos o si su inserción/modificación
 * resultará en una excepción (posiblemente una {@code ElementoNuloException}
 * personalizada si se desea restringir). Esta interfaz, por sí misma, no
 * prohíbe elementos {@code null}.
 * </p>
 * <p>
 * La gestión de la capacidad y el tamaño ({@link #largo()}) es responsabilidad
 * de la clase implementadora. Por ejemplo, un arreglo de tamaño fijo tendrá un
 * {@code largo()} constante, mientras que una lista dinámica podría cambiar su
 * {@code largo()} a través de otras operaciones no definidas en esta interfaz
 * (como agregar o eliminar elementos).
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia.
 */
public interface Indexable<T> {

    /**
     * Modifica, reemplazando, el valor en la posición especificada dentro de la secuencia.
     * <p>
     * Si la implementación tiene restricciones sobre el tipo de valor (por ejemplo,
     * no permitir {@code null} o requerir que el valor cumpla ciertas condiciones),
     * podría lanzar una excepción personalizada (ej. {@code ElementoInvalidoException}
     * o {@code ElementoNuloException}).
     * </p>
     *
     * @param indice base cero de la ubicación a modificar.
     *               Debe estar en el rango {@code [0, largo() - 1]}.
     * @param valor  a ser almacenado en la ubicación especificada.
     *               Puede ser {@code null} si la implementación lo permite.
     * @throws IndiceFueraDeRangoException si el {@code indice} es negativo o si es
     *                                     mayor o igual al {@link #largo()} de la secuencia.
     * @throws ElementoInvalidoException   si el {@code element} no es válido para esta
     *                                     secuencia según las reglas de la implementación.
     */
    void modificar(int indice, T valor);

    /**
     * Obtiene (retorna) el elemento en la posición especificada dentro de la secuencia.
     * <p>
     * Si la secuencia está vacía ({@code largo() == 0}), cualquier intento de obtener
     * un elemento resultará en una {@code IndiceFueraDeRangoException}.
     * </p>
     *
     * @param indice el índice base cero de la ubicación del elemento a obtener.
     *               Debe estar en el rango {@code [0, largo() - 1]}.
     * @return el elemento encontrado en la ubicación especificada.
     * Puede ser {@code null} si un elemento {@code null} fue previamente
     * almacenado en esa posición y la implementación lo permite.
     * @throws IndiceFueraDeRangoException si el {@code indice} es negativo o si es
     *                                     mayor o igual al {@link #largo()} de la secuencia.
     */
    T obtener(int indice);

    /**
     * Retorna el número de elementos actualmente contenidos en la secuencia.
     * <p>
     * Este valor representa el tamaño lógico de la secuencia y determina el rango
     * válido de índices para las operaciones {@link #modificar(int, Object)} y
     * {@link #obtener(int)}, que es {@code [0, largo() - 1]}.
     * </p>
     * <p>
     * Si la secuencia no contiene elementos, este método debe retornar 0.
     * El valor retornado nunca debe ser negativo.
     * </p>
     *
     * @return el número de elementos en la secuencia (su tamaño lógico).
     */
    int largo();
}
