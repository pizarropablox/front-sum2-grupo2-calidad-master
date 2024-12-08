package com.example.recetas_front.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class RouterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrarFormularioRegistro() throws Exception {
        mockMvc.perform(get("/registro"))
                .andExpect(status().isOk())
                .andExpect(view().name("registro"));
    }

    @Test
    void testMostrarFormularioLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    void testMostrarInicio() throws Exception {
        mockMvc.perform(get("/inicio"))
                .andExpect(status().isOk())
                .andExpect(view().name("inicio"));
    }

    @Test
    void testMostrarIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/inicio"));
    }

    @Test
    @WithMockUser
    void testVerReceta() throws Exception {
        mockMvc.perform(get("/receta/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("receta"));
    }

    @Test
    @WithMockUser
    void testMostrarBusqueda() throws Exception {
        mockMvc.perform(get("/buscar"))
                .andExpect(status().isOk())
                .andExpect(view().name("busqueda"));
    }

    @Test
    @WithMockUser
    void testPublicar() throws Exception {
        mockMvc.perform(get("/publicar"))
                .andExpect(status().isOk())
                .andExpect(view().name("publicar"));
    }

    @Test
    void testNoAutorizado() throws Exception {
        mockMvc.perform(get("/403"))
                .andExpect(status().isOk())
                .andExpect(view().name("403"));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void testAdminPanel() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("administracion"));
    }

}
