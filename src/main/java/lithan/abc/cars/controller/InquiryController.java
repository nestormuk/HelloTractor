package lithan.abc.cars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lithan.abc.cars.service.SendInquiriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.SendInquiries;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.service.UserCarService;
import lithan.abc.cars.service.UserService;

import java.time.LocalDate;

@Controller
public class InquiryController {

    private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);

    @Autowired
    private UserCarService userCarService;

    @Autowired
    private UserService userService;

    @Autowired
    private SendInquiriesService sendInquiriesService;

    @GetMapping("/send-inquiry/{idCar}")
    public String sendInquiry(@PathVariable("idCar") int idCar, Model model) {
        logger.info("Accessing send inquiry form for car ID: {}", idCar);

        try {
            Car car = userCarService.getCarById(idCar);
            if (car == null) {
                logger.error("Car not found with ID: {}", idCar);
                return "redirect:/cars?error=Car not found";
            }

            UserAccount user = userService.getUserLogin();
            if (user == null) {
                logger.error("No user logged in");
                return "redirect:/login";
            }

            // Prepare the inquiry object through the service
            SendInquiries inquiry = sendInquiriesService.prepareInquiry(car, user, "");
            inquiry.setDate(LocalDate.now());  // Set the current date for the inquiry

            model.addAttribute("inquiry", inquiry);
            model.addAttribute("car", car);
            model.addAttribute("user", user);
            logger.info("Successfully prepared inquiry form for car ID: {}", idCar);

            return "/user/send-inquiry-form"; // View name for the form

        } catch (Exception e) {
            logger.error("Error preparing inquiry for car ID: {}", idCar, e);
            return "redirect:/cars?error=Error preparing inquiry";
        }
    }

    @PostMapping("/user/send-inquiry")
    public String submitInquiry(@RequestParam("message") String message,
                                @RequestParam("car.idCar") int carId,
                                @RequestParam("user.idUser") int userId) {
        logger.info("Attempting to submit inquiry for car ID: {} and user ID: {}", carId, userId);

        try {
            // No need to check for car and user existence again, just directly prepare and save the inquiry
            Car car = userCarService.getCarById(carId);
            UserAccount user = userService.getUserAccountById(userId);

            // Proceed directly to save the inquiry
            SendInquiries inquiry = sendInquiriesService.prepareInquiry(car, user, message);
            inquiry.setDate(LocalDate.now());  // Set the current date for the inquiry

            sendInquiriesService.saveInquiry(inquiry);  // Save the inquiry

            logger.info("Successfully saved inquiry");

            return "redirect:/user/inquiries"; // Redirect to the inquiries page after successful submission

        } catch (Exception e) {
            logger.error("Failed to save inquiry", e);
            return "redirect:/cars?error=Failed to send inquiry";
        }
    }

    @GetMapping("/user/inquiries")
    public String viewInquiries(Model model) {
        logger.info("Accessing user inquiries view");

        UserAccount user = userService.getUserLogin();
        if (user == null) {
            logger.error("No user logged in while accessing inquiries");
            return "redirect:/login";
        }

        model.addAttribute("inquiries", sendInquiriesService.getInquiriesByUser(user));
        return "user/view-inquiries";
    }
}
