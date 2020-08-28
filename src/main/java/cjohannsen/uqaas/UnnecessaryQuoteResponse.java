package cjohannsen.uqaas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnnecessaryQuoteResponse {
    String sourceSentence;
    Integer minimumReplacementCount;
    Integer maximumReplacementCount;
    String resultSentence;
}
