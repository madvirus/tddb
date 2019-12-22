package appc;

public class Game {
    private GameNumGen gen;
    private String answer;

    public Game(GameNumGen gen) {
        this.gen = gen;
    }

    public void init(GameLevel level) {
        answer = gen.generate(level);
    }

    public boolean guess(String s) {
        return answer.equals(s);
    }
}
