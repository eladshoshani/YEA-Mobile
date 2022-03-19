/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author assafliron
 */
@ManagedBean
@RequestScoped
public class Product {

    /**
     * Creates a new instance of Product
     */
    public Product() {
    }
    
    private String pid;
    private String name;
    private String brand;
    private String color;
    private int storageCapacity;
    private double weight;
    private String operatingSystem;
    private double price;
    private int inStock;

    public String save(boolean newProduct) {
        // TODO: Validate all user fields & save to database
        // TODO: If newProduct - validate that the product doesn't already exist
        // TODO: If not newProduct - update  the existing product
        return "/product.xhtml?faces-redirect=true";
    }

    public static ArrayList<Product> getProductsList() {
        // TODO: return the prodcuts from the Data base instead of a static list
        ArrayList<Product> productsList = new ArrayList<Product>() {{
          Product product = new Product();
          product.setPid("1234");
          product.setBrand("Apple");
          product.setName("Iphone 6s");
          product.setColor("Black");
          product.setStorageCapacity(16);
          product.setWeight(10);
          product.setPrice(1500);
          product.setOperatingSystem("IOS");
          product.setInStock(5);
          add(product);
        }};

        return productsList;
    }

    public static String edit(String pid) {
        Product product = null;
        // TODO: return the product from the data base instead of from the static list
        for (Product p : getProductsList()) {
            if (pid.equals(p.pid)) {
                product = p;
                break;
            }
        }
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("product", product);
        return "/product.xhtml?faces-redirect=true";
    }
    
    public static String delete(String pid) {
        // TODO: delete the product from the database
        
        return "/index.xhtml?faces-redirect=true";
    }
    
    // Redirects to product.xhtml with empty fields, for a product new to be created
    public static String createNewProduct() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("product", new Product());
        return "/product.xhtml?faces-redirect=true";
    }
    
    
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
