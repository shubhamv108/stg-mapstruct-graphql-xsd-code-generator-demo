package code.shubham.transformers;

public interface Transformer<S, T> {

    T transform(S source);

}
