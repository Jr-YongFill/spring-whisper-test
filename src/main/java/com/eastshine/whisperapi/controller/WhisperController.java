package com.eastshine.whisperapi.controller;

import com.eastshine.whisperapi.model.request.TranscriptionRequest;
import com.eastshine.whisperapi.model.response.WhisperTranscriptionResponse;
import com.eastshine.whisperapi.service.OpenAIClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class WhisperController {

    private final OpenAIClientService openAIClientService;

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WhisperTranscriptionResponse createTranscription(@ModelAttribute TranscriptionRequest transcriptionRequest){
        return openAIClientService.createTranscription(transcriptionRequest);
    }

}
