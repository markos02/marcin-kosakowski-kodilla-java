package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("TV");
        Product product2 = new Product("Carrot");
        Product product3 = new Product("Shampoo");

        Item itemTv = new Item(product1, new BigDecimal(3999.99), 1, new BigDecimal(3999.99));
        Item itemCarrot1 = new Item(product2, new BigDecimal(2.5), 10, new BigDecimal(25));
        Item itemCarrot2 = new Item(product2, new BigDecimal(2.5), 5, new BigDecimal(12.5));
        Item itemShampoo = new Item(product3, new BigDecimal(15.20), 2, new BigDecimal(30.40));

        product1.getItems().add(itemTv);
        product2.getItems().add(itemCarrot1);
        product2.getItems().add(itemCarrot2);
        product3.getItems().add(itemShampoo);

        Invoice invoice1 = new Invoice("00045");
        invoice1.getItems().add(itemTv);
        invoice1.getItems().add(itemCarrot1);
        invoice1.getItems().add(itemShampoo);
        itemTv.setInvoice(invoice1);
        itemCarrot1.setInvoice(invoice1);
        itemShampoo.setInvoice(invoice1);

        Invoice invoice2 = new Invoice("00046");
        invoice2.getItems().add(itemCarrot2);
        itemCarrot2.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        int idInvoice1 = invoice1.getId();
        invoiceDao.save(invoice2);
        int idInvoice2 = invoice2.getId();

        //Then
        assertNotEquals(0, idInvoice1);
        assertNotEquals(0, idInvoice2);

        //Cleanup

        try {
            invoiceDao.deleteById(idInvoice1);
            invoiceDao.deleteById(idInvoice2);
        } catch (Exception e) {
            //Do nothing
        }
    }
}
