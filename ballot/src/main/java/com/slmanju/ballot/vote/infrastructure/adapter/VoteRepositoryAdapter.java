package com.slmanju.ballot.vote.infrastructure.adapter;

import com.slmanju.ballot.vote.domain.entity.Vote;
import com.slmanju.ballot.vote.domain.port.out.VoteRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class VoteRepositoryAdapter implements VoteRepository {

  private Map<String, Map<String, Vote>> pollVotes = new HashMap<>();

  @Override
  public void save(Vote vote) {
    Map<String, Vote> votes = this.pollVotes.get(vote.getPollId());
    if (Objects.isNull(votes)) {
      votes = new HashMap<>();
      pollVotes.put(vote.getPollId(), votes);
    }
    if (!votes.containsKey(vote.getVoter())) {
      votes.put(vote.getVoter(), vote);
    }
  }

  @Override
  public List<Vote> findByPollId(String pollId) {
    Map<String, Vote> votes = pollVotes.get(pollId);
    if (Objects.nonNull(votes)) {
      return new ArrayList<>(votes.values());
    }
    return Collections.emptyList();
  }

}
