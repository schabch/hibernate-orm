package org.hibernate.orm.test.id.uuid.annotation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Embeddable
public class EmbeddedUuid implements Serializable {

//  @UuidGenerator
  @Column
  private UUID id;

  public EmbeddedUuid() {
    super();
  }

  public EmbeddedUuid(final UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EmbeddedUuid that = (EmbeddedUuid) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
