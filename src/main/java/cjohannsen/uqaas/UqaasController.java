package cjohannsen.uqaas;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UqaasController {

    @PostMapping(value = "/enquotify")
    public UnnecessaryQuoteResponse enquotify(@RequestBody UnnecessaryQuoteRequest request) {
        final var sourceSentence = request.getSourceSentence();
        final var minimumReplacementCount = request.getMinimumReplacementCount();
        final var tokens = sourceSentence.split(" ");
        final var replacementCount = (int) Math.max(minimumReplacementCount, Math.random() * tokens.length);
        final var replacedIndices = new ArrayList<Integer>();
        for(int i = 0; i < replacementCount; i++) {
            final var nextReplacementIndex = nextReplacementIndex(replacementCount, replacedIndices);
            final var token = tokens[nextReplacementIndex];
            tokens[nextReplacementIndex] = "\"" + token + "\"";
            replacedIndices.add(nextReplacementIndex);
        }
        final var resultSentence = Arrays.stream(tokens).collect(Collectors.joining(" "));
        return new UnnecessaryQuoteResponse(sourceSentence, minimumReplacementCount, resultSentence);
    }

    private int nextReplacementIndex(int tokenCount, List<Integer> usedIndices) {
        int nextIndex = (int) (Math.random() * tokenCount);
        while(usedIndices.contains(nextIndex)) {
            nextIndex = (int) (Math.random() * tokenCount);
        }
        return nextIndex;
    }
}
