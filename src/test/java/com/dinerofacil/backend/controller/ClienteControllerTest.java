package com.dinerofacil.backend.controller;

import com.dinerofacil.backend.model.Cliente;
import com.dinerofacil.backend.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testGetAllClientes() throws Exception {
        when(clienteService.getAllClientes()).thenReturn(Arrays.asList(new Cliente(), new Cliente()));

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteID(1);

        when(clienteService.getClienteById(1)).thenReturn(Optional.of(cliente));

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteID").value(1));
    }

    @Test
    public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteID(1);

        when(clienteService.saveCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/api/clientes")
                        .contentType("application/json")
                        .content("{\"tipoDocumento\":\"CC\",\"numeroDocumento\":\"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteID").value(1));
    }

    @Test
    public void testDeleteCliente() throws Exception {
        doNothing().when(clienteService).deleteCliente(1);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isOk());
    }
}
