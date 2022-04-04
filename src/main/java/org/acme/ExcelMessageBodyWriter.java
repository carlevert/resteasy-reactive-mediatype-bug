package org.acme;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@Provider
public class ExcelMessageBodyWriter implements MessageBodyWriter<MyResponseEntity> {

    @Context
    HttpHeaders headers;

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
//        return aClass.equals(MyResponseEntity.class) &&
//                mediaType.getType().equals("application") &&
//                mediaType.getSubtype().equals("vnd.ms-excel");

        return aClass.equals(MyResponseEntity.class) &&
                headers.getAcceptableMediaTypes().stream().anyMatch(t -> t.getType().equals("application") && t.getSubtype().equals("vnd.ms-excel"));

    }

    @Override
    public void writeTo(MyResponseEntity myResponseEntity, Class<?> aClass, Type type, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {

        outputStream.write((myResponseEntity.getData() + " vnd.ms-excel").getBytes(StandardCharsets.UTF_8));
    }

}
