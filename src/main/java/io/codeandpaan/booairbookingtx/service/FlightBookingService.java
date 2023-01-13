package io.codeandpaan.booairbookingtx.service;

import io.codeandpaan.booairbookingtx.dto.FlightBookingAcknowledgement;
import io.codeandpaan.booairbookingtx.dto.FlightBookingRequest;
import io.codeandpaan.booairbookingtx.entity.PassengerInfo;
import io.codeandpaan.booairbookingtx.entity.PaymentInfo;
import io.codeandpaan.booairbookingtx.repository.PassengerInfoRepository;
import io.codeandpaan.booairbookingtx.repository.PaymentInfoRepository;
import io.codeandpaan.booairbookingtx.utils.PaymentUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {

    private final PassengerInfoRepository passengerInfoRepository;
    private final PaymentInfoRepository paymentInfoRepository;

    public FlightBookingService(PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

//        PaymentUtils.generateCredit();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }

    public List<PassengerInfo> getAllBookings() {
        return passengerInfoRepository.findAll();
    }
}
