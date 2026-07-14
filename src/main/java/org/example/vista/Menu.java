package org.example.vista;
import org.example.dao.AlumnoDAO;
import org.example.modelo.Alumno;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Profesor;
import org.example.modelo.PersonaUT;

import java.io.*;
import java.util.*;

public class Menu {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();
    private ArrayList<PersonaUT> comunidadUniversitaria = new ArrayList<>();

    private void registrar(){
        try {
            Alumno alumno = new Alumno();
            System.out.println("Número de expediente: ");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));
            System.out.println("Nombre del alumno: ");
            alumno.setNombre(br.readLine());
            System.out.println("Edad del alumno: ");
            alumno.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Carrera del alumno(TI, Qui, Mec, Mkt): ");
            alumno.setCarrera(br.readLine());
            System.out.println("Cuatrimestre del alumno: ");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));
            alumnoDAO.nuevoAlumno(alumno);
            comunidadUniversitaria.add(alumno);
        }catch(Exception e){
            System.out.println("Error al ingresar: " + e.getMessage());
        }
    }

    private void listar(){
        ArrayList<Alumno> lista = alumnoDAO.listarAlumnos();
        System.out.println("------------Lista de Alumnos------------");
        for(Alumno alumno : lista){
            System.out.println(alumno);
            System.out.println("----------------------------");
        }
    }

    private void modificar(){
        try {
            Alumno alumno = new Alumno();
            System.out.println("Modificar alumno por numero de expediente:");
            System.out.println("Numero de expediente: ");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));
            System.out.println("Nombre: ");
            alumno.setNombre(br.readLine());
            System.out.println("Edad: ");
            alumno.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Carrera: ");
            alumno.setCarrera(br.readLine());
            System.out.println("Cuatrimestre: ");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));
            alumnoDAO.actualizarAlumno(alumno);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void eliminar(){
        try{
            System.out.println("Numero de expediente del alumno a eliminar:");
            int expediente = Integer.parseInt(br.readLine());
            alumnoDAO.eliminarAlumno(expediente);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void buscar(){
        try{
            System.out.println("Numero de expediente:");
            int expediente = Integer.parseInt(br.readLine());
            Alumno alumno = alumnoDAO.buscarAlumno(expediente);
            if(alumno != null){
                System.out.println(alumno);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void registrarProfesor(){
        try{
            Profesor profesor = new Profesor();
            System.out.println("Número de empleado: ");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));
            System.out.println("Nombre del profesor: ");
            profesor.setNombre(br.readLine());
            System.out.println("Edad del profesor: ");
            profesor.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Especialidad (TI, Qui, Mec, Mkt): ");
            profesor.setEspecialidad(br.readLine());
            System.out.println("Sueldo del profesor: ");
            profesor.setSueldo(Double.parseDouble(br.readLine()));
            profesorDAO.nuevoProfesor(profesor);
            comunidadUniversitaria.add(profesor);
        }catch(Exception e){
            System.out.println("Error al ingresar: " + e.getMessage());
        }
    }

    private void listarProfesores(){
        ArrayList<Profesor> lista = profesorDAO.listarProfesores();
        System.out.println("------------Lista de Profesores------------");
        for(Profesor profesor : lista){
            System.out.println(profesor);
            System.out.println("----------------------------");
        }
    }

    private void modificarProfesor(){
        try{
            Profesor profesor = new Profesor();
            System.out.println("Numero de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));
            System.out.println("Nombre:");
            profesor.setNombre(br.readLine());
            System.out.println("Edad:");
            profesor.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Especialidad:");
            profesor.setEspecialidad(br.readLine());
            System.out.println("Sueldo:");
            profesor.setSueldo(Double.parseDouble(br.readLine()));
            profesorDAO.actualizarProfesor(profesor);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void eliminarProfesor(){
        try{
            System.out.println("Numero de empleado:");
            int numEmpleado = Integer.parseInt(br.readLine());
            profesorDAO.eliminarProfesor(numEmpleado);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void buscarProfesor(){
        try{
            System.out.println("Numero de empleado:");
            int numEmpleado = Integer.parseInt(br.readLine());
            Profesor profesor = profesorDAO.buscarProfesor(numEmpleado);
            if(profesor != null){
                System.out.println(profesor);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void mostrarComunidadUniversitaria(){
        if(comunidadUniversitaria.isEmpty()){
            System.out.println("No hay personas registradas.");
            return;
        }
        System.out.println("====== COMUNIDAD UNIVERSITARIA ======");
        for(PersonaUT persona : comunidadUniversitaria){
            System.out.println(persona);
            System.out.println("--------------------------------");
        }
    }

    public void menu(){
        try{
            int salir = 0;
            while(salir != 12){
                System.out.println("=========== MENU ===========");
                System.out.println("1. Registrar Alumno");
                System.out.println("2. Listar Alumnos");
                System.out.println("3. Registrar Profesor");
                System.out.println("4. Listar Profesores");
                System.out.println("5. Modificar Alumno");
                System.out.println("6. Eliminar Alumno");
                System.out.println("7. Buscar Alumno");
                System.out.println("8. Modificar Profesor");
                System.out.println("9. Eliminar Profesor");
                System.out.println("10. Buscar Profesor");
                System.out.println("11. Mostrar Comunidad Universitaria");
                System.out.println("12. Salir");
                System.out.print("Seleccione una opcion: ");
                salir = Integer.parseInt(br.readLine());
                switch(salir){
                    case 1:
                        registrar();
                    break;
                    case 2:
                        listar();
                    break;
                    case 3:
                        registrarProfesor();
                    break;
                    case 4:
                        listarProfesores();
                    break;
                    case 5:
                        modificar();
                     break;
                    case 6:
                        eliminar();
                    break;
                    case 7:
                        buscar();
                   break;
                    case 8:
                        modificarProfesor();
                    break;
                    case 9:
                        eliminarProfesor();
                    break;
                    case 10:
                        buscarProfesor();
                    break;
                    case 11:
                        mostrarComunidadUniversitaria();
                    break;
                    case 12:
                        System.out.println("Baiii!");
                    break;
                }
            }

        }catch(IOException e){
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
