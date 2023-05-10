package edu.craptocraft.streams.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LecturaEscrituraStreams {
    
    LecturaEscrituraStreams() {}

    public static String pedirRuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo: ");
        String ruta = scanner.nextLine();
        return ruta;
    }

    public static void leerEscribirByteByte(String pathFile) {
        try {
            FileInputStream fis = new FileInputStream(pathFile);
            byte[] bytes = fis.readAllBytes();
            String cartelera = new String(bytes);
            String[] peliculas = cartelera.split("\\{");

            System.out.println("\n\tCartelera de CineCIFFBMOLL");

            for (String pelicula : peliculas) {
                String[] campos = pelicula.split("#");

                if (campos.length == 7) {
                    Pelicula p = new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
                    System.out.println(p.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
