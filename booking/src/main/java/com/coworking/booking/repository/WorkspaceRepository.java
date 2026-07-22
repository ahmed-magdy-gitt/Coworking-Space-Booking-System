package com.coworking.booking.repository;

import com.coworking.booking.model.Workspace;
import com.coworking.booking.model.WorkspaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    
    // جلب كل الغرف المتاحة حالياً
    List<Workspace> findByAvailableTrue();

    // جلب الغرف حسب النوع (مثلاً كل الـ Meeting Rooms)
    List<Workspace> findByType(WorkspaceType type);

    // ميثود مساعدة لجلب الغرف التي ليست ضمن قائمة معينة (سنستخدمها في البحث بالوقت)
    List<Workspace> findByIdNotIn(List<Long> ids);
}