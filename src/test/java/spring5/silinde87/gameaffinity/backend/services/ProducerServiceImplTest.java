package spring5.silinde87.gameaffinity.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring5.silinde87.gameaffinity.backend.domain.Producer;
import spring5.silinde87.gameaffinity.backend.repositories.GameRepository;
import spring5.silinde87.gameaffinity.backend.repositories.ProducerRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProducerServiceImplTest {

    @Mock
    ProducerRepository producerRepository;

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    ProducerServiceImpl producerService;

    Producer returnProducer;

    @BeforeEach
    void setUp() {
        returnProducer = Producer.builder().id(1L).build();
    }

    @Test
    void findAll() {
        List<Producer> returnProducerList = new ArrayList<>();
        returnProducerList.add(Producer.builder().id(1L).build());
        returnProducerList.add(Producer.builder().id(2L).build());

        when(producerRepository.findAll()).thenReturn(returnProducerList);

        Collection<Producer> producers = producerService.findAll();

        assertNotNull(producers);
        assertEquals(2, producers.size());
    }

    @Test
    void add() {
        Producer producerToSave = Producer.builder().id(1L).build();

        when(producerRepository.save(any())).thenReturn(returnProducer);

        Producer savedProducer = producerService.add(producerToSave);

        assertNotNull(savedProducer);

        verify(producerRepository).save(any());
    }

    @Test
    void update() {
        Producer producerToUpdate = Producer.builder().id(1L).build();

        when(producerRepository.save(any())).thenReturn(returnProducer);

        Producer updatedProducer = producerService.update(producerToUpdate);

        assertNotNull(updatedProducer);

        verify(producerRepository).save(any());
    }

    @Test
    void delete() {
        producerService.delete(returnProducer);

        verify(producerRepository, times(1)).delete(any());
    }
}