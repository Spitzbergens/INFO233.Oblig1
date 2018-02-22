package no.INFO233.v18.oblig1.matsh;

public class DequeFullException extends RuntimeException {

    public DequeFullException() {
        this("Deque is full");
    }

    public DequeFullException(String message) {
        super(message);
    }

}
