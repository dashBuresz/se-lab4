package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    @Test
    void fire_Failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0); // Set failure rate to 100%

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
    }
    @Test
    void fire_InvalidAmountOfTorpedos() {
        // Arrange
        TorpedoStore emptyStore = new TorpedoStore(0);
        TorpedoStore storeWithOneTorpedo = new TorpedoStore(1);

        // Act & Assert
        try {
            emptyStore.fire(1);
            storeWithOneTorpedo.fire(2);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }
    
    @Test
    void defaultFailureRateWhenEnvironmentVariableIsAbsent() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        // Act
        boolean result = store.fire(1);
        // Assert
        assertEquals(true, result);
    }

    @Test
    void getTorpedoCount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(5);

        // Act
        int count = store.getTorpedoCount();

        // Assert
        assertEquals(5, count);
    }
}
