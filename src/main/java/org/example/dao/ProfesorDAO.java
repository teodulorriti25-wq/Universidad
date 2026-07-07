package org.example.dao;
import org.example.config.Conexion;
import org.example.modelo.Profesor;
import java.sql.*;
import java.util.*;

public class ProfesorDAO {
    public boolean nuevoProfesor(Profesor profesor){
        boolean registrado = false;
        String sql = "INSERT INTO profesores VALUES (?,?,?,?,?)";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setInt(3, profesor.getEdad());
            stm.setString(4, profesor.getEspecialidad());
            stm.setDouble(5, profesor.getSueldo());
            int filas = stm.executeUpdate();
            if(filas > 0){
                registrado = true;
                System.out.println("Profesor insertado correctamente");
            }else{
                System.out.println("Error al insertar");
            }
        }catch(SQLException e){
            System.out.println("Error al capturar: " + e.getMessage());
        }
        return registrado;
    }

    public ArrayList<Profesor> listarProfesores(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesores";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()){
            while(rs.next()){
                Profesor profesor = new Profesor();
                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setSueldo(rs.getDouble("sueldo"));
                profesores.add(profesor);
            }
            System.out.println(profesores);
        }catch(SQLException e){
            System.out.println("Error al extraer datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return profesores;
    }

    public boolean actualizarProfesor(Profesor profesor){
        boolean actualizado = false;
        String sql = "UPDATE profesores SET nombre = ?, edad = ?, especialidad = ?, sueldo = ? WHERE numEmpleado = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setString(1, profesor.getNombre());
            stm.setInt(2, profesor.getEdad());
            stm.setString(3, profesor.getEspecialidad());
            stm.setDouble(4, profesor.getSueldo());
            stm.setInt(5, profesor.getNumEmpleado());
            int filas = stm.executeUpdate();
            if(filas > 0){
                actualizado = true;
                System.out.println("Profesor actualizado correctamente");
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al actualizar profesor: " + e.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarProfesor(int numEmpleado){
        boolean eliminado = false;
        String sql = "DELETE FROM profesores WHERE numEmpleado = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, numEmpleado);
            int filas = stm.executeUpdate();
            if(filas > 0){
                eliminado = true;
                System.out.println("Profesor eliminado correctamente");
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al eliminar profesor: " + e.getMessage());
        }
        return eliminado;
    }

    public Profesor buscarProfesor(int numEmpleado){

        Profesor profesor = null;

        String sql = "SELECT * FROM profesores WHERE numEmpleado = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, numEmpleado);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                profesor = new Profesor();
                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setSueldo(rs.getDouble("sueldo"));
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al buscar profesor: " + e.getMessage());
        }
        return profesor;
    }
}