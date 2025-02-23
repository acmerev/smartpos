package mx.com.pcdata.smartpost.domain.producto;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ListaPreciosService {
    private final ListaPreciosRepository listaPreciosRepository;
    private final ProductoRepository productoRepository;

    public ListaPreciosService(ListaPreciosRepository listaPreciosRepository, ProductoRepository productoRepository) {
        this.listaPreciosRepository = listaPreciosRepository;
        this.productoRepository = productoRepository;
    }

    public Optional<DatosListaPrecio> obtenerDatosListaPrecio(Long claveProducto) {
        Optional<Producto> productoOpt = productoRepository.findByClaveProducto(claveProducto);
        Optional<ListaPrecios> listaPreciosOpt = listaPreciosRepository.findByClaveProducto(claveProducto);

        if (productoOpt.isPresent() && listaPreciosOpt.isPresent()) {
            return Optional.of(new DatosListaPrecio(productoOpt.get(), listaPreciosOpt.get()));
        } else {
            return Optional.empty();
        }
    }
}
