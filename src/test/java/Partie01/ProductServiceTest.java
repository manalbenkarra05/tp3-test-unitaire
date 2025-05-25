package Partie01;

import org.example.*;
import org.example.Partie01.Product;
import org.example.Partie01.ProductApiClient;
import org.example.Partie01.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() throws Exception {
        ProductApiClient mockApi = mock(ProductApiClient.class);
        Product expected = new Product("p001", "Laptop");

        when(mockApi.getProduct("p001")).thenReturn(expected);

        ProductService service = new ProductService(mockApi);
        Product result = service.getProduct("p001");

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(mockApi).getProduct("p001");
    }

    @Test
    public void testGetProduct_ApiFailure() throws Exception {
        ProductApiClient mockApi = mock(ProductApiClient.class);

        when(mockApi.getProduct("fail")).thenThrow(new RuntimeException("API failed"));

        ProductService service = new ProductService(mockApi);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.getProduct("fail");
        });

        assertEquals("API failed", exception.getMessage());
        verify(mockApi).getProduct("fail");
    }

    @Test
    public void testGetProduct_InvalidData() throws Exception {
        ProductApiClient mockApi = mock(ProductApiClient.class);

        when(mockApi.getProduct("null")).thenReturn(null);

        ProductService service = new ProductService(mockApi);
        Product result = service.getProduct("null");

        assertNull(result);
        verify(mockApi).getProduct("null");
    }
}
