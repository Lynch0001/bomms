DROP TABLE IF EXISTS public.inventory_items CASCADE;

DROP TABLE IF EXISTS public.stores CASCADE;

CREATE TABLE IF NOT EXISTS public.stores(
              id INT8,
              store_code VARCHAR(5),
              address VARCHAR(25),
              city VARCHAR(25),
              state VARCHAR(2),
              zip VARCHAR(15),
              primary key (id)
);

CREATE TABLE IF NOT EXISTS public.inventory_items(
                              id INT8,
                              isbn13 VARCHAR(15),
                              quantity INT4,
                              store_id int8 not null,
                              primary key (id),
                              FOREIGN KEY (store_id) REFERENCES public.stores(id)
);
