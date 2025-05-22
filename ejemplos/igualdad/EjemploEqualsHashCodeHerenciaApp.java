package ar.unrn.igualdad;


// Clase de ejemplo para demostrar el uso (sin cambios)
public class EjemploEqualsHashCodeHerenciaApp {
    public static void main(String[] args) {
        // Creamos objetos Empleado
        Empleado emp1 = new Empleado("Juan Perez", 30, "EMP001", 50000L);
        Empleado emp2 = new Empleado("Juan Perez", 30, "EMP001", 50000L);
        // Mismos datos que emp1
        Empleado emp3 = new Empleado("Maria Gomez", 25, "EMP002", 45000L);
        // Datos diferentes
        Empleado emp4 = new Empleado("Juan Perez", 30, "EMP003", 55000L);
        // Mismo nombre/edad, diferente id/salario
        Persona per1 = new Persona("Juan Perez", 30); // Un objeto Persona con los mismos datos de Persona

        // Demostramos el comportamiento de equals()
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2));
        // Debería ser true
        System.out.println("emp1.equals(emp3): " + emp1.equals(emp3)); // Debería ser false
        System.out.println("emp1.equals(emp4): " + emp1.equals(emp4)); // Debería ser false (idEmpleado o salario diferentes)
        System.out.println("emp1.equals(per1): " + emp1.equals(per1)); // Debería ser false (diferente tipo o atributos propios)

        // Demostramos el comportamiento de hashCode() (los objetos iguales deben tener el mismo hashcode)
        System.out.println("HashCode de emp1: " + emp1.hashCode());
        System.out.println("HashCode de emp2: " + emp2.hashCode()); // Debería ser igual al de emp1
        System.out.println("HashCode de emp3: " + emp3.hashCode()); // Debería ser diferente al de emp1
        System.out.println("HashCode de emp4: " + emp4.hashCode()); // Debería ser diferente al de emp1
        System.out.println("HashCode de per1: " + per1.hashCode()); // Probablemente diferente, aunque los datos de Persona sean iguales
    }
}
