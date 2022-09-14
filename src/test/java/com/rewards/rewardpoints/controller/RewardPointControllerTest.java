package com.rewards.rewardpoints.controller;

import com.rewards.rewardpoints.model.RewardPoints;
import com.rewards.rewardpoints.service.RewardsCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
class RewardPointControllerTest {

  @Autowired
    private MockMvc mockMvc ;

    @MockBean
    private RewardsCalculator rewardsCalculator;
    @Test
    public void getRewardpoints() throws Exception {

        RewardPoints rewardPoints = new RewardPoints(90);
        Mockito.when(rewardsCalculator.calculateRewards(Mockito.anyDouble())).thenReturn(rewardPoints);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rewards/120").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{\"totalPoints\":90}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);

    }

    @Test
    public void getRewardPointsInputStringThrowsBadRequest() throws Exception {
        RewardPoints rewardPoints = new RewardPoints(90);
        Mockito.when(rewardsCalculator.calculateRewards(Mockito.anyDouble())).thenReturn(rewardPoints);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rewards/str").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{\n" +
                "    \"errorCode\": \"422 UNPROCESSABLE_ENTITY\",\n" +
                "    \"errorMessage\": \"Please provide numeric value\"\n" +
                "}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
}