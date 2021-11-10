PGDMP     /            	    
    y            Disco    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24789    Disco    DATABASE     c   CREATE DATABASE "Disco" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Disco";
                postgres    false            �            1259    24805    album    TABLE     `  CREATE TABLE public.album (
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
       public         heap    postgres    false            �            1259    24803    album_id_seq    SEQUENCE     �   CREATE SEQUENCE public.album_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.album_id_seq;
       public          postgres    false    203            �           0    0    album_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;
          public          postgres    false    202            �            1259    24797    artista    TABLE     D  CREATE TABLE public.artista (
    id integer NOT NULL,
    nombre character varying(15) NOT NULL,
    nombre_artistico character varying(15) NOT NULL,
    genero character varying(15) NOT NULL,
    nacionalidad character varying(15) NOT NULL,
    imagen character varying(30) NOT NULL,
    fecha_nacimiento date NOT NULL
);
    DROP TABLE public.artista;
       public         heap    postgres    false            �            1259    24795    artista_id_seq    SEQUENCE     �   CREATE SEQUENCE public.artista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.artista_id_seq;
       public          postgres    false    201            �           0    0    artista_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.artista_id_seq OWNED BY public.artista.id;
          public          postgres    false    200            �            1259    24813    cancion    TABLE     �  CREATE TABLE public.cancion (
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
       public         heap    postgres    false            �            1259    24811    cancion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cancion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cancion_id_seq;
       public          postgres    false    205            �           0    0    cancion_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cancion_id_seq OWNED BY public.cancion.id;
          public          postgres    false    204            /           2604    24808    album id    DEFAULT     d   ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);
 7   ALTER TABLE public.album ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            .           2604    24800 
   artista id    DEFAULT     h   ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);
 9   ALTER TABLE public.artista ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            0           2604    24816 
   cancion id    DEFAULT     h   ALTER TABLE ONLY public.cancion ALTER COLUMN id SET DEFAULT nextval('public.cancion_id_seq'::regclass);
 9   ALTER TABLE public.cancion ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            �          0    24805    album 
   TABLE DATA           }   COPY public.album (id, nombre, descripcion, duracion, precio, imagen, fecha_lanzamiento, num_ventas, id_artista) FROM stdin;
    public          postgres    false    203   J        �          0    24797    artista 
   TABLE DATA           o   COPY public.artista (id, nombre, nombre_artistico, genero, nacionalidad, imagen, fecha_nacimiento) FROM stdin;
    public          postgres    false    201   �        �          0    24813    cancion 
   TABLE DATA           �   COPY public.cancion (id, nombre, descripcion, duracion, nacionalidad, precio, imagen, fecha_lanzamiento, num_ventas, id_album, id_artista) FROM stdin;
    public          postgres    false    205   !       �           0    0    album_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.album_id_seq', 2, true);
          public          postgres    false    202            �           0    0    artista_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.artista_id_seq', 3, true);
          public          postgres    false    200            �           0    0    cancion_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cancion_id_seq', 4, true);
          public          postgres    false    204            4           2606    24810    album album_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public            postgres    false    203            2           2606    24802    artista artista_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.artista DROP CONSTRAINT artista_pkey;
       public            postgres    false    201            6           2606    24818    cancion cancion_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT cancion_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cancion DROP CONSTRAINT cancion_pkey;
       public            postgres    false    205            8           2606    24844    cancion fkalbumacancion    FK CONSTRAINT     w   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkalbumacancion FOREIGN KEY (id_album) REFERENCES public.album(id);
 A   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkalbumacancion;
       public          postgres    false    2868    205    203            7           2606    24834    album fkartista    FK CONSTRAINT     s   ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 9   ALTER TABLE ONLY public.album DROP CONSTRAINT fkartista;
       public          postgres    false    203    201    2866            9           2606    24849    cancion fkartista    FK CONSTRAINT     u   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 ;   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkartista;
       public          postgres    false    2866    205    201            �   9   x�3�t	u���p�L*M���460�4b��^VA:����������)X؈+F��� r��      �   t   x�3�L�KO�I��M,�L�,�/���/JM�4615�4200�50�50�2�L)M�t)MT��,H�����/�/���e���ss&�&��Vd$"�@�����"���2������ �)      �   P   x��A
� ���Sxe�:L#�4�D�}�[?���i�>�\��ИF������ ���t�Nf��Z��%�}�l�     