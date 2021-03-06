package com.slmanju.ballot.voter.rest;

import com.slmanju.ballot.voter.rest.dto.VoterRequest;
import com.slmanju.ballot.voter.rest.dto.VoterView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface VoterApi {

  @PostMapping(value = "/voters")
  ResponseEntity<String> save(@RequestBody VoterRequest voterRequest);

  @GetMapping(value = "/voters/{id}")
  ResponseEntity<VoterView> getPoll(@PathVariable("id") String id);

}
