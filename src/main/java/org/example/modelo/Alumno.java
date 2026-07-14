package org.example.modelo;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {

    private int numExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestres;

    private static final String[] CARRERAS_VALIDAS={"TI","Qui","Mec","Mkt"};

    public Alumno(){}

    public Alumno(int numExpediente,String nombre,String curp,int edad,String carrera,int cuatrimestres){
        super(nombre,curp);
        setNumExpediente(numExpediente);
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad>15 && edad<110){
            this.edad=edad;
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {

        if(validarCarreras(carrera)){
            this.carrera=carrera;
        }else{
            System.out.println("Carrera no valida");
        }

    }

    public int getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(int cuatrimestres) {
        if(cuatrimestres>=1 && cuatrimestres<=11){
            this.cuatrimestres=cuatrimestres;
        }
    }

    public boolean validarCarreras(String carrera){
        for(String c:CARRERAS_VALIDAS){
            if(c.equalsIgnoreCase(carrera)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String mostrarTipoPersona() {
        return "----- ALUMNO -----";
    }

    @Override
    public void aprender() {
        System.out.println(getNombre()+" esta aprendiendo.");
    }

    @Override
    public void recibirEvaluacion() {
        System.out.println(getNombre()+" recibe una evaluacion.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numero de expediente: " + getNumExpediente() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Carrera: " + getCarrera() + "\n" +
                "Cuatrimestre: " + getCuatrimestres() + "\n";
    }
}