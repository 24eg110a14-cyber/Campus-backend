package com.campus.eventportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Venue is required")
    private String venue;

    @NotNull(message = "Event date is required")
    private LocalDateTime eventDate;

    private String organizer;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    @Column(columnDefinition = "LONGTEXT")
    private String posterImage;

}