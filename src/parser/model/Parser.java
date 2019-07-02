package parser.model;

public interface Parser<T> {

    T toUnit();

    int getIndex();

    void addParser(Parser parser);
}
