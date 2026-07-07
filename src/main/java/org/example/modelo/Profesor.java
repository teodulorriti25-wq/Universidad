package org.example.modelo;

public class Profesor {
    private int numEmpleado;
    private String nombre;
    private int edad;
    private String especialidad;
    private double sueldo;
    private static final String[] ESPECIALIDADES_VALIDAS = {"TI","Qui","Mec","Mkt"};

    public Profesor(){}

    public Profesor(int numEmpleado, String nombre, int edad, String especialidad, double sueldo) {
        setNumEmpleado(numEmpleado);
        setNombre(nombre);
        setEdad(edad);
        setEspecialidad(especialidad);
        setSueldo(sueldo);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.isBlank() || nombre.isEmpty()){
            System.out.println("Error en el nombre requerido");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad > 20 && edad < 80){
            this.edad = edad;
        }else{
            System.out.println("LA EDAD NO ES VALIDA");
        }
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(validarEspecialidad(especialidad)){
            this.especialidad = especialidad;
        }else{
            System.out.println("ESPECIALIDAD NO VALIDA");
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if(sueldo > 0){
            this.sueldo = sueldo;
        }else{
            System.out.println("EL SUELDO DEBE SER MAYOR A 0");
        }
    }

    @Override
    public String toString() {
        return "Numero de Empleado: " + numEmpleado + '\n' +
                "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "Especialidad: " + especialidad + '\n' +
                "Sueldo: $" + sueldo + '\n';
    }

    public boolean validarEspecialidad(String especialidad){
        boolean especialidadValida = false;
        for(String validar : ESPECIALIDADES_VALIDAS){
            if(especialidad.equalsIgnoreCase(validar)){
                return true;
            }
        }
        return especialidadValida;
    }
}