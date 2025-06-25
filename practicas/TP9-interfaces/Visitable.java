package ar.unrn.secuencias.interfaces;

/**
 * Define el contrato para objetos o estructuras que pueden ser "visitados"
 * por un objeto {@link Visitor}. Esta interfaz es un componente fundamental
 * del patrón de diseño Visitor, que permite añadir nuevas operaciones a una
 * jerarquía de objetos sin modificar las clases de dichos objetos.
 * <p>
 * Un objeto {@code Visitable} se encarga de "aceptar" un {@link Visitor} y
 * dirigirlo para que realice su operación. Esto se logra típicamente mediante
 * un mecanismo de doble despacho: el {@code Visitable} invoca un método
 * específico en el {@code Visitor} (usualmente sobrecargado para el tipo
 * concreto del {@code Visitable} o del elemento actual), pasándose a sí mismo
 * o a sus elementos como argumento. De esta manera, la operación correcta
 * se selecciona dinámicamente tanto por el tipo del {@code Visitable} como
 * por el tipo del {@code Visitor}.
 * </p>
 * <p>
 * <b>Contrato General del Visitable:</b>
 * <ul>
 *   <li><b>Aceptación del Visitante:</b> Debe proveer un método (generalmente
 *       denominado {@code aceptar} o, como en este caso, {@link #visitar(Visitor)})
 *       que permita a un {@link Visitor} iniciar su operación sobre el
 *       objeto visitable o sus componentes.</li>
 *   <li><b>Control de Travesía (para estructuras compuestas):</b> Si el
 *       {@code Visitable} es una estructura que contiene múltiples elementos
 *       (que pueden ser de tipo {@code T} o ellos mismos {@code Visitable}),
 *       es responsabilidad del {@code Visitable} controlar la iteración sobre
 *       estos elementos. Debe asegurar que el {@code Visitor} sea aceptado por cada
 *       uno de ellos, o que el {@code Visitor} reciba cada elemento para su
 *       procesamiento, según la estrategia definida por la implementación
 *       concreta del {@code Visitable} y la interfaz del {@code Visitor}.</li>
 *   <li><b>Provisión de Contexto:</b> Al invocar al {@code Visitor}, el
 *       {@code Visitable} debe proveer el contexto necesario para que el
 *       {@code Visitor} pueda realizar su tarea. Esto usualmente implica
 *       pasar una referencia al elemento actual de tipo {@code T} que está
 *       siendo visitado o, si el {@code Visitable} es en sí mismo el elemento
 *       de interés, una referencia a sí mismo.</li>
 *   <li><b>Desacoplamiento:</b> El {@code Visitable} no debe tener conocimiento
 *       de la operación concreta que el {@code Visitor} realizará. Su única
 *       responsabilidad es guiar al {@code Visitor} a través de su estructura
 *       o elementos, permitiendo que el {@code Visitor} aplique su lógica.</li>
 * </ul>
 * </p>
 *
 * @param <T> El tipo de los elementos que el {@link Visitor} está diseñado para
 *            procesar. Un objeto {@code Visitable} que maneja o representa
 *            elementos de este tipo {@code T} se los pasará al {@code Visitor}
 *            (típicamente al método {@code visita(T elemento)} del {@code Visitor}).
 *            Si el {@code Visitable} es en sí mismo un elemento simple de tipo {@code T},
 *            entonces se pasará a sí mismo.
 * @see Visitor
 */
public interface Visitable<T> {
    /**
     * Acepta un {@link Visitor} y le permite realizar una operación sobre
     * este objeto visitable o sobre los elementos de tipo {@code T} que contiene,
     * representa o gestiona.
     * <p>
     * Este método es el punto de entrada para el patrón Visitor. La
     * implementación de este método en una clase concreta típicamente
     * invoca un método apropiado en la interfaz del {@code Visitor} (por ejemplo,
     * {@code visitor.visita(this)} si el objeto actual es el elemento a visitar,
     * o itera sobre sus componentes y llama a {@code visitor.visita(componente)}
     * para cada uno).
     * </p>
     * <p>
     * El tipo del parámetro {@code visitor} es {@code Visitor<T, ?>}. Esto significa
     * que el {@code Visitable} espera un {@code Visitor} que pueda operar sobre
     * elementos de tipo {@code T}, pero no le importa el tipo de resultado
     * (representado por el comodín {@code ?}) que el {@code Visitor} pueda producir.
     * </p>
     *
     * @param visitor El visitante que realizará la operación. Debe ser capaz de
     *                procesar elementos de tipo {@code T}.
     */
    void visitar(Visitor<T, ?> visitor);
}