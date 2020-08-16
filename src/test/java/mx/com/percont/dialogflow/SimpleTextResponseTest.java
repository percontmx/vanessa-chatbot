package mx.com.percont.dialogflow;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mx.com.percont.dialogflow.response.Platform;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;

public class SimpleTextResponseTest {

    private JsonObject expectedTextResponse;

    @Before
    public void loadSimpleResponse() {
        if (null == expectedTextResponse) {
            expectedTextResponse = new Gson().fromJson(
                    new InputStreamReader(
                            getClass().getResourceAsStream("simple_text_response.json")),
                    JsonObject.class);
        }
        Assert.assertNotNull(expectedTextResponse);
    }

    @Test
    public void produceSimpleTextTest() {
        ResponseBuilder builder = new ResponseBuilder();
        builder.add(Platform.FACEBOOK, "Simple Text Response for Facebook.").
                add("Simple Text Response.");
        JsonObject jsonResponse = builder.build();
        Assert.assertNotNull(jsonResponse);
        Assert.assertEquals(expectedTextResponse, jsonResponse);
    }
}
