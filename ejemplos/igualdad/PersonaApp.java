package ar.unrn.igualdad;

import java.util.ArrayList;
import java.util.List;

public class PersonaApp {
    public static void main(String[] args) {
        // Crear una lista de personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Maria", 30));
        personas.add(new Persona("Pedro", 20));
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Carlos", 17));

        // Usar Filtrator para filtrar por edad
        System.out.println("Personas con 30 años:");
        Filtrator<Persona> filtroEdad30 = Persona.porEdad(30);
        for (Persona persona : personas) {
            if (filtroEdad30.filtra(persona)) {
                System.out.println(persona);
            }
        }

        // Usar Filtrator para filtrar mayores de edad
        System.out.println("\nPersonas mayores de edad:");
        Filtrator<Persona> filtroMayorEdad = Persona.esMayorEdad();
        for (Persona persona : personas) {
            if (filtroMayorEdad.filtra(persona)) {
                System.out.println(persona);
            }
        }

        // Usar Filtrable para filtrar por nombre (para un objeto específico)
        System.out.println("\nPersonas llamadas Juan (usando Filtrable):");
        for (Persona persona : personas) {
            if (persona.porNombre("Juan").filtra()) {
                System.out.println(persona);
            }
        }
    }
}