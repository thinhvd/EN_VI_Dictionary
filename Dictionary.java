import java.util.ArrayList;

public class Dictionary {
    public ArrayList<Word> WordList;
    /**
     * Constructor.
     */
    public Dictionary() {
        WordList = new ArrayList<Word>();
    }
    
    public void addWord(Word w) {
        WordList.add(w);
    }
    
    public void deleteWord(String target) {
        for (int i = 0; i < WordList.size(); i++) {
            if(WordList.get(i).getWordTarget().equals(target)) {
                WordList.remove(i);
                break;
            }
        }
    }
}
