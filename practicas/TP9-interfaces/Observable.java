package ar.unrn.secuencias.interfaces;

/**
 * Define el contrato para objetos que actúan como Sujetos (o "Observables")
 * dentro del patrón de diseño Observer. Un Sujeto Observable mantiene una lista
 * de dependientes, llamados {@link Observador}es, que les avisa de cualquier cambio
 * en su estado.
 * <p>
 * Esta interfaz extiende {@link Indexable}, lo que implica que el estado
 * observable es una secuencia de elementos accesibles por índice. Los cambios
 * en esta secuencia (ej. modificación de un elemento, adición o remoción si
 * también implementa {@link Expandable}) son los que típicamente dispararán
 * las notificaciones a los observadores.
 * </p>
 * <p>
 * <b>Contrato General del Observable:</b>
 * <ul>
 *   <li><b>Gestión de Observadores:</b> Debe permitir el registro ({@link #addObserver})
 *       y la anulación del registro ({@link #removeObserver}) de objetos {@link Observador}.</li>
 *   <li><b>Notificación de Cambios:</b> Cuando el estado interno del {@code Observable}
 *       cambia de una manera significativa, este es responsable de invocar
 *       {@link #notificarObservadores(int)} para informar a todos los observadores
 *       registrados.</li>
 *   <li><b>Consistencia del Estado:</b> Se espera que el estado del {@code Observable}
 *       sea consistente y refleje el cambio reportado <em>antes</em> de que se
 *       invoque {@code notificarObservadores}. Los observadores deben poder
 *       consultar el estado actualizado del {@code Observable} durante la
 *       invocación de su método {@code actualizar}.</li>
 *   <li><b>Manejo de Nulos:</b> Las implementaciones deben definir y documentar
 *       su política respecto a pasar un {@code Observador} nulo a
 *       {@code addObserver} o {@code removeObserver}. Comúnmente, se lanza
 *       {@link NullPointerException} o se ignora la operación.</li>
 *   <li><b>Duplicados:</b> Las implementaciones deben definir y documentar
 *       su política respecto a agregar un observador que ya está registrado.
 *       Comúnmente, se ignora la adición duplicada o se asegura que solo
 *       exista una instancia del observador en la lista.</li>
 * </ul>
 * </p>
 *
 * @param <T> El tipo de los elementos contenidos en la secuencia observable.
 * @see Observador
 * @see Indexable
 */
public interface Observable<T> extends Indexable<T> {
    /**
     * Añade un observador a la lista de observadores.
     *
     * @param observador El observador que será añadido.
     */
    void addObserver(Observador<T> observador);

    /**
     * Elimina un observador de la lista de observadores.
     *
     * @param observador El observador que será eliminado.
     */
    void removeObserver(Observador<T> observador);

    /**
     * Notifica a todos los observadores sobre un cambio en el sujeto observable.
     *
     * @param indice El índice del elemento que ha cambiado, o cualquier otro
     *               dato relevante para los observadores.
     */
    void notificarObservadores(int indice);
}