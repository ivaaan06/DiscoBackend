package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T16:19:31")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, Integer> costo;
    public static volatile SingularAttribute<Carrito, Usuario> usuario;
    public static volatile SingularAttribute<Carrito, Integer> id_pedido;
    public static volatile ListAttribute<Carrito, Cancion> cancion;
    public static volatile ListAttribute<Carrito, Album> albumes;

}