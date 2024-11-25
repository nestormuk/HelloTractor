package lithan.abc.cars.service;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lithan.abc.cars.entity.SendInquiries;
import lithan.abc.cars.repository.SendInquiriesRepository;
import lithan.abc.cars.service.SendInquiriesService;

import java.time.LocalDate;
import java.util.List;

@Service
public class SendInquiriesServiceImpl implements SendInquiriesService {

    @Autowired
    private SendInquiriesRepository sendInquiriesRepository;

    @Override
    public void saveInquiry(SendInquiries inquiry) {
        sendInquiriesRepository.save(inquiry);
    }

    @Override
    public SendInquiries prepareInquiry(Car car, UserAccount user, String message) {
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }
        SendInquiries inquiry = new SendInquiries();
        inquiry.setCar(car);
        inquiry.setUser(user);
        inquiry.setMessage(message); // Add the message
        inquiry.setDate(LocalDate.now()); // Set the date here
        return inquiry;
    }


    @Override
    public List<SendInquiries> getInquiriesByUser(UserAccount user) {
        return sendInquiriesRepository.findByUser(user);
    }

    @Override
    public SendInquiries getInquiryById(int id) {
        return sendInquiriesRepository.findById(id).orElse(null);
    }
}
