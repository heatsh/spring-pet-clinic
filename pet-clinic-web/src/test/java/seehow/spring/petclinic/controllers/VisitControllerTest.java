package seehow.spring.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import seehow.spring.petclinic.model.Owner;
import seehow.spring.petclinic.model.Pet;
import seehow.spring.petclinic.services.PetService;
import seehow.spring.petclinic.services.VisitService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({MockitoExtension.class})
class VisitControllerTest {
    @Mock
    VisitService visitService;
    @Mock
    PetService petService;

    @InjectMocks
    VisitController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(new Pet());

        mockMvc.perform(get("/owners/1/pets/2/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(new Pet());

        mockMvc.perform((post("/owners/1/pets/2/visits/new")))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(visitService).save(any());
    }
}