package hellotractor.com.model;

import hellotractor.com.util.EProductCategory;
import hellotractor.com.util.EProductCondition;
import hellotractor.com.util.EProductEngineType;
import hellotractor.com.util.EProductShipping;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "product_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private EProductCategory category;

    @Column(name = "product_brand")
    private String brand;

    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_condition")
    private EProductCondition condition;

    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type")
    private EProductEngineType engineType;

    @Column(name = "usage_hours")
    private int usageHours;

    @Enumerated(EnumType.STRING)
    private EProductShipping shipping;

    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "product")
    private List<ReviewRating> reviewRatings;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;


    public Product() {
    }

    public Product(String productTitle, String description, EProductCategory category, String brand, int yearOfManufacture, EProductCondition condition, int price, int stockQuantity, String location, EProductEngineType engineType, int usageHours, EProductShipping shipping, String photo, List<ReviewRating> reviewRatings, List<Cart> carts) {

        this.productTitle = productTitle;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.condition = condition;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.location = location;
        this.engineType = engineType;
        this.usageHours = usageHours;
        this.shipping = shipping;
        this.photo = photo;
        this.reviewRatings = reviewRatings;
        this.carts = carts;
    }


}
