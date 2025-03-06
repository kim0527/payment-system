package com.paymentsystem.membership.application.port.in;

import com.paymentsystem.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

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
  private RegisterMembershipCommand(
      String name,
      String email,
      String address,
      boolean isValid,
      boolean isCorp
  ) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.isValid = isValid;
    this.isCorp = isCorp;
    this.validateSelf(); // @NotBlank, @AssertTrue 검증
  }
}
