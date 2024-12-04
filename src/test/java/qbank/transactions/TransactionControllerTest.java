package qbank.transactions;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class TransactionControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testSuccessfulTransfer() {
        String response = client.toBlocking().retrieve(
                "/transactions/transfer?fromAccount=123&toAccount=456&amount=1000&type=own"
        );
        assertEquals("Transferência de R$1000.0 de 123 para 456 via own efetuada.", response);
    }
}
