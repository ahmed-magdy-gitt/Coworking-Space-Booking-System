package com.coworking.booking.service;

import com.coworking.booking.dto.WorkspaceDTO;
import com.coworking.booking.model.Workspace;
import com.coworking.booking.repository.BookingRepository;
import com.coworking.booking.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final BookingRepository bookingRepository;

    // الميزة المطلوبة: البحث عن الغرف المتاحة في وقت معين
    public List<WorkspaceDTO> getAvailableWorkspaces(LocalDateTime start, LocalDateTime end) {
        // نجيب الـ IDs بتاعة الغرف اللي عندها حجز في الوقت ده
        List<Long> bookedIds = bookingRepository.findBookedWorkspaceIdsInPeriod(start, end);

        List<Workspace> available;
        if (bookedIds.isEmpty()) {
            available = workspaceRepository.findAll();
        } else {
            // نجيب كل الغرف ما عدا المحجوزة
            available = workspaceRepository.findByIdNotIn(bookedIds);
        }

        return available.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // للأدمن: إضافة غرفة جديدة
    public Workspace saveWorkspace(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    // ميثود تحويل Entity لـ DTO
    private WorkspaceDTO mapToDTO(Workspace workspace) {
        return WorkspaceDTO.builder()
                .id(workspace.getId())
                .name(workspace.getName())
                .type(workspace.getType())
                .pricePerHour(workspace.getPricePerHour())
                .capacity(workspace.getCapacity())
                .available(workspace.isAvailable())
                .description(workspace.getDescription())
                .build();
    }
}