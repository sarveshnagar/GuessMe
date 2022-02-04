package io.word.guessmedata;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GuessMe {

   @Id
   private String id;
   private String word;

   public GuessMe() {
   }

   public GuessMe(String id, String word) {
      this.id = id;
      this.word = word;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getWord() {
      return word;
   }

   public void setWord(String word) {
      this.word = word;
   }
}
