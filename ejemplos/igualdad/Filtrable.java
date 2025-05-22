package ar.unrn.igualdad;

/**
 * Representa un objeto que puede filtrar a otro.
 * <p>
 * La idea de esta interfaz es implementar código de filtrado como clase interna para
 * determinar si una instancia de la clase externa cumple con algún criterio específico.
 * </p>
 * <p>
 * Implementaciones de esta interfaz deben proporcionar una lógica clara y
 * consistente en el método {@link #filtra()}, retornando {@code true} si el objeto
 * cumple con el criterio de filtrado y {@code false} en caso contrario.
 * </p>
 */
public interface Filtrable {

    /**
     * Aplica el filtro al objeto y determina si cumple con el criterio.
     *
     * @return {@code true} si el objeto cumple con el criterio de filtrado,
     * {@code false} en caso contrario.
     */
    boolean filtra();
}