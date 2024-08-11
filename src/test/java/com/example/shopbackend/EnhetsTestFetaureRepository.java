package com.example.shopbackend;

import com.example.shopbackend.controller.dataController;
import com.example.shopbackend.repository.dataRepository;
import com.example.shopbackend.repository.fetaureRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetsTestFetaureRepository {

    @Mock
    private fetaureRepository fetaureRepo;

    @Test
    public void testGetEnabledTrue(){
        //Arrange
        when(fetaureRepo.value()).thenReturn(true);

        //Act
        boolean result = fetaureRepo.value();
        verify(fetaureRepo).value();

        //Assert
        assertTrue(result);
    }

    @Test
    public void testGetEnabledFalse(){
        //Arrange
        when(fetaureRepo.value()).thenReturn(false);

        //Act
        boolean result = fetaureRepo.value();
        verify(fetaureRepo).value();

        //Assert
        assertFalse(result);
    }


}
