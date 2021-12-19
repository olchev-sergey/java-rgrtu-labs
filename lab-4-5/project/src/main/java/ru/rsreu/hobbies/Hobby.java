package ru.rsreu.hobbies;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Hobby {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        CARDIOVASCULAR_DISEASES,LAXATIVES, SWEATSHOPS, EXPECTORANTS, SOOTHING, ANTI_INFLAMMATORY, VITAMIN_SUPPLEMENTS,
        KIND, BUSYNESS, DAY_COUNT, SUPPOSE_START_TIME
    }
}
