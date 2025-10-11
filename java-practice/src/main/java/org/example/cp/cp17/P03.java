package org.example.cp.cp17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.common.BaseClass;

// 객체 리스트에서 특정 조건의 데이터만 추출하여 새로운 리스트 만들기
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class P03 extends BaseClass {
    @Override
    public void main() {
        List<User> users = Arrays.asList(
            new User("Alice", 25),
            new User("Bob", 30),
            new User("Charlie", 22),
            new User("David", 28)
        );
        List<String> userNames = new ArrayList<>();

        // for (User user : users) {
        //     if (user.getAge() >= 25) {
        //         userNames.add(user.getName());
        //     }
        // }

        userNames = users.stream()
            .filter(u -> u.getAge() >= 25)
            .map(User::getName)
            .toList();

        System.out.println(userNames); // [Alice, Bob, David]
    }
}
