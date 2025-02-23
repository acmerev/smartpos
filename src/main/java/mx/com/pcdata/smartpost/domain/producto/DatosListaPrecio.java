package mx.com.pcdata.smartpost.domain.producto;

import java.math.BigDecimal;

public record DatosListaPrecio(
        Long claveProducto,
        String descripcion,
        BigDecimal stock,
        BigDecimal precioPublico,
        BigDecimal precioMayoreo,
        BigDecimal precioMedioMayoreo

) {
    public DatosListaPrecio(Producto producto, ListaPrecios listaPrecios) {
        this(producto.getClaveProducto(),
                producto.getDescripcion(),
                producto.getStock(),
                listaPrecios.getPrecioPublico(),
                listaPrecios.getPrecioMayoreo(),
                listaPrecios.getPrecioMedioMayoreo());
    }
}