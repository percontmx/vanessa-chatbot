package mx.com.percont.dialogflow.response;

import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
public class TextResponse {

    private final Platform platform;

    private final List<String> texts;

    public TextResponse(Platform platform, String text){
        this.platform = platform;
        this.texts = Stream.of(text).collect(toList());
    }

}
