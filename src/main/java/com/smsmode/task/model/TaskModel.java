/**
 * <p>Copyright (C) Calade Technologies, Inc - All Rights Reserved Unauthorized copying of this
 * file, via any medium is strictly prohibited Proprietary and confidential
 */
package com.smsmode.task.model;

import com.smsmode.task.model.base.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a Guest in the PMS system.
 * A guest is a person who makes a reservation at the hotel.
 *
 * @author hamzahabchi (contact: hamza.habchi@messaging-technologies.com)
 * <p>Created 16 Jun 2025</p>
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "X_TASK")
public class TaskModel extends AbstractBaseModel {


}