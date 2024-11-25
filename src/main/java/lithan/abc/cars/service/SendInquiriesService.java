package lithan.abc.cars.service;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.SendInquiries;
import lithan.abc.cars.entity.UserAccount;

import java.util.List;

public interface SendInquiriesService {
    void saveInquiry(SendInquiries inquiry);

    SendInquiries prepareInquiry(Car car, UserAccount user, String message);

    List<SendInquiries> getInquiriesByUser(UserAccount user);

    SendInquiries getInquiryById(int id);


}
