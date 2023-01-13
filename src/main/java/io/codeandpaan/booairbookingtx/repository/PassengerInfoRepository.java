package io.codeandpaan.booairbookingtx.repository;

import io.codeandpaan.booairbookingtx.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
