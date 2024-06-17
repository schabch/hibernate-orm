/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.orm.test.id.uuid.annotation;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TheGenericGeneratorIdEntity")
@Table(name = "TheGenericGeneratorIdEntity")
public class TheGenericGeneratorIdEntity {
	@Id
	@GeneratedValue(generator = "generic-uuidgenerator")
	@GenericGenerator(name = "generic-uuidgenerator", type = GenericIdUuidGenerator.class)
	public UUID id;
	@Basic
	public String name;

	private TheGenericGeneratorIdEntity() {
		// for Hibernate use
	}

	public TheGenericGeneratorIdEntity(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}