package ar.unrn;


import java.util.Arrays;

public class Cadena {

    /**
     * Calcula la longitud de un string al estilo C representado por un array de caracteres.
     * La longitud se determina contando los caracteres hasta que se encuentra el terminador nulo ('\0').
     * Si no se encuentra el terminador nulo, se lanza una excepción.
     *
     * @param cadena El array de caracteres que representa el string.
     * @return La longitud del string (excluyendo el terminador nulo).
     * @throws CharArrayException si el array de caracteres de entrada es nulo o si no se encuentra el terminador nulo.
     * @Ejemplo <pre>
     *     char[] arrayDeCaracteres = {'h', 'o', 'l', 'a', '\0'};
     *     int longitud = Cadena.largo(arrayDeCaracteres);
     *     // longitud será 4
     * </pre>
     * @see #verificarNulo(char[]) para más detalles sobre la verificación de arrays nulos.
     */
    public static int largo(char[] cadena) {
        verificarNulo(cadena);
        int largo = 0;
        while (largo < cadena.length && cadena[largo] != '\0') {
            largo++;
        }
        if (largo == cadena.length) {
            throw new CharArrayException("El terminador '\\0' no fue encontrado en la cadena.");
        }
        return largo;
    }

    /**
     * Crea un nuevo array de caracteres con un tamaño especificado y copia el contenido del array de caracteres original en él.
     * El contenido del array original se copia hasta que se alcanza el terminador nulo ('\0').
     * Si el nuevo tamaño es menor que la longitud original del string, el string será truncado.
     * Si el nuevo tamaño es mayor, el espacio extra se llenará con valores char por defecto (no '\0').
     *
     * @param cadena       El array de caracteres original.
     * @param nuevoTamanio El nuevo tamaño del array de caracteres.
     * @return Un nuevo array de caracteres con el tamaño especificado, conteniendo el contenido del array original.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @throws CharArrayException     si el nuevo tamaño es negativo.
     * @Ejemplo <pre>
     *     char[] arrayDeCaracteres = {'h', 'o', 'l', 'a', '\0'};
     *     char[] nuevoArrayDeCaracteres = Cadena.ampliar(arrayDeCaracteres, 10);
     *     // nuevoArrayDeCaracteres será {'h', 'o', 'l', 'a', '\0', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'}
     * </pre>
     * @see #verificarNulo(char[]) para más detalles sobre la verificación de arrays nulos.
     */
    public static char[] ampliar(char[] cadena, int nuevoTamanio) {
        verificarNulo(cadena);
        char[] nuevaCadena;
        if (nuevoTamanio <= 0) {
            throw new CharArrayException("El nuevo tamaño no puede ser negativo.");
        } else if (nuevoTamanio + 1 == cadena.length) {
            nuevaCadena = Arrays.copyOf(cadena, cadena.length);
        } else {
            nuevoTamanio = nuevoTamanio + 1; //Hacemos lugar para el terminador
            nuevaCadena = new char[nuevoTamanio];
            int i = 0;
            while (i < cadena.length && cadena[i] != '\0' && i < nuevoTamanio - 1) {
                nuevaCadena[i] = cadena[i];
                i++;
            }
            if (i < nuevoTamanio) {
                nuevaCadena[i] = '\0';
            }
        }
        return nuevaCadena;
    }

    /**
     * Concatena dos strings al estilo C (arrays de caracteres) agregando el contenido de `concatenante` al final de `concatenada`.
     * El array `concatenada` debe tener suficiente espacio para acomodar el contenido de ambos strings, incluyendo el terminador nulo.
     *
     * @param concatenada  El array de caracteres al que se le agregará el contenido.
     * @param concatenante El array de caracteres a agregar.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @throws CharArrayException     si `concatenada` no tiene suficiente espacio para almacenar el resultado.
     * @Ejemplo <pre>
     *     char[] str1 = {'h', 'o', 'l', 'a', '\0', ' ', ' ', ' ', ' ', ' '};
     *     char[] str2 = {'m', 'u', 'n', 'd', 'o', '\0'};
     *     Cadena.concatena(str1, str2);
     *     // str1 será {'h', 'o', 'l', 'a', 'm', 'u', 'n', 'd', 'o', '\0'}
     * </pre>
     * @see #verificarNulo(char[]) para más detalles sobre la verificación de arrays nulos.
     */
    public static void concatena(char[] concatenada, char[] concatenante) {
        verificarNulo(concatenada, "El arreglo destino no puede ser nulo");
        verificarNulo(concatenante, "El arreglo concatenante no puede ser nulo");

        int i = 0;
        while (concatenada[i] != '\0') {
            i++;
        }
        int j = 0;
        while (concatenante[j] != '\0') {
            if (i >= concatenada.length) {
                throw new CharArrayException("El array 'concatenada' no tiene suficiente espacio para almacenar el resultado.");
            }
            concatenada[i] = concatenante[j];
            i++;
            j++;
        }
        if (i < concatenada.length) {
            concatenada[i] = '\0';
        }
    }

    /**
     * Cuenta la cantidad de veces que aparece un carácter específico en un string al estilo C (array de caracteres).
     *
     * @param cadena   El array de caracteres dentro del cual buscar.
     * @param caracter El carácter a contar.
     * @return La cantidad de veces que `caracter` aparece en `cadena`.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @Ejemplo <pre>
     *     char[] arrayDeCaracteres = {'h', 'o', 'l', 'a', '\0'};
     *     int cantidad = Cadena.contarCaracter(arrayDeCaracteres, 'a');
     *     // cantidad será 1
     * </pre>
     * @see #verificarNulo(char[]) para más detalles sobre la verificación de arrays nulos.
     */
    public static int contarCaracter(char[] cadena, char caracter) {
        verificarNulo(cadena);
        int contador = 0;
        for (int i = 0; cadena[i] != '\0'; i++) {
            if (cadena[i] == caracter) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Elimina todas las ocurrencias de un carácter específico de un string al estilo C (array de caracteres).
     *
     * @param cadena   El array de caracteres a modificar.
     * @param caracter El carácter a eliminar.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @Ejemplo <pre>
     *     char[] arrayDeCaracteres = {'h', 'o', 'l', 'a', '\0'};
     *     Cadena.removerCaracter(arrayDeCaracteres, 'a');
     *     // arrayDeCaracteres será {'h', 'o', 'l', '\0', 'a', '\0'}
     * </pre>
     * @see #verificarNulo(char[]) para más detalles sobre la verificación de arrays nulos.
     */
    public static void removerCaracter(char[] cadena, char caracter) {
        verificarNulo(cadena);
        int i = 0;
        int j = 0;
        while (cadena[i] != '\0') {
            if (cadena[i] != caracter) {
                cadena[j] = cadena[i];
                j++;
            }
            i++;
        }
        cadena[j] = '\0';
    }

    /**
     * Verifica si un array de caracteres es nulo.
     * Si el array es nulo, lanza una excepción NullCharArrayException con un mensaje de error predeterminado.
     * Este método se utiliza internamente para validar los arrays de caracteres antes de realizar operaciones
     * sobre ellos.
     *
     * @param cadena El array de caracteres a verificar.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @throws CharArrayException     cuando el largo del arreglo es cero
     */
    public static void verificarNulo(char[] cadena) {
        verificarNulo(cadena, "El array de caracteres no puede ser nulo.");
    }

    /**
     * Verifica si un array de caracteres es nulo.
     * Si el array es nulo, lanza una excepción NullCharArrayException con un mensaje de error personalizado.
     * Esta función es de uso interno para validar los arrays de caracteres antes de realizar operaciones
     * sobre ellos.
     * </p>
     * Cuando el arreglo de caracteres es cero, no hay lugar ni para el terminador lo cual es problema en
     * la definición del arreglo de caracteres.
     *
     * @param cadena   El array de caracteres a verificar.
     * @param contexto El mensaje de error personalizado que se incluirá en la excepción si el array es nulo.
     * @throws NullCharArrayException si el array de caracteres es nulo.
     * @throws CharArrayException     cuando el largo del arreglo es cero
     */
    public static void verificarNulo(char[] cadena, String contexto) {
        if (cadena == null) {
            throw new NullCharArrayException(contexto);
        }
        if (cadena.length == 0) {
            String mensaje = "El largo del array de caracteres debe ser de al menos uno: " + contexto;
            throw new CharArrayException(contexto);
        }
    }

}
