package com.zpybotlabs.gunsnammo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;



@SpringBootTest(classes = GunsNAmmoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GunsIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({"data.sql"})
    @Test
    @Order(1)
    public void testAllGuns() {
        ResponseEntity<List<GunDTO>> exchange = this.restTemplate
                .exchange("http://localhost:" + port + "/api/v2/guns", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        assertTrue(exchange.getBody().size() > 0);
    }

    @Test
    @Order(2)
    public void testAddGuns() {

        List<GunDTO> guns = List.of(new GunDTO(123L, "Ishrav", "ishara@gmail.com", "secret"));
        ResponseEntity<Void> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v2/guns", guns, Void.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

}