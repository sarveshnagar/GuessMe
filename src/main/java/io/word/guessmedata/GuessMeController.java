package io.word.guessmedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuessMeController {

    @Autowired
    private GuessMeService guessMe;

    @RequestMapping("/word")
    public String getWord() {
        String word = guessMe.getRandomWord();
        return word;
    }

}
