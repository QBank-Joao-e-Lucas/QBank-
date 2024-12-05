package qbank.transactions;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class TransactionControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @BeforeEach
    void ensureServerRunning() {
        if (!server.isRunning()) {
            server.start();
        }
    }

    @Test
    void testSuccessfulTransfer() {
        HttpResponse<String> response = client.toBlocking().exchange(
                HttpRequest.POST("/transactions/transfer?fromAccount=123&toAccount=456&amount=1000&type=own", ""),
                String.class
        );

        assertEquals("Transferência de R$1000.00 de 123 para 456 via own efetuada.", response.body());
    }
}
