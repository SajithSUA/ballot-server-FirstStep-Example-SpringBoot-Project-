package com.slmanju.ballot.voteresult.domain.port.in;

import com.slmanju.ballot.vote.domain.event.VotedEvent;

public interface VoteEventListener {

  void receiveVote(VotedEvent votedEvent);

}
