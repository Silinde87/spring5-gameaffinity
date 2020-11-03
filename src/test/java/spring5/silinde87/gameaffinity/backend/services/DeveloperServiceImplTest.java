package spring5.silinde87.gameaffinity.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Developer;
import spring5.silinde87.gameaffinity.backend.repositories.DeveloperRepository;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeveloperServiceImplTest {

    @Mock
    DeveloperRepository developerRepository;

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    DeveloperServiceImpl developerService;

    Developer returnDeveloper;


    @BeforeEach
    void setUp() {
        returnDeveloper = Developer.builder().id(1L).build();
    }

    @Test
    void findAll() {
        List<Developer> returnDeveloperList = new ArrayList<>();
        returnDeveloperList.add(Developer.builder().id(1L).build());
        returnDeveloperList.add(Developer.builder().id(2L).build());

        when(developerRepository.findAll()).thenReturn(returnDeveloperList);

        Collection<Developer> developers = developerService.findAll();

        assertNotNull(developers);
        assertEquals(2, developers.size());
    }

    @Test
    void add() {
        Developer devToSave = Developer.builder().id(1L).build();

        when(developerRepository.save(any())).thenReturn(returnDeveloper);

        Developer savedDev = developerService.add(devToSave);

        assertNotNull(savedDev);

        verify(developerRepository).save(any());
    }

    @Test
    void update() {
        Developer devToUpdate = Developer.builder().id(1L).build();

        when(developerRepository.save(any())).thenReturn(returnDeveloper);

        Developer updatedDev = developerService.update(devToUpdate);

        assertNotNull(updatedDev);

        verify(developerRepository).save(any());
    }

    @Test
    void delete() {
        developerService.delete(returnDeveloper);

        verify(developerRepository, times(1)).delete(any());
    }
}