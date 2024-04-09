package me.harrydrummond.server.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapperTest {

    @Test
    void testStringValueWithHeader_Valid() {
        // Arrange
        Map<String, Integer> mappings = new HashMap<>();
        String header = "example";
        mappings.put(header, 2);
        String expectedValue = "test";
        String[] values = new String[] {"", "", expectedValue, ""};

        // Act
        String actualValue = Mapper.getStringValueWithHeaderOrNull(mappings, header, values);

        // Assert
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testStringValueWithHeader_Null() {
        // Arrange
        Map<String, Integer> mappings = new HashMap<>();
        String[] values = new String[] {"", "", ""};

        // Act
        String actualValue = Mapper.getStringValueWithHeaderOrNull(mappings, "different header", values);

        // Assert
        Assertions.assertNull(actualValue);
    }

    @Test
    void testIntegerValueWithHeader_Valid() {
        // Arrange
        Map<String, Integer> mappings = new HashMap<>();
        String header = "example";
        mappings.put(header, 2);
        Integer expectedValue = 3;
        String[] values = new String[] {"", "", expectedValue+"", ""};

        // Act
        Integer actualValue = Mapper.getIntegerValueWithHeaderOrNull(mappings, header, values);

        // Assert
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testIntegerValueWithHeader_Null() {
        // Arrange
        Map<String, Integer> mappings = new HashMap<>();
        String[] values = new String[] {"", "", ""};

        // Act
        Integer actualValue = Mapper.getIntegerValueWithHeaderOrNull(mappings, "different header", values);

        // Assert
        Assertions.assertNull(actualValue);
    }
}