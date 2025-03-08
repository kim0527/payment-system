package com.paymentsystem.membership.adapter.in.web;

import com.paymentsystem.common.WebAdapter;
import com.paymentsystem.membership.application.port.in.FindMembershipCommand;
import com.paymentsystem.membership.application.port.in.FindMembershipUseCase;
import com.paymentsystem.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

  private final FindMembershipUseCase findMembershipUseCase;

  @GetMapping(path = "/membership/{membershipId}")
  public ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId){

    FindMembershipCommand command = FindMembershipCommand.builder()
        .membershipId(membershipId)
        .build();
    return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
  }

}
