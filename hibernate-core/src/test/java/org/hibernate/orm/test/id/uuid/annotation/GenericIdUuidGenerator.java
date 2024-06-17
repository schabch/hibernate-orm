package org.hibernate.orm.test.id.uuid.annotation;

import java.util.Properties;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.UUIDJavaType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;
import org.hibernate.type.internal.NamedBasicTypeImpl;

public class GenericIdUuidGenerator implements IdentifierGenerator {

  private final UUIDGenerator delegate;
  private Class<?> returnedClass;

  public GenericIdUuidGenerator() {
    this.delegate = new UUIDGenerator();
  }

  @Override
  public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
    this.returnedClass = type.getReturnedClass();
    if (EmbeddedUuid.class.isAssignableFrom(type.getReturnedClass())) {
      delegate.configure(
          new NamedBasicTypeImpl<>(UUIDJavaType.INSTANCE, UUIDJdbcType.INSTANCE, "uuid"),
          parameters,
          serviceRegistry);
    }
    else {
      delegate.configure(type, parameters, serviceRegistry);
    }
  }

  @Override
  public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    if (EmbeddedUuid.class.isAssignableFrom(returnedClass)) {
      return new EmbeddedUuid((UUID) delegate.generate(session, object));
    }
    return delegate.generate(session, object);
  }
}
