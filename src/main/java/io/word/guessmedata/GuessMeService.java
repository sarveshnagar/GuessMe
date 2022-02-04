package io.word.guessmedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GuessMeService {

    @Autowired
    private GuessMeRepository guessMeRepository;

    private String[] words = {
            "about","above","abuse","actor","acute","admit"
    };

    private List<GuessMe> wordList = new ArrayList<>(Arrays.asList(
//            new GuessMe("04/02/2022","about")
    ));

    public String getRandomWord() {
        return (words[new Random().nextInt(words.length)]);
    }

    public String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String date = d.format(cal.getTime());
        return date;
    }

    public String getPreviousDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date myDate = dateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_YEAR, -1);

            Date previousDate = calendar.getTime();
            return dateFormat.format(previousDate);
        }
        catch (ParseException except) {
            except.printStackTrace();
            return null;
        }
    }

    public boolean checkDate(String date) {
        if(guessMeRepository.findById(date).isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    public void deletePrevWord(String id) {
        guessMeRepository.deleteById(id);
    }

    public String addWord(String id, String previousDate) {
        String word = getRandomWord();
        if(guessMeRepository.findById(previousDate).isPresent()) {
            String prevWord = guessMeRepository.findById(previousDate).get().getWord();
            while(prevWord.equals(word)){
                word = getRandomWord();
            }
            deletePrevWord(previousDate);
        }
        GuessMe guessMe = new GuessMe(id, word);
        guessMeRepository.save(guessMe);
        return word;
    }

    public String getWord(String id) {
        return guessMeRepository.findById(id).get().getWord();
    }
}
