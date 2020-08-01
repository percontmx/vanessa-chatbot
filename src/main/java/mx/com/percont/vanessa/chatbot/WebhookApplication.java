package mx.com.percont.vanessa.chatbot;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import mx.com.percont.vanessa.chatbot.intents.WatchMenuIntent;

public class WebhookApplication extends DialogflowApp {

    @ForIntent("webhook_intent")
    public ActionResponse webhookIntent(ActionRequest request) {
        ResponseBuilder builder = getResponseBuilder(request);
        builder.add("webhook intent message");
        return builder.build();
    }

    @ForIntent("watch_menu")
    public ActionResponse watchMenu(ActionRequest request) {
        WatchMenuIntent intent = new WatchMenuIntent();
        return intent.getResponse(getResponseBuilder(request));
    }

}
