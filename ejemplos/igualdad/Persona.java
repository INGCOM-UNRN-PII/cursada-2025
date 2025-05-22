package ar.unrn.igualdad;

import java.util.Objects;

/**
 * Representa a una persona con nombre y edad.
 */
class Persona {
    private String nombre;
    private int edad;

    /**
     * Constructor para crear un objeto {@code Persona}.
     *
     * @param nombre El nombre de la persona.
     * @param edad   La edad de la persona.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Crea un {@code Filtrator<Persona>} que filtra personas por edad.
     *
     * @param edad La edad a filtrar.
     * @return Un {@code Filtrator<Persona>} que retorna {@code true} si la persona
     * tiene la edad especificada, {@code false} en caso contrario.
     */
    public static Filtrator<Persona> porEdad(int edad) {
        return new Filtrator<Persona>() {
            @Override
            public boolean filtra(Persona persona) {
                return persona.edad == edad;
            }
        };
    }

    public static Filtrator<Persona> esMayorEdad() {
        return new Filtrator<Persona>() {
            @Override
            public boolean filtra(Persona persona) {
                return persona.edad >= 18;
            }
        };
    }

    /**
     * Crea un {@code Filtrable} que filtra personas por nombre.
     *
     * @param nombre El nombre a filtrar.
     * @return Un {@code Filtrable} que retorna {@code true} si la persona tiene
     * el nombre especificado, {@code false} en caso contrario.
     */
    public Filtrable porNombre(String nombre) {
        return new Filtrable() {
            @Override
            public boolean filtra() {
                return Persona.this.nombre.equals(nombre);
            }
        };
    }

    /**
     * Compara este objeto {@code Persona} con otro objeto para determinar la igualdad.
     * Dos objetos {@code Persona} se consideran iguales si tienen el mismo nombre
     * y la misma edad.
     *
     * @param o El objeto a comparar con este objeto.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Persona persona) {
            return edad == persona.edad &&
                    Objects.equals(nombre, persona.nombre);
        } else {
            return false;
        }
    }

    /**
     * Retorna el valor del código hash para este objeto {@code Persona}.
     * El código hash se calcula basado en el nombre y la edad de la persona.
     *
     * @return El valor del código hash para este objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    /**
     * Retorna una representación en cadena de este objeto {@code Persona}.
     * La cadena contiene el nombre y la edad de la persona.
     *
     * @return Una representación en cadena del objeto.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}