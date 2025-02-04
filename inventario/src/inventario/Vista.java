import java.util.Scanner;
import java.util.List;
class VistaConsola {
    private Scanner scanner = new Scanner(System.in);

    public Producto solicitarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: $ ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        return new Producto(nombre, precio, cantidad);
    }

    public String solicitarNombreProducto() {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        return scanner.nextLine();
    }

public double solicitarPrecio() {
        System.out.print("Ingrese el nuevo precio: $ ");
        return scanner.nextDouble();
    }    
    public int solicitarCantidad() {
        System.out.print("Ingrese la nueva cantidad: ");
        return scanner.nextInt();
    }

    public void mostrarProductos(List <Producto> productos) {
        System.out.println("Inventario Actual:");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: $ " + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
        }
    }

    public void mostrarValorTotal(double valor) {
        System.out.println("Valor total del inventario: $ " + valor);
    }
}