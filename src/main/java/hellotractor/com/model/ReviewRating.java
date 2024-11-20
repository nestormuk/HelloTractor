package hellotractor.com.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class ReviewRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String comment;

    private int rating;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
