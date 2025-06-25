package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.CapacidadExcedidaException;
import ar.unrn.secuencias.excepciones.ElementoNuloException;
import ar.unrn.secuencias.excepciones.IndiceFueraDeRangoException;

/**
 * Define un contrato para secuencias de elementos que, además de ser accesibles
 * y modificables por índice (heredado de {@link Indexable}), también pueden
 * expandir o contraer su tamaño dinámicamente mediante la adición y remoción
 * de elementos.
 * <p>
 * Tengan en cuenta que es posible implementar esta interfaz con un tope de,
 * capacidad, por lo que las operaciones de agregado pueden fallar.
 * </p>
 * <p>
 * Esta interfaz extiende {@link Indexable}, por lo que todas las consideraciones
 * y contratos de {@code Indexable} (como el uso de índice base cero y el manejo
 * de {@link Indexable#largo()}) también aplican aquí.
 * </p>
 * <p>
 * Las implementaciones de {@code Expandable} típicamente representarán estructuras
 * de datos como listas dinámicas o arreglos que pueden redimensionarse.
 * La política específica sobre cómo se maneja la capacidad interna (si existe
 * una distinción entre capacidad y tamaño lógico) es responsabilidad de la
 * clase implementadora.
 * </p>
 * <p>
 * Al igual que con {@code Indexable}, las implementaciones deben ser claras
 * sobre su política de elementos {@code null}. Si se intenta agregar un elemento
 * {@code null} y no está permitido, se podría lanzar una excepción personalizada
 * (ej. {@code ElementoNuloException} o {@code ElementoInvalidoException}).
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia expandible.
 * @see Indexable
 */
public interface Expandable<T> extends Indexable<T> {

    /**
     * Agrega el elemento especificado al final de esta secuencia.
     * <p>
     * Después de esta operación, el {@link #largo()} de la secuencia se incrementará
     * en uno, y el nuevo elemento estará accesible en el índice {@code largo() - 1}
     * (considerando el nuevo largo).
     * </p>
     * <p>
     * Si la implementación tiene una capacidad máxima y esta se alcanza,
     * el comportamiento dependerá de la implementación: podría intentar
     * expandir su capacidad interna o podría lanzar una excepción si no puede
     * crecer más (ej. {@code CapacidadExcedidaException} o {@code SecuenciaLlenaException}).
     * </p>
     *
     * @param valor el elemento a ser agregado a la secuencia. Puede ser {@code null}
     *              si la implementación específica lo permite.
     * @throws ElementoNuloException      si {@code valor} es {@code null} y la
     *                                    implementación no permite elementos nulos.
     * @throws CapacidadExcedidaException si la secuencia tiene una capacidad fija
     *                                    y no puede ser expandida para acomodar
     *                                    el nuevo elemento.
     *                                    (Esta sería una excepción opcional).
     */
    void agregar(T valor);

    /**
     * Remueve el elemento en la posición especificada de esta secuencia.
     * <p>
     * Los elementos subsecuentes (si los hay) se desplazan hacia la izquierda
     * (sus índices disminuyen en uno). Después de esta operación, el
     * {@link #largo()} de la secuencia se decrementará en uno.
     * </p>
     * <p>
     * Si la secuencia está vacía antes de la llamada, o si el índice está fuera
     * del rango válido {@code [0, largo() - 1]}, se lanzará una
     * {@code IndiceFueraDeRangoException}.
     * </p>
     *
     * @param indice el índice base cero del elemento a ser removido.
     *               Debe estar en el rango {@code [0, largo() - 1]}.
     * @return el elemento que fue removido de la secuencia.
     * @throws IndiceFueraDeRangoException si el {@code indice} es negativo o si es
     *                                     mayor o igual al {@link #largo()} actual
     *                                     de la secuencia.
     */
    T remover(int indice);
}