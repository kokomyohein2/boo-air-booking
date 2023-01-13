package io.codeandpaan.booairbookingtx.repository;

import io.codeandpaan.booairbookingtx.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
