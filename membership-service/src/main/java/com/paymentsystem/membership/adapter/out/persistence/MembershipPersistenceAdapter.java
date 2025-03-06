package com.paymentsystem.membership.adapter.out.persistence;

import com.paymentsystem.common.PersistenceAdapter;
import com.paymentsystem.membership.application.port.out.FindMembershipPort;
import com.paymentsystem.membership.application.port.out.RegisterMembershipPort;
import com.paymentsystem.membership.domain.Membership;
import com.paymentsystem.membership.domain.Membership.MembershipAddress;
import com.paymentsystem.membership.domain.Membership.MembershipEmail;
import com.paymentsystem.membership.domain.Membership.MembershipId;
import com.paymentsystem.membership.domain.Membership.MembershipIsCorp;
import com.paymentsystem.membership.domain.Membership.MembershipIsValid;
import com.paymentsystem.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

  private final SpringDataMembershipRepository membershipRepository;
  private final MembershipMapper membershipMapper;

  @Override
  public MembershipJpaEntity createMembership(MembershipName membershipName,
                               MembershipEmail membershipEmail,
                               MembershipAddress membershipAddress,
                               MembershipIsValid membershipIsValid,
                               MembershipIsCorp membershipIsCorp)
  {
    return membershipRepository.save(
        new MembershipJpaEntity(
            membershipName.getNameValue(),
            membershipEmail.getEmailValue(),
            membershipAddress.getAddressValue(),
            membershipIsValid.isValidValue(),
            membershipIsCorp.isCorpValue()
        )
    );
  }

  @Override
  public Membership findMembership(Membership.MembershipId membershipId) {
    return membershipMapper.mapToDomainEntity(
        membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()))
    );
  }
}
