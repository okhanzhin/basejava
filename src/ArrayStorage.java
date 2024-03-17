import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i <= size; i++) {
            storage[i] = null;
            size = 0;
        }
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            Resume tempResume = storage[i];
            if (tempResume.uuid.equals(uuid)) {
                return tempResume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[--size];
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resultResumeArray = new Resume[size];
        System.arraycopy(storage, 0, resultResumeArray, 0, size);

        return resultResumeArray;
    }

    int size() {
        return size;
    }
}
