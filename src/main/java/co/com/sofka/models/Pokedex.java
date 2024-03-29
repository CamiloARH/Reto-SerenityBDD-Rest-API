package co.com.sofka.models;
import java.util.List;

public class Pokedex {
    private Integer count;
    private String next;
    private Object previous;
    private List<ResultPokemon> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<ResultPokemon> getResults() {
        return results;
    }

    public void setResults(List<ResultPokemon> results) {
        this.results = results;
    }

}
