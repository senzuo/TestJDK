package nio.selectordemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by 申卓 on 2017/8/10.
 */
public class EchoTest {

    Process server;
    EchoClient client;

    @Before
    public void setup() throws IOException, InterruptedException {
        System.out.println("before");
        server = EchoServer.start();
        client = EchoClient.start();
    }

    @Test
    public void givenServerClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
    }

    @After
    public void teardown() throws IOException {
        System.out.println("end");
        server.destroy();
        EchoClient.stop();
    }
}