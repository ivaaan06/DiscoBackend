toc.dat                                                                                             0000600 0004000 0002000 00000036270 14147313576 0014462 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           &            
    y            Disquera    13.4    13.4 3    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         �           1262    16926    Disquera    DATABASE     f   CREATE DATABASE "Disquera" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Disquera";
                postgres    false         �            1259    16927    album    TABLE     `  CREATE TABLE public.album (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    descripcion character varying(30) NOT NULL,
    duracion integer NOT NULL,
    precio integer NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_lanzamiento date NOT NULL,
    num_ventas integer NOT NULL,
    id_artista integer NOT NULL
);
    DROP TABLE public.album;
       public         heap    postgres    false         �            1259    16932    artista    TABLE     D  CREATE TABLE public.artista (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    nombre_artistico character varying(15) NOT NULL,
    genero character varying(15) NOT NULL,
    nacionalidad character varying(15) NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_nacimiento date NOT NULL
);
    DROP TABLE public.artista;
       public         heap    postgres    false         �            1259    16970    ViewArtistaAlbum    VIEW     %  CREATE VIEW public."ViewArtistaAlbum" AS
 SELECT art.id,
    art.nombre_artistico,
    art.genero,
    alb.nombre AS nombre_album,
    alb.precio,
    alb.imagen AS imagen_album,
    alb.fecha_lanzamiento
   FROM (public.artista art
     JOIN public.album alb ON ((art.id = alb.id_artista)));
 %   DROP VIEW public."ViewArtistaAlbum";
       public          postgres    false    200    200    200    200    202    200    202    202         �            1259    16937    cancion    TABLE     �  CREATE TABLE public.cancion (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    descripcion character varying(30) NOT NULL,
    duracion integer NOT NULL,
    nacionalidad character varying(15) NOT NULL,
    precio integer NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_lanzamiento date NOT NULL,
    num_ventas integer NOT NULL,
    id_album integer NOT NULL,
    id_artista integer NOT NULL
);
    DROP TABLE public.cancion;
       public         heap    postgres    false         �            1259    16966    ViewArtistaCancion    VIEW     !  CREATE VIEW public."ViewArtistaCancion" AS
 SELECT art.id,
    art.nombre_artistico,
    art.genero,
    c.nombre AS nombre_cancion,
    c.precio,
    c.imagen AS imagen_cancion,
    c.fecha_lanzamiento
   FROM (public.artista art
     JOIN public.cancion c ON ((art.id = c.id_artista)));
 '   DROP VIEW public."ViewArtistaCancion";
       public          postgres    false    204    204    204    204    204    202    202    202         �            1259    16930    album_id_seq    SEQUENCE     �   CREATE SEQUENCE public.album_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.album_id_seq;
       public          postgres    false    200         �           0    0    album_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;
          public          postgres    false    201         �            1259    16935    artista_id_seq    SEQUENCE     �   CREATE SEQUENCE public.artista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.artista_id_seq;
       public          postgres    false    202         �           0    0    artista_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.artista_id_seq OWNED BY public.artista.id;
          public          postgres    false    203         �            1259    16940    cancion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cancion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cancion_id_seq;
       public          postgres    false    204         �           0    0    cancion_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cancion_id_seq OWNED BY public.cancion.id;
          public          postgres    false    205         �            1259    16984    rol    TABLE     `   CREATE TABLE public.rol (
    id integer NOT NULL,
    nombre character varying(25) NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false         �            1259    16982 
   rol_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.rol_id_seq;
       public          postgres    false    210         �           0    0 
   rol_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;
          public          postgres    false    209         �            1259    16992    usuario    TABLE     b  CREATE TABLE public.usuario (
    id integer NOT NULL,
    documento character varying(15) NOT NULL,
    email character varying(25) NOT NULL,
    fecha_nacimiento date NOT NULL,
    imagen character varying(15) NOT NULL,
    nombre character varying(15) NOT NULL,
    password character varying(25) NOT NULL,
    token text,
    rol integer NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false         �            1259    16990    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    212         �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    211         �            1259    17001    viewartistaalbum    TABLE       CREATE TABLE public.viewartistaalbum (
    id integer NOT NULL,
    fecha_lanzamiento date,
    genero character varying(255),
    imagen_cancion character varying(255),
    nombre_album character varying(255),
    nombre_artistico character varying(255),
    precio integer
);
 $   DROP TABLE public.viewartistaalbum;
       public         heap    postgres    false         �            1259    16974    viewartistacancion    TABLE       CREATE TABLE public.viewartistacancion (
    id integer NOT NULL,
    fecha_lanzamiento date,
    genero character varying(255),
    imagen_cancion character varying(255),
    nombre_artistico character varying(255),
    nombre_cancion character varying(255),
    precio integer
);
 &   DROP TABLE public.viewartistacancion;
       public         heap    postgres    false         M           2604    16942    album id    DEFAULT     d   ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);
 7   ALTER TABLE public.album ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200         N           2604    16943 
   artista id    DEFAULT     h   ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);
 9   ALTER TABLE public.artista ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202         O           2604    16944 
   cancion id    DEFAULT     h   ALTER TABLE ONLY public.cancion ALTER COLUMN id SET DEFAULT nextval('public.cancion_id_seq'::regclass);
 9   ALTER TABLE public.cancion ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204         P           2604    16987    rol id    DEFAULT     `   ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.rol_id_seq'::regclass);
 5   ALTER TABLE public.rol ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    210    210         Q           2604    16995 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    212    212         �          0    16927    album 
   TABLE DATA           }   COPY public.album (id, nombre, descripcion, duracion, precio, imagen, fecha_lanzamiento, num_ventas, id_artista) FROM stdin;
    public          postgres    false    200       3048.dat �          0    16932    artista 
   TABLE DATA           o   COPY public.artista (id, nombre, nombre_artistico, genero, nacionalidad, imagen, fecha_nacimiento) FROM stdin;
    public          postgres    false    202       3050.dat �          0    16937    cancion 
   TABLE DATA           �   COPY public.cancion (id, nombre, descripcion, duracion, nacionalidad, precio, imagen, fecha_lanzamiento, num_ventas, id_album, id_artista) FROM stdin;
    public          postgres    false    204       3052.dat �          0    16984    rol 
   TABLE DATA           )   COPY public.rol (id, nombre) FROM stdin;
    public          postgres    false    210       3056.dat �          0    16992    usuario 
   TABLE DATA           o   COPY public.usuario (id, documento, email, fecha_nacimiento, imagen, nombre, password, token, rol) FROM stdin;
    public          postgres    false    212       3058.dat �          0    17001    viewartistaalbum 
   TABLE DATA           �   COPY public.viewartistaalbum (id, fecha_lanzamiento, genero, imagen_cancion, nombre_album, nombre_artistico, precio) FROM stdin;
    public          postgres    false    213       3059.dat �          0    16974    viewartistacancion 
   TABLE DATA           �   COPY public.viewartistacancion (id, fecha_lanzamiento, genero, imagen_cancion, nombre_artistico, nombre_cancion, precio) FROM stdin;
    public          postgres    false    208       3054.dat �           0    0    album_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.album_id_seq', 2, true);
          public          postgres    false    201                     0    0    artista_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.artista_id_seq', 3, true);
          public          postgres    false    203                    0    0    cancion_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cancion_id_seq', 4, true);
          public          postgres    false    205                    0    0 
   rol_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.rol_id_seq', 1, false);
          public          postgres    false    209                    0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);
          public          postgres    false    211         S           2606    16946    album album_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public            postgres    false    200         U           2606    16948    artista artista_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.artista DROP CONSTRAINT artista_pkey;
       public            postgres    false    202         W           2606    16950    cancion cancion_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT cancion_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cancion DROP CONSTRAINT cancion_pkey;
       public            postgres    false    204         [           2606    16989    rol rol_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public            postgres    false    210         ]           2606    17000    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    212         _           2606    17008 &   viewartistaalbum viewartistaalbum_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.viewartistaalbum
    ADD CONSTRAINT viewartistaalbum_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.viewartistaalbum DROP CONSTRAINT viewartistaalbum_pkey;
       public            postgres    false    213         Y           2606    16981 *   viewartistacancion viewartistacancion_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.viewartistacancion
    ADD CONSTRAINT viewartistacancion_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.viewartistacancion DROP CONSTRAINT viewartistacancion_pkey;
       public            postgres    false    208         c           2606    17009    usuario fk_usuario_rol    FK CONSTRAINT     o   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_rol FOREIGN KEY (rol) REFERENCES public.rol(id);
 @   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fk_usuario_rol;
       public          postgres    false    2907    212    210         a           2606    16951    cancion fkalbumacancion    FK CONSTRAINT     w   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkalbumacancion FOREIGN KEY (id_album) REFERENCES public.album(id);
 A   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkalbumacancion;
       public          postgres    false    204    2899    200         `           2606    16956    album fkartista    FK CONSTRAINT     s   ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 9   ALTER TABLE ONLY public.album DROP CONSTRAINT fkartista;
       public          postgres    false    200    2901    202         b           2606    16961    cancion fkartista    FK CONSTRAINT     u   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 ;   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkartista;
       public          postgres    false    202    2901    204                                                                                                                                                                                                                                                                                                                                                3048.dat                                                                                            0000600 0004000 0002000 00000000067 14147313576 0014266 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	DUA_LIPA	bueno	300	400	DUA.jpg	2016-07-25	400	2
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                         3050.dat                                                                                            0000600 0004000 0002000 00000000222 14147313576 0014250 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	angela	maria	pop	korea	3456	2000-06-07
2	dua	Dua lipa	POP	Kosovo	dua.jpf	2000-06-27
3	beberexha	beberexha	pop	EEUU	beberexha.jh	2000-06-07
\.


                                                                                                                                                                                                                                                                                                                                                                              3052.dat                                                                                            0000600 0004000 0002000 00000000114 14147313576 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        4	blow your mind	regular	500	inglaterra	240	new.jpg	2000-07-28	500	2	2
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                    3056.dat                                                                                            0000600 0004000 0002000 00000000005 14147313576 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3058.dat                                                                                            0000600 0004000 0002000 00000000005 14147313576 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3059.dat                                                                                            0000600 0004000 0002000 00000000005 14147313576 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3054.dat                                                                                            0000600 0004000 0002000 00000000005 14147313576 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000031751 14147313576 0015406 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

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

DROP DATABASE "Disquera";
--
-- Name: Disquera; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Disquera" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE "Disquera" OWNER TO postgres;

\connect "Disquera"

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
-- Name: album; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.album (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    descripcion character varying(30) NOT NULL,
    duracion integer NOT NULL,
    precio integer NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_lanzamiento date NOT NULL,
    num_ventas integer NOT NULL,
    id_artista integer NOT NULL
);


ALTER TABLE public.album OWNER TO postgres;

--
-- Name: artista; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.artista (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    nombre_artistico character varying(15) NOT NULL,
    genero character varying(15) NOT NULL,
    nacionalidad character varying(15) NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_nacimiento date NOT NULL
);


ALTER TABLE public.artista OWNER TO postgres;

--
-- Name: ViewArtistaAlbum; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."ViewArtistaAlbum" AS
 SELECT art.id,
    art.nombre_artistico,
    art.genero,
    alb.nombre AS nombre_album,
    alb.precio,
    alb.imagen AS imagen_album,
    alb.fecha_lanzamiento
   FROM (public.artista art
     JOIN public.album alb ON ((art.id = alb.id_artista)));


ALTER TABLE public."ViewArtistaAlbum" OWNER TO postgres;

--
-- Name: cancion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cancion (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    descripcion character varying(30) NOT NULL,
    duracion integer NOT NULL,
    nacionalidad character varying(15) NOT NULL,
    precio integer NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_lanzamiento date NOT NULL,
    num_ventas integer NOT NULL,
    id_album integer NOT NULL,
    id_artista integer NOT NULL
);


ALTER TABLE public.cancion OWNER TO postgres;

--
-- Name: ViewArtistaCancion; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."ViewArtistaCancion" AS
 SELECT art.id,
    art.nombre_artistico,
    art.genero,
    c.nombre AS nombre_cancion,
    c.precio,
    c.imagen AS imagen_cancion,
    c.fecha_lanzamiento
   FROM (public.artista art
     JOIN public.cancion c ON ((art.id = c.id_artista)));


ALTER TABLE public."ViewArtistaCancion" OWNER TO postgres;

--
-- Name: album_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.album_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.album_id_seq OWNER TO postgres;

--
-- Name: album_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;


--
-- Name: artista_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.artista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.artista_id_seq OWNER TO postgres;

--
-- Name: artista_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.artista_id_seq OWNED BY public.artista.id;


--
-- Name: cancion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cancion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cancion_id_seq OWNER TO postgres;

--
-- Name: cancion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cancion_id_seq OWNED BY public.cancion.id;


--
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id integer NOT NULL,
    nombre character varying(25) NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- Name: rol_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_seq OWNER TO postgres;

--
-- Name: rol_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    documento character varying(15) NOT NULL,
    email character varying(25) NOT NULL,
    fecha_nacimiento date NOT NULL,
    imagen character varying(15) NOT NULL,
    nombre character varying(15) NOT NULL,
    password character varying(25) NOT NULL,
    token text,
    rol integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- Name: viewartistaalbum; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.viewartistaalbum (
    id integer NOT NULL,
    fecha_lanzamiento date,
    genero character varying(255),
    imagen_cancion character varying(255),
    nombre_album character varying(255),
    nombre_artistico character varying(255),
    precio integer
);


ALTER TABLE public.viewartistaalbum OWNER TO postgres;

--
-- Name: viewartistacancion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.viewartistacancion (
    id integer NOT NULL,
    fecha_lanzamiento date,
    genero character varying(255),
    imagen_cancion character varying(255),
    nombre_artistico character varying(255),
    nombre_cancion character varying(255),
    precio integer
);


ALTER TABLE public.viewartistacancion OWNER TO postgres;

--
-- Name: album id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);


--
-- Name: artista id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);


--
-- Name: cancion id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cancion ALTER COLUMN id SET DEFAULT nextval('public.cancion_id_seq'::regclass);


--
-- Name: rol id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.rol_id_seq'::regclass);


--
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- Data for Name: album; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.album (id, nombre, descripcion, duracion, precio, imagen, fecha_lanzamiento, num_ventas, id_artista) FROM stdin;
\.
COPY public.album (id, nombre, descripcion, duracion, precio, imagen, fecha_lanzamiento, num_ventas, id_artista) FROM '$$PATH$$/3048.dat';

--
-- Data for Name: artista; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.artista (id, nombre, nombre_artistico, genero, nacionalidad, imagen, fecha_nacimiento) FROM stdin;
\.
COPY public.artista (id, nombre, nombre_artistico, genero, nacionalidad, imagen, fecha_nacimiento) FROM '$$PATH$$/3050.dat';

--
-- Data for Name: cancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cancion (id, nombre, descripcion, duracion, nacionalidad, precio, imagen, fecha_lanzamiento, num_ventas, id_album, id_artista) FROM stdin;
\.
COPY public.cancion (id, nombre, descripcion, duracion, nacionalidad, precio, imagen, fecha_lanzamiento, num_ventas, id_album, id_artista) FROM '$$PATH$$/3052.dat';

--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id, nombre) FROM stdin;
\.
COPY public.rol (id, nombre) FROM '$$PATH$$/3056.dat';

--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, documento, email, fecha_nacimiento, imagen, nombre, password, token, rol) FROM stdin;
\.
COPY public.usuario (id, documento, email, fecha_nacimiento, imagen, nombre, password, token, rol) FROM '$$PATH$$/3058.dat';

--
-- Data for Name: viewartistaalbum; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.viewartistaalbum (id, fecha_lanzamiento, genero, imagen_cancion, nombre_album, nombre_artistico, precio) FROM stdin;
\.
COPY public.viewartistaalbum (id, fecha_lanzamiento, genero, imagen_cancion, nombre_album, nombre_artistico, precio) FROM '$$PATH$$/3059.dat';

--
-- Data for Name: viewartistacancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.viewartistacancion (id, fecha_lanzamiento, genero, imagen_cancion, nombre_artistico, nombre_cancion, precio) FROM stdin;
\.
COPY public.viewartistacancion (id, fecha_lanzamiento, genero, imagen_cancion, nombre_artistico, nombre_cancion, precio) FROM '$$PATH$$/3054.dat';

--
-- Name: album_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.album_id_seq', 2, true);


--
-- Name: artista_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.artista_id_seq', 3, true);


--
-- Name: cancion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cancion_id_seq', 4, true);


--
-- Name: rol_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_seq', 1, false);


--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- Name: album album_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);


--
-- Name: artista artista_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);


--
-- Name: cancion cancion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT cancion_pkey PRIMARY KEY (id);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: viewartistaalbum viewartistaalbum_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.viewartistaalbum
    ADD CONSTRAINT viewartistaalbum_pkey PRIMARY KEY (id);


--
-- Name: viewartistacancion viewartistacancion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.viewartistacancion
    ADD CONSTRAINT viewartistacancion_pkey PRIMARY KEY (id);


--
-- Name: usuario fk_usuario_rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_rol FOREIGN KEY (rol) REFERENCES public.rol(id);


--
-- Name: cancion fkalbumacancion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkalbumacancion FOREIGN KEY (id_album) REFERENCES public.album(id);


--
-- Name: album fkartista; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);


--
-- Name: cancion fkartista; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       