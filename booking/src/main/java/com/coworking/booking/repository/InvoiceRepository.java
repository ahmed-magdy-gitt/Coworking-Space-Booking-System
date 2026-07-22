package com.coworking.booking.repository;

import com.coworking.booking.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    // البحث عن فاتورة برقمها الفريد (زي اللي بنبعته في الـ DTO)
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

    // إيجاد فاتورة حجز معين
    Optional<Invoice> findByBookingId(Long bookingId);
}