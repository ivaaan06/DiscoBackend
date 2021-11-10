package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-09T22:39:32")
@StaticMetamodel(Cancion.class)
public class Cancion_ { 

    public static volatile SingularAttribute<Cancion, String> descripcion;
    public static volatile SingularAttribute<Cancion, Date> fLanzamiento;
    public static volatile SingularAttribute<Cancion, Integer> numVentas;
    public static volatile SingularAttribute<Cancion, Integer> precio;
    public static volatile SingularAttribute<Cancion, Artista> artista;
    public static volatile SingularAttribute<Cancion, Album> album;
    public static volatile SingularAttribute<Cancion, Integer> duracion;
    public static volatile SingularAttribute<Cancion, String> imagen;
    public static volatile SingularAttribute<Cancion, Integer> id;
    public static volatile SingularAttribute<Cancion, String> nombre;
    public static volatile SingularAttribute<Cancion, String> nacionalidad;

}