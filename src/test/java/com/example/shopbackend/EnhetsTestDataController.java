package com.example.shopbackend;

import com.example.shopbackend.controller.dataController;
import com.example.shopbackend.repository.dataRepository;
import com.example.shopbackend.repository.fetaureRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetsTestDataController {

    @InjectMocks
    private dataController controller;

    @Mock
    private dataRepository repo;

    @Mock
    private fetaureRepository fetaureRepo;

    @Test
    public void testItem_Price_True(){
        //Arrange
        when(controller.featuerValue()).thenReturn(true);

        List<Object[]> mockData = new ArrayList<>();
        Object[] object1 = new Object[]{"Item1", 10.0};
        Object[] object2 = new Object[]{"Item2", 20.0};
        mockData.add(object1);
        mockData.add(object2);

        when(controller.feature()).thenReturn(mockData);

        //Act
        List<Object[]> result = controller.feature();

        //Assert
        assertEquals(mockData.size(), result.size());
    }

    @Test
    public void testItem_Price_False(){
        //Arrange
        when(controller.featuerValue()).thenReturn(false);

        List<Object[]> mockData = new ArrayList<>();
        Object[] object1 = new Object[]{"Item1", 5.0};
        Object[] object2 = new Object[]{"Item2", 10.0};
        mockData.add(object1);
        mockData.add(object2);

        when(controller.feature()).thenReturn(mockData);

        //Act
        List<Object[]> result = controller.feature();

        //Assert
        assertEquals(mockData.size(), result.size());
    }
}
