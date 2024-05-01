package Dao;

import Entidades.Alumno;

import java.util.HashMap;
import java.util.Map;

public class AlumnoDao {
    private Map<Integer, Alumno> alumnos;

    public AlumnoDao() {
        this.alumnos = new HashMap<>();
    }

    public Alumno findByAlumnoId(int id) {
        return alumnos.get(id);
    }

    public void add(Alumno alumno) {
        alumnos.put(alumno.getId(), alumno);
    }

    public void update(Alumno alumno) {
        if (alumnos.containsKey(alumno.getId())) {
            alumnos.put(alumno.getId(), alumno);
        } else {
            throw new IllegalArgumentException("El alumno con id " + alumno.getId() + " no existe.");
        }
    }

    public void delete(int id) {
        alumnos.remove(id);
    }

    public Map<Integer, Alumno> findAll() {
        return alumnos;
    }

}