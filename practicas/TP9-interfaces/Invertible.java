package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.SecuenciaNoModificableException;


/**
 * Define un contrato para secuencias de elementos que, además de ser accesibles
 * por índice (heredado de {@link Indexable}), permiten invertir el orden de
 * sus elementos.
 * <p>
 * Esta interfaz extiende {@link Indexable}, por lo que todas las consideraciones
 * y contratos de {@code Indexable} (como el uso de índice base cero y el manejo
 * de {@link Indexable#largo()}) también aplican aquí.
 * </p>
 * <p>
 * La operación de inversión modifica la secuencia en su lugar, reorganizando
 * los elementos de modo que el primer elemento se convierta en el último, el
 * segundo en el penúltimo, y así sucesivamente.
 * </p>
 * <p>
 * El {@link #largo()} de la secuencia permanece igual después de la inversión.
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia invertible.
 * @see Indexable
 */
public interface Invertible<T> extends Indexable<T> {

    /**
     * Invierte el orden de los elementos en esta secuencia.
     * <p>
     * La inversión se realiza "in-place", es decir, modificando la secuencia
     * actual.
     * </p>
     * <p>
     * Si la secuencia está vacía o contiene un solo elemento, esta operación
     * no tiene efecto.
     * </p>
     *
     * @throws SecuenciaNoModificableException si la implementación es de solo lectura
     *                                         y no permite la modificación (inversión).
     */
    void invertir();
}


