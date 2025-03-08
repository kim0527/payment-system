package com.paymentsystem.membership.application.service;


import com.paymentsystem.common.UseCase;
import com.paymentsystem.membership.adapter.out.persistence.MembershipJpaEntity;
import com.paymentsystem.membership.adapter.out.persistence.MembershipMapper;
import com.paymentsystem.membership.application.port.in.ModifyMembershipCommand;
import com.paymentsystem.membership.application.port.in.ModifyMembershipUseCase;
import com.paymentsystem.membership.application.port.out.ModifyMembershipPort;
import com.paymentsystem.membership.domain.Membership;
import com.paymentsystem.membership.domain.Membership.MembershipAddress;
import com.paymentsystem.membership.domain.Membership.MembershipEmail;
import com.paymentsystem.membership.domain.Membership.MembershipId;
import com.paymentsystem.membership.domain.Membership.MembershipIsCorp;
import com.paymentsystem.membership.domain.Membership.MembershipIsValid;
import com.paymentsystem.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

  private final ModifyMembershipPort modifyMembershipPort;
  private final MembershipMapper membershipMapper;

  @Override
  public Membership modifyMembership(ModifyMembershipCommand command) {
    MembershipJpaEntity membershipJpaEntity = modifyMembershipPort.modifyMembership(
        new MembershipId(command.getMembershipId()),
        new MembershipName(command.getName()),
        new MembershipEmail(command.getEmail()),
        new MembershipAddress(command.getAddress()),
        new MembershipIsValid(command.isValid()),
        new MembershipIsCorp(command.isCorp())
    );;

    // entity -> MemberShip
    return membershipMapper.mapToDomainEntity(membershipJpaEntity);
  }

}
