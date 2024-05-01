package Dao;

import Entidades.Alumno;
import java.util.HashMap;
import java.util.Map;

public class AlumnoDao {
    private Map<Integer, Alumno> alumnos;

    public AlumnoDao() {
        this.alumnos = new HashMap<>();
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.put(alumno.getId(), alumno);
    }

    public Alumno obtenerAlumno(int id) {
        return alumnos.get(id);
    }

    public void actualizarAlumno(Alumno alumno) {
        if (alumnos.containsKey(alumno.getId())) {
            alumnos.put(alumno.getId(), alumno);
        } else {
            throw new IllegalArgumentException("El alumno con id " + alumno.getId() + " no existe.");
        }
    }

    public void eliminarAlumno(int id) {
        alumnos.remove(id);
    }

    public Map<Integer, Alumno> getAlumnos() {
        return alumnos;
    }
}