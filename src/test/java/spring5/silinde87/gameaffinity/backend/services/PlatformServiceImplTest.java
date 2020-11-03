package spring5.silinde87.gameaffinity.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Platform;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.PlatformRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlatformServiceImplTest {

    @Mock
    PlatformRepository platformRepository;

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    PlatformServiceImpl platformService;

    Platform returnPlatform;

    @BeforeEach
    void setUp() {
        returnPlatform = Platform.builder().id(1L).build();
    }

    @Test
    void findAll() {
        List<Platform> returnPlatformList = new ArrayList<>();
        returnPlatformList.add(Platform.builder().id(1L).build());
        returnPlatformList.add(Platform.builder().id(2L).build());

        when(platformRepository.findAll()).thenReturn(returnPlatformList);

        Collection<Platform> platforms = platformService.findAll();

        assertNotNull(platforms);
        assertEquals(2, platforms.size());
    }

    @Test
    void add() {
        Platform platformToSave = Platform.builder().id(1L).build();

        when(platformRepository.save(any())).thenReturn(returnPlatform);

        Platform savedPlatform = platformService.add(platformToSave);

        assertNotNull(savedPlatform);

        verify(platformRepository).save(any());
    }

    @Test
    void update() {
        Platform platformToUpdate = Platform.builder().id(1L).build();

        when(platformRepository.save(any())).thenReturn(returnPlatform);

        Platform updatedPlatform = platformService.update(platformToUpdate);

        assertNotNull(updatedPlatform);

        verify(platformRepository).save(any());
    }

    @Test
    void delete() {
        platformService.delete(returnPlatform);

        verify(platformRepository, times(1)).delete(any());
    }
}