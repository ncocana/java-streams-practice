package edu.craptocraft.streams.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LecturaEscrituraStreams {
    
    LecturaEscrituraStreams() {}

    public static String pedirRuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo: ");
        String ruta = scanner.nextLine();
        return ruta;
    }

    public static void leerEscribirByteByte(String pathFile) {
        try (FileInputStream fis = new FileInputStream(pathFile)){
            byte[] bytes = fis.readAllBytes();
            String cartelera = new String(bytes);
            String[] peliculas = cartelera.split("\\{");

            System.out.println("\n\tCartelera de CineCIFFBMOLL");

            Arrays.stream(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirCarCar(String pathFile) {
        try (FileReader reader = new FileReader(pathFile)) {
            String cartelera = "";
            int c;
            while ((c = reader.read()) != -1) {
                cartelera += (char) c;
            }
            String[] peliculas = cartelera.split("\\{");
    
            System.out.println("\n\tCartelera de CineCIFFBMOLL");
    
            Arrays.stream(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> System.out.println(p.toString()));
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirBuffer(String pathFile) {
        try (FileReader reader = new FileReader(pathFile)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String cartelera = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            String[] peliculas = cartelera.split("\\{");
    
            System.out.println("\n\tCartelera de CineCIFFBMOLL");
    
            Arrays.stream(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> System.out.println(p.toString()));
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
