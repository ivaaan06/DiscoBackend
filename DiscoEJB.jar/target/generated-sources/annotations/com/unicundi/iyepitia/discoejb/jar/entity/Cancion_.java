package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-17T00:34:57")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-14T16:50:07")
>>>>>>> 043eeb5b5f5163f3ff2a4f85bb6b14270e97b3c5
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