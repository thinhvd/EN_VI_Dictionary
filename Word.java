public class Word {
    private String word_target;
    private String word_explain;
    
    /**
     * Constructor.
     */
    public Word(){}
    
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
    
    // Getter and Setter
    public void setWordTarget(String wordTarget) {
        word_target = wordTarget;
    }
    
    public String getWordTarget() {
        return word_target;
    }
    
    public void setWordExplain(String wordExplain) {
        word_explain = wordExplain;
    }
    
    public String getWordExplain() {
        return word_explain;
    }
}
