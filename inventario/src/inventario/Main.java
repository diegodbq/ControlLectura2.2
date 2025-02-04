public class Main
{
	public static void main(String[] args) {
	 Inventario inventario = new Inventario();
        VistaConsola vista = new VistaConsola();
        ControladorInventario controlador = new ControladorInventario(inventario, vista);
        controlador.ejecutar();
	}
}
