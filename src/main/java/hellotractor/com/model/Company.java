package hellotractor.com.model;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.UUID;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "dealer_affiliation")
    private String dealerAffiliation;

    private String companyName;

    @Lob
    private byte[] image;

    private String location;

    private String companyDescription;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


}
