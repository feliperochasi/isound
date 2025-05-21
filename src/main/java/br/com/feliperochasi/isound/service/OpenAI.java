package br.com.feliperochasi.isound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class OpenAI {
    public static String getResultAI(String text, String object) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        var prompt = "";
        if (object.equalsIgnoreCase("artistic")) {
            prompt = "traga informacoes sobre esse artista: ";
        } else if (object.equalsIgnoreCase("music")) {
            prompt = "traga informacoes sobre essa musica: ";
        } else {
            prompt = "traga imforacoes sobre esse album: ";
        }

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt(prompt + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
