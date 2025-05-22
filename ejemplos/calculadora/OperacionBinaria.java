package ar.unrn.calculadora;

import ar.unrn.calculadora.Operacion;

/**
 * Clase abstracta que sirve como base para todas las operaciones aritméticas binarias
 * dentro de la calculadora, como {@link Suma}, {@link Resta}, {@link Multiplicacion},
 * y {@link Division}.
 * <p>
 * Esta clase extiende {@link Operacion} y encapsula la lógica común a las operaciones
 * que requieren dos operandos (uno izquierdo y uno derecho). Define la estructura
 * para almacenar estos operandos y el símbolo textual del operador.
 * </p>
 * <p>
 * Las subclases concretas son responsables de:
 * <ol>
 *     <li>Proporcionar el símbolo específico del operador (ej. "+", "-", "*", "/")
 *         a través de la llamada al constructor
           ({@link #OperacionBinaria(String, Operacion, Operacion)}).</li>
 *     <li>Implementar el método {@link Operacion#calcular()} para definir la lógica
 *         aritmética específica de esa operación (ej. cómo sumar, restar, etc.,
 *         los resultados de {@code izquierda.calcular()} y {@code derecha.calcular()}).</li>
 * </ol>
 * Esta clase proporciona una implementación genérica del método {@link #toString()}
 * que formatea la expresión binaria de manera estándar, utilizando el operador
 * provisto por la subclase.
 * </p>
 *
 * @see Operacion
 * @see Suma
 * @see Resta
 * @see Multiplicacion
 * @see Division
 */
public abstract class OperacionBinaria extends Operacion {
    /**
     * Representa el operando izquierdo de la operación binaria.
     * Este es el primer término en una expresión como {@code (a operador b)}.
     * Puede ser cualquier instancia de {@link Operacion}, permitiendo anidar
     * expresiones complejas (ej. el operando izquierdo de una suma podría ser
     * otra suma o un número).
     */
    protected Operacion izquierda;

    /**
     * Representa el operando derecho de la operación binaria.
     * Este es el segundo término en una expresión como {@code (a operador b)}.
     * Al igual que {@link #izquierda}, puede ser cualquier instancia de {@link Operacion}.
     */
    protected Operacion derecha;

    /**
     * Cadena de texto que representa el símbolo del operador aritmético en estructura
     * 'infija', esto es, el operador en el medio de los operandos.
     */
    protected String operador;

    /**
     * Constructor para crear un objeto de tipo {@code OperacionBinaria}.
     * Inicializa los operandos izquierdo y derecho de la operación.
     * <p>
     * Las subclases que hereden de {@code OperacionBinaria} deben llamar a este
     * constructor (usando {@code super(simbolo, izquierdo, derecho)})
     * </p>
     *
     * @param operador  es el simbolo de la operacion aritmetica implementada
     *                  usado por {@link #toString()}.
     * @param izquierdo La {@link Operacion} que actuará como miembro izquierdo.
     *                  No debe ser {@code null}.
     * @param derecho   La {@link Operacion} que actuará como miembro derecho.
     *                  No debe ser {@code null}.
     * @throws NullPointerException si {@code izquierdo} o {@code derecho} son {@code null}
     *                              (aunque la validación explícita no está en este constructor,
     *                              se espera que los operandos sean válidos para el cálculo).
     */
    protected OperacionBinaria(String operador, Operacion izquierdo, Operacion derecho) {
        super();
        this.operador = operador;
        this.izquierda = izquierdo;
        this.derecha = derecho;
    }

    /**
     * Genera una representación textual de la operación binaria.
     * El formato estándar es {@code "(<representación_izquierda> <operador> <representación_derecha>)"}.
     * <p>
     * Este método invoca recursivamente {@code toString()} en los operandos izquierdo
     * y derecho, y utiliza el valor del campo {@link #operador} (que fue establecido
     * por la subclase concreta) para construir la cadena.
     * </p>
     * <p>
     * Ejemplos de salida según la subclase (asumiendo que los operandos son números simples):
     * <ul>
     *     <li>Para {@link Suma} con operandos 3 y 4: {@code "(3 + 4)"}</li>
     *     <li>Para {@link Resta} con operandos 7 y 2: {@code "(7 - 2)"}</li>
     *     <li>Para {@link Multiplicacion} con operandos 5 y 6: {@code "(5 * 6)"}</li>
     *     <li>Para {@link Division} con operandos 8 y 2: {@code "(8 / 2)"}</li>
     * </ul>
     * Si los operandos son expresiones más complejas, estas también se representarán
     * entre paréntesis, por ejemplo: {@code "((1 + 2) * 3)"}.
     * </p>
     *
     * @return Una cadena de caracteres que representa la operación binaria,
     * incluyendo sus operandos y el operador, encerrada entre paréntesis.
     */
    @Override
    public String toString() {
        return String.format("(%s %s %s)", izquierda, operador, derecha);
    }
}
