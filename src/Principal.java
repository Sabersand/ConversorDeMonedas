import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiConversor apiConversor = new ApiConversor();

        System.out.println("Bienvenido al Conversor de Monedas");

        // Utiliza println para separar visualmente las instrucciones y la entrada del usuario
        System.out.print("Introduce la divisa base (por ejemplo, USD): ");
        String divisaBase = scanner.nextLine().toUpperCase();
        
        System.out.print("Introduce la divisa objetivo (por ejemplo, EUR): ");
        String divisaObjetivo = scanner.nextLine().toUpperCase();

        System.out.print("Introduce la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        Moneda moneda = apiConversor.obtenerTasaDeCambio(divisaBase, divisaObjetivo);

        double resultado = cantidad * moneda.conversion_rate();
        // Utiliza println para el resultado final
        System.out.printf("La cantidad de %.2f %s es igual a %.2f %s%n", cantidad, divisaBase, resultado, divisaObjetivo);
    }
}
