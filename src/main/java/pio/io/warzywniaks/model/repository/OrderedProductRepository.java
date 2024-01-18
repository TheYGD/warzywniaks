package pio.io.warzywniaks.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.OrderedProduct;

import java.util.List;


@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct,Long> {
    @Query("select product from OrderedProduct as product where product.order.id=:orderId")
    List<OrderedProduct> getProductsByOrder(long orderId);
}
