package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

public interface ISerializer {
  <T> T deserialize(Reader reader, Class<T> clazz);

  UserFeedback deserializeUserFeedback(Reader reader);

  Session deserializeSession(Reader reader);

  SentryTransaction deserializeTransaction(Reader reader);

  SentryEnvelope deserializeEnvelope(InputStream inputStream);

  <T> void serialize(T entity, Writer writer) throws IOException;

  void serialize(SentryEnvelope envelope, Writer writer) throws Exception;

  String serialize(Map<String, Object> data) throws Exception;
}
