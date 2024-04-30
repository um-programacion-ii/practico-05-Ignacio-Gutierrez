package Servicios;

import Dao.AlumnoDao;
import Entidades.Alumno;

import java.util.Map;

public class AlumnoService {
    private AlumnoDao alumnoDao;

    public AlumnoService() {
        this.alumnoDao = new AlumnoDao();
    }

    public Alumno findByAlumnoId(int id) {
        return alumnoDao.findByAlumnoId(id);
    }

    public void addAlumno(Alumno alumno) {
        alumnoDao.add(alumno);
    }

    public void updateAlumno(Alumno alumno) {
        alumnoDao.update(alumno);
    }

    public void deleteAlumno(int id) {
        alumnoDao.delete(id);
    }

    public Map<Integer, Alumno> findAllAlumnos() {
        return alumnoDao.findAll();
    }
}