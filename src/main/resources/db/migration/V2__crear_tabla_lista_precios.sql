-- Crear la secuencia para el ID si no existe
CREATE SEQUENCE IF NOT EXISTS lista_precios_id_seq START WITH 1 INCREMENT BY 1;

-- Crear la tabla lista_precios si no existe
CREATE TABLE IF NOT EXISTS public.lista_precios (
    id BIGINT NOT NULL DEFAULT nextval('lista_precios_id_seq'),
    clave_producto BIGINT UNIQUE NOT NULL,
    precio_publico NUMERIC(38,2) NOT NULL,
    precio_medio_mayoreo NUMERIC(38,2) NOT NULL,
    precio_mayoreo NUMERIC(38,2) NOT NULL,
    CONSTRAINT lista_precios_pkey PRIMARY KEY (id),
    CONSTRAINT lista_precios_clave_producto_fkey FOREIGN KEY (clave_producto)
        REFERENCES public.productos (clave_producto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

-- Asignar el dueño de la tabla
ALTER TABLE public.lista_precios OWNER TO postgres;

-- Asociar la secuencia a la columna id
ALTER SEQUENCE lista_precios_id_seq OWNED BY public.lista_precios.id;
