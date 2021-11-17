PGDMP     -                 
    y            Disco    13.0    13.0 +    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
          public          postgres    false    204            �            1259    32778    rol    TABLE     W   CREATE TABLE public.rol (
    id integer NOT NULL,
    nombre character varying(25)
);
    DROP TABLE public.rol;
       public         heap    postgres    false            �            1259    32776 
   rol_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.rol_id_seq;
       public          postgres    false    209            �           0    0 
   rol_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;
          public          postgres    false    208            �            1259    32770    usuario    TABLE     b  CREATE TABLE public.usuario (
    id integer NOT NULL,
    documento character varying(15) NOT NULL,
    email character varying(25) NOT NULL,
    fecha_nacimiento date NOT NULL,
    imagen character varying(15) NOT NULL,
    nombre character varying(15) NOT NULL,
    password character varying(25) NOT NULL,
    rol integer NOT NULL,
    token text
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    32768    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    207            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    206            <           2604    24808    album id    DEFAULT     d   ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);
 7   ALTER TABLE public.album ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            ;           2604    24800 
   artista id    DEFAULT     h   ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);
 9   ALTER TABLE public.artista ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            =           2604    24816 
   cancion id    DEFAULT     h   ALTER TABLE ONLY public.cancion ALTER COLUMN id SET DEFAULT nextval('public.cancion_id_seq'::regclass);
 9   ALTER TABLE public.cancion ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            ?           2604    32781    rol id    DEFAULT     `   ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.rol_id_seq'::regclass);
 5   ALTER TABLE public.rol ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            >           2604    32773 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            �          0    24805    album 
   TABLE DATA           }   COPY public.album (id, nombre, descripcion, duracion, precio, imagen, fecha_lanzamiento, num_ventas, id_artista) FROM stdin;
    public          postgres    false    203   w0       �          0    24797    artista 
   TABLE DATA           o   COPY public.artista (id, nombre, nombre_artistico, genero, nacionalidad, imagen, fecha_nacimiento) FROM stdin;
    public          postgres    false    201   �0       �          0    24813    cancion 
   TABLE DATA           �   COPY public.cancion (id, nombre, descripcion, duracion, nacionalidad, precio, imagen, fecha_lanzamiento, num_ventas, id_album, id_artista) FROM stdin;
    public          postgres    false    205   U1       �          0    32778    rol 
   TABLE DATA           )   COPY public.rol (id, nombre) FROM stdin;
    public          postgres    false    209   �1       �          0    32770    usuario 
   TABLE DATA           o   COPY public.usuario (id, documento, email, fecha_nacimiento, imagen, nombre, password, rol, token) FROM stdin;
    public          postgres    false    207   �1       �           0    0    album_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.album_id_seq', 2, true);
          public          postgres    false    202            �           0    0    artista_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.artista_id_seq', 4, true);
          public          postgres    false    200            �           0    0    cancion_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cancion_id_seq', 4, true);
          public          postgres    false    204            �           0    0 
   rol_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.rol_id_seq', 1, false);
          public          postgres    false    208            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 2, true);
          public          postgres    false    206            C           2606    24810    album album_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public            postgres    false    203            A           2606    24802    artista artista_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.artista DROP CONSTRAINT artista_pkey;
       public            postgres    false    201            E           2606    24818    cancion cancion_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT cancion_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cancion DROP CONSTRAINT cancion_pkey;
       public            postgres    false    205            I           2606    32783    rol rol_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public            postgres    false    209            G           2606    32775    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    207            K           2606    24844    cancion fkalbumacancion    FK CONSTRAINT     w   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkalbumacancion FOREIGN KEY (id_album) REFERENCES public.album(id);
 A   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkalbumacancion;
       public          postgres    false    2883    205    203            J           2606    24834    album fkartista    FK CONSTRAINT     s   ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 9   ALTER TABLE ONLY public.album DROP CONSTRAINT fkartista;
       public          postgres    false    201    203    2881            L           2606    24849    cancion fkartista    FK CONSTRAINT     u   ALTER TABLE ONLY public.cancion
    ADD CONSTRAINT fkartista FOREIGN KEY (id_artista) REFERENCES public.artista(id);
 ;   ALTER TABLE ONLY public.cancion DROP CONSTRAINT fkartista;
       public          postgres    false    201    2881    205            M           2606    32784    usuario fkrol    FK CONSTRAINT     f   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fkrol FOREIGN KEY (rol) REFERENCES public.rol(id);
 7   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fkrol;
       public          postgres    false    207    2889    209            �   9   x�3�t	u���p�L*M���460�4b��^VA:����������)X؈+F��� r��      �   �   x�M��� E��W�%��m��`�n.������F�޺h����s�B8-$!�K�3���/WS��h�+}�L-v����_#mVℶ��?R���t-�h|��1��ѐ�v��)a๐�aX�����־*!���18      �   P   x��A
� ���Sxe�:L#�4�D�}�[?���i�>�\��ИF������ ���t�Nf��Z��%�}�l�      �   0   x�3�tL����,.)JL�/�2�-.M,���2�t,*�'r��qqq ��      �   �   x���n�0@���.��`�S�l�D*�,Y�2i���	��u��rr aL��M #q/��ڊ�(�}9�B�&?+�e�,w����0���"��!��K.V"�L�>!1��}"��D����>����9��_ú<���4�#�u���6��+�r ��֥r�7��K��U�AX�K2�sє^��t�d���3�� ��ݦ�����-KY��N�?L�&i���e�ǧ���$����<�}'���k�vƧi��[_     