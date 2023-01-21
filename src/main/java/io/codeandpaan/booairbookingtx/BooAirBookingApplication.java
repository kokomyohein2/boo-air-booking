package io.codeandpaan.booairbookingtx;

import io.codeandpaan.booairbookingtx.entity.PassengerInfo;
import io.codeandpaan.booairbookingtx.service.FlightBookingService;
import io.codeandpaan.booairbookingtx.service.TransactionalService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BooAirBookingApplication implements ApplicationRunner {

    private final FlightBookingService flightBookingService;
    private final TransactionalService transactionalService;

    public BooAirBookingApplication(FlightBookingService flightBookingService, TransactionalService transactionalService) {
        this.flightBookingService = flightBookingService;
        this.transactionalService = transactionalService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BooAirBookingApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        List<PassengerInfo> allBookings = flightBookingService.getAllBookings("test", 20);
//        System.out.println("super all booking: " + allBookings);
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transactionalService.setSomething("test");
        transactionalService.doSomething();
    }
}
