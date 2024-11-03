package exportar;

import dao.DAOProducto;
import dto.DTOProducto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportarExcel {

    public void exportarProductosAExcel(String filePath) {
        DAOProducto daoProducto = new DAOProducto();
        List<DTOProducto> productos = daoProducto.listarProductos();

        // crea un libro de trabajo 
        Workbook workbook = new XSSFWorkbook();
        // crear la ho ja
        Sheet sheet = workbook.createSheet("Productos");

        // filas de encabezdo
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Proveedor ID");
        headerRow.createCell(2).setCellValue("Nombre Producto");
        headerRow.createCell(3).setCellValue("Descripción");
        headerRow.createCell(4).setCellValue("Precio Unitario");
        headerRow.createCell(5).setCellValue("Stock");

        // agregar los productos a la hoja
        int rowNum = 1; 
        for (DTOProducto producto : productos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(producto.getProductoid());
            row.createCell(1).setCellValue(producto.getProveedorid());
            row.createCell(2).setCellValue(producto.getNombreProducto());
            row.createCell(3).setCellValue(producto.getDescripcion());
            row.createCell(4).setCellValue(producto.getPrecioU());
            row.createCell(5).setCellValue(producto.getStock());
        }

        // guar da
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel creado con éxito en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el libro de trabajo: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ExportarExcel exportarExcel = new ExportarExcel();
        exportarExcel.exportarProductosAExcel("productos.xlsx");
    }
}