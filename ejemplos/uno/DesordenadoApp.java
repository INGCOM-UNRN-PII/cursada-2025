package ar.unrn;

public class DesordenadoApp { public static final int MAXIMO = 10;
public static void main(String[] args) {System.out.printf("Hola y bienvenido! %s%n", "Estudiante");
for (int i = 0; i <= MAXIMO; i++) {System.out.println("i = " + suma(i, MAXIMO));}}
public static int suma(int primer, int segundo) {return primer + segundo;}
}
