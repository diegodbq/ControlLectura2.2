import java.util.Scanner;
class ControladorInventario {
    private Inventario inventario;
    private VistaConsola vista;

    public ControladorInventario(Inventario inventario, VistaConsola vista) {
        this.inventario = inventario;
        this.vista = vista;
    }

    public void ejecutar() {
        while (true) {
            System.out.println();
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Actualizar Inventario");
            System.out.println("4. Mostrar Valor Total");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = new Scanner(System.in).nextInt();
            System.out.println();
            
            switch (opcion) {
                case 1:
                    inventario.registrarProducto(vista.solicitarProducto());
                    break;
                case 2:
                    vista.mostrarProductos(inventario.consultarProductos());
                    break;
                case 3:
                    String nombre = vista.solicitarNombreProducto();
                    double precio = vista.solicitarPrecio();
                    int cantidad = vista.solicitarCantidad();
                    inventario.actualizarInventario(nombre,precio,cantidad);
                    break;
                case 4:
                    vista.mostrarValorTotal(inventario.calcularValorTotal());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
