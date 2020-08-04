package mx.com.percont.vanessa.chatbot;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Singleton
public class WebhookHttpServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebhookHttpServlet.class);

    private final WebhookApplication app;

    @Inject
    public WebhookHttpServlet(WebhookApplication app) {
        this.app = app;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonRequest = req.getReader().lines().collect(Collectors.joining());
        LOGGER.info(jsonRequest);
        Map<String, String> headers = new HashMap<>();
        CompletableFuture<String> compString = app.handleRequest(jsonRequest, headers);
        try {
            String jsonResponse = compString.get();
            LOGGER.info(jsonResponse);
            resp.getWriter().write(jsonResponse);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("Exception while serving", e);
            throw new ServletException(e);
        }
    }
}
