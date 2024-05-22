import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var apiConversor = new ApiConversor();
        boolean continuar = true;
        List<String> historial = new ArrayList<>();

        System.out.println("\nBienvenido al conversor de Monedas! A continuación encontrarás dos opciones para elegir si quieres convertir una moneda o salir del programa.");
        System.out.println("Al elegir convertir una moneda tendrás que ingresar la moneda base que quieras convertir y luego a cual deseas convertirla.");
        System.out.println("Esta debe ser ingresada en en formato de código ISO 4217, como por ejemplo: USD - EUR - CAD - etc. ");
        System.out.println("En la siguiente página web puedes encontrar el listado https://es.wikipedia.org/wiki/ISO_4217.");

        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Historial de conversiones");
            System.out.println("3. Salir");
            System.out.print("Escriba el número de la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la divisa base (por ejemplo, USD): ");
                    var divisaBase = scanner.nextLine().toUpperCase();

                    System.out.print("Introduce la divisa a la que quieres convertir tu divisa base (por ejemplo, EUR): ");
                    var divisaObjetivo = scanner.nextLine().toUpperCase();

                    System.out.print("Introduce la cantidad a convertir: ");
                    var cantidad = scanner.nextDouble();

                    var moneda = apiConversor.obtenerTasaDeCambio(divisaBase, divisaObjetivo);

                    var resultado = cantidad * moneda.conversion_rate();
                    System.out.printf("La cantidad de %.2f %s es igual a %.2f %s%n", cantidad, divisaBase, resultado, divisaObjetivo);

                    String conversion = String.format("%.2f %s a %.2f %s", cantidad, divisaBase, resultado, divisaObjetivo);
                    historial.add(conversion);

                    break;

                case 2:
                    System.out.println("Este es el historial de conversiones realizadas: ");
                    if (historial.isEmpty()){
                        System.out.println("No existen registro de conversiones realizadas.");
                    } else {
                        historial.forEach(System.out::println);
                    }
                    break;

                case 3:
                    continuar = false;
                    System.out.println("....Finalizando programa....");
                    System.out.println("Muchas gracias por usar nuestros servicios de conversión de monedas. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }
    }
}
