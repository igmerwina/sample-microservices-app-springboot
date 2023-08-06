package com.param.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "parameter")
public class Parameter {
    @Id
    @Column(name = "key_", nullable = false, length = 100)
    private String key;

    @Column(name = "value_", nullable = false, length = 600)
    private String value;

    @Column(name = "description", nullable = false, length = 200)
    private String description;
}
