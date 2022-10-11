package com.example.person;

import com.example.person.controller.ModelController;
import com.example.person.model.PersonModel;
import com.example.person.repository.ModelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ModelController.class)
class PersonApplicationTests {

    @MockBean
    private ModelRepository modelRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddPerson() throws Exception {
        PersonModel model = new PersonModel(1, "name", "address", "postcode", "age", "job", "email", "phoneno");


        mockMvc.perform(post("/api/person").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(model)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void showAllPerson() throws Exception {
        Mockito.when(modelRepository.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0))
                .andDo(print());
    }
    @Test
    void testAddPersonIfEmpty() throws Exception {
        PersonModel model = new PersonModel();

        mockMvc.perform(post("/api/person").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(model)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
