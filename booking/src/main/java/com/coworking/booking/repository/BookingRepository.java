package com.coworking.booking.repository;

import com.coworking.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // جلب حجوزات يوزر معين
    List<Booking> findByUserId(Long userId);

    // الكويري السحرية: التأكد لو فيه حجز "بيتقاطع" مع الوقت المطلوب
    // التقاطع يعني: (وقت البداية الجديد قبل نهاية حجز قديم) AND (وقت النهاية الجديد بعد بداية حجز قديم)
    @Query("SELECT b.workspace.id FROM Booking b WHERE b.status != 'CANCELLED' " +
           "AND (:start < b.endTime AND :end > b.startTime)")
    List<Long> findBookedWorkspaceIdsInPeriod(@Param("start") LocalDateTime start, 
                                             @Param("end") LocalDateTime end);

    // ميثود للتأكد من غرفة معينة تحديداً في وقت معين
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.workspace.id = :workspaceId " +
           "AND b.status != 'CANCELLED' " +
           "AND (:start < b.endTime AND :end > b.startTime)")
    boolean existsOverlappingBooking(@Param("workspaceId") Long workspaceId, 
                                     @Param("start") LocalDateTime start, 
                                     @Param("end") LocalDateTime end);
}