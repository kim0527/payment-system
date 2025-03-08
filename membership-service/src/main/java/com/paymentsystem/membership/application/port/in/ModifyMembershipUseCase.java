package com.paymentsystem.membership.application.port.in;

import com.paymentsystem.membership.domain.Membership;

public interface ModifyMembershipUseCase {

  Membership modifyMembership(ModifyMembershipCommand command);
}
