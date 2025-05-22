package ar.unrn.igualdad;

import java.util.Objects;

// Subclase que hereda de Persona y añade nuevos atributos
class Empleado extends Persona {
    private String legajo;
    private long salario;

    public Empleado(String nombre, int edad, String legajo, long salario) {
        super(nombre, edad);
        this.legajo = legajo;
        this.salario = salario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (otro instanceof Empleado empleado) {
            return super.equals(empleado) &&
                    Objects.equals(legajo, empleado.legajo) &&
                    (salario == empleado.salario);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), legajo, salario);
    }

    @Override
    public String toString() {
        return "Empleado{" + super.toString() +
                ", idEmpleado='" + legajo + '\'' +
                ", salario=" + salario + '}';
    }
}
