package com.paymentsystem.membership.application.port.in;

import com.paymentsystem.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

  @NotBlank
  private final String membershipId;
  @NotBlank
  private final String name;
  @NotBlank
  private final String email;
  @NotBlank
  private final String address;
  @AssertTrue
  private final boolean isValid;
  private final boolean isCorp;

  @Builder
  private ModifyMembershipCommand(String membershipId, String name, String email, String address, boolean isValid,
                                 boolean isCorp) {
    this.membershipId = membershipId;
    this.name = name;
    this.email = email;
    this.address = address;
    this.isValid = isValid;
    this.isCorp = isCorp;
  }
}
