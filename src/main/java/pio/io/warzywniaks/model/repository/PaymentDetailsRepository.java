package pio.io.warzywniaks.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pio.io.warzywniaks.model.entity.PaymentDetails;


@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {
}
