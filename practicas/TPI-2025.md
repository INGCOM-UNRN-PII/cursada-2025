# Trabajo Integrador Final

Este es el repositorio para la entrega del Trabajo Integrador Final.

**Reemplacen este documento por la descripción de lo que terminen implementando.**

## Entrega

La entrega del repositorio para revisión es en el mismo formulario que el usado para los Trabajos Prácticos y debe ser 24 horas antes de la defensa del mismo; **sin excepciones**.

## Consigna

Este proyecto final tiene como objetivo principal evaluar la comprensión y aplicación de los principios fundamentales de la Programación Orientada a Objetos (POO). Se espera que demuestren su habilidad para diseñar, implementar y probar soluciones robustas, haciendo uso de patrones de diseño adecuados y estructuras de datos eficientes para resolver problemas complejos.

Las consignas planteadas están para guiarlos, y no para ser completadas tal cual fueron planteadas.

### Libre

Esta modalidad permite a los equipos proponer y desarrollar un proyecto de su propia elección.
Es una excelente oportunidad para aplicar la POO en un dominio que sea de su interés o en el que identifiquen una necesidad.

Es vital para quienes elijan esta opción, que nos sentemos a conversar sobre la idea, cosa de que luego no sufran por su elección luego. Para esto, tengan _escrita_ la idea en el `README.md` y, si es posible, con un boceto del diagrama de clases que implementarán y una breve justificación de por qué eligieron desarrollar la idea.

Esto es para asegurarnos que el proyecto resultante tiene una complejidad apropiada.

### Batalla naval / Estrategia por turnos

Desarrollar una implementación del clásico juego «Batalla Naval» para dos jugadores pero con un algunas de mejoras.

- Tablero Ajustable: El escenario de juego debe ser de tamaño configurable (ej. 10×10, 15×15), permitiendo al usuario definir las dimensiones al inicio de la partida.

- Terreno variado: El tablero puede contener diferentes tipos de terreno, como agua y tierra. Esto podría influir en la colocación de unidades.

- Unidades Variadas: Las unidades pueden poseer habilidades como el lanzamiento de helicópteros o aviones  para detectar barcos enemigos.  Bombas de humo y demás.

- Movimiento de las unidades: Parte de las acciones posibles en un turno, puede incluir cambiar de lugar los barcos. Para esto, se puede pensar en un indicador de energía acumulable entre turnos que se utiliza en las acciones de las unidades.

### Juego de rol

Esta opción consiste en el desarrollo de un juego de rol de texto, en donde se permita a los jugadores explorar un escenario de juego, combatir contra enemigos y poseer un inventario.

El objetivo del juego puede ser llegar a la salida del calabozo o la erradicación de los monstruos del mapa.

### Supermercado (o venta de productos)

Desarrollar un sistema de software que simule las operaciones de un supermercado mayorista, enfocado en la venta a granel y la aplicación de descuentos por volumen.

- **Gestión de Inventario:**
  - Registro de productos con atributos (nombre, código, precio unitario, inventario  actual, inventario mínimo).
  - Funcionalidades para agregar, eliminar, actualizar productos y reponer inventario.
  - Alertas por bajo inventario.

- **Procesamiento de ventas:**
  - Sistema de carrito de compras para clientes.
  - Registro de ventas, incluyendo múltiples productos y cantidades.
  - Actualización automática del inventario tras una venta.

- **Cálculo de Descuentos:**
  - Implementación de reglas de descuento por volumen (ej. «compra 10 unidades de X y obtén un 15 % de descuento», «por compras superiores a $5000, 10 % de descuento total»).
  - Posibilidad de aplicar descuentos a productos específicos o al total de la compra.

- **Generación de reportes:**
  - Reportes de ventas por período (diario, semanal, mensual).
  - Reportes de inventario (productos más vendidos, productos con bajo inventario).
  - Reportes de clientes y sus compras.

- **Gestión de Clientes:** Registro de clientes y seguimiento de su historial de compras para programas de fidelidad.

### Agenda II

Este proyecto busca ampliar el ejercicio de agenda visto en clase, incorporando nuevas funcionalidades y haciendo uso de persistencia de datos a través de archivos.

- **Gestión de Contactos Mejorada:**

  - Registro de contactos con información ampliada (nombre completo, múltiples números de teléfono - celular, fijo, trabajo -, múltiples direcciones de correo electrónico, dirección física, fecha de nacimiento, notas).
  - Más tipos de contactos (clientes, familia, amigos, etc.)
  - Funcionalidades para agregar, modificar, eliminar y buscar contactos.

- **Gestión de Eventos:**

  - Registro de eventos con atributos (nombre, fecha, hora de inicio, hora de fin, descripción, ubicación).
  - Posibilidad de establecer recordatorios para eventos.
  - Soporte para eventos recurrentes (diarios, semanales, mensuales, anuales).
  - Visualización de eventos por día, semana o mes.

- **Almacenamiento de Datos:**

  - La información de contactos y eventos debe ser almacenada y recuperada de archivos (ej. CSV, JSON o un formato propio).
  - Manejo de la carga y guardado de datos al iniciar y cerrar la aplicación.
  - Considerar la serialización y deserialización de objetos para almacenar estructuras de datos complejas.

### Plataforma de Reservas (Hoteles/Vuelos/Eventos)

Desarrollar un sistema para gestionar reservas en un dominio específico (ej. hoteles, vuelos, eventos, consultorios médicos).

- **Gestión de Recursos Reservables:**
  - Definición de entidades reservables (ej. habitaciones de hotel, asientos de avión, entradas a eventos, turnos de médico).
  - Atributos de los recursos (ID, disponibilidad, precio, características).

- **Gestión de Usuarios/Clientes:**
  - Registro y autenticación de usuarios.
  - Perfil de usuario con historial de reservas.

- **Búsqueda y disponibilidad:**
  - Funcionalidad de búsqueda de recursos por criterios (ej. fecha, tipo, ubicación).
  - Verificación de disponibilidad en tiempo real.

- **Proceso de Reserva:**
  - Selección de recursos y fechas.
  - Confirmación de reserva.
  - Generación de un identificador único para cada reserva.

- **Cancelación y Modificación:**
  - Posibilidad de cancelar o modificar una reserva existente (sujeto a reglas de negocio).

- **Reportes:**

  - Reportes de ocupación o reservas por período.
  - Reportes de ingresos.

- **Persistencia:** Almacenamiento de datos de recursos, usuarios y reservas en archivos.

#### Sistema de Gestión de Biblioteca Digital

Desarrollar un sistema para gestionar una biblioteca digital, permitiendo a los usuarios buscar, prestar y devolver libros electrónicos.

- **Gestión de Libros:**
  - Registro de libros con atributos (título, autor, ISBN, género, año de publicación, número de copias disponibles, formato digital).
  - Funcionalidades para agregar, eliminar, actualizar información de libros.
  - Búsqueda de libros por título, autor, género o ISBN.

- **Gestión de Usuarios:**
  - Registro de usuarios con atributos (nombre, ID de usuario, historial de préstamos).
  - Autenticación de usuarios.

- **Préstamos y devoluciones:**
  - Sistema para que los usuarios puedan «prestar» libros digitales (reduciendo las copias disponibles).
  - Sistema para «devolver» libros (aumentando las copias disponibles).
  - Límites de tiempo para los préstamos y penalizaciones por retraso (opcional).

- **Historial de Préstamos:**
  - Mantener un registro de los libros prestados por cada usuario.
  - Generación de reportes de préstamos y disponibilidad de libros.

- **Persistencia:** Almacenamiento de datos de libros y usuarios en archivos (ej. CSV, JSON).

## Rúbrica de evaluación

La evaluación del proyecto se basará en los siguientes criterios:

### Funcionalidad del proyecto (25 %)

- El proyecto debe compilar, ejecutarse sin errores y operar correctamente.
- La aplicación debe ser estable y robusta.

### Estructura y diseño del código (25 %)

- La estructura del código debe ser clara, modular y seguir los principios de la Programación Orientada a Objetos vistos en clase.
- Se espera la aplicación de patrones de diseño cuando sea apropiado, demostrando una comprensión de su utilidad.
- Uso adecuado de estructuras de datos para optimizar el rendimiento y la organización de la información.

### Encapsulamiento y abstracción (15 %)

- El encapsulamiento debe ser respetado rigurosamente.
- Uso efectivo de la abstracción, interfaces y herencia para modelar el dominio del problema.

### Participación del equipo (10 %)

- Se observará en el historial del repositorio de control de versiones la participación activa y equitativa de todos los miembros del equipo.
- Los commits deben ser significativos y reflejar el trabajo individual y colaborativo.

### Documentación y legibilidad del código (10 %)

- La documentación externa (README, diagramas UML) debe ser completa, clara y ser consistente con lo implementado.
- El código debe ser legible, bien comentado y seguir los estándares de codificación indicados en clase.

### Tests (15 %)

- Implementación de tests rigurosos para el aseguramiento de la calidad y fiabilidad del código.
