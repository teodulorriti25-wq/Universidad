package org.example.dao;
import org.example.modelo.Alumno;
import org.example.config.Conexion;
import java.sql.*;
import java.util.*;

public class AlumnoDAO {
    public boolean nuevoAlumno(Alumno alumno){
        boolean registrado = false;
        String sql = "INSERT INTO alumnos VALUES (?,?,?,?,?)";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setInt(3, alumno.getEdad());
            stm.setString(4, alumno.getCarrera());
            stm.setInt(5, alumno.getCuatrimestres());
            int filas = stm.executeUpdate();
            if(filas > 0){
                registrado = true;
                System.out.println("Alumno insertado correctamente");
            }
        }catch(SQLException e){
            System.out.println("Error al capturar: " + e.getMessage());
        }
        return registrado;
    }
    public ArrayList<Alumno> listarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try(Connection connection = Conexion.getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery()){
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestre"));
                alumnos.add(alumno);
            }
            System.out.println(alumnos);
        } catch (SQLException e) {
            System.out.println("Error al extraer datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return alumnos;
    }

    public boolean actualizarAlumno(Alumno alumno){
        boolean actualizado = false;
        String sql = "UPDATE alumnos SET nombre = ?, edad = ?, carrera = ?, cuatrimestre = ? WHERE numExpediente = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setString(1, alumno.getNombre());
            stm.setInt(2, alumno.getEdad());
            stm.setString(3, alumno.getCarrera());
            stm.setInt(4, alumno.getCuatrimestres());
            stm.setInt(5, alumno.getNumExpediente());
            int filas = stm.executeUpdate();
            if(filas > 0){
                actualizado = true;
                System.out.println("Alumno actualizado correctamente");
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al actualizar al alumno: " + e.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarAlumno(int numExpediente){
        boolean eliminado = false;
        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, numExpediente);
            int filas = stm.executeUpdate();
            if(filas > 0){
                eliminado = true;
                System.out.println("Alumno eliminado correctamente");
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return eliminado;
    }

    public Alumno buscarAlumno(int numExpediente){
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";
        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setInt(1, numExpediente);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestre"));
            }else{
                System.out.println("No se encontro ese registro");
            }
        }catch(SQLException e){
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
        return alumno;
    }
}
