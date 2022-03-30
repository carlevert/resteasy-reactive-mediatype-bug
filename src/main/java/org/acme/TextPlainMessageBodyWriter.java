package org.acme;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class TextPlainMessageBodyWriter implements MessageBodyWriter<MyResponseEntity> {

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return aClass.equals(MyResponseEntity.class) && mediaType.isCompatible(MediaType.TEXT_PLAIN_TYPE);
    }

    @Override
    public void writeTo(MyResponseEntity myResponseEntity, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        outputStream.write("text/plain".getBytes());
    }

}
