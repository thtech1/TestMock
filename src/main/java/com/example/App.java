package com.example;

import com.example.applications.ProductApplication;
import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class App {

    @Mock
    private ProductService productService;

    @Mock
    private Product product;

    @InjectMocks
    private ProductApplication productApplication;

    @Test
    public void deveSalvarImagem() {
        Mockito.when(productService.save(product)).thenReturn(true);
        Assertions.assertTrue(productService.save(product));
        Mockito.verify(productService, Mockito.times(1)).save(product);
    }

    @Test
    public void DeveAtualizarImagem() {
        //obs: o doNothing serve para não chamar nada de instância da classe prodcut, por isso que tá
        // dando erro mano
        Mockito.doNothing().when(productService).update(Mockito.any(Product.class));

        productService.update(product);

        Mockito.verify(productService, Mockito.times(1)).update(product);
    }
    @Test
    public void deveRemoverImagem() {
        Mockito.doNothing().when(productService).remove(1);

        productService.remove(1);

        Mockito.verify(productService, Mockito.times(1)).remove(1);
    }
}

