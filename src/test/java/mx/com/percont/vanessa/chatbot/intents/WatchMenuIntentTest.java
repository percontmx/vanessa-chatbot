package mx.com.percont.vanessa.chatbot.intents;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WatchMenuIntentTest {

    @Test
    public void Merga() {
        WatchMenuIntentDelegate i = new WatchMenuIntentDelegate();
        Assert.assertNotNull(i);
    }


}
