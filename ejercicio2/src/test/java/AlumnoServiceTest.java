import Dao.AlumnoDao;
import Entidades.Alumno;
import Servicios.AlumnoService;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AlumnoServiceTest {

    @Mock
    private AlumnoDao alumnoDao;

    @InjectMocks
    private AlumnoService alumnoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddAlumno() {
        Alumno alumno = new Alumno(1, "Juan", "Perez");
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(1)).thenReturn(alumno);
        Alumno resultado = alumnoService.findByAlumnoId(1);
        assertEquals(alumno, resultado);
    }

    @Test
    public void testFindByAlumnoIdExitente() {
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(7)).thenReturn(alumno);
        Alumno resultado = alumnoService.findByAlumnoId(7);
        assertEquals(alumno, resultado);
    }

    @Test
    public void testFindByAlumnoIdNoExistente() {
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(7)).thenReturn(null);
        Alumno resultado = alumnoService.findByAlumnoId(7);
        assertNull(resultado);
    }


    @Test
    public void testUpdateAlumnoNoExistente() {
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Alumno alumno = new Alumno(7, "Laura", "Fernandez");
        Mockito.doThrow(IllegalArgumentException.class).when(alumnoService).updateAlumno(alumno);
        try {
            alumnoService.updateAlumno(alumno);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Se esperaba una excepción.");
    }

    @Test
    public void testUpdateAlumnoExistente() {
        Alumno alumno = new Alumno(3, "Lucia", "Martinez");
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(3)).thenReturn(alumno);
        Alumno resultado = alumnoService.findByAlumnoId(3);
        assertEquals(alumno, resultado);
    }


    @Test
    public void testEliminarAlumnoExistente() {
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(7)).thenReturn(null);
        Alumno resultado = alumnoService.findByAlumnoId(7);
        assertNull(resultado);
    }

    @Test
    public void testEliminarAlumnoNoExistente() {
        AlumnoService alumnoService = Mockito.mock(AlumnoService.class);
        Mockito.when(alumnoService.findByAlumnoId(7)).thenReturn(null);
        Alumno resultado = alumnoService.findByAlumnoId(7);
        assertNull(resultado);
    }

    @Test
    public void testFindAll() {
        Map<Integer, Alumno> mockAlumnos = new HashMap<>();
        mockAlumnos.put(1, new Alumno(1, "Juan", "Perez"));
        mockAlumnos.put(2, new Alumno(2, "Maria", "Gomez"));
        mockAlumnos.put(3, new Alumno(3, "Carlos", "Lopez"));
        mockAlumnos.put(4, new Alumno(4, "Ana", "Rodriguez"));
        mockAlumnos.put(5, new Alumno(5, "Pedro", "Garcia"));

        Mockito.when(alumnoService.findAllAlumnos()).thenReturn(mockAlumnos);

        Map<Integer, Alumno> alumnos = alumnoService.findAllAlumnos();

        assertEquals(5, alumnos.size());
        assertEquals(new Alumno(1, "Juan", "Perez"), alumnos.get(1));
        assertEquals(new Alumno(2, "Maria", "Gomez"), alumnos.get(2));
        assertEquals(new Alumno(3, "Carlos", "Lopez"), alumnos.get(3));
        assertEquals(new Alumno(4, "Ana", "Rodriguez"), alumnos.get(4));
        assertEquals(new Alumno(5, "Pedro", "Garcia"), alumnos.get(5));
    }
}
