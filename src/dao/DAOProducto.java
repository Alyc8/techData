package dao;

/**
 *
 * @author #RoaAlyc '^'
 */
import dto.DTOProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto extends DAOConexion {

    private static final Logger logger = LoggerFactory.getLogger(DAOProducto.class); // Logger para la clase

    public DAOProducto() {
        super();
        Conectar();
    }

    // MÉTODO PARA LISTAR PRODUCTOS
    public List<DTOProducto> listarProductos() {
        List<DTOProducto> productos = new ArrayList<>();
        String query = "select * from Producto";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                DTOProducto producto = new DTOProducto(
                    rs.getString("Producto_ID"),
                    rs.getString("Proveedor_ID"),
                    rs.getString("NombreProducto"),
                    rs.getString("Descripcion"),
                    rs.getFloat("PrecioUnitario"),
                    rs.getInt("CantidadStock")
                );
                productos.add(producto);
            }

        } catch (SQLException e) {
            logger.error("Error al listar productos: {}", e.getMessage());
        }

        return productos;
    }

    // MÉTODO PARA BUSCAR POR ID DEL PRODUCTO
    public DTOProducto buscarProductoPorId(String productoId) {
        DTOProducto producto = null;
        String query = "SELECT * FROM Producto WHERE Producto_ID = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, productoId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                producto = new DTOProducto(
                    rs.getString("Producto_ID"),
                    rs.getString("Proveedor_ID"),
                    rs.getString("NombreProducto"),
                    rs.getString("Descripcion"),
                    rs.getFloat("PrecioUnitario"),
                    rs.getInt("CantidadStock")
                );
            }
        } catch (SQLException e) {
            logger.error("Error al buscar producto: {}", e.getMessage());
        }

        return producto;
    }

    // MÉTODO PARA ELIMINAR PRODUCTO
    public boolean eliminarProducto(String productoId) {
        String query = "delete from Producto where Producto_ID = ?";
        boolean resultado = false;

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, productoId);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                resultado = true; // Se eliminó el producto
            }
        } catch (SQLException e) {
            logger.error("Error al eliminar producto: {}", e.getMessage());
        }

        return resultado;
    }

    // MÉTODO PARA CREAR PRODUCTO
    public boolean crearProducto(DTOProducto producto) {
        String query = "insert into Producto (Producto_ID, Proveedor_ID, NombreProducto, Descripcion, PrecioUnitario, CantidadStock) VALUES (?, ?, ?, ?, ?, ?)";
        boolean resultado = false;

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, producto.getProductoid());
            pstmt.setString(2, producto.getProveedorid());
            pstmt.setString(3, producto.getNombreProducto());
            pstmt.setString(4, producto.getDescripcion());
            pstmt.setFloat(5, producto.getPrecioU());
            pstmt.setInt(6, producto.getStock());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                resultado = true; // Se creó el producto
            }
        } catch (SQLException e) {
            logger.error("Error al crear producto: {}", e.getMessage());
        }

        return resultado;
    }

    // MÉTODO PARA MODIFICAR PRODUCTO
    public boolean modificarProducto(DTOProducto producto) {
        String query = "update Producto set Proveedor_ID = ?, NombreProducto = ?, Descripcion = ?, PrecioUnitario = ?, CantidadStock = ? where Producto_ID = ?";
        boolean resultado = false;

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, producto.getProveedorid());
            pstmt.setString(2, producto.getNombreProducto());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setFloat(4, producto.getPrecioU());
            pstmt.setInt(5, producto.getStock());
            pstmt.setString(6, producto.getProductoid());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                resultado = true; // Se modificó el producto
            }
        } catch (SQLException e) {
            logger.error("Error al modificar producto: {}", e.getMessage());
        }

        return resultado;
    }
}