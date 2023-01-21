package io.codeandpaan.booairbookingtx.controller;

import io.codeandpaan.booairbookingtx.annotation.AuditLogger;
import io.codeandpaan.booairbookingtx.dto.FlightBookingAcknowledgement;
import io.codeandpaan.booairbookingtx.dto.FlightBookingRequest;
import io.codeandpaan.booairbookingtx.entity.PassengerInfo;
import io.codeandpaan.booairbookingtx.service.FlightBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping(value = "/api/v1")
//@EnableTransactionManagement
public class BooAirBookingController {

    private final FlightBookingService flightBookingService;

    public BooAirBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @PostMapping("/bookFlightTicket")
    public ResponseEntity<FlightBookingAcknowledgement> bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return ResponseEntity.ok(flightBookingService.bookFlightTicket(request));
    }

//    @GetMapping("/bookings")
//    public ResponseEntity<List<PassengerInfo>> getAllBookings() {
//        return ResponseEntity.ok(flightBookingService.getAllBookings());
//    }
}
