package by.epam.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @NonNull String name;
    @NonNull String surname;
    @NonNull int age;
}
