package edu.craptocraft.streams.logic;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class RutaInvalidaTest {

    private RutaInvalida rutaInvalida;

    @Before
    public void setUp() {
        rutaInvalida = new RutaInvalida("Ruta inválida");
    }

    @Test
    public void testConstructorWithoutArguments() {
        RutaInvalida rutaInvalida = new RutaInvalida();
        assertEquals(null, rutaInvalida.getMessage());
    }

    @Test
    public void testConstructorWithMessageArgument() {
        String expectedMessage = "Ruta inválida";
        assertEquals(expectedMessage, rutaInvalida.getMessage());
    }
    
}
