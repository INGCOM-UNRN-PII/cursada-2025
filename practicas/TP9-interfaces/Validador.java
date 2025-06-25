package ar.unrn.secuencias.interfaces;

/**
 * Define un contrato para objetos que pueden validar si un elemento de tipo {@code T}
 * cumple con ciertos criterios o reglas predefinidas.
 * <p>
 * Esta interfaz es genérica y permite la creación de diversas estrategias de validación
 * que pueden ser aplicadas a elementos antes de ser procesados, almacenados o
 * utilizados en alguna operación.
 * </p>
 * <p>
 * Las implementaciones de esta interfaz son responsables de definir la lógica
 * específica que determina la validez de un elemento. Por ejemplo, una
 * implementación podría verificar si un número está dentro de un rango, si una
 * cadena de texto no es nula o vacía, o si un objeto cumple con un conjunto
 * complejo de reglas de negocio.
 * </p>
 * <p>
 * El contrato principal se centra en el método {@link #esValido(Object)}, el cual
 * debe retornar {@code true} si el elemento cumple con los criterios de validación
 * y {@code false} en caso contrario. Las implementaciones deben ser consistentes
 * y, para una misma entrada y estado del validador (si lo tuviera), siempre
 * deberían retornar el mismo resultado.
 * </p>
 * <p>
 * Se espera que las implementaciones manejen adecuadamente los elementos {@code null}
 * pasados al método {@link #esValido(Object)}. La política sobre si un {@code null}
 * es considerado válido o no, o si debe lanzar una excepción (aunque no es parte
 * del contrato de este método, que solo retorna boolean), debe ser documentada
 * por cada implementación específica. Si una implementación no puede manejar
 * {@code null} y no está definido como un caso válido/inválido, debiera de
 * lanzar una excepción propia aunque el contrato de {@code esValido} solo
 * espera un booleano.
 * </p>
 *
 * @param <T> el tipo de elemento que este validador puede evaluar.
 */
public interface Validador<T> {

    /**
     * Evalúa si el elemento proporcionado cumple con los criterios de validación
     * definidos por la implementación de este validador.
     * <p>
     * No se espera que este método lance excepciones por invalidez, sino que
     * retorne {@code false}. Excepciones podrían surgir por errores
     * inesperados o si el parámetro {@code aValidar} es {@code null} y la
     * implementación no lo maneja explícitamente como válido/inválido.
     * </p>
     *
     * @param aValidar el elemento de tipo {@code T} que se desea validar.
     *                 Las implementaciones deben especificar cómo manejan un valor
     *                 {@code null} para este parámetro.
     * @return {@code true} si el elemento {@code aValidar} es considerado válido
     * según las reglas de esta implementación; {@code false} en caso contrario.
     */
    boolean esValido(T aValidar);
}
