package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.entity.Carrito;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T18:19:40")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, String> descripcion;
    public static volatile SingularAttribute<Album, Date> fLanzamiento;
    public static volatile SingularAttribute<Album, Integer> numVentas;
    public static volatile SingularAttribute<Album, Integer> precio;
    public static volatile SingularAttribute<Album, Artista> artista;
    public static volatile SingularAttribute<Album, Integer> duracion;
    public static volatile SingularAttribute<Album, String> imagen;
    public static volatile SingularAttribute<Album, Integer> id;
    public static volatile SingularAttribute<Album, Carrito> carrito;
    public static volatile SingularAttribute<Album, String> nombre;
    public static volatile ListAttribute<Album, Cancion> cancion;

}