package edu.craptocraft.streams.logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RutaInvalida extends Exception {

    private static final String ERROR_LOG_FILE = "error.log";

    public RutaInvalida() {
        super();
    }

    public RutaInvalida(String message) {
        super(message);
    }

    public RutaInvalida(Throwable cause) {
        super(cause);
    }

    public RutaInvalida(String message, Throwable cause) {
        super(message, cause);
    }

    public void printError() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String mensajeError = timeStamp + " - " + this.getStackTrace() + " - " + this.getMessage() + "\n";

        try (PrintWriter out = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true))) {
            out.append(mensajeError);
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el archivo de log de errores.");
            e.printStackTrace();
        }

        System.err.println(mensajeError);
    }

}
