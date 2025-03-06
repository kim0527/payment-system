package com.paymentsystem.membership.adapter.in.web;

import com.paymentsystem.common.WebAdapter;
import com.paymentsystem.membership.application.port.in.RegisterMembershipCommand;
import com.paymentsystem.membership.application.port.in.RegisterMembershipUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

  private final RegisterMembershipUseCase registerMembershipUseCase;

  @PostMapping(path = "/membership/register/")
  void registerMembership(@RequestBody RegisterMembershipRequest request) {
    // reqeust ~~
    // request -> command
    // usecase

    RegisterMembershipCommand command = RegisterMembershipCommand.builder()
        .name(request.getName())
        .email(request.getEmail())
        .address(request.getAddress())
        .isValid(true)
        .isCorp(request.isCorp())
        .build();

    registerMembershipUseCase.registerMembership(command);
  }
}
