package mx.com.pcdata.smartpost.domain.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByClaveProducto(Long claveProducto);
}
