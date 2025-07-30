
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
## 🔍 Optional in Java (Revision Notes)

`Optional<T>` is a **container object** introduced in Java 8 that may or may not contain a non-null value. It helps in **avoiding `NullPointerException`** and promotes **functional-style programming**.

---

### 📘 Definition

`Optional<T>` is a **wrapper** around an object of type `T`. It represents:

- **Present**: If a value is available
- **Empty**: If no value is present

It’s part of the `java.util` package.

---

### ✅ Common Use Cases

- To return values from methods **safely** without returning `null`
- To represent the **absence of a value** clearly
- To **chain operations** without null checks (using functional methods)

---

### 🔧 Common Methods of `Optional`

| Method                          | Description                                                                 |
|---------------------------------|-----------------------------------------------------------------------------|
| `empty()`                       | Returns an empty `Optional`                                                 |
| `of(value)`                     | Returns `Optional` with non-null value (throws `NullPointerException` if null) |
| `ofNullable(value)`             | Returns `Optional` with value or empty if null                              |
| `isPresent()`                   | Returns `true` if value is present                                          |
| `isEmpty()`                     | Returns `true` if value is absent                                           |
| `get()`                         | Returns the value if present (⚠️ may throw `NoSuchElementException`)        |
| `orElse(defaultValue)`         | Returns value if present; else returns the default value                    |
| `orElseGet(Supplier)`          | Returns value if present; else gets value from supplier                     |
| `orElseThrow(Supplier)`        | Returns value or throws exception provided by the supplier                  |
| `ifPresent(Consumer)`          | Executes the given action if value is present                               |
| `map(Function)`                 | Transforms value if present and returns a new `Optional`                    |
| `filter(Predicate)`            | Returns same `Optional` if condition matches; else returns empty            |

---

### 📝 Example

```java
Optional<String> name = Optional.ofNullable(getUserName());
String finalName = name.orElse("Default Name");
```
📌 Best Practices
- Use Optional as return types, not for fields or parameters

- Avoid using .get() unless you're sure the value is present

- Use orElseThrow() or orElse() for safe retrieval

- Combine with map, filter, and ifPresent for fluent and clean code

✅ Summary
- Optional is a null-safe container introduced in Java 8

- Prevents common NullPointerException issues

- Encourages functional-style programming

- Use when a method may or may not return a value
---

