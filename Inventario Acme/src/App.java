import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            almacen.mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    almacen.agregarProducto();
                    break;
                case 2:
                    almacen.eliminarProducto();
                    break;
                case 3:
                    almacen.visualizarInventarioPorCategoria();
                    break;
                case 4:
                    almacen.visualizarCategorias();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
           
        }
    }
}
    


