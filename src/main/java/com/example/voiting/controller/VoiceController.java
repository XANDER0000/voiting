package com.example.voiting.controller;

import com.example.voiting.entity.*;
import com.example.voiting.service.VoiceService;
import com.example.voiting.service.VoitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api/voice")
public class VoiceController {

    @Autowired
    private VoiceService voiceService;

    @Autowired
    private VoitingService voitingService;

    /**
     * TODO: UPDATE VOICE-CONTROLLER
     */
    @PostMapping("/send")
    ResponseEntity sendVoice(@RequestBody Voice voice) {
        voiceService.sendVoice(voice);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO: UPDATE THIS
     */
    @GetMapping("/question/{id}")
    ResponseEntity<Voiting> getVoitingById(@PathVariable(name = "id") long id) {
        Optional<Voiting> result = voitingService.getVoitingById(id);
        return result.map(voiting -> ResponseEntity.ok().body(voiting))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * TODO: UPDATE THIS
     */
//    @PostMapping("/verification")
//    ModelAndView getVoiting(@RequestBody GetVoiting voiting) {
//        if (voiceService.checkCode(voiting.getCode(), voiting.getId())) {
//            return new ModelAndView("redirect:/api/voice/question/" + voiting.getId());
//        }
//        return new ModelAndView("redirect:/api/voiting");
//    }
}
