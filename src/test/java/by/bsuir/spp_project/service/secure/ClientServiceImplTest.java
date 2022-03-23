package by.bsuir.spp_project.service.secure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    @Test
    void generateHashCode() {
        ClientServiceImpl c = new ClientServiceImpl();
        char[] a = c.generateHashCode("pidor");
        System.out.println(Arrays.toString(a));
    }
}