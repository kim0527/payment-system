package com.paymentsystem.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

  private final String membershipId;
  private final String name;
  private final String email;
  private final String address;
  private final boolean isValid;
  private final boolean isCorp;

  public static Membership generateMember(
      MembershipId membershipId,
      MembershipName membershipName,
      MembershipEmail membershipEmail,
      MembershipAddress membershipAddress,
      MembershipIsValid membershipIsValid,
      MembershipIsCorp membershipIsCorp
  ) {
    return Membership.builder()
        .membershipId(membershipId.membershipId)
        .name(membershipName.nameValue)
        .email(membershipEmail.emailValue)
        .address(membershipAddress.addressValue)
        .isValid(membershipIsValid.isValidValue)
        .isCorp(membershipIsCorp.isCorpValue)
        .build();
  }

  // Membership
  // 오염이 되면 안되는 클래스. 핵심 도메인
  @Value
  public static class MembershipId {
    public MembershipId(String value) {
      this.membershipId = value;
    }

    String membershipId;
  }

  @Value
  public static class MembershipName {
    public MembershipName(String value) {
      this.nameValue = value;
    }

    String nameValue;
  }

  @Value
  public static class MembershipEmail {
    public MembershipEmail(String value) {
      this.emailValue = value;
    }

    String emailValue;
  }

  @Value
  public static class MembershipAddress {
    public MembershipAddress(String value) {
      this.addressValue = value;
    }

    String addressValue;
  }

  @Value
  public static class MembershipIsValid {
    public MembershipIsValid(boolean value) {
      this.isValidValue = value;
    }

    boolean isValidValue;
  }

  @Value
  public static class MembershipIsCorp {
    boolean isCorpValue;

    public MembershipIsCorp(boolean isCorpValue) {
      this.isCorpValue = isCorpValue;
    }
  }

}
