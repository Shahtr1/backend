package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record RecordPerson(String name, int age, List<String> hobbies) {
    public RecordPerson {
        // Defensive copy: prevent external mutation of the list
        hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
    }

    // Getter methods are auto-generated:
    // - name()
    // - age()
    // - hobbies()
}
