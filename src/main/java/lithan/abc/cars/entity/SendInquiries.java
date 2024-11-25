package lithan.abc.cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_send_inquiries")
public class SendInquiries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_inquiry")
  private int idInquiry;

  @DateTimeFormat(pattern = "yyyy/MM/dd")
  @Column(nullable = false)
  private LocalDate date;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private UserAccount user;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_car")
  private Car car;

  @Column(name = "message", nullable = false, length = 1000)
  private String message;

  @Column(name = "response", length = 1000)
  private String response;

  public SendInquiries() {
  }

  public SendInquiries(LocalDate date, UserAccount user, Car car, String message) {
    this.date = date;
    this.user = user;
    this.car = car;
    this.message = message;
  }


  // Getters and setters
  public int getIdInquiry() {
    return idInquiry;
  }

  public void setIdInquiry(int idInquiry) {
    this.idInquiry = idInquiry;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public UserAccount getUser() {
    return user;
  }

  public void setUser(UserAccount user) {
    this.user = user;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
}
