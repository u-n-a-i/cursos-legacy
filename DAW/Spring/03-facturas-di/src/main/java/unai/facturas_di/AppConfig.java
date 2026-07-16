package unai.facturas_di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import unai.facturas_di.models.Item;
import unai.facturas_di.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Cámara Sonic", 300);
        Product p2 = new Product("Bicicleta Orb", 450);

        List<Item> items = Arrays.asList(
                new Item(p1, 4),
                new Item(p2, 1));

        return items;
    }

    @Bean
    // @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Samsung 27", 250);
        Product p2 = new Product("Notebook Lenovo", 1450);
        Product p3 = new Product("Notebook Samsung", 1250);
        Product p4 = new Product("Mac Book", 2500);

        List<Item> items = Arrays.asList(
                new Item(p1, 4),
                new Item(p2, 1),
                new Item(p3, 2),
                new Item(p4, 5));

        return items;
    }

}
