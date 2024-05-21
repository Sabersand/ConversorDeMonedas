import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var apiConversor = new ApiConversor();
        boolean continuar = true;

        System.out.println("\nBienvenido al conversor de Monedas! A continuación encontrarás dos opciones para elegir si quieres convertir una moneda o salir del programa.");
        System.out.println("Al elegir convertir una moneda tendrás que ingresar la moneda base que quieras convertir y luego a cual deseas convertirla.");
        System.out.println("Esta debe ser ingresada en en formato de código ISO 4217, como por ejemplo: USD - EUR - CAD - etc. ");
        System.out.println("En la siguiente página web puedes encontrar el listado https://es.wikipedia.org/wiki/ISO_4217.");
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la divisa base (por ejemplo, USD): ");
                    var divisaBase = scanner.nextLine().toUpperCase();

                    System.out.print("Introduce la divisa objetivo (por ejemplo, EUR): ");
                    var divisaObjetivo = scanner.nextLine().toUpperCase();

                    System.out.print("Introduce la cantidad a convertir: ");
                    var cantidad = scanner.nextDouble();

                    var moneda = apiConversor.obtenerTasaDeCambio(divisaBase, divisaObjetivo);

                    var resultado = cantidad * moneda.conversion_rate();
                    System.out.printf("La cantidad de %.2f %s es igual a %.2f %s%n", cantidad, divisaBase, resultado, divisaObjetivo);
                    break;

                case 2:
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
