package org.example.cp.cp_optional;

public class Main {
    public static String getUserCity(String userId, UserRepository userRepository) {
        return userRepository.findById(userId)
            .flatMap(User::getAddress)
            .flatMap(Address::getCity)
            .orElse("도시 정보 없음");
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println("user1 도시: " + getUserCity("user1", userRepository));
        System.out.println("user2 도시: " + getUserCity("user2", userRepository));
        System.out.println("user3 도시: " + getUserCity("user3", userRepository));
        System.out.println("user4 도시: " + getUserCity("user4", userRepository));
    }
}
