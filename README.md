```mermaid
classDiagram
    %% Paquete Config
    class Conexion {
        -String URL$-String USER$
        -String PASSWORD$+conectar()$ Connection
    }

    %% Paquete DAO
    class AlumnoDAO {
        +leerAlumnos()$ ArrayList~Alumno~
        +agregarAlumno(Alumno alumno)$ void
        +actualizarAlumno(Alumno alumno)$ void
        +eliminarAlumno(String numExpediente)$ void
    }

    class ProfesorDAO {
        +agregarProfesor(Profesor profesor)$ void
        +actualizarProfesor(Profesor profesor)$ void
        +eliminarProfesor(String numEmpleado)$ void
        +leerProfesores()$ ArrayList~Profesor~
    }

    %% Paquete Vista
    class Main {
        +main(String[] args)$ void
    }

    class MenuGeneral {
        -mostrarOpciones()$ void
        +menu()$ void
    }

    class MenuAlumno {
        -agregar()$ void
        -leer()$ void
        -actualizar()$ void
        -eliminar()$ void
        +menu()$ void
    }

    class MenuProfesor {
        -agregar()$ void
        -leer()$ void
        -actualizar()$ void
        -eliminar()$ void
        +menu()$ void
    }

    %% Paquete Modelo
    class Persona {
        <<abstract>>
        -String curp
        -String nombre
        +getNombre() String
        +setNombre(String nombre) void
        +getCurp() String
        +setCurp(String curp) void
        +mostrarTipoPersona()* String
    }

    class Alumno {
        -String numExpediente
        -double promedio
        +getNumExpediente() String
        +setNumExpediente(String numExpediente) void
        +getPromedio() double
        +setPromedio(double promedio) void
        +mostrarTipoPersona() String
    }

    class Profesor {
        -String numEmpleado
        -double sueldo
        +getNumEmpleado() String
        +setNumEmpleado(String numEmpleado) void
        +getSueldo() double
        +setSueldo(double sueldo) void
        +mostrarTipoPersona() String
    }

    class Estudiante {
        <<interface>>
        +getNumExpediente()* String
    }

    class Empleado {
        <<interface>>
        +getNumEmpleado()* String
    }

    %% Relaciones de las Vistas (Llamadas)
    Main -->|"Llama"| MenuGeneral
    MenuGeneral -->|"Llama"| MenuAlumno
    MenuGeneral -->|"Llama"| MenuProfesor

    %% Relaciones con DAO (Uso)
    MenuAlumno -->|"Usa"| AlumnoDAO
    MenuProfesor -->|"Usa"| ProfesorDAO
    AlumnoDAO -->|"Usa"| Conexion
    ProfesorDAO -->|"Usa"| Conexion

    %% Relaciones con el Modelo (Uso)
    MenuAlumno -->|"Usa"| Alumno
    MenuProfesor -->|"Usa"| Profesor
    AlumnoDAO -->|"Usa"| Alumno
    ProfesorDAO -->|"Usa"| Profesor

    %% Herencia y Realización
    Alumno --|> Persona : Hereda de
    Profesor --|> Persona : Hereda de
    Alumno ..|> Estudiante : Implementa
    Profesor ..|> Empleado : Implementa
