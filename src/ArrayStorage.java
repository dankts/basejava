import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size++] = r;
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                r = storage[i];
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return size;
    }
}
