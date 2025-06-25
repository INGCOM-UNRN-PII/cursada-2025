package ar.unrn.secuencias.interfaces;

import ar.unrn.secuencias.excepciones.CapacidadExcedidaException;
import ar.unrn.secuencias.excepciones.ElementoNuloException;
import ar.unrn.secuencias.excepciones.EstructuraVaciaException;

/**
 * Define un contrato para colecciones de elementos que gestionan la adición y
 * remoción de elementos basada en una política de extremos, como es el caso
 * de las colas (FIFO) o las pilas (LIFO).
 * <p>
 * Esta interfaz proporciona las operaciones fundamentales para insertar un
 * elemento, extraer el elemento que corresponde ser procesado según la
 * política de la estructura (ej. el del frente en una cola, o el del tope
 * en una pila), y consultar dicho elemento sin alterar la estructura.
 * </p>
 * <p>
 * Las implementaciones de esta interfaz deben:
 * <ul>
 *   <li>Especificar claramente si se comportan como una cola (Primero en Entrar,
 *       Primero en Salir - FIFO), una pila (Último en Entrar, Primero en Salir - LIFO),
 *       u otra estructura con una política de acceso por extremos definida.</li>
 *   <li>Definir su política respecto a la admisión de elementos {@code null}.
 *       Si se intenta agregar un elemento {@code null} y la implementación no lo
 *       soporta, se debe lanzar {@link ElementoNuloException}.</li>
 *   <li>Indicar si la estructura posee una capacidad máxima. Si se intenta
 *       agregar un elemento a una estructura llena que no puede expandirse,
 *       se debe lanzar {@link CapacidadExcedidaException}.</li>
 *   <li>Si se intenta realizar una operación de remoción o consulta
 *       ({@link #remover()} o {@link #proximo()}) sobre una estructura vacía,
 *       se debe lanzar {@link EstructuraVaciaException}.</li>
 * </ul>
 * </p>
 *
 * @param <T> el tipo de los elementos contenidos en la estructura.
 * @see ElementoNuloException
 * @see CapacidadExcedidaException
 * @see EstructuraVaciaException
 */
public interface Dispensable<T> {

    /**
     * Inserta el elemento especificado en la estructura, de acuerdo con su
     * política de gestión de extremos.
     * <p>
     * Tras esta operación, el valor retornado por {@link #largo()} se
     * incrementará en uno.
     * </p>
     *
     * @param elemento el elemento a ser agregado a la estructura.
     *                 La admisibilidad de {@code null} depende de la implementación.
     * @throws ElementoNuloException      si {@code elemento} es {@code null} y la
     *                                    implementación no admite elementos nulos.
     * @throws CapacidadExcedidaException si la estructura ha alcanzado su capacidad
     *                                    máxima y no puede albergar nuevos elementos.
     */
    void agregar(T elemento);

    /**
     * Extrae y retorna el elemento que se encuentra en la posición de dispensa
     * de la estructura, según su política operativa (FIFO o LIFO).
     * <p>
     * Tras esta operación, el valor retornado por {@link #largo()} se
     * decrementará en uno.
     * </p>
     *
     * @return el elemento dispensado de la estructura.
     * @throws EstructuraVaciaException si se invoca sobre una estructura vacía.
     */
    T remover();

    /**
     * Retorna, sin remover, el elemento que se encuentra en la posición de
     * dispensa de la estructura (es decir, el elemento que sería retornado
     * por una invocación subsecuente a {@link #remover()}).
     * <p>
     * Esta operación no modifica el estado ni el tamaño de la estructura.
     * </p>
     *
     * @return el próximo elemento a ser dispensado.
     * @throws EstructuraVaciaException si se invoca sobre una estructura vacía.
     */
    T proximo();

    /**
     * Retorna el número de elementos actualmente contenidos en la estructura.
     *
     * @return la cantidad de elementos presentes en la estructura;
     * cero si la estructura está vacía.
     */
    int largo();

    /**
     * Verifica si la estructura no contiene elementos.
     * <p>
     * Esta operación es equivalente a comprobar si {@code largo() == 0}.
     * </p>
     *
     * @return {@code true} si la estructura está vacía, {@code false} en caso contrario.
     */
    boolean estaVacia();
}