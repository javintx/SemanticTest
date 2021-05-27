package com.semantic.usecase;

import com.semantic.domain.Channels;

public class ChannelsUseCase {

  public String getAllChannelsInXml() {
    ChannelUseCase testCases = new ChannelUseCase();
    return new Channels()
        .withChannels(testCases.getChannelsWithId())
        .andWithChannels(testCases.getChannelsWithDaemonId())
        .toXml();
  }

  public String getChannelsByDaemonInXml(int daemon) {
    ChannelUseCase testCases = new ChannelUseCase();
    return new Channels()
        .withChannels(testCases.getChannelsWithId())
        .andWithChannels(testCases.getChannelsWithDaemonId())
        .filteredByDaemon(daemon)
        .toXml();
  }

  public String getChannelsByChannelInXml(String channel) {
    ChannelUseCase testCases = new ChannelUseCase();
    return new Channels()
        .withChannels(testCases.getChannelsWithId())
        .andWithChannels(testCases.getChannelsWithDaemonId())
        .filteredByChannel(channel)
        .toXml();
  }

}
