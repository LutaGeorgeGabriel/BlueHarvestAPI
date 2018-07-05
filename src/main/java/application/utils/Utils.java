package application.utils;

import java.util.UUID;

public class Utils {
    // extracted the UUID generation method here, to use in multiple places
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }
}
