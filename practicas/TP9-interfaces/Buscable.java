package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.ElementoNuloException;

/**
 * Define un contrato para secuencias de elementos que, además de ser accesibles
 * por índice (heredado de {@link Indexable}), permiten realizar operaciones
 * de búsqueda de elementos.
 * <p>
 * Esta interfaz extiende {@link Indexable}, por lo que todas las consideraciones
 * y contratos de {@code Indexable} (como el uso de índice base cero y el manejo
 * de {@link Indexable#largo()}) también aplican aquí.
 * </p>
 * <p>
 * Las operaciones de búsqueda se basan en la comparación de igualdad de elementos
 * definida dentro de {@code equals()}
 * </p>
 * <p>
 * La política de manejo de elementos {@code null} durante las búsquedas debe
 * ser especificada por la implementación. Si se intenta buscar un elemento
 * {@code null} y la implementación no lo soporta, se debe lanzar una excepción
 * propia (ej. {@code ElementoNuloException}).
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia buscable.
 * @see Indexable
 * @see ElementoNuloException
 */
public interface Buscable<T> extends Indexable<T> {

    /**
     * Retorna {@code true} si esta secuencia contiene el elemento especificado.
     * <p>
     * Más formalmente, retorna {@code true} si y solo si esta secuencia contiene
     * al menos un elemento {@code e} tal que {@code (elemento == null ? e == null : elemento.equals(e))}.
     * </p>
     * <p>
     * Si la secuencia está vacía ({@code largo() == 0}), este método siempre debe retornar {@code false}.
     * </p>
     *
     * @param elemento el elemento cuya presencia en esta secuencia va a ser probada.
     *                 Puede ser {@code null} si la implementación lo soporta.
     * @return {@code true} si esta secuencia contiene el elemento especificado.
     * @throws ElementoNuloException si {@code elemento} es {@code null} y la
     *                               implementación no permite buscar elementos nulos.
     */
    boolean contiene(T elemento);

    /**
     * Retorna el índice de la primera ocurrencia del elemento especificado en esta
     * secuencia, o -1 si la secuencia no contiene el elemento.
     * <p>
     * Más formalmente, retorna el índice más bajo {@code i} tal que
     * {@code (elemento == null ? obtener(i) == null : elemento.equals(obtener(i)))}.
     * </p>
     * <p>
     * Si la secuencia está vacía ({@code largo() == 0}), este método siempre debe retornar -1.
     * </p>
     *
     * @param elemento el elemento a buscar. Puede ser {@code null} si la implementación lo soporta.
     * @return el índice de la primera ocurrencia del elemento especificado en esta
     * secuencia, o -1 si la secuencia no contiene el elemento.
     * @throws ElementoNuloException si {@code elemento} es {@code null} y la
     *                               implementación no permite buscar elementos nulos.
     */
    int indiceDe(T elemento);

    /**
     * Retorna el índice de la última ocurrencia del elemento especificado en esta
     * secuencia, o -1 si la secuencia no contiene el elemento.
     * <p>
     * Más formalmente, retorna el índice más alto {@code i} tal que
     * {@code (elemento == null ? obtener(i) == null : elemento.equals(obtener(i)))}.
     * </p>
     * <p>
     * Si la secuencia está vacía ({@code largo() == 0}), este método siempre debe retornar -1.
     * </p>
     *
     * @param elemento el elemento a buscar. Puede ser {@code null} si la implementación lo soporta.
     * @return el índice de la última ocurrencia del elemento especificado en esta
     * secuencia, o -1 si la secuencia no contiene el elemento.
     * @throws ElementoNuloException si {@code elemento} es {@code null} y la
     *                               implementación no permite buscar elementos nulos.
     */
    int ultimoIndiceDe(T elemento);
}
