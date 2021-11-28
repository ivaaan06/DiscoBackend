package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-27T19:20:19")
@StaticMetamodel(Artista.class)
public class Artista_ { 

    public static volatile ListAttribute<Artista, Album> album;
    public static volatile SingularAttribute<Artista, String> genero;
    public static volatile SingularAttribute<Artista, Date> fNacimiento;
    public static volatile SingularAttribute<Artista, String> imagen;
    public static volatile SingularAttribute<Artista, String> nombreArtistico;
    public static volatile SingularAttribute<Artista, Integer> id;
    public static volatile SingularAttribute<Artista, String> nombre;
    public static volatile ListAttribute<Artista, Cancion> cancion;
    public static volatile SingularAttribute<Artista, String> nacionalidad;

}