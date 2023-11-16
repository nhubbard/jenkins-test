import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TestCommission {
    private AutoCloseable mocks;
    @Mock private Lock lock = mock(Lock.class);
    @Mock private Stock stock = mock(Stock.class);
    @Mock private Barrel barrel = mock(Barrel.class);
    @InjectMocks private CalculateCommission c = new CalculateCommission();

    @BeforeAll
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterAll
    public void closeDown() throws Exception {
        mocks.close();
    }

    @Test
    public void testGetCommissionSkipWhileLoop() {
        when(lock.getCount()).thenReturn(0);
        double actual = c.getCommission(lock, stock, barrel);
        Assertions.assertEquals(0.0, actual);
    }

    @Test
    public void testGetCommissionEnterWhileLoop() {
        when(lock.getCount()).thenReturn(5);
        when(stock.getCount()).thenReturn(5);
        when(barrel.getCount()).thenReturn(5);
        double actual = c.getCommission(lock, stock, barrel);
        Assertions.assertEquals(520.0, actual);
    }
}