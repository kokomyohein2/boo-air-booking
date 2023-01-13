package io.codeandpaan.booairbookingtx.dto;

import io.codeandpaan.booairbookingtx.entity.PassengerInfo;
import io.codeandpaan.booairbookingtx.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
