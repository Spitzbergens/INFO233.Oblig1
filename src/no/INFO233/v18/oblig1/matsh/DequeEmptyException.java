package no.INFO233.v18.oblig1.matsh;


public class DequeEmptyException extends RuntimeException {

    public DequeEmptyException() {
        this("Deque is empty");
    }

    public DequeEmptyException(String message) {


    }

}
