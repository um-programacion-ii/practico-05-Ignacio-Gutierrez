import Dao.AlumnoDao;
import Entidades.Alumno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AlumnoDaoTest {
    private AlumnoDao alumnoDao;

    @BeforeEach
    public void setUp() {
        this.alumnoDao = new AlumnoDao();
        alumnoDao.agregarAlumno(new Alumno(1, "Juan", "Perez"));
        alumnoDao.agregarAlumno(new Alumno(2, "Maria", "Gomez"));
        alumnoDao.agregarAlumno(new Alumno(3, "Carlos", "Lopez"));
        alumnoDao.agregarAlumno(new Alumno(4, "Ana", "Rodriguez"));
        alumnoDao.agregarAlumno(new Alumno(5, "Pedro", "Garcia"));
    }

    @Test
    public void testAgregarAlumno() {
        Alumno alumno = new Alumno(6, "Laura", "Fernandez");
        alumnoDao.agregarAlumno(alumno);
        assertEquals(alumno, alumnoDao.obtenerAlumno(6));
    }

    @Test
    public void testObtenerAlumnoExitente() {
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        alumnoDao.agregarAlumno(alumno);
        assertEquals(alumno, alumnoDao.obtenerAlumno(7));
    }
    @Test
    public void testObtenerAlumnoNoExistente() {
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        assertNull(alumnoDao.obtenerAlumno(7));
    }


    @Test
    public void testActualizarAlumno() {
        Alumno alumno = new Alumno(3, "Lucia", "Martinez");
        alumnoDao.actualizarAlumno(alumno);
        assertEquals(alumno, alumnoDao.obtenerAlumno(3));
    }

    @Test
    public void testEliminarAlumno() {
        alumnoDao.eliminarAlumno(5);
        assertEquals(null, alumnoDao.obtenerAlumno(5));
    }

    @Test
    public void testGetAlumnos() {
        Map<Integer, Alumno> alumnos = alumnoDao.getAlumnos();
        assertEquals(5, alumnos.size());
    }
}
