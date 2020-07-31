package mx.com.percont.vanessa.chatbot;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WebhookApplicationTest {

    private WebhookApplication app = new WebhookApplication();

    @Mock
    private ActionRequest mockRequest;

    @Test
    public void webhookIntentTest() {
        ActionResponse actionResponse = app.webhookIntent(mockRequest);
        Assert.assertNotNull(actionResponse);
        Assert.assertNotNull(actionResponse.getWebhookResponse());
        Assert.assertNotNull(actionResponse.getWebhookResponse().getFulfillmentText());
        Assert.assertEquals("webhook intent message",
                actionResponse.getWebhookResponse().getFulfillmentText());
    }
}
