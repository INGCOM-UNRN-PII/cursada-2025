package ar.unrn.igualdad;

/**
 * Representa un objeto que puede filtrar otros objetos de tipo T.
 *
 * <p>Esta interfaz está pensada para ser implementada como clase interna para
 * preservar al maximo el encapsulamiento y permitir la aplicacion de un criterio
 * de filtrado.</p>
 *
 * <p>Implementaciones de esta interfaz deben proporcionar una lógica clara y
 * consistente en el método {@link #filtra(Object)}, retornando {@code true} si el
 * objeto cumple con el criterio de filtrado y {@code false} en caso contrario.</p>
 *
 * @param <T> El tipo de objeto que este filtro puede evaluar.
 */
public interface Filtrator<T> {

    /**
     * Aplica el filtro al objeto y determina si cumple con el criterio.
     *
     * @param objeto El objeto de tipo T a evaluar.
     * @return {@code true} si el objeto cumple con el criterio de filtrado,
     * {@code false} en caso contrario.
     */
    boolean filtra(T objeto);
}