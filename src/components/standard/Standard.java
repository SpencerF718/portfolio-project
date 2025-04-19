package components.standard;

public interface Standard<T> {
    void clear();

    T newInstance();

    void transferFrom(T source);
}