package ar.unrn.secuencias.interfaces;

/**
 * Define el contrato para objetos que actúan como Observadores dentro del
 * patrón de diseño Observer. Un Observador se registra con un sujeto
 * {@link Observable} para ser notificado de los cambios en el estado de dicho sujeto.
 * <p>
 * La principal responsabilidad de una clase que implementa esta interfaz es
 * proveer una implementación para el método {@link #actualizar(Observable, int)},
 * el cual es invocado por el sujeto observable cuando ocurre un cambio relevante
 * en su estado.
 * </p>
 * <p>
 * <b>Contrato General del Observador:</b>
 * <ul>
 *   <li>Un observador se suscribe a un {@link Observable} para recibir notificaciones.</li>
 *   <li>Cuando el estado del {@link Observable} cambia de una manera significativa
 *       (según lo definido por el {@link Observable}), este notificará a todos
 *       sus observadores registrados invocando su método {@code actualizar}.</li>
 *   <li>El observador, al recibir la notificación, es responsable de tomar las
 *       acciones apropiadas en respuesta al cambio.</li>
 * </ul>
 * </p>
 *
 * @param <T> El tipo de los elementos contenidos en el sujeto {@link Observable}
 *            que este observador está monitoreando.
 * @see Observable
 */
public interface Observador<T> {
    /**
     * Método llamado para notificar al observador de un cambio en el sujeto observable.
     *
     * @param observable El sujeto observable que notifica el cambio.
     * @param indice     El índice del elemento que ha cambiado.
     */
    void actualizar(Observable<T> observable, int indice);
}