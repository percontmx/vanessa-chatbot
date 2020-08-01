package mx.com.percont.vanessa.chatbot.config;

import com.google.inject.servlet.ServletModule;
import mx.com.percont.vanessa.chatbot.WebhookHttpServlet;

public class WebhookServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/webhook").with(WebhookHttpServlet.class);
    }
}
