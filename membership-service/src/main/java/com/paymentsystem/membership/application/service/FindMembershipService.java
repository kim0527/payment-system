package com.paymentsystem.membership.application.service;

import com.paymentsystem.common.UseCase;
import com.paymentsystem.membership.application.port.in.FindMembershipCommand;
import com.paymentsystem.membership.application.port.in.FindMembershipUseCase;
import com.paymentsystem.membership.application.port.out.FindMembershipPort;
import com.paymentsystem.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

  private final FindMembershipPort findMembershipPort;

  @Override
  public Membership findMembership(FindMembershipCommand command) {
    return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
  }
}
