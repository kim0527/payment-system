package com.paymentsystem.membership.adapter.in.web;

import com.paymentsystem.common.WebAdapter;
import com.paymentsystem.membership.application.port.in.RegisterMembershipCommand;
import com.paymentsystem.membership.application.port.in.RegisterMembershipUseCase;
import com.paymentsystem.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

  private final RegisterMembershipUseCase registerMembershipUseCase;

  @PostMapping(path = "/membership/register/")
  public ResponseEntity<Membership> registerMembership(@RequestBody RegisterMembershipRequest request) {
    // reqeust ~~
    // request -> command
    // usecase
    //CQRS - 커맨드와 쿼리를 분리

    RegisterMembershipCommand command = RegisterMembershipCommand.builder()
        .name(request.getName())
        .email(request.getEmail())
        .address(request.getAddress())
        .isValid(true)
        .isCorp(request.isCorp())
        .build();

    return ResponseEntity.ok(registerMembershipUseCase.registerMembership(command));
  }
}
