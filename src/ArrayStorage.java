import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[size++] = r;
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i < size() - 1; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                r = storage[i];
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i < size() - 1; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] resumesAvailable = Arrays.copyOf(storage, size());
        return resumesAvailable;
    }

    int size() {
        return size;
    }
}
