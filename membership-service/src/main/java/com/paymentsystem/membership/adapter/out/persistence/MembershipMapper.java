package com.paymentsystem.membership.adapter.out.persistence;

import com.paymentsystem.membership.domain.Membership;
import com.paymentsystem.membership.domain.Membership.MembershipAddress;
import com.paymentsystem.membership.domain.Membership.MembershipEmail;
import com.paymentsystem.membership.domain.Membership.MembershipId;
import com.paymentsystem.membership.domain.Membership.MembershipIsCorp;
import com.paymentsystem.membership.domain.Membership.MembershipIsValid;
import com.paymentsystem.membership.domain.Membership.MembershipName;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {
  public Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity) {
    return Membership.generateMember(
        new MembershipId(String.valueOf(membershipJpaEntity.getMembershipId())),
        new MembershipName(membershipJpaEntity.getName()),
        new MembershipEmail(membershipJpaEntity.getEmail()),
        new MembershipAddress(membershipJpaEntity.getAddress()),
        new MembershipIsValid(membershipJpaEntity.isValid()),
        new MembershipIsCorp(membershipJpaEntity.isCorp())
    );
  }

}
