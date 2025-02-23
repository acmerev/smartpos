-- Crear tabla de productos
CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    clave_sat_producto VARCHAR(10) NOT NULL,
    clave_producto BIGINT UNIQUE NOT NULL,
    descripcion TEXT NOT NULL,
    unidad VARCHAR(20) NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    stock DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock_minimo DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock_maximo DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- Crear tabla de proveedores
CREATE TABLE proveedores (
    id SERIAL PRIMARY KEY,
    rfc VARCHAR(13) UNIQUE NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    regimen_fiscal VARCHAR(5) NOT NULL
);

-- Crear tabla de compras
CREATE TABLE compras (
    id SERIAL PRIMARY KEY,
    proveedor_id BIGINT NOT NULL,
    fecha TIMESTAMP NOT NULL DEFAULT NOW(),
    total DECIMAL(10,2) NOT NULL,
    xml_uuid VARCHAR(50) UNIQUE NOT NULL,
    estatus VARCHAR(10) NOT NULL DEFAULT 'Pendiente',
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE CASCADE
);

-- Crear tabla de detalles de compra
CREATE TABLE detalles_compra (
    id SERIAL PRIMARY KEY,
    compra_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad DECIMAL(10,2) NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compras(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);

-- Crear tabla de movimientos de inventario
CREATE TABLE movimientos_inventario (
    id SERIAL PRIMARY KEY,
    producto_id BIGINT NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('ENTRADA', 'SALIDA')),
    cantidad DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL DEFAULT NOW(),
    referencia VARCHAR(50) NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);
