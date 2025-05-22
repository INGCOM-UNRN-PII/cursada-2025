import java.util.Objects;

// Superclase (sin cambios)
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Aquí se usa getClass() para asegurar igualdad estricta de tipo
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o; // Aquí no usamos pattern matching porque esta es la superclase
        return edad == persona.edad &&
               Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return "Persona{" +
               "nombre='" + nombre + '\'' +
               ", edad=" + edad +
               '}';
    }
}

// Subclase que hereda de Persona y añade nuevos atributos
class Empleado extends Persona {
    private String idEmpleado;
    private double salario;

    public Empleado(String nombre, int edad, String idEmpleado, double salario) {
        super(nombre, edad); // Llama al constructor de la superclase
        this.idEmpleado = idEmpleado;
        this.salario = salario;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // *** Implementación con Pattern Matching ***
        // 1. Chequea si 'o' es nulo o si no es una instancia de Empleado.
        //    Si 'o' es una instancia de Empleado, se declara y asigna automáticamente la variable 'empleado'.
        if (!(o instanceof Empleado empleado)) {
            return false;
        }

        // 2. Llama al equals de la superclase para comparar los atributos heredados.
        //    Pasamos 'o' (que sabemos que es un Empleado, por el check anterior) a super.equals().
        if (!super.equals(empleado)) { // Podrías pasar 'o' o 'empleado', ambos apuntan al mismo objeto
            return false;
        }

        // 3. Compara los atributos propios de la subclase usando la variable 'empleado'
        return Double.compare(empleado.salario, salario) == 0 &&
               Objects.equals(idEmpleado, empleado.idEmpleado);
    }

    @Override
    public int hashCode() {
        // Combina el hashcode de la superclase con el hashcode de los nuevos atributos
        return Objects.hash(super.hashCode(), idEmpleado, salario);
    }

    @Override
    public String toString() {
        return "Empleado{" +
               "nombre='" + getNombre() + '\'' +
               ", edad=" + getEdad() + '\'' + // Acceder a atributos heredados via getters
               ", idEmpleado='" + idEmpleado + '\'' +
               ", salario=" + salario +
               '}';
    }
}

// Clase de ejemplo para demostrar el uso (sin cambios)
public class EjemploEqualsHashCodeHerenciaPM {
    public static void main(String[] args) {
        // Creamos objetos Empleado
        Empleado emp1 = new Empleado("Juan Perez", 30, "EMP001", 50000.0);
        Empleado emp2 = new Empleado("Juan Perez", 30, "EMP001", 50000.0); // Mismos datos que emp1
        Empleado emp3 = new Empleado("Maria Gomez", 25, "EMP002", 45000.0); // Datos diferentes
        Empleado emp4 = new Empleado("Juan Perez", 30, "EMP003", 55000.0); // Mismo nombre/edad, diferente id/salario
        Persona per1 = new Persona("Juan Perez", 30); // Un objeto Persona con los mismos datos de Persona

        // Demostramos el comportamiento de equals()
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2)); // Debería ser true
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
