package mx.com.pcdata.smartpost.domain.producto;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lista_precios", schema = "public")
public class ListaPrecios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clave_producto", nullable = false, unique = true)
    private Long claveProducto;

    @Column(name = "precio_publico", nullable = false, precision = 38, scale = 2)
    private BigDecimal precioPublico;

    @Column(name = "precio_medio_mayoreo", nullable = false, precision = 38, scale = 2)
    private BigDecimal precioMedioMayoreo;

    @Column(name = "precio_mayoreo", nullable = false, precision = 38, scale = 2)
    private BigDecimal precioMayoreo;

    @ManyToOne
    @JoinColumn(name = "clave_producto", referencedColumnName = "clave_producto", insertable = false, updatable = false)
    private Producto producto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(Long claveProducto) {
        this.claveProducto = claveProducto;
    }

    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(BigDecimal precioPublico) {
        this.precioPublico = precioPublico;
    }

    public BigDecimal getPrecioMedioMayoreo() {
        return precioMedioMayoreo;
    }

    public void setPrecioMedioMayoreo(BigDecimal precioMedioMayoreo) {
        this.precioMedioMayoreo = precioMedioMayoreo;
    }

    public BigDecimal getPrecioMayoreo() {
        return precioMayoreo;
    }

    public void setPrecioMayoreo(BigDecimal precioMayoreo) {
        this.precioMayoreo = precioMayoreo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
