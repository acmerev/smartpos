package mx.com.pcdata.smartpost.domain.producto;

import mx.com.pcdata.smartpost.domain.producto.ListaPrecios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ListaPreciosRepository extends JpaRepository<ListaPrecios, Long> {
    Optional<ListaPrecios> findByClaveProducto(Long claveProducto);
}
