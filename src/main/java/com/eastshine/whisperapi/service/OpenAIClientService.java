package com.eastshine.whisperapi.service;

import com.eastshine.whisperapi.model.request.TranscriptionRequest;
import com.eastshine.whisperapi.model.request.WhisperTranscriptionRequest;
import com.eastshine.whisperapi.model.response.WhisperTranscriptionResponse;
import com.eastshine.whisperapi.openaiclient.OpenAIClient;
import com.eastshine.whisperapi.openaiclient.OpenAIClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                .model(openAIClientConfig.getAudioModel())
                .file(transcriptionRequest.getFile())
                .build();
        return openAIClient.createTranscription(whisperTranscriptionRequest);
    }

}
