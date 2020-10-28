package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;

public final class TransactionContexts extends Contexts {
  private static final long serialVersionUID = 252445813254943011L;

  public TransactionContexts() {
    this(new Trace());
  }

  private TransactionContexts(final @NotNull Trace trace) {
    this.setTrace(trace);
  }

  /**
   * Creates {@link TransactionContexts} from sentry-header.
   *
   * @param sentryHeader - the sentryHeader header
   * @return the transaction contexts
   */
  public static @NotNull TransactionContexts fromSentryHeader(final @NotNull String sentryHeader)
      throws InvalidSentryTraceHeaderException {
    final String[] parts = sentryHeader.split("-", -1);
    if (parts.length < 2) {
      throw new InvalidSentryTraceHeaderException(sentryHeader);
    }
    return new TransactionContexts(
        new Trace(new SentryId(parts[0]), new SpanId(), new SpanId(parts[1])));
  }

  public Trace getTrace() {
    return toContextType(Trace.TYPE, Trace.class);
  }

  public void setTrace(final @NotNull Trace trace) {
    this.put(Trace.TYPE, trace);
  }
}
