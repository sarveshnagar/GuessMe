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

        String date = guessMe.getDate();
        String previousDate = guessMe.getPreviousDate(date);
        String word = null;
        if (guessMe.checkDate(date)) {
            word = guessMe.addWord(date, previousDate);
        } else {
            word = guessMe.getWord(date);
        }
        return word;
    }
}
