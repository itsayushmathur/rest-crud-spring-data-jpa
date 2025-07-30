
### 🧱 What is `JpaRepository`?

`JpaRepository` is an interface provided by Spring Data JPA that extends **`CrudRepository`** and **`PagingAndSortingRepository`**.

### 📋 Hierarchy
JpaRepository<T, ID>  
  ↳ PagingAndSortingRepository<T, ID>  
      ↳ CrudRepository<T, ID>

---

### 🏷️ Key Methods from `JpaRepository`

| Method                        | Purpose                             |
|-------------------------------|-------------------------------------|
| `save(entity)`                | Insert or update                    |
| `findById(id)`                | Get entity by ID                    |
| `findAll()`                   | Get all records                     |
| `deleteById(id)`              | Delete by ID                        |
| `existsById(id)`              | Check if record exists              |
| `count()`                     | Total number of records             |

---

### 🪜 Steps to Use `JpaRepository`

| Step | Action                                                                 |
|------|------------------------------------------------------------------------|
| 1    | Create an entity class and annotate with `@Entity`                    |
| 2    | Create an interface that extends `JpaRepository<Entity, ID>`          |
| 3    | Spring auto-implements repository during runtime                      |
| 4    | Inject the repository in your service/controller using `@Autowired`   |

---

### ✅ Example

```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName); // Auto-generated query
}
```
---
