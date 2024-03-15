import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.nonNull(storage[i])) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i <= storage.length - 1; i++) {
            if (Objects.isNull(storage[i])) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume e : storage) {
            if (Objects.nonNull(e) && e.uuid.equals(uuid)) {
                return e;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.nonNull(storage[i]) && storage[i].uuid.equals(uuid)) {
                for (int j = i; j < storage.length - 1; j++) {
                    storage[j] = storage[j + 1];
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int capacityCount = 0;
        for (Resume resume : storage) {
            if (Objects.nonNull(resume)) {
                capacityCount++;
            }
        }
        Resume[] resultResumeArray = new Resume[capacityCount];
        System.arraycopy(storage, 0, resultResumeArray, 0, capacityCount);

        return resultResumeArray;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (Objects.nonNull(resume)) {
                size++;
            }
        }

        return size;
    }
}
