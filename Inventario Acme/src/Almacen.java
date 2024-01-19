import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Almacen {
     private Map<Integer, Producto> inventario;
    private Map<Integer, String> categorias;
    private Scanner scanner;

    public Almacen() {
        this.inventario = new HashMap<>();
        this.categorias = new HashMap<>();
        this.scanner = new Scanner(System.in);
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        categorias.put(1, "Computadores");
        categorias.put(2, "Celulares");
        categorias.put(3, "Electrodomésticos");
        categorias.put(4, "TV");
        categorias.put(5, "Accesorios");
        categorias.put(6, "Videojuegos");
        categorias.put(7, "Audio y video");
    }

    public void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1 - Agregar Producto");
        System.out.println("2 - Eliminar Producto");
        System.out.println("3 - Visualizar Inventario por Categoría");
        System.out.println("4 - Visualizar Categorías");
        System.out.println("0 - Salir");
    }

    public void agregarProducto() {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese cantidad disponible: ");
        int cantidad = scanner.nextInt();

        // Mostrar menú de categorías
        int categoria = seleccionarCategoria();

        Producto producto = new Producto(nombre, precio, inventario.size() + 1, cantidad, categoria);
        inventario.put(producto.getReference(), producto);
        System.out.println("Producto agregado con éxito.");
    }

    public int seleccionarCategoria() {
        System.out.println("=== Seleccione una Categoría ===");
        categorias.forEach((key, value) -> System.out.println(key + " - " + value));

        int categoriaSeleccionada;
        do {
            System.out.print("Ingrese el número de la categoría: ");
            categoriaSeleccionada = scanner.nextInt();
        } while (!categorias.containsKey(categoriaSeleccionada));

        return categoriaSeleccionada;
    }

    public void eliminarProducto() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.print("Ingrese referencia del producto a eliminar: ");
        int referencia = scanner.nextInt();

        if (inventario.containsKey(referencia)) {
            Producto productoEliminado = inventario.remove(referencia);
            System.out.println("Producto eliminado con éxito: " + productoEliminado);
        } else {
            System.out.println("Error: Producto no encontrado.");
        }
    }

    public void visualizarInventarioPorCategoria() {
        System.out.print("Ingrese categoría para visualizar el inventario: ");
        int categoria = scanner.nextInt();

        if (categorias.containsKey(categoria)) {
            System.out.println("Inventario para la categoría " + categorias.get(categoria) + ":");
            inventario.values().stream()
                    .filter(producto -> producto.getCategoria() == categoria)
                    .forEach(System.out::println);
        } else {
            System.out.println("Error: Categoría no válida.");
        }
    }

    public void visualizarCategorias() {
        System.out.println("Categorías disponibles:");
        categorias.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
