package com.example.examenjava.repository;

import com.example.examenjava.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(nativeQuery = true, value = "select * from payments " +
            "where type = :type")
    List<Payment> findByType(@Param("type") String type);

    @Query(nativeQuery = true, value = "select * from payments " +
            "where status = :status")
    List<Payment> findByStatus(@Param("status") String status);

    @Query(nativeQuery = true, value = "select * from payments " +
            "where status = :status AND type = :type")
    List<Payment> findByTypeAndStatus(@Param("type") String type,
                                      @Param("status") String status);

    void deleteById(Long id);
}
