package com.example.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    @Test
    @DisplayName("스터디 만들기 - Assertion Test")
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "message");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "message");
        assertEquals(StudyStatus.STARTD,  study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "supplier message";
            }
        });
    }

    @Test
    @DisplayName("스터디 만들기 - assertAll")
    void asssertAllTest() {
        Study study = new Study();

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.ENDED, study.getStatus(), "message"),
                () -> assertEquals(StudyStatus.STARTD, study.getStatus(), () -> "message")
        );
    }

}
