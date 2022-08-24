package com.kurly.demo.order.repository;

import com.kurly.demo.order.domain.OrderInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInformationRepository extends JpaRepository<OrderInformation, Long> {
}
