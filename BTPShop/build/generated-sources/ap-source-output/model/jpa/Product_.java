package model.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T22:30:19")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> productdetail;
    public static volatile SingularAttribute<Product, Integer> productid;
    public static volatile SingularAttribute<Product, Integer> productqueslity;
    public static volatile SingularAttribute<Product, String> productname;
    public static volatile SingularAttribute<Product, Date> productin;
    public static volatile SingularAttribute<Product, Integer> productprice;
    public static volatile SingularAttribute<Product, String> productimage;
    public static volatile SingularAttribute<Product, String> producttype;

}