package ar.unrn.calculadora;

import ar.unrn.calculadora.binarias.Resta;
import ar.unrn.calculadora.binarias.Suma;
import ar.unrn.calculadora.multiples.SumaMultiple;
import ar.unrn.calculadora.unarias.Invertir;

/**
 * Clase abstracta que representa el componente base en una estructura de árbol
 * para expresiones aritméticas, siguiendo el patrón de diseño Composite.
 * <p>
 * Esta clase define la interfaz común para todas las operaciones (tanto
 * operaciones simples/terminales como {@code Numero}, como operaciones compuestas
 * que agrupan otras operaciones, por ejemplo {@code Suma}, {@code Resta}, etc.).
 * </p>
 * <p>
 * En el contexto de este proyecto de calculadora, {@code Operacion} permite
 * construir expresiones matemáticas complejas como un árbol. Cada nodo del árbol
 * es una instancia de una subclase de {@code Operacion}.
 * Por ejemplo, la expresión "(5 + 3) * 2" se representaría como un árbol donde:
 * <ul>
 *     <li>La raíz es una operación de Multiplicación.</li>
 *     <li>El operando izquierdo de la Multiplicación es una operación de Suma.</li>
 *     <li>Los operandos de la Suma son operaciones de Número (5 y 3).</li>
 *     <li>El operando derecho de la Multiplicación es una operación de Número (2).</li>
 * </ul>
 * </p>
 * <p>
 * El cliente (la calculadora) interactuará con la raíz de este árbol de operaciones
 * para calcular el resultado final de la expresión y para obtener su representación
 * en formato de texto.
 * </p>
 *
 * @see Numero
 * @see Suma
 * @see Resta
 * @see Invertir
 * @see SumaMultiple
 */
public abstract class Operacion {

    /**
     * Calcula y devuelve el resultado numérico de la operación o sub-expresión
     * representada por esta instancia.
     * <p>
     * Cada subclase concreta (como {@code Numero}, {@code Suma}, {@code Resta})
     * debe implementar este método para definir cómo se calcula su valor específico.
     * En el caso de operaciones compuestas (como {@code Suma}), esta implementación
     * típicamente implicará llamar recursivamente al método {@code calcular()}
     * de sus operaciones hijas (operandos) y combinar sus resultados.
     * </p>
     * <p>
     * Por ejemplo:
     * <ul>
     *     <li>Para un {@code Numero}, {@code calcular()} devolvería el valor numérico almacenado.</li>
     *     <li>Para una {@code Suma}, {@code calcular()} devolvería la suma de los resultados
     *         de {@code calcular()} de su operando izquierdo y su operando derecho.</li>
     * </ul>
     * </p>
     *
     * @return El resultado de la evaluación de esta operación, como un valor de tipo {@code long}.
     * Se utiliza {@code long} para permitir un rango más amplio de números enteros.
     * @throws AritmeticaException si ocurre un error aritmético durante el cálculo,
     *                             como una división por cero en una subclase {@code Division}.
     */
    public abstract long calcular();

    /**
     * Devuelve una representación en formato {@code String} de la operación o
     * sub-expresión matemática que esta instancia representa.
     * <p>
     * Este método es útil para propósitos de depuración, para mostrar la expresión
     * al usuario, o para registrar la estructura de la operación.
     * Cada subclase concreta debe implementar este método para proporcionar una
     * representación textual adecuada.
     * </p>
     * <p>
     * Por ejemplo:
     * <ul>
     *     <li>Para un {@code Numero(5)}, {@code toString()} podría devolver "5".</li>
     *     <li>Para una {@code Suma} con operandos que representan "3" y "4",
     *         {@code toString()} podría devolver "(3 + 4)".</li>
     * </ul>
     * El formato exacto (por ejemplo, el uso de paréntesis) dependerá de la
     * implementación específica en las subclases para asegurar la correcta
     * representación de la precedencia y asociatividad de las operaciones.
     * </p>
     *
     * @return Una cadena de texto que representa la estructura de la operación matemática.
     */
    public abstract String toString();
}
