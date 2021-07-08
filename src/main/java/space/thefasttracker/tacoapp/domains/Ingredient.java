package space.thefasttracker.tacoapp.domains;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED, force=true)
@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;

    @Enumerated(EnumType.STRING) //for sql type varchar
    private Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}