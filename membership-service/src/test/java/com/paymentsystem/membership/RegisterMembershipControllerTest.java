package com.paymentsystem.membership;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymentsystem.membership.adapter.in.web.RegisterMembershipRequest;
import com.paymentsystem.membership.domain.Membership;
import com.paymentsystem.membership.domain.Membership.MembershipAddress;
import com.paymentsystem.membership.domain.Membership.MembershipEmail;
import com.paymentsystem.membership.domain.Membership.MembershipId;
import com.paymentsystem.membership.domain.Membership.MembershipIsCorp;
import com.paymentsystem.membership.domain.Membership.MembershipIsValid;
import com.paymentsystem.membership.domain.Membership.MembershipName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterMembershipControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void testRegisterMembership() throws Exception {
    RegisterMembershipRequest request = new RegisterMembershipRequest("name","email","address",true);

    Membership expect = Membership.generateMember(
        new MembershipId("1"),
        new MembershipName("name"),
        new MembershipEmail("email"),
        new MembershipAddress("address"),
        new MembershipIsValid(true),
        new MembershipIsCorp(true)
    );

    mockMvc.perform(
            MockMvcRequestBuilders.post("/membership/register/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(expect)));
  }


}
