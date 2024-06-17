/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.orm.test.id.uuid.annotation;

import jakarta.persistence.Basic;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TheGenericGeneratorEmbeddingEntity")
@Table(name = "TheGenericGeneratorEmbeddingEntity")
public class TheGenericGeneratorEmbeddingEntity {

	@EmbeddedId
//	@UuidGenerator
	@GeneratedValue(generator = "generic-embedded-uuidgenerator")
	@GenericGenerator(name = "generic-embedded-uuidgenerator", type = GenericIdUuidGenerator.class)
	public EmbeddedUuid id;

	@Basic
	public String name;

	private TheGenericGeneratorEmbeddingEntity() {
		// for Hibernate use
	}

	public TheGenericGeneratorEmbeddingEntity(String name) {
		this.name = name;
	}

	public EmbeddedUuid getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}