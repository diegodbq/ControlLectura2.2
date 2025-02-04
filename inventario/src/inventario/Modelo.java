import java.util.ArrayList;
import java.util.List;
class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }
}

class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void actualizarInventario(String nombre, double precio, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                return;
            }
        }
    }

    public List<Producto> consultarProductos() {
        return productos;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
}