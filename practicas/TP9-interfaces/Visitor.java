package ar.unrn.secuencias.interfaces;

/**
 * Define el contrato para objetos que actúan como Visitantes dentro del patrón
 * de diseño Visitor. Un Visitante encapsula una operación que se realizará
 * sobre los elementos de una estructura de objetos (implementadores de
 * {@link Visitable}).
 * <p>
 * Esta interfaz permite definir nuevas operaciones sobre una estructura de
 * objetos sin modificar las clases de dichos objetos. El {@link Visitable}
 * "acepta" al {@code Visitor} y le delega la ejecución de la operación
 * específica para el tipo de elemento que está siendo visitado.
 * </p>
 * <p>
 * <b>Contrato General del Visitor:</b>
 * <ul>
 *   <li><b>Encapsulación de Operaciones:</b> Cada implementación concreta de
 *       {@code Visitor} representa una operación lógica distinta que se puede
 *       aplicar a los elementos de tipo {@code T}.</li>
 *   <li><b>Interacción con {@link Visitable}:</b> Un {@code Visitor} es pasado
 *       a un objeto {@link Visitable} a través de su método {@code visitar}
 *       (o un método similar como {@code aceptar}). El {@code Visitable} es
 *       entonces responsable de invocar el método apropiado de este
 *       {@code Visitor} (generalmente {@link #visita(Object)} o un método más
 *       específico si la jerarquía de {@code Visitable}s es compleja y se usa
 *       sobrecarga de métodos en el {@code Visitor}).</li>
 *   <li><b>Estado y Resultado:</b> Un {@code Visitor} puede mantener un estado
 *       interno que acumula información o resultados a medida que visita
 *       diferentes elementos de la estructura. El método {@link #resultado()}
 *       permite obtener el resultado final de la operación tras la visita.</li>
 *   <li><b>Desacoplamiento:</b> El {@code Visitor} opera sobre los elementos
 *       que le son pasados por el {@code Visitable}, sin necesidad de conocer
 *       la estructura interna completa del {@code Visitable} (más allá de los
 *       elementos individuales que procesa).</li>
 * </ul>
 * </p>
 * <p>
 * Para jerarquías de elementos más complejas, donde existen múltiples tipos
 * concretos de elementos visitables, la interfaz {@code Visitor} a menudo
 * define múltiples métodos {@code visita} sobrecargados (e.g.,
 * {@code visita(ElementoConcretoA a)}, {@code visita(ElementoConcretoB b)}).
 * En este caso, el parámetro genérico {@code <T>} representaría un tipo base
 * común para todos los elementos visitables, y el método {@link #visita(Object)}
 * aquí presente serviría como un método genérico o de fallback si no se
 * utiliza la sobrecarga específica. El tipo {@code <R>} seguiría representando
 * el tipo del resultado global de la operación del visitante.
 * </p>
 *
 * @param <T> El tipo de los elementos que este {@code Visitor} está diseñado
 *            para procesar.
 * @param <R> El tipo del resultado que este {@code Visitor} produce tras
 *            procesar los elementos.
 * @see Visitable
 */
public interface Visitor<T, R> {
    /**
     * Realiza una operación específica, definida por la implementación concreta
     * de este {@code Visitor}, sobre el elemento proporcionado.
     * <p>
     * Este método es invocado por un objeto {@link Visitable} como parte del
     * proceso de "aceptación" del visitante. El {@link Visitable} pasa una
     * referencia a uno de sus elementos (o a sí mismo si es un elemento simple)
     * para que el {@code Visitor} pueda actuar sobre él. La ejecución de este
     * método puede modificar el estado interno del {@code Visitor}, contribuyendo
     * al resultado final que se obtendrá mediante {@link #resultado()}.
     * </p>
     *
     * @param elemento El elemento de tipo {@code T} que será visitado.
     *                 Las implementaciones deben definir cómo se procesa este
     *                 elemento y cómo afecta al estado acumulado del visitante.
     */
    void visita(T elemento);

    /**
     * Retorna el resultado acumulado o calculado por el {@code Visitor} después
     * de que ha visitado uno o más elementos.
     * <p>
     * Este método se invoca típicamente después de que la estructura de objetos
     * (o los elementos de interés) ha sido recorrida y visitada. El valor
     * retornado es del tipo {@code R}, que representa el producto final de la
     * operación encapsulada por este {@code Visitor}.
     * </p>
     * <p>
     * El estado que contribuye a este resultado se actualiza a través de las
     * llamadas al método {@link #visita(Object)}. Si no se ha visitado ningún
     * elemento, el comportamiento de este método (e.g., retornar un valor
     * por defecto, un estado inicial o lanzar una excepción) debe ser
     * definido por la implementación concreta.
     * </p>
     *
     * @return El resultado de tipo {@code R} de la operación del visitante.
     */
    R resultado();
}