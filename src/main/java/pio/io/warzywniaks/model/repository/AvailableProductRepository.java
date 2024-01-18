package pio.io.warzywniaks.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pio.io.warzywniaks.model.entity.AvailableProduct;

import java.util.List;

@Repository
public interface AvailableProductRepository extends JpaRepository<AvailableProduct,Long> {

}
