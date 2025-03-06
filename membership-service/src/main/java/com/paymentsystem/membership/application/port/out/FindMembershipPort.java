package com.paymentsystem.membership.application.port.out;

import com.paymentsystem.membership.domain.Membership;

public interface FindMembershipPort {
  Membership findMembership(Membership.MembershipId membershipId);
}
