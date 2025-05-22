package ar.unrn.calculadora;

import ar.unrn.calculadora.Operacion;

/**
 * Clase abstracta que sirve como base para todas las operaciones aritméticas unarias
 * dentro de la calculadora, como podrían ser {@code Negacion} (cambio de signo),
 * {@code RaizCuadrada}, {@code Factorial}, etc. (aunque no todas estas
 * estén implementadas actualmente en el proyecto).
 * <p>
 * Esta clase extiende {@link Operacion} y encapsula la lógica común a las operaciones
 * que requieren un único operando (referido como {@link #valor}). Define la estructura
 * para almacenar este operando y el símbolo textual del operador.
 * </p>
 * <p>
 * En el contexto del patrón Composite, {@code OperacionUnaria} actúa como un nodo
 * compuesto que tiene un único hijo (el operando {@link #valor}).
 * Por ejemplo, una expresión como "Negacion(5)" o "RaizCuadrada((3 + 1))" se
 * representaría con:
 * <ul>
 *     <li>Una instancia de una subclase de {@code OperacionUnaria} (ej. {@code Negacion}) como raíz.</li>
 *     <li>Esta instancia contendría una referencia a su único operando {@link #valor}, que puede ser:
 *         <ul>
 *             <li>Un {@code Numero(5)} en el primer caso.</li>
 *             <li>Una {@code Suma} (que es una {@link ar.unrn.calculadora.binarias.OperacionBinaria})
 *                 con operandos {@code Numero(3)} y {@code Numero(1)} en el segundo caso.</li>
 *         </ul>
 *     </li>
 * </ul>
 * </p>
 * <p>
 * Las subclases concretas son responsables de:
 * <ol>
 *     <li>Pasar el símbolo específico del operador (ej. "-", "√", "!")
 *         al constructor de esta clase base ({@link #OperacionUnaria(String, Operacion)}).</li>
 *     <li>Implementar el método {@link Operacion#calcular()} para definir la lógica
 *         aritmética específica de esa operación (ej. cómo negar, calcular la raíz cuadrada, etc.,
 *         del resultado de {@code valor.calcular()}).</li>
 * </ol>
 * Esta clase proporciona una implementación genérica del método {@link #toString()}
 * que formatea la expresión unaria de manera estándar.
 * </p>
 *
 * @see Operacion
 * @see Negacion (Ejemplo de subclase si existiera)
 * @see RaizCuadrada (Ejemplo de subclase si existiera)
 */
public abstract class OperacionUnaria extends Operacion {
    /**
     * Representa el único operando de la operación unaria.
     * <p>
     * Este es el valor sobre el cual actúa el operador unario.
     * Puede ser cualquier instancia de {@link Operacion}, permitiendo anidar
     * expresiones complejas (ej. el operando de una negación podría ser
     * una suma, una multiplicación, u otro número).
     * </p>
     */
    protected Operacion valor;
    /**
     * Cadena de texto que representa el símbolo del operador aritmético unario.
     * Este va de forma prefija al Operacion.
     */
    protected String operador;

    /**
     * Constructor para crear un objeto de tipo {@code OperacionUnaria}.
     * Inicializa el operando único de la operación y el símbolo del operador.
     * <p>
     * Las subclases que hereden de {@code OperacionUnaria} deben llamar a este
     * constructor (usando {@code super(simbolo, valor)}) para proporcionar el
     * símbolo que las identifica y el operando sobre el cual actuarán.
     * </p>
     * <p>
     * Ejemplo en una subclase {@code Negacion}:
     * <pre>{@code
     * public class Negacion extends OperacionUnaria {
     *     public Negacion(Operacion valor) {
     *         super("-", valor); // Llama al constructor de OperacionUnaria con el símbolo y el valor
     *     }
     *     // ... implementación de calcular() ...
     * }
     * }</pre>
     * </p>
     *
     * @param simboloOperando El símbolo textual que representa a esta operación unaria (ej. "-", "sqrt").
     *                        No debe ser {@code null}.
     * @param valor           La {@link Operacion} que actuará como el único operando.
     *                        No debe ser {@code null}.
     */
    protected OperacionUnaria(String simboloOperando, Operacion valor) {
        super();
        this.valor = valor;
        this.operador = simboloOperando;
    }

    /**
     * Genera una representación textual de la operación unaria.
     * El formato estándar es {@code "operador(representación_del_valor)"}.
     * <p>
     * Este método invoca recursivamente {@code toString()} en el operando {@link #valor}
     * y utiliza el valor del campo {@link #operador} para construir la cadena.
     * </p>
     * <p>
     * Ejemplos de salida según la subclase (asumiendo que el operando es un número simple
     * o una expresión ya formateada):
     * <ul>
     *     <li>Para una {@code Negacion} con operando 5: {@code "-(5)"} (si el operador es "-")</li>
     *     <li>Para una {@code RaizCuadrada} con operando 9: {@code "sqrt(9)"} (si el operador es "sqrt")</li>
     * </ul>
     * Si el operando {@link #valor} es una expresión más compleja, esta también se representará
     * dentro de los paréntesis, por ejemplo: {@code "-( (1 + 2) )"}.
     * </p>
     *
     * @return Una cadena de caracteres que representa la operación unaria,
     * incluyendo su operador y la representación de su operando.
     */
    @Override
    public String toString() {
        return String.format("%s(%s)", operador, valor);
    }

}
