import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoDaoTest {
    private AlumnoDao alumnoDao;

    @BeforeEach
    public void setUp() {
        this.alumnoDao = new AlumnoDao();
        alumnoDao.add(new Alumno(1, "Juan", "Perez"));
        alumnoDao.add(new Alumno(2, "Maria", "Gomez"));
        alumnoDao.add(new Alumno(3, "Carlos", "Lopez"));
        alumnoDao.add(new Alumno(4, "Ana", "Rodriguez"));
        alumnoDao.add(new Alumno(5, "Pedro", "Garcia"));
    }

    @Test
    public void testAdd() {
        Alumno alumno = new Alumno(6, "Laura", "Fernandez");
        alumnoDao.add(alumno);
        assertEquals(alumno, alumnoDao.findByAlumnoId(6));
    }

    @Test
    public void testFindByAlumnoIdExitente() {
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        alumnoDao.add(alumno);
        assertEquals(alumno, alumnoDao.findByAlumnoId(7));
    }
    @Test
    public void testFindByAlumnoIdNoExistente() {
        assertNull(alumnoDao.findByAlumnoId(7));
    }


    @Test
    public void testUpdateExistente() {
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        try {
            alumnoDao.update(alumno);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Se esperaba una excepción.");
    }

    @Test
    public void testUpdateNoExistente() {
        Alumno alumno = new Alumno(3, "Lucia", "Martinez");
        alumnoDao.update(alumno);
        assertEquals(alumno, alumnoDao.findByAlumnoId(3));
    }


    @Test
    public void testEliminarAlumnoExistente() {
        alumnoDao.delete(5);
        assertEquals(null, alumnoDao.findByAlumnoId(5));
    }

    @Test
    public void testEliminarAlumnoNoExistente() {
        alumnoDao.delete(6);
        assertEquals(null, alumnoDao.findByAlumnoId(6));
    }


    @Test
    public void testFindAll() {
        Map<Integer, Alumno> alumnos = alumnoDao.findAll();
        assertEquals(5, alumnos.size());
        assertEquals(new Alumno(1, "Juan", "Perez"), alumnos.get(1));
        assertEquals(new Alumno(2, "Maria", "Gomez"), alumnos.get(2));
        assertEquals(new Alumno(3, "Carlos", "Lopez"), alumnos.get(3));
        assertEquals(new Alumno(4, "Ana", "Rodriguez"), alumnos.get(4));
        assertEquals(new Alumno(5, "Pedro", "Garcia"), alumnos.get(5));
    }
}
