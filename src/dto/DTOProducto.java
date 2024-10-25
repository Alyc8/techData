package dto;

/**
 *
 * @author #RoaAlyc '^'
 */
public class DTOProducto {
    String Productoid;
    String Proveedorid;
    String NombreProducto;
    String Descripcion;
    float PrecioU;
    int Stock;


    public DTOProducto(String Productoid, String Proveedorid, String NombreProducto, String Descripcion, float PrecioU, int Stock) {
        this.Productoid = Productoid;
        this.Proveedorid = Proveedorid;
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
        this.PrecioU = PrecioU;
        this.Stock = Stock;
    }

    public String getProductoid() {
        return Productoid;
    }

    public void setProductoid(String Productoid) {
        this.Productoid = Productoid;
    }

    public String getProveedorid() {
        return Proveedorid;
    }

    public void setProveedorid(String Proveedorid) {
        this.Proveedorid = Proveedorid;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecioU() {
        return PrecioU;
    }

    public void setPrecioU(float PrecioU) {
        this.PrecioU = PrecioU;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

                
}
