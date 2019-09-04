package com.testPackage.java8;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

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


        List<String> subordinates = Lists.newArrayList();
        subordinates.add("1");
        subordinates.add("2");
        subordinates.add("4");
        subordinates.add("5");
        subordinates.add("6");

        List<String> concernIds = Lists.newArrayList();
        concernIds.add("1");
        concernIds.add("2");
        concernIds.add("3");
        concernIds.add("4");
        // item  是指循环concernIds中的当前的那个元素
        List<String> collect = concernIds.stream().filter(item -> subordinates.contains(item)).distinct()
                .collect(Collectors.toList());
        System.out.println("subordinates所包含的元素"+collect);
        // 剔除掉元素为2的集合
        List<String> collect2 = concernIds.stream().filter(item -> subordinates.contains(item)).filter(item -> !item.equals("2")).distinct()
                .collect(Collectors.toList());
        System.out.println("剔除后的集合为"+collect2);
    }


}
