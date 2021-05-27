package com.semantic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Channels {

  private final List<Channel> channels;

  public Channels() {
    this.channels = new ArrayList<>();
  }

  public Channels withChannels(final List<Channel> channels) {
    this.channels.addAll(channels);
    return this;
  }

  public Channels andWithChannels(final List<Channel> channels) {
    return withChannels(channels);
  }

  public Channels filteredByChannel(final String channelId) {
    return new Channels()
        .withChannels(channels.stream().filter(new FilterByChannel().withId(channelId)).collect(Collectors.toList()));
  }

  public Channels filteredByDaemon(final int daemonId) {
    return new Channels()
        .withChannels(channels.stream().filter(new FilterByDaemon().withId(daemonId)).collect(Collectors.toList()));
  }

  public String toXml() {
    final StringBuilder xml = new StringBuilder();
    xml.append(String.format("<channelList xmlns='%s'>", "namespace"));
    for (Channel channel : channels) {
      xml.append(channel.toXml());
    }
    xml.append("</channelList>");
    return xml.toString();
  }

  private static final class FilterByChannel implements Predicate<Channel> {

    private String channelId;

    public FilterByChannel withId(final String channelId) {
      this.channelId = channelId;
      return this;
    }

    @Override
    public boolean test(Channel channel) {
      return channelId.equalsIgnoreCase(channel.id());
    }
  }

  private static final class FilterByDaemon implements Predicate<Channel> {

    private int daemonId;

    public FilterByDaemon withId(final int daemonId) {
      this.daemonId = daemonId;
      return this;
    }

    @Override
    public boolean test(final Channel channel) {
      return channel.daemonId() == daemonId;
    }
  }
}
