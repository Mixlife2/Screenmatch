package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
