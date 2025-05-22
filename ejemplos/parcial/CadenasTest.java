package ar.unrn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfeCadenaTest {

    @Test
    @DisplayName("Largo de una cadena válida")
    void testLargoConCadenaValida() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        int esperado = 4;
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        assertEquals(esperado, Cadena.largo(cadena));
    }

    @Test
    @DisplayName("Largo de una cadena correcta y vacía")
    void testLargoConCadenaVacia() {
        char[] cadena = {'\0'};
        int esperado = 0;

        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        assertEquals(esperado, Cadena.largo(cadena));
    }

    @Test
    @DisplayName("Largo de una cadena de cero elementos")
    void testLargoConCadenaCero() {
        char[] cadena = {};

        try {
            Cadena.largo(cadena);

            fail("Se esperaba una excepción CharArrayException");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    @DisplayName("Largo de una cadena sin terminador")
    void testLargoConCadenaSinTerminador() {
        char[] cadena = {'h', 'o', 'l', 'a'};
        try {
            Cadena.largo(cadena);
            fail("Se esperaba una excepción CharArrayException");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    @DisplayName("Largo de una cadena null")
    void testLargoConCadenaNula() {
        try {
            Cadena.largo(null);
            fail("Se esperaba una excepción NullCharArrayException");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testAmpliarConTamanioMayor() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        char[] resultado = Cadena.ampliar(cadena, 10);
        char[] esperado = {'h', 'o', 'l', 'a', '\0', '\0', '\0', '\0', '\0', '\0', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));
        System.out.println("resultado: " + CadenaApp.muestraArreglo(resultado));
        assertEquals(Cadena.largo(resultado), Cadena.largo(esperado));
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testAmpliarConTamanioMenor() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        char[] resultado = Cadena.ampliar(cadena, 2);
        char[] esperado = {'h', 'o', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));
        System.out.println("resultado: " + CadenaApp.muestraArreglo(resultado));
        assertEquals(Cadena.largo(resultado), Cadena.largo(esperado));
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testAmpliarConTamanioIgual() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        char[] resultado = Cadena.ampliar(cadena, 4);
        char[] esperado = {'h', 'o', 'l', 'a', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));
        System.out.println("resultado: " + CadenaApp.muestraArreglo(resultado));
        assertEquals(Cadena.largo(resultado), Cadena.largo(esperado));
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testAmpliarConTamanioNegativo() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        try {
            Cadena.ampliar(cadena, -1);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testAmpliarConCadenaNula() {
        try {
            Cadena.ampliar(null, 10);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testConcatenaConEspacioSuficiente() {
        char[] str1 = {'h', 'o', 'l', 'a', '\0', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] str2 = {'m', 'u', 'n', 'd', 'o', '\0'};
        char[] esperado = {'h', 'o', 'l', 'a', 'm', 'u', 'n', 'd', 'o', '\0', ' ', ' '};

        System.out.println("str1: " + CadenaApp.muestraArreglo(str1));
        System.out.println("str2: " + CadenaApp.muestraArreglo(str2));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));

        Cadena.concatena(str1, str2);
        assertArrayEquals(esperado, str1);
    }

    @Test
    void testConcatenaSinEspacioSuficiente() {
        char[] str1 = {'h', 'o', 'l', 'a', '\0'};
        char[] str2 = {'m', 'u', 'n', 'd', 'o', '\0'};
        System.out.println("str1: " + CadenaApp.muestraArreglo(str1));
        System.out.println("str2: " + CadenaApp.muestraArreglo(str2));
        try {
            Cadena.concatena(str1, str2);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testConcatenaConCadenaNula1() {
        char[] str1 = null;
        char[] str2 = {'m', 'u', 'n', 'd', 'o', '\0'};

        System.out.println("str2: " + CadenaApp.muestraArreglo(str2));
        try {
            Cadena.concatena(str1, str2);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testConcatenaConCadenaNula2() {
        char[] str1 = {'h', 'o', 'l', 'a', '\0', ' ', ' ', ' ', ' ', ' '};
        char[] str2 = null;
        System.out.println("str1: " + CadenaApp.muestraArreglo(str1));
        try {
            Cadena.concatena(str1, str2);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testContarCaracterConCaracterPresente() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));

        assertEquals(1, Cadena.contarCaracter(cadena, 'a'));
    }

    @Test
    void testContarCaracterConCaracterAusente() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));

        char caracter = 'z';
        assertEquals(0, Cadena.contarCaracter(cadena, caracter));
    }

    @Test
    void testContarCaracterConCadenaNula() {
        char[] cadena = null;
        try {
            Cadena.contarCaracter(cadena, 'a');
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

    @Test
    void testRemoverCaracterConCaracterPresente() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        char[] esperado = {'h', 'o', 'l', '\0', '\0'};
        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));
        Cadena.removerCaracter(cadena, 'a');
        assertEquals(Cadena.largo(cadena), Cadena.largo(esperado));
        assertArrayEquals(esperado, cadena);
    }

    @Test
    void testRemoverCaracterConCaracterAusente() {
        char[] cadena = {'h', 'o', 'l', 'a', '\0'};
        char[] esperado = {'h', 'o', 'l', 'a', '\0'};
        char caracter = 'z';

        System.out.println("cadena: " + CadenaApp.muestraArreglo(cadena));
        System.out.println("esperado: " + CadenaApp.muestraArreglo(esperado));

        Cadena.removerCaracter(cadena, caracter);

        assertEquals(Cadena.largo(cadena), Cadena.largo(esperado));
        assertArrayEquals(esperado, cadena);
    }

    @Test
    void testRemoverCaracterConCadenaNula() {
        char[] cadena = null;
        char caracter = 'a';

        try {
            Cadena.removerCaracter(cadena, caracter);
            fail("Se esperaba una excepción");
        } catch (CharArrayException e) {
            // Excepción esperada
        }
    }

}
