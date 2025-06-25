package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.ComparadorNuloException;
import ar.unrn.secuencias.excepciones.ElementoNuloException;

import java.util.Comparator;

/**
 * Define un contrato para secuencias de elementos que, además de ser accesibles
 * por índice (heredado de {@link Indexable}), también pueden ser ordenadas.
 * <p>
 * Esta interfaz extiende {@link Indexable} y requiere que el tipo de los
 * elementos {@code T} implemente la interfaz {@link Comparable}. Esto permite
 * un ordenamiento "natural" de los elementos. Adicionalmente, proporciona
 * un método para ordenar la secuencia utilizando un {@link Comparator} externo,
 * lo que ofrece flexibilidad para definir criterios de ordenamiento personalizados.
 * </p>
 * <p>
 * Las implementaciones de esta interfaz deberán proporcionar la lógica para
 * reorganizar los elementos dentro de la secuencia según el criterio de ordenamiento
 * especificado. El algoritmo de ordenamiento específico (ej. BubbleSort, MergeSort,
 * QuickSort, etc.) queda a discreción de la clase implementadora.
 * </p>
 * <p>
 * Después de una operación de ordenamiento, los elementos dentro de la secuencia
 * estarán reorganizados, pero el {@link #largo()} de la secuencia permanecerá
 * inalterado. Los elementos seguirán siendo accesibles mediante sus nuevos índices.
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia ordenable.
 *            Este tipo debe implementar {@link Comparable} para soportar
 *            el ordenamiento natural.
 * @see Indexable
 * @see Comparable
 * @see Comparator
 */
public interface Ordenable<T extends Comparable<T>> extends Indexable<T> {

    /**
     * Ordena los elementos de esta secuencia de acuerdo con su orden natural,
     * definido por la implementación de {@link Comparable#compareTo(Object)}
     * en el tipo de elemento {@code T}.
     * <p>
     * Se espera que el ordenamiento sea ascendente por defecto, a menos que la
     * semántica de {@code compareTo} para el tipo {@code T} indique lo contrario.
     * </p>
     * <p>
     * Si la secuencia contiene elementos {@code null} y el método {@code compareTo}
     * de los elementos no los maneja (o si la implementación del algoritmo de
     * ordenamiento no lo hace), podría resultar en una {@code NullPointerException}
     * o una excepción personalizada (ej. {@code ElementoNuloNoOrdenableException}).
     * Las implementaciones deben documentar su comportamiento frente a elementos nulos
     * durante el ordenamiento.
     * </p>
     *
     * @throws ElementoNuloException si la secuencia contiene elementos nulos
     *                               y el algoritmo o el tipo {@code T} no
     *                               pueden manejarlos durante la comparación.
     */
    void ordenar();

    /**
     * Ordena los elementos de esta secuencia de acuerdo con el orden inducido
     * por el {@link Comparator} especificado.
     * <p>
     * Este método permite definir criterios de ordenamiento personalizados que
     * pueden diferir del orden natural de los elementos.
     * </p>
     * <p>
     * Si el comparador es {@code null}, el comportamiento es indefinido y podría
     * resultar en una {@code NullPointerException} o una excepción personalizada
     * (ej. {@code ComparadorNuloException}). Idealmente, las implementaciones
     * deberían manejar este caso, por ejemplo, recurriendo al orden natural si
     * el comparador es nulo, o lanzando una excepción clara.
     * </p>
     * <p>
     * Al igual que con el ordenamiento natural, el manejo de elementos {@code null}
     * dentro de la secuencia dependerá de cómo el {@code Comparator} proporcionado
     * los trate. Si el comparador no maneja nulos, podría lanzarse una
     * {@code NullPointerException}.
     * </p>
     *
     * @param comparador el {@link Comparator} que se utilizará para determinar el
     *                   orden de los elementos. Si es {@code null}, el comportamiento
     *                   debe ser documentado por la implementación (podría usar el
     *                   orden natural o lanzar una excepción).
     * @throws ComparadorNuloException si se provee un {@code comparador} nulo y la
     *                                 implementación decide no recurrir al orden natural
     *                                 y en su lugar lanzar una excepción.
     * @throws ElementoNuloException   si la secuencia contiene elementos nulos
     *                                 y el {@code comparador} no puede manejarlos.
     */
    void ordenar(Comparator<? super T> comparador);
}