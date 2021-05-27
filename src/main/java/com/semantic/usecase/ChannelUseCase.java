package com.semantic.usecase;

import com.semantic.domain.Channel;
import java.util.Collections;
import java.util.List;

public class ChannelUseCase {

  public List<Channel> getChannelsWithId() {
    return Collections.singletonList(
        Channel.buildChannel()
            .withId("id")
            .build()
    );
  }

  public List<Channel> getChannelsWithDaemonId() {
    return Collections.singletonList(
        Channel.buildChannel()
            .withDaemonId(1)
            .build()
    );
  }

}
