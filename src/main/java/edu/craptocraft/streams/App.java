package edu.craptocraft.streams;

import java.util.Scanner;

import edu.craptocraft.streams.logic.LecturaEscrituraStreams;
import edu.craptocraft.streams.logic.RutaInvalida;


public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String rutaEntrada = "";
        String rutaSalida = "";
        String errorMessage = "La ruta del archivo es inválida o no está específicada.";

        try {
            do {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Leer y escribir byte a byte");
                System.out.println("2. Leer y escribir carácter a carácter");
                System.out.println("3. Leer y escribir línea a línea con buffers");
                System.out.println("4. Tratamiento de objetos");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    if (opcion == 1 || opcion == 2 || opcion == 3) {
                        System.out.print("Introduce la ruta del archivo: ");
                        rutaEntrada = LecturaEscrituraStreams.pedirRuta();
                        System.out.print("Introduce la ruta donde quieres guardar el archivo: ");
                        rutaSalida = LecturaEscrituraStreams.pedirRuta();
                        // File path: .\src\main\resources\file.txt
                        // File path: .\src\main\resources\file2.txt
                        if (rutaEntrada == null || rutaEntrada.isBlank() || rutaSalida == null || rutaSalida.isBlank()) {
                            throw new RutaInvalida(errorMessage);
                        }
                    }
                    switch (opcion) {
                        case 1:
                            LecturaEscrituraStreams.leerEscribirByteByte(rutaEntrada, rutaSalida);
                            break;
                        case 2:
                            LecturaEscrituraStreams.leerEscribirCarCar(rutaEntrada, rutaSalida);
                            break;
                        case 3:
                            LecturaEscrituraStreams.leerEscribirBuffer(rutaEntrada, rutaSalida);
                            break;
                        case 4:
                            int opcion2 = 0;
                            do {
                                System.out.println("\n--- Tratamiento de objetos ---");
                                System.out.println("1. Lectura línea a línea y escritura con objetos");
                                System.out.println("2. Lectura de objetos y escritura de objetos");
                                System.out.println("3. Lectura de objetos y escritura por consola");
                                System.out.println("0. Volver al menú principal");
                                System.out.print("Selecciona una opción: ");
                        
                                if (scanner.hasNextInt()) {
                                    opcion2 = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer de entrada
                                    if (opcion2 == 1 || opcion2 == 2) {
                                        System.out.print("Introduce la ruta del archivo: ");
                                        rutaEntrada = LecturaEscrituraStreams.pedirRuta();
                                        System.out.print("Introduce la ruta donde quieres guardar el archivo: ");
                                        rutaSalida = LecturaEscrituraStreams.pedirRuta();
                                        // File path: .\src\main\resources\file.txt
                                        // File path: .\src\main\resources\fileObj
                                        // File path: .\src\main\resources\fileObj2
                                        if (rutaEntrada == null || rutaEntrada.isBlank() || rutaSalida == null || rutaSalida.isBlank()) {
                                            throw new RutaInvalida(errorMessage);
                                        }
                                    }
                                    if (opcion2 == 3) {
                                        System.out.print("Introduce la ruta del archivo: ");
                                        rutaEntrada = LecturaEscrituraStreams.pedirRuta();
                                        if (rutaEntrada == null || rutaEntrada.isBlank()) {
                                            throw new RutaInvalida(errorMessage);
                                        }
                                    }
                        
                                    switch (opcion2) {
                                        case 1:
                                            LecturaEscrituraStreams.leerLineaEscribirObj(rutaEntrada, rutaSalida);
                                            break;
                                        case 2:
                                            LecturaEscrituraStreams.leerObjEscribirObj(rutaEntrada, rutaSalida);
                                            break;
                                        case 3:
                                            LecturaEscrituraStreams.leerObjEscribirCons(rutaEntrada);
                                            break;
                                        case 0:
                                            System.out.println("Volder al menú principal...");
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                } else {
                                    scanner.nextLine(); // Limpiar el buffer de entrada
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                                }
                            } while (opcion2 != 0);
                            break;
                        case 0:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } else {
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (opcion != 0);
        } catch (RutaInvalida e) {
            e.printError();
        } finally {
            scanner.close();
        }
    }
}
