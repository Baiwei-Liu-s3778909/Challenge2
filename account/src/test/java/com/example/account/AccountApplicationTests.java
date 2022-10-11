package com.example.account;

import com.example.account.controller.AccountController;
import com.example.account.model.AccountModel;
import com.example.account.repository.AccountRepository;
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

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
class AccountApplicationTests {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddAccount() throws Exception {
        AccountModel model = new AccountModel();
        model.setAccNumber(1);
        model.setAccountType("load");
        model.setAccountName("bai");
        model.setBalance("12");

        mockMvc.perform(post("/api/account").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(model)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    void showAllAccount() throws Exception {
        Mockito.when(accountRepository.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0))
                .andDo(print());
    }

    @Test
    void testAddAccountIfEmpty() throws Exception {
        AccountModel model = new AccountModel();

        mockMvc.perform(post("/api/account").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(model)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
