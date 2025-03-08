package com.paymentsystem.membership.application.port.out;

import com.paymentsystem.membership.adapter.out.persistence.MembershipJpaEntity;
import com.paymentsystem.membership.domain.Membership;

public interface ModifyMembershipPort {
  MembershipJpaEntity modifyMembership(
      Membership.MembershipId membershipId,
      Membership.MembershipName membershipName,
      Membership.MembershipEmail membershipEmail,
      Membership.MembershipAddress membershipAddress,
      Membership.MembershipIsValid membershipIsValid,
      Membership.MembershipIsCorp membershipIsCorp
  );
}
