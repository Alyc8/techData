package techdata;

/** SOLO PARA VERIFICAR QUE LOS METODOS FUNCIONAN - ELIMINAR LUEGO
 *
 * @author #RoaAlyc '^'
 */
import dao.DAOProducto;
import dto.DTOProducto;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOProducto daoProducto = new DAOProducto();
        
 //----------   LISTA DE TODOS LOS PRDUCTOS
        
       List<DTOProducto> productos = daoProducto.listarProductos();
       
       for (DTOProducto producto : productos) {
            System.out.println("ID: " + producto.getProductoid());
            System.out.println("Proveedor ID: " + producto.getProveedorid());
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio Unitario: S/." + producto.getPrecioU());
            System.out.println("Stock: " + producto.getStock()+"\n");                  
        }
        
    System.out.println("Total de productos: " + productos.size());
    
    
// -------------  BUSCAR POR ID 

//        String productoId = "Prod001";
//
//        DTOProducto producto = daoProducto.buscarProductoPorId(productoId);
//        if (producto != null) {
//            System.out.println("Producto encontrado: " + producto.getProductoid());
//            System.out.println("Proveedor ID: " + producto.getProveedorid());
//            System.out.println("Nombre: " + producto.getNombreProducto());
//            System.out.println("Descripción: " + producto.getDescripcion());
//            System.out.println("Precio Unitario: S/." + producto.getPrecioU());
//            System.out.println("Stock: " + producto.getStock()+"\n");  
//        } else {
//            System.out.println("Producto no encontrado o no existe. Vuelve a ingresar.");
//        }


// -----------    ELIMINAR POR ID

//        String productoId = "Prod004"; 
//        
//        boolean eliminado = daoProducto.eliminarProducto(productoId);
//
//        if (eliminado) {
//            System.out.println("El producto ha sido eliminado.");
//        } else {
//            System.out.println("No se pudo eliminar el producto o no existe.");
//        }


// ---------   CREAR  PROD CTO
//        DTOProducto nuevoProducto = new DTOProducto("Prod004", "Prov003", "Producto Ejemplo", "ejemplo en netbeans", 100.0f, 50);
//
//        boolean creado = daoProducto.crearProducto(nuevoProducto);
//            if (creado) {
//                System.out.println("El producto s e ha agregado.");
//            } else {
//                System.out.println("Error al crear el producto. Intente otra vez");
//            }

            
// ----------  MODIFICAR/ACTUALIZAR PRODUCTO

//        DTOProducto productoModificado = new DTOProducto("Prod004", "Prov003", "Producto Ejemplo", "ejemplo en netbeans- probando modificacion", 100.0f, 50);
//        boolean exito = daoProducto.modificarProducto(productoModificado);
//
//        if (exito) {
//            System.out.println("Producto modificado exitosamente.");
//        } else {
//            System.out.println("Error al modificar el producto.");
//        }
//            
    }   
}