package mx.com.percont.vanessa.chatbot;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

public class WebhookApplication extends DialogflowApp {

    @ForIntent("webhook_intent")
    public ActionResponse webhookIntent(ActionRequest request){
        ResponseBuilder builder = getResponseBuilder(request);
        builder.add("Me pelas la merga");
        return builder.build();
    }

}
