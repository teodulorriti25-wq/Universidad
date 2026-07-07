package org.example.modelo;

public class Alumno {
    private int numExpediente ;
    private String nombre;
    private int edad;
    private String carrera;
    private int cuatrimestres;
    private static final String[] CARRERAS_VALIDAS = {"TI", "Qui", "Mec", "Mkt"};
    public Alumno(){}

    public Alumno(int numExpediente, String nombre, int edad, String carrera, int cuatrimestres) {
        setNumExpediente(numExpediente);
        setNombre(nombre);
        setEdad(edad);
        setCarrera(carrera);
        setCuatrimestres(cuatrimestres);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        if(nombre.isBlank()|| nombre.isEmpty()){
            System.out.println("Error en el nombre requerido");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad>15 && edad<110){
            this.edad = edad;
        }
        else{

        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if(validarCarreras(carrera)){
            this.carrera = carrera;
        }else{
            System.out.println("CARRERA NO VALIDA");
        }
    }

    public int getCuatrimestre() {
        return cuatrimestres;
    }

    public void setCuatrimestres(int cuatrimestres) {
        if(cuatrimestres>0 && cuatrimestres<12){
            this.cuatrimestres = cuatrimestres;
        }
        else{
            System.out.println("EL CUATRIMESTRE DEBE SER ENTRE 1 Y 11");
        }
    }
    @Override
    public String toString() {
        return "Numero de Expediente: " + numExpediente +'\n' +
                "Nombre:" + nombre + '\n' +
                "Edad:" + edad + '\n'+
                "Carrera:" + carrera + '\n' +
                "Cuatrimestre:" + cuatrimestres +'\n';
    }
    public boolean validarCarreras(String carrera){
        boolean carreraValida=false;
        for(String validar: CARRERAS_VALIDAS){
            if(carrera.equalsIgnoreCase(validar)){
                return true;
            }
        }
        return carreraValida;
    }
}