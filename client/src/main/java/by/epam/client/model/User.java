package by.epam.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable{
    @NonNull String name;
    @NonNull String surname;
    @NonNull int age;
}
