package gui;

/**
 *
 * @author #RoaAlyc '^'
 */
import dao.DAOProducto;
import dto.DTOProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final Logger logger = LoggerFactory.getLogger(Principal.class);
    public static void main(String[] args) {
        DAOProducto daoProducto = new DAOProducto();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.print("\nGestión de TEchData\n"
                    + "1. Listar los productos.\n"
                    + "2. Buscar producto por ID.\n"
                    + "3. Insertar un nuevo producto.\n"
                    + "4. Modificar producto.\n"
                    + "5. Eliminar producto.\n"
                    + "6. Salir\n"
                    + "Escoge la opción que desea realizar: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: //----------   LISTA DE TODOS LOS PRODUCTOS
                    List<DTOProducto> productos = daoProducto.listarProductos();

                    for (DTOProducto producto : productos) {
                        System.out.println("\nID: " + producto.getProductoid());
                        System.out.println("Proveedor ID: " + producto.getProveedorid());
                        System.out.println("Nombre: " + producto.getNombreProducto());
                        System.out.println("Descripción: " + producto.getDescripcion());
                        System.out.println("Precio Unitario: S/. " + producto.getPrecioU());
                        System.out.println("Stock: " + producto.getStock() + "\n");
                    }

                    System.out.print("Total de productos: " + productos.size() + "\n");
                    break;

                case 2: // -------------  BUSCAR POR ID                                              
                    System.out.print("\nIngrese ID: ");
                    String productoId = sc.next();
                    
                    DTOProducto producto = daoProducto.buscarProductoPorId(productoId);
                    if (producto != null) {
                        System.out.println("Proveedor ID: " + producto.getProveedorid());
                        System.out.println("Nombre: " + producto.getNombreProducto());
                        System.out.println("Descripción: " + producto.getDescripcion());
                        System.out.println("Precio Unitario: S/. " + producto.getPrecioU());
                        System.out.println("Stock: " + producto.getStock() + "\n");
                    } else {
                        System.out.println("Producto no encontrado o no existe. Vuelve a ingresar.");
                    }
                    break;

                case 3: // ---------   CREAR  PRODUCTO
                    System.out.print("Ingrese ID: ");
                    String Productoid = sc.next();
                    
                    System.out.print("\nLista de Proveedores\n"
                            + "Prov001: TecnoPC Solutions\n"
                            + "Prov002: MonitorPro Supplies\n"
                            + "Prov003: InputX Innovations\n\n");
                    
                    System.out.print("Inserte ID del proveedor: ");
                    String Proveedorid = sc.next();
                    
                    sc.nextLine();

                    System.out.print("Ingrese nombre del producto: ");
                    String NombreProducto = sc.nextLine();
                    
                    System.out.print("Ingrese descripcion: ");
                    String Descripcion = sc.nextLine();
                    
                    System.out.print("Ingrese precio: ");
                    float PrecioU = sc.nextFloat();
                    
                    System.out.print("Ingrese stock: ");
                    int Stock = sc.nextInt();
                    
                    sc.nextLine();

                    DTOProducto nuevoProducto = new DTOProducto(Productoid, Proveedorid, NombreProducto, Descripcion, PrecioU, Stock);
                    boolean creado = daoProducto.crearProducto(nuevoProducto);
                    if (creado) {
                        System.out.println("El producto se ha agregado.");
                    } else {
                        System.out.println("Error al crear el producto. Intente otra vez");
                    }
                    break;

                case 4: // ----------  MODIFICAR/ACTUALIZAR PRODUCTO
                    System.out.print("\nIngrese ID del producto a modificar: ");
                    Productoid = sc.next();

                    // Buscar el producto por ID
                    DTOProducto productoExistente = daoProducto.buscarProductoPorId(Productoid);
                    
                    // si el producto existe
                    if (productoExistente != null) {
                        System.out.println("Proveedor ID: " + productoExistente.getProveedorid());
                        System.out.println("Nombre: " + productoExistente.getNombreProducto());
                        System.out.println("Descripción: " + productoExistente.getDescripcion());
                        System.out.println("Precio Unitario: S/. " + productoExistente.getPrecioU());
                        System.out.println("Stock: " + productoExistente.getStock() + "\n");

                        // Mostrar la lista de proveedores
                        System.out.print("\nModificar Proveedor\n"
                                + "Prov001: TecnoPC Solutions\n"
                                + "Prov002: MonitorPro Supplies\n"
                                + "Prov003: InputX Innovations\n\n");

                        System.out.print("(Dejar en blanco para no modificar)\n");
                        System.out.print("Inserte ID del proveedor: ");
                        Proveedorid = sc.nextLine();
                        if (Proveedorid.isEmpty()) {
                            Proveedorid = productoExistente.getProveedorid();
                        }
                        
                        sc.nextLine();

                        System.out.print("(Dejar en blanco para no modificar)\n");
                        System.out.print("Ingrese nuevo nombre del producto: ");
                        NombreProducto = sc.nextLine();
                        if (NombreProducto.isEmpty()) {
                            NombreProducto = productoExistente.getNombreProducto();
                        }

                        System.out.print("(Dejar en blanco para no modificar)\n");
                        System.out.print("Ingrese nueva descripción: ");
                        Descripcion = sc.nextLine();
                        if (Descripcion.isEmpty()) {
                            Descripcion = productoExistente.getDescripcion();
                        }

                        System.out.print("(Dejar en blanco para no modificar)\n");
                        System.out.print("Ingrese nuevo precio: ");
                        String inputPrecioU = sc.nextLine();
                        PrecioU = inputPrecioU.isEmpty() ? productoExistente.getPrecioU() : Float.parseFloat(inputPrecioU);

                        System.out.print("(Dejar en blanco para no modificar)\n");
                        System.out.print("Ingrese nuevo stock: ");
                        String inputStock = sc.nextLine();
                        Stock = inputStock.isEmpty() ? productoExistente.getStock() : Integer.parseInt(inputStock);

                        DTOProducto productoModificado = new DTOProducto(Productoid, Proveedorid, NombreProducto, Descripcion, PrecioU, Stock);

                        boolean exito = daoProducto.modificarProducto(productoModificado);

                        if (exito) {
                            System.out.println("Producto modificado exitosamente.");
                        } else {
                            System.out.println("Error al modificar el producto.");
                        }
                    } else {
                        System.out.println("Producto no encontrado o no existe. Vuelve a ingresar.");
                    }
                    break;

                case 5: // -----------    ELIMINAR POR ID
                    System.out.print("\nIngrese ID del producto a eliminar: ");
                    productoId = sc.next();
                    
                    boolean eliminado = daoProducto.eliminarProducto(productoId);

                    if (eliminado) {
                        System.out.println("El producto ha sido eliminado.");
                    } else {
                        System.out.println("No se pudo eliminar el producto o no existe.");
                    }
                    break;

                case 6: // Opción para salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    logger.warn("Opción no válida seleccionada: {}", opcion); // log de advertencia
                    System.out.println("Error. Vuelva a escoger la opción.");
                    break;
            }
        } while (opcion != 6);
        sc.close(); 
    }   
}
