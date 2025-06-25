package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.IndiceFueraDeRangoException;

/**
 * Define un contrato para secuencias de elementos que, además de ser accesibles
 * por índice (heredado de {@link Indexable}), permiten obtener sub-secuencias
 * o "vistas" de una porción de la secuencia original.
 * <p>
 * Esta interfaz extiende {@link Indexable}, por lo que todas las consideraciones
 * y contratos de {@code Indexable} (como el uso de índice base cero y el manejo
 * de {@link Indexable#largo()}) también aplican aquí.
 * </p>
 * <p>
 * La operación de subdivisión permite trabajar con partes específicas de la
 * secuencia sin necesidad de crear copias completas (aunque la implementación
 * podría optar por retornar copias).
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la secuencia subdivisible.
 * @see Indexable
 * @see IndiceFueraDeRangoException
 */
public interface Subdivisible<T> extends Indexable<T> {

    /**
     * Retorna una {@link Indexable} que representa la porción de esta secuencia
     * entre el {@code indiceDesde} (inclusivo) y el {@code indiceHasta} (exclusivo).
     * <p>
     * Si {@code indiceDesde} y {@code indiceHasta} son iguales, la sub-secuencia
     * resultante estará vacía (su {@code largo()} será 0).
     * </p>
     * <p>
     * Los índices deben cumplir la condición: {@code 0 <= indiceDesde <= indiceHasta <= largo()}.
     * Si esta condición no se cumple, se lanzará una {@code IndiceFueraDeRangoException}.
     * </p>
     * <p>
     * <strong>Comportamiento de la sub-secuencia (Vista vs. Copia):</strong>
     * Las implementaciones deben documentar claramente si la {@link Indexable}
     * retornada es una <strong>vista</strong> respaldada por esta secuencia
     * (donde las modificaciones en la vista se reflejan en la original y viceversa)
     * o si es una <strong>copia independiente</strong> (donde las modificaciones
     * en una no afectan a la otra). El comportamiento de vista es más común y
     * eficiente, pero requiere cuidado con las modificaciones estructurales
     * en la secuencia original (como agregar o remover elementos si implementa
     * {@link Expandable}), ya que podrían invalidar la vista.
     * </p>
     *
     * @param indiceDesde el índice inicial de la sub-secuencia (inclusivo).
     *                    Debe ser no negativo y menor o igual a {@code indiceHasta}.
     * @param indiceHasta el índice final de la sub-secuencia (exclusivo).
     *                    Debe ser menor o igual a {@code largo()}.
     * @return una {@link Indexable} que representa la porción especificada de esta secuencia.
     * @throws IndiceFueraDeRangoException si los índices están fuera del rango válido
     *                                     o si {@code indiceDesde > indiceHasta}.
     */
    Indexable<T> subSecuencia(int indiceDesde, int indiceHasta);
}
