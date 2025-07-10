/**
 * <p>Copyright (C) Calade Technologies, Inc - All Rights Reserved Unauthorized copying of this
 * file, via any medium is strictly prohibited Proprietary and confidential
 */
package com.smsmode.task.model;

import com.smsmode.task.model.base.AbstractBaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a Guest in the PMS system.
 * A guest is a person who makes a reservation at the hotel.
 *
 * @author hamzahabchi (contact: hamza.habchi@messaging-technologies.com)
 * <p>Created 16 Jun 2025</p>
 */

@Table(name = "X_INCIDENT")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class IncidentModel extends AbstractBaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reporterId;

    private String reviewerId;
    private String rentalId;
    private String severity;
    private String status;
    private String tags;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "X_INCIDENT_CATEGORY",
            joinColumns = @JoinColumn(name = "incident_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryModel> categories = new HashSet<>();
}
