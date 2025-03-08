package com.paymentsystem.membership;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymentsystem.membership.adapter.in.web.FindMembershipRequest;
import com.paymentsystem.membership.adapter.in.web.RegisterMembershipController;
import com.paymentsystem.membership.adapter.in.web.RegisterMembershipRequest;
import com.paymentsystem.membership.domain.Membership;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FindMembershipControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private RegisterMembershipController registerMembershipController;

  @Test
  public void findMembershipByMemberId() throws Exception {
    RegisterMembershipRequest registerRequest = new RegisterMembershipRequest("name","email","address",true);
    Membership membership = registerMembershipController.registerMembership(registerRequest).getBody();

    mockMvc.perform(
            MockMvcRequestBuilders.get(String.format("/membership/%s", membership.getMembershipId()))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(membership)));
  }

}
