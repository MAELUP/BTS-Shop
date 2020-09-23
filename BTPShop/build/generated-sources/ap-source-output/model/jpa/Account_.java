package model.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T22:30:19")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> address;
    public static volatile SingularAttribute<Account, Character> gender;
    public static volatile SingularAttribute<Account, String> province;
    public static volatile SingularAttribute<Account, Date> dob;
    public static volatile SingularAttribute<Account, String> postalcode;
    public static volatile SingularAttribute<Account, String> district;
    public static volatile SingularAttribute<Account, String> tel;
    public static volatile SingularAttribute<Account, String> fullname;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;

}