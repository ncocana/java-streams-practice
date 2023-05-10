package edu.craptocraft.streams;

import java.util.Scanner;

import edu.craptocraft.streams.logic.LecturaEscrituraStreams;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // List<Libro> libros = new ArrayList<>();
        // List<Reservas> reservas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Leer y escribir byte a byte");
            // System.out.println("2. Leer y escribir carácter a carácter");
            // System.out.println("3. Leer y escribir línea a línea con buffers");
            // System.out.println("4. Tratamiento de objetos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
                switch (opcion) {
                    case 1:
                        String ruta = LecturaEscrituraStreams.pedirRuta();
                        LecturaEscrituraStreams.leerEscribirByteByte(ruta);
                        break;
                    // case 2:
                    //     LecturaEscrituraStreams.leerEscribirCarCar(libros);
                    //     break;
                    // case 3:
                    //     LecturaEscrituraStreams.leerEscribirBuffer(libros);
                    //     break;
                    // case 4:
                    //     LecturaEscrituraStreams.buscarLibroPorTitulo(libros);
                    //     break;
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
        scanner.close();
    }
}
