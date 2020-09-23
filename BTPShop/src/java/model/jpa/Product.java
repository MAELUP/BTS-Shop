/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid")
    , @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname")
    , @NamedQuery(name = "Product.findByProducttype", query = "SELECT p FROM Product p WHERE p.producttype = :producttype")
    , @NamedQuery(name = "Product.findByProductdetail", query = "SELECT p FROM Product p WHERE p.productdetail = :productdetail")
    , @NamedQuery(name = "Product.findByProductprice", query = "SELECT p FROM Product p WHERE p.productprice = :productprice")
    , @NamedQuery(name = "Product.findByProductqueslity", query = "SELECT p FROM Product p WHERE p.productqueslity = :productqueslity")
    , @NamedQuery(name = "Product.findByProductin", query = "SELECT p FROM Product p WHERE p.productin = :productin")
    , @NamedQuery(name = "Product.findByProductimage", query = "SELECT p FROM Product p WHERE p.productimage = :productimage")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private int productid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Size(max = 2)
    @Column(name = "PRODUCTTYPE")
    private String producttype;
    @Size(max = 100)
    @Column(name = "PRODUCTDETAIL")
    private String productdetail;
    @Column(name = "PRODUCTPRICE")
    private Integer productprice;
    @Column(name = "PRODUCTQUESLITY")
    private Integer productqueslity;
    @Column(name = "PRODUCTIN")
    @Temporal(TemporalType.DATE)
    private Date productin;
    @Size(max = 80)
    @Column(name = "PRODUCTIMAGE")
    private String productimage;
//    -------------------------------------- // 
    private List<Product> productList;

    public Product() {
    }

    public Product(String productname) {
        this.productname = productname;
    }

    public Product(String productname, int productid) {
        this.productname = productname;
        this.productid = productid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(String productdetail) {
        this.productdetail = productdetail;
    }

    public Integer getProductprice() {
        return productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    public Integer getProductqueslity() {
        return productqueslity;
    }

    public void setProductqueslity(Integer productqueslity) {
        this.productqueslity = productqueslity;
    }

    public Date getProductin() {
        return productin;
    }

    public void setProductin(Date productin) {
        this.productin = productin;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }
    
      @XmlTransient
    public List<Product> getProduceList() {
        return productList;
    }

    public void setProduceList(List<Product> historyList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productname != null ? productname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productname == null && other.productname != null) || (this.productname != null && !this.productname.equals(other.productname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.jpa.Product[ productname=" + productname + " ]";
    }
    
}
