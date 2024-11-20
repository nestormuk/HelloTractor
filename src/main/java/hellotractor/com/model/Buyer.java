package hellotractor.com.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Buyer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_mumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address")
    private String address;

    private String role ="Buyer";

    @OneToMany(mappedBy = "")
    private List<ReviewRating> reviewRating;

    @OneToMany(mappedBy = "buyer")
    private List<Cart> cart;

    @OneToMany(mappedBy = "buyer")
    private List<Wishlist> wishlist;

    public Buyer() {
    }

    public Buyer(String fullName, String email, String phoneNumber, String password, String address, List<ReviewRating> reviewRating, List<Cart> cart, List<Wishlist> wishlist) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.reviewRating = reviewRating;
        this.cart = cart;
        this.wishlist = wishlist;
    }


}
