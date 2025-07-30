
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
## 🌐 Spring Data REST (Revision Notes)

Spring Data REST is a Spring project that **automatically exposes CRUD REST APIs** for your Spring Data JPA repositories — **no controller code needed**.

---

### 🎯 Purpose

- Rapidly build RESTful services from JPA repositories
- Auto-generate endpoints for common operations
- Follows **HATEOAS** (Hypermedia as the Engine of Application State)

---

### 🔧 How It Works

| Layer               | Responsibility                                     |
|---------------------|-----------------------------------------------------|
| Repository Layer    | Extend `JpaRepository` or similar interface         |
| Spring Data REST    | Automatically exposes repository methods as REST APIs |
| HTTP Client         | Can consume the exposed endpoints using HTTP verbs |

---

### 🛠️ Setup Steps

| Step | Task                                                  |
|------|--------------------------------------------------------|
| 1    | Add dependency: `spring-boot-starter-data-rest`        |
| 2    | Define entity classes with `@Entity`                   |
| 3    | Create repository interface (e.g., `UserRepository`)   |
| 4    | Spring auto-generates REST endpoints at runtime        |

---

### 🔗 Default Endpoint Behavior

| Action       | HTTP Method | Endpoint                  |
|--------------|-------------|---------------------------|
| Get all      | `GET`       | `/users`                  |
| Get by ID    | `GET`       | `/users/{id}`             |
| Create       | `POST`      | `/users`                  |
| Update       | `PUT`       | `/users/{id}`             |
| Delete       | `DELETE`    | `/users/{id}`             |

---

### ⚙️ Customization Options

| Technique                        | Use Case                             |
|----------------------------------|--------------------------------------|
| `@RepositoryRestResource`        | Customize base path or export name   |
| `@RestResource`                  | Customize method-level endpoints     |
| `@Param` in method signatures    | Add query methods (e.g., by name)    |
| `spring.data.rest.basePath=/api`| Change default API root path         |

---

### 📌 HATEOAS Support

- Responses contain hypermedia links (`_links`)
- Helps clients navigate resources dynamically
- Example:

```json
{
  "name": "John",
  "_links": {
    "self": { "href": "http://localhost:8080/users/1" },
    "users": { "href": "http://localhost:8080/users" }
  }
}
```
✅ Summary
- Spring Data REST eliminates the need to write boilerplate controllers

- Automatically exposes RESTful endpoints for repositories

- Great for quick prototyping, admin tools, or internal APIs

- Use with caution in public APIs; you may want finer control for security & structure
---
