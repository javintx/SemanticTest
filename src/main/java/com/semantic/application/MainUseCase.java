package com.semantic.application;

import com.semantic.usecase.ChannelsUseCase;

public class MainUseCase {

  public static void main(String[] args) {
    ChannelsUseCase channelsUseCase = new ChannelsUseCase();

    System.out.println("All channels");
    System.out.println(channelsUseCase.getAllChannelsInXml());
    System.out.println();

    System.out.println("Channels by id");
    System.out.println(channelsUseCase.getChannelsByChannelInXml("id"));
    System.out.println();

    System.out.println("Channels by daemons id");
    System.out.println(channelsUseCase.getChannelsByDaemonInXml(1));
    System.out.println();
  }
}
