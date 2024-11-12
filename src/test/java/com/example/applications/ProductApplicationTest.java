package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductApplicationTest {
    @InjectMocks
    private ProductApplication productApplication;

    @Mock
    private ProductService productService;

    @Mock
    private Product product;

    @Test
    public void DeveSalvarImagem() {
        Mockito.when(productService.save(product)).thenReturn(true);

        productApplication.append(product);

        verify(productService, Mockito.times(1)).save(product);
    }

    @Test
    public void DeveAtualizarImagem() {
      productApplication.update(product.getId(),product);
      verify(productService).update(product);

    }
    @Test
    public void DeveRemoverImagem() {
        productApplication.remove(product.getId());
        verify(productService, Mockito.times(1)).remove(product.getId());

    }
}
