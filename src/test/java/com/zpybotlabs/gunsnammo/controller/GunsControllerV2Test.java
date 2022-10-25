package com.zpybotlabs.gunsnammo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.service.impl.GunsServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = GunsControllerV2.class)
class GunsControllerV2Test {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GunsServiceImpl gunsService;


  @Test
  void getGuns() throws Exception {
    List<Gun> mockGuns = List.of(new Gun(1L, "name", "mail@mail.com", "1x2i3e"));
    Mockito.when(gunsService.getGuns()).thenReturn(mockGuns);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
        "/api/v2/guns").accept(
        MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    String expected = "[{\"name\":\"name\",\"email\":\"mail@mail.com\",\"gunId\":1}]";

    JSONAssert.assertEquals(expected, result.getResponse()
        .getContentAsString(), false);
  }

  @Test
  void getGun() throws Exception {
    Gun mockGun = new Gun(1L, "name", "mail@mail.com", "1x2i3e");
    Mockito.when(gunsService.getGun(anyLong())).thenReturn(mockGun);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
        "/api/v2/guns/1").accept(
        MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    String expected = "{\"name\":\"name\",\"email\":\"mail@mail.com\",\"gunId\":1}";

    JSONAssert.assertEquals(expected, result.getResponse()
        .getContentAsString(), false);
  }

  @Test
  void addGuns() throws Exception {
    doNothing().when(gunsService).createGuns(anyList());
    String input = "[{\"name\":\"name\",\"email\":\"mail@mail.com\",\"gunId\":1}]";
    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v2/guns")
        .content(input)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    assertEquals(201, result.getResponse().getStatus());
  }

  @Test
  void updateGun() throws Exception {
    doNothing().when(gunsService).updateGun(any(Gun.class), anyLong());
    String input = "{\"name\":\"name\",\"email\":\"mail@mail.com\",\"gunId\":1}";
    RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v2/guns/1")
        .content(input)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void updatePatchGun() throws Exception {
    doNothing().when(gunsService).updateGun(any(Gun.class), anyLong());
    String input = "{\"name\": \"M-16\" }";
    RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v2/guns/1")
        .content(input)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void deleteGun() throws Exception {
    doNothing().when(gunsService).updateGun(any(Gun.class), anyLong());
    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v2/guns/1")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }
}