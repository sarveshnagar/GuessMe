package io.word.guessmedata;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GuessMeService {

    private String[] words = {
                "about","above","abuse","actor","acute","admit"
    };

    public String getRandomWord() {
        return (words[new Random().nextInt(words.length)]);
    }
}
