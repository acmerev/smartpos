package mx.com.pcdata.smartpost.domain.producto;

import java.math.BigDecimal;

public record DatosListadoProducto(
        Long claveProducto,
        String descripcion,
        String unidad,
        BigDecimal precioUnitario,
        BigDecimal stock) {

    public DatosListadoProducto(Producto producto){
        this(producto.getClaveProducto(),
                producto.getDescripcion(),
                producto.getUnidad(),
                producto.getPrecioUnitario(),
                producto.getStock());
    }
}
