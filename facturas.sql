--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-02-12 23:20:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16599)
-- Name: articulos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.articulos (
    id_articulo bigint NOT NULL,
    nombre character varying(255),
    precio double precision NOT NULL
);


ALTER TABLE public.articulos OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16602)
-- Name: articulos_id_articulo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.articulos_id_articulo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.articulos_id_articulo_seq OWNER TO postgres;

--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 210
-- Name: articulos_id_articulo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.articulos_id_articulo_seq OWNED BY public.articulos.id_articulo;


--
-- TOC entry 211 (class 1259 OID 16603)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id_cliente character varying(255) NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16608)
-- Name: detalles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalles (
    id_detalle bigint NOT NULL,
    cantidad integer NOT NULL,
    total double precision NOT NULL,
    id_articulo bigint,
    id_factura bigint
);


ALTER TABLE public.detalles OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16611)
-- Name: detalles_id_detalle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalles_id_detalle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalles_id_detalle_seq OWNER TO postgres;

--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 213
-- Name: detalles_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalles_id_detalle_seq OWNED BY public.detalles.id_detalle;


--
-- TOC entry 214 (class 1259 OID 16612)
-- Name: facturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.facturas (
    id_factura bigint NOT NULL,
    fecha timestamp without time zone,
    iva double precision,
    sub_total double precision NOT NULL,
    total double precision NOT NULL,
    id_cliente character varying(255)
);


ALTER TABLE public.facturas OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16615)
-- Name: facturas_id_factura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.facturas_id_factura_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.facturas_id_factura_seq OWNER TO postgres;

--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 215
-- Name: facturas_id_factura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.facturas_id_factura_seq OWNED BY public.facturas.id_factura;


--
-- TOC entry 3178 (class 2604 OID 16616)
-- Name: articulos id_articulo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulos ALTER COLUMN id_articulo SET DEFAULT nextval('public.articulos_id_articulo_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 16617)
-- Name: detalles id_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles ALTER COLUMN id_detalle SET DEFAULT nextval('public.detalles_id_detalle_seq'::regclass);


--
-- TOC entry 3330 (class 0 OID 16599)
-- Dependencies: 209
-- Data for Name: articulos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.articulos (id_articulo, nombre, precio) FROM stdin;
11	Mouse Log	80000
12	Memoria DDR4 4gb	110000
13	Teclado Mecanico	230000
9	Pantalla LCD-ips	150000
14	Audifonos Sony	40000
10	Computador Acer Aspire e14	1500000
\.


--
-- TOC entry 3332 (class 0 OID 16603)
-- Dependencies: 211
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id_cliente, nombre) FROM stdin;
1090517520	Jean Carlos Moncada
1004802394	Gabriela Lizeth Diaz
1090504585	Javier Andres Moncada Peña
88199771	Javier Alberto Moncada Moncada
\.


--
-- TOC entry 3333 (class 0 OID 16608)
-- Dependencies: 212
-- Data for Name: detalles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalles (id_detalle, cantidad, total, id_articulo, id_factura) FROM stdin;
52	1	150000	9	1
53	1	150000	9	2
54	1	1500000	10	2
55	1	80000	11	2
56	1	230000	13	3
57	2	220000	12	3
\.


--
-- TOC entry 3335 (class 0 OID 16612)
-- Dependencies: 214
-- Data for Name: facturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.facturas (id_factura, fecha, iva, sub_total, total, id_cliente) FROM stdin;
1	2022-02-12 22:43:09.619	28500	121500	150000	1090504585
2	2022-02-12 22:50:11.231	328700	1401300	1730000	1090517520
3	2022-02-12 22:50:47.703	85500	364500	450000	88199771
\.


--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 210
-- Name: articulos_id_articulo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.articulos_id_articulo_seq', 14, true);


--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 213
-- Name: detalles_id_detalle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalles_id_detalle_seq', 66, true);


--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 215
-- Name: facturas_id_factura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.facturas_id_factura_seq', 25, true);


--
-- TOC entry 3181 (class 2606 OID 16620)
-- Name: articulos articulos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_pkey PRIMARY KEY (id_articulo);


--
-- TOC entry 3183 (class 2606 OID 16622)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 3185 (class 2606 OID 16624)
-- Name: detalles detalles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT detalles_pkey PRIMARY KEY (id_detalle);


--
-- TOC entry 3187 (class 2606 OID 16626)
-- Name: facturas facturas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT facturas_pkey PRIMARY KEY (id_factura);


--
-- TOC entry 3188 (class 2606 OID 16627)
-- Name: detalles fk4iei5reu3tpf61hgtq240ameq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT fk4iei5reu3tpf61hgtq240ameq FOREIGN KEY (id_articulo) REFERENCES public.articulos(id_articulo);


--
-- TOC entry 3189 (class 2606 OID 16632)
-- Name: detalles fkj21fer0c8gm86rarf28yoyldw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT fkj21fer0c8gm86rarf28yoyldw FOREIGN KEY (id_factura) REFERENCES public.facturas(id_factura);


--
-- TOC entry 3190 (class 2606 OID 16637)
-- Name: facturas fkp2ab9l9b5y3b0pv1ag1hfiun7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT fkp2ab9l9b5y3b0pv1ag1hfiun7 FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente);


-- Completed on 2022-02-12 23:20:22

--
-- PostgreSQL database dump complete
--

