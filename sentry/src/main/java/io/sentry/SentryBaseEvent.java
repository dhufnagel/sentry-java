package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An item sent to Sentry in the envelope. Can be either {@link SentryEvent} or the Performance
 * transaction.
 */
public abstract class SentryBaseEvent {
  private @Nullable SentryId eventId;
  private Contexts contexts;
  private @Nullable SdkVersion sdk;
  private @Nullable Request request;

  /** The captured Throwable */
  protected transient @Nullable Throwable throwable;

  protected SentryBaseEvent(final @NotNull SentryId eventId) {
    this.eventId = eventId;
  }

  protected SentryBaseEvent() {
    this(new SentryId());
  }

  public @Nullable SentryId getEventId() {
    return eventId;
  }

  public void setEventId(@Nullable SentryId eventId) {
    this.eventId = eventId;
  }

  public Contexts getContexts() {
    return contexts;
  }

  public void setContexts(Contexts contexts) {
    this.contexts = contexts;
  }

  public SdkVersion getSdk() {
    return sdk;
  }

  public void setSdk(@Nullable SdkVersion sdk) {
    this.sdk = sdk;
  }

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  /**
   * Returns the captured Throwable or null
   *
   * @return the Throwable or null
   */
  public @Nullable Throwable getThrowable() {
    return throwable;
  }

  /**
   * Sets the Throwable
   *
   * @param throwable the Throwable or null
   */
  public void setThrowable(final @Nullable Throwable throwable) {
    this.throwable = throwable;
  }
}
