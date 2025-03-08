package com.paymentsystem.membership.adapter.in.web;

import com.paymentsystem.common.WebAdapter;
import com.paymentsystem.membership.application.port.in.ModifyMembershipCommand;
import com.paymentsystem.membership.application.port.in.ModifyMembershipUseCase;
import com.paymentsystem.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

  private final ModifyMembershipUseCase modifyMembershipUseCase;

  @PostMapping(path = "/membership/modify")
  public ResponseEntity<Membership> modifyMembershipByMemberId(@PathVariable ModifyMembershipRequest request){

    ModifyMembershipCommand command = ModifyMembershipCommand.builder()
        .membershipId(request.getMembershipId())
        .name(request.getName())
        .address(request.getAddress())
        .email(request.getEmail())
        .isCorp(request.isCorp())
        .isValid(request.isValid)
        .build();

    return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
  }

}
