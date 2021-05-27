package com.semantic.domain;

public class Channel {

  private final String id;
  private final int daemonId;

  private Channel(final String id, final int daemonId) {
    this.id = id;
    this.daemonId = daemonId;
  }

  public static Builder buildChannel() {
    return new Builder();
  }

  public String id() {
    return id;
  }

  public int daemonId() {
    return daemonId;
  }

  public String toXml() {
    return String.format("<configuration id='%s' daemon='%d'/>", id, daemonId);
  }

  public static final class Builder {

    private String id = "UNKNOWN";
    private int daemonId = -1;

    public Builder withId(final String id) {
      this.id = id;
      return this;
    }

    public Builder withDaemonId(final int daemonId) {
      this.daemonId = daemonId;
      return this;
    }

    public Channel build() {
      return new Channel(id, daemonId);
    }
  }
}
