package com.salmanwahed.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salmanwahed.todoapp.model.utils.BaseEntity;
import com.salmanwahed.todoapp.model.utils.TodoStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "todoapp_todo")
public class Todo extends BaseEntity {
    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
}
