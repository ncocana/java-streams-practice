package edu.craptocraft.streams.logic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PeliculaTest {
    
    @Test
    public void testGetTitulo() {
        Pelicula pelicula = new Pelicula("The Matrix", "1999", "Lana Wachowski", "136", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss", "18:00");
        assertEquals("The Matrix", pelicula.getTitulo());
    }
    
    @Test
    public void testSetTitulo() {
        Pelicula pelicula = new Pelicula("The Matrix", "1999", "Lana Wachowski", "136", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss", "18:00");
        pelicula.setTitulo("The Matrix Reloaded");
        assertEquals("The Matrix Reloaded", pelicula.getTitulo());
    }
    
    @Test
    public void testToString() {
        Pelicula pelicula = new Pelicula("The Matrix", "1999", "Lana Wachowski", "136", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss", "18:00");
        String expected = "\n\t-----The Matrix-----" + 
            "\n\tAño: 1999" + 
            "\n\tDirector: Lana Wachowski" + 
            "\n\tDuración: 136 minutos" + 
            "\n\tSinopsis: A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers." + 
            "\n\tReparto: Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss" + 
            "\n\tSesión: 18:00 horas";
        assertEquals(expected, pelicula.toString());
    }
    
}
