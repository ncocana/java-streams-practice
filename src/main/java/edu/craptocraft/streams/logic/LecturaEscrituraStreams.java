package edu.craptocraft.streams.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LecturaEscrituraStreams {
    
    private static final String PRINT_CARTELERA = "\n\tCartelera de CineCIFFBMOLL";

    LecturaEscrituraStreams() {}

    public static String pedirRuta() {
        try {
            Scanner scanner = new Scanner(System.in);
            String ruta = scanner.nextLine();
            return ruta;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static void leerEscribirByteByte(String pathFileInput, String pathFileOutput) {
        try (FileInputStream fis = new FileInputStream(pathFileInput);
        FileWriter fw = new FileWriter(pathFileOutput)) {
            byte[] bytes = fis.readAllBytes();
            String cartelera = new String(bytes);
            String[] peliculas = cartelera.split("\\{");
    
            System.out.println(PRINT_CARTELERA);
            fw.write(PRINT_CARTELERA + "\n");
    
            Stream.of(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> {
                    try {
                        System.out.println(p.toString());
                        fw.write(p.toString() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirCarCar(String pathFileInput, String pathFileOutput) {
        try (FileReader reader = new FileReader(pathFileInput);
        FileWriter fw = new FileWriter(pathFileOutput)) {
            String cartelera = "";
            int c;
            while ((c = reader.read()) != -1) {
                cartelera += (char) c;
            }
            String[] peliculas = cartelera.split("\\{");
    
            System.out.println(PRINT_CARTELERA);
            fw.write(PRINT_CARTELERA + "\n");
    
            Stream.of(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> {
                    try {
                        System.out.println(p.toString());
                        fw.write(p.toString() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirBuffer(String pathFileInput, String pathFileOutput) {
        try (FileReader reader = new FileReader(pathFileInput);
        FileWriter fw = new FileWriter(pathFileOutput)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String cartelera = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            String[] peliculas = cartelera.split("\\{");
    
            System.out.println(PRINT_CARTELERA);
            fw.write(PRINT_CARTELERA + "\n");
    
            Stream.of(peliculas)
                .map(pelicula -> pelicula.split("#"))
                .filter(campos -> campos.length == 7)
                .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                .forEach(p -> {
                    try {
                        System.out.println(p.toString());
                        fw.write(p.toString() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerLineaEscribirObj(String pathFileInput, String pathFileOutput) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFileInput));
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(pathFileOutput))) {
    
            reader.lines()
                    .map(line -> line.split("#"))
                    .filter(campos -> campos.length == 7)
                    .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
                    .forEach(pelicula -> {
                        try {
                            writer.writeObject(pelicula);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void leerObjEscribirCons(String pathFileInput) {
    //     try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(pathFileInput))) {
            
    //         Object obj = reader.readObject();

    //         reader.lines()
    //                 .map(line -> line.split("#"))
    //                 .filter(campos -> campos.length == 7)
    //                 .map(campos -> new Pelicula(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]))
    //                 .forEach(pelicula -> 
    //                     System.out.println(pelicula.toString())
    //                 );
    
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}
