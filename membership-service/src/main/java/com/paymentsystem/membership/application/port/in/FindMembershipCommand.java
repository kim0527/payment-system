package com.paymentsystem.membership.application.port.in;

import com.paymentsystem.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {
  private final String membershipId;

}
