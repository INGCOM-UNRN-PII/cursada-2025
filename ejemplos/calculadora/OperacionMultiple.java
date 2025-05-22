package ar.unrn.calculadora;

import ar.unrn.calculadora.Operacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que sirve como base para operaciones aritméticas que pueden
 * tomar un número variable de operandos, como una suma o producto de múltiples
 * términos (ej. Suma(1, 2, 3, 4) o Producto(2, 3, 5)).
 * <p>
 * Esta clase extiende {@link Operacion} y gestiona una lista de {@code Operacion}es
 * que actúan como sus operandos. También define un campo para el símbolo o nombre
 * del operador que la representa.
 * </p>
 * <p>
 * En el contexto del patrón Composite, {@code OperacionMultiple} actúa como un nodo
 * compuesto que puede tener múltiples hijos (los operandos en la lista).
 * Por ejemplo, una expresión como "Suma(5, (3 * 2), 4)" se representaría con:
 * <ul>
 *     <li>Una instancia de una subclase de {@code OperacionMultiple} (ej. {@code SumaMultiple}) como raíz.</li>
 *     <li>Esta instancia contendría una lista de operandos:
 *         <ul>
 *             <li>Un {@code Numero(5)}.</li>
 *             <li>Una {@code Multiplicacion} (que a su vez es una {@link ar.unrn.calculadora.binarias.OperacionBinaria})
 *                 con operandos {@code Numero(3)} y {@code Numero(2)}.</li>
 *             <li>Un {@code Numero(4)}.</li>
 *         </ul>
 *     </li>
 * </ul>
 * </p>
 * <p>
 * Las subclases concretas (ej. {@code SumaMultiple}, {@code ProductoMultiple}) son responsables de:
 * <ol>
 *     <li>Pasar el nombre o símbolo textual de la operación (ej. "Suma", "Producto")
 *         al constructor de esta clase base ({@link #OperacionMultiple(String)}).</li>
 *     <li>Implementar el método abstracto {@link Operacion#calcular()} para definir
 *         la lógica específica de cómo combinar los resultados de todos los
 *         {@code operandos.calcular()} en la lista (ej. sumarlos todos, multiplicarlos todos).</li>
 * </ol>
 * Esta clase proporciona una implementación para agregar operandos y una
 * representación {@link #toString()} genérica.
 * </p>
 *
 * @see Operacion
 * @see SumaMultiple (Ejemplo de subclase)
 * @see ProductoMultiple (Ejemplo de subclase)
 */
public abstract class OperacionMultiple extends Operacion {
    /**
     * Lista que almacena las sub-operaciones (operandos) que componen esta
     * operación múltiple.
     * <p>
     * Cada elemento de esta lista es una instancia de {@link Operacion}, lo que
     * permite anidar expresiones de cualquier complejidad. Por ejemplo, un operando
     * de una {@code SumaMultiple} podría ser un {@code Numero}, una
     * {@link ar.unrn.calculadora.binarias.OperacionBinaria}, u otra {@code OperacionMultiple}.
     * </p>
     * La lista se inicializa vacía en el constructor y se puebla mediante el método
     * {@link #agregar(Operacion)}.
     */
    protected List<Operacion> operandos;

    /**
     * Cadena de texto que representa el nombre o símbolo del operador múltiple, de forma
     * prefija al operando.
     */
    protected String operando; // Nombre más descriptivo podría ser "nombreOperador" o "simboloOperador"

    /**
     * Constructor para crear una instancia de {@code OperacionMultiple}.
     * Inicializa la lista interna de {@link #operandos} como una nueva {@link ArrayList}
     * vacía y establece el nombre o símbolo del operador.
     * <p>
     * Las subclases que hereden de {@code OperacionMultiple} deben llamar a este
     * constructor (usando {@code super(nombreOperador)}) para proporcionar el
     * nombre o símbolo que las identifica.
     * </p>
     *
     * @param operando El nombre o símbolo textual que representa a esta operación múltiple (ej. "Suma", "∑").
     *                 Pensado como palabra o simbolo 'prefijo', {@link #toString()}.
     */
    protected OperacionMultiple(String operando) {
        super();
        this.operandos = new ArrayList<Operacion>();
        this.operando = operando;
    }

    /**
     * Agrega una nueva {@link Operacion} a la lista de {@link #operandos} de esta
     * operación múltiple.
     * <p>
     * Este método permite construir dinámicamente la expresión múltiple añadiendo
     * sus componentes uno por uno.
     * </p>
     *
     * @param op La {@link Operacion} a añadir a la lista de operandos.
     *           No debe ser {@code null}. Si se añade {@code null}, podría causar
     *           {@code NullPointerException} más tarde al llamar a {@code calcular()}
     *           o {@code toString()} sobre ese operando.
     */
    public void agregar(Operacion op) {
        operandos.add(op);
    }

    /**
     * Genera una representación textual de la operación múltiple.
     * El formato es {@code "NombreOperador ( operandoUno, operandoDos, ..., operandoN )"},
     * donde "NombreOperador" es el valor del campo {@link #operando}.
     * <p>
     * Este método itera sobre la lista de {@link #operandos}, invocando
     * recursivamente el método {@code toString()} de cada uno y separándolos
     * por comas y un espacio.
     * </p>
     * <p>
     * Si la lista de operandos está vacía, la salida sería, por ejemplo:
     * {@code "Suma (  )"} (con espacios alrededor de los paréntesis).
     * </p>
     *
     * @return Una cadena de caracteres que representa la operación múltiple,
     * incluyendo su nombre y la representación de todos sus operandos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int largo = operandos.size();
        sb.append(operando);
        sb.append(" ( ");
        for (int i = 0; i < largo; i++) {
            sb.append(operandos.get(i).toString());
            if (i < largo - 1) {
                sb.append(", ");
            }
        }
        sb.append(" )");
        return sb.toString();
    }

}
