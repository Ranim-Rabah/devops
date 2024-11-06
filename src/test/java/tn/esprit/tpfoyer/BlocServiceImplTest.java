package tn.esprit.tpfoyer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlocServiceImplTest {

    @Mock
    private BlocRepository blocRepository;

    @InjectMocks
    private BlocServiceImpl blocService;

    /**
     * Test the addBloc method to ensure it correctly saves and returns the Bloc.
     */
    @Test
    public void testAddBloc() {
        // Arrange
        Bloc bloc = new Bloc();
        bloc.setCapaciteBloc(100);
        bloc.setNomBloc("Bloc A");

        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc result = blocService.addBloc(bloc);

        // Assert
        assertEquals(bloc, result, "The returned Bloc should be the one saved in the repository");
        verify(blocRepository, times(1)).save(bloc);
    }

    /**
     * Test the retrieveBloc method to ensure it retrieves the correct Bloc by ID.
     */
    @Test
    public void testRetrieveBloc() {
        // Arrange
        Long blocId = 1L;
        Bloc bloc = new Bloc();
        bloc.setId(blocId);
        bloc.setCapaciteBloc(100);
        bloc.setNomBloc("Bloc B");

        when(blocRepository.findById(blocId)).thenReturn(Optional.of(bloc));

        // Act
        Bloc result = blocService.retrieveBloc(blocId);

        // Assert
        assertEquals(bloc, result, "The returned Bloc should match the one retrieved by ID");
        verify(blocRepository, times(1)).findById(blocId);
    }
}
