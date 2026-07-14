package org.example.modelo;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {

    private int numEmpleado;
    private int edad;
    private String especialidad;
    private double sueldo;

    private static final String[] ESPECIALIDADES_VALIDAS={"TI","Qui","Mec","Mkt"};

    public Profesor(){}

    public Profesor(int numEmpleado, String nombre, String curp, int edad, String especialidad, double sueldo){
        super(nombre,curp);
        setNumEmpleado(numEmpleado);
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad>20 && edad<80){
            this.edad=edad;
        }
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(validarEspecialidad(especialidad)){
            this.especialidad=especialidad;
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if(sueldo>0){
            this.sueldo=sueldo;
        }
    }

    public boolean validarEspecialidad(String especialidad){
        for(String e:ESPECIALIDADES_VALIDAS){
            if(e.equalsIgnoreCase(especialidad)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String mostrarTipoPersona() {
        return "----- PROFESOR -----";
    }

    @Override
    public void ensenar() {
        System.out.println(getNombre()+" esta enseñando.");
    }

    @Override
    public void evaluar() {
        System.out.println(getNombre()+" esta evaluando.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numero de empleado: " + getNumEmpleado() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Especialidad: " + getEspecialidad() + "\n" +
                "Sueldo: $" + getSueldo() + "\n";
    }
}