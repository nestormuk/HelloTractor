package hellotractor.com.model;

import hellotractor.com.util.ESellerStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    private String phone;

    private String password;

    @Column(name = "registration_date")
    private Date registrationDate=new Date();

    @Enumerated(EnumType.STRING)
    private ESellerStatus status;

    private String role = "Seller";

    @OneToMany(mappedBy = "seller")
    private List<ReviewRating> rating;

    @OneToMany(mappedBy = "seller")
    private List<Company> companies;

    @OneToMany(mappedBy = "seller")
    private List<ReviewRating> reviewRating;

    @OneToMany(mappedBy = "")
    private List<Product> products;

    public Seller() {
    }

    public Seller(String fullName, String email, String phone, String password, ESellerStatus status, List<ReviewRating> rating, List<Company> companies, List<ReviewRating> reviewRating, List<Product> products) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.status = status;
        this.rating = rating;
        this.companies = companies;
        this.reviewRating = reviewRating;
        this.products = products;
    }

}
