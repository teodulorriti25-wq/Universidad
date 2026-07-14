package org.example.modelo;

public abstract class PersonaUT {

    private String nombre;
    private String curp;

    public PersonaUT(){}

    public PersonaUT(String nombre, String curp){
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        if(nombre.isBlank()){
            System.out.println("El nombre es requerido");
        }else{
            this.nombre = nombre;
        }
    }

    public String getCurp() {
        return curp.toUpperCase();
    }

    public void setCurp(String curp) {
        if(curp.isBlank()){
            System.out.println("El CURP es requerido");
        }else{
            this.curp = curp;
        }
    }

    public abstract String mostrarTipoPersona();

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp() + "\n";
    }
}