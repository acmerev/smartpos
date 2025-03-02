package mx.com.pcdata.smartpost.controller;

import mx.com.pcdata.smartpost.domain.producto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ListaPreciosService listaPreciosService;

    @GetMapping
    public ResponseEntity<Page<DatosListadoProducto>> listadoProductos(@PageableDefault(size = 50) Pageable paginacion) {
        Page<DatosListadoProducto> productos = productoRepository.findAll(paginacion)
                .map(DatosListadoProducto::new);

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{claveProducto}")
    public ResponseEntity<DatosListaPrecio> obtenerPrecio(@PathVariable Long claveProducto) {
        Optional<DatosListaPrecio> datosListaPrecio = listaPreciosService.obtenerDatosListaPrecio(claveProducto);

        return datosListaPrecio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
