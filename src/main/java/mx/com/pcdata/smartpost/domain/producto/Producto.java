package mx.com.pcdata.smartpost.domain.producto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claveSatProducto;
    @Column(name = "clave_producto")
    private Long claveProducto;
    private String descripcion;
    private String unidad;
    private BigDecimal precioUnitario;
    private BigDecimal stock;
    private BigDecimal stockMinimo;
    private BigDecimal stockMaximo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaveSatProducto() {
        return claveSatProducto;
    }

    public void setClaveSatProducto(String claveSatProducto) {
        this.claveSatProducto = claveSatProducto;
    }

    public Long getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(Long claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigDecimal stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public BigDecimal getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(BigDecimal stockMaximo) {
        this.stockMaximo = stockMaximo;
    }
}