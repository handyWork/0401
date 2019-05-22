package com.testPackage.java8;

import java.util.*;

public class Stream {

    private enum Status {
        OPEN, CLOSED
    };

private void add(String string){
    System.out.println("测试lambda表达式"+string);
}

    private static final class Task {
        private final Status  status;
        private  final Integer  points;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }
    }

    final Collection<Task> tasks = Arrays.asList(
            new Task(Status.OPEN, 5), new Task(Status.OPEN, 6), new Task(Status.CLOSED, 7)
    );


    public static void main(String[] args) {
        Stream stream = new Stream();
        int sum = stream.tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        System.out.println("值的总和为"+sum);
    }


}
