package mx.com.percont.vanessa.chatbot;

import com.google.inject.Inject;
import com.google.inject.Singleton;

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

    private WebhookApplication app;

    @Inject
    public WebhookHttpServlet(WebhookApplication app) {
        this.app = app;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonRequest = req.getReader().lines().collect(Collectors.joining());
        Map<String, String> headers = new HashMap<>();
        CompletableFuture<String> compString = app.handleRequest(jsonRequest, headers);
        try {
            resp.getWriter().write(compString.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new ServletException(e);
        }
    }
}
