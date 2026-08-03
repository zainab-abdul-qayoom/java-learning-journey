# Video: Structuring Java Code and Comments — Remember This

## Comments (3 types)
- `// comment` — single-line
- `/* comment */` — multi-line
- `/** comment */` — documentation comment (used by Javadoc tool, includes `@param`, `@return`)

## Packages
- Group related classes together, avoid naming conflicts
- Declared at top of file: `package com.example.myapp;`
- Folder structure must match package name (`src/com/example/myapp`)

## File & Class Rules
- Each **public class** = its own file, named exactly like the class (`Book` class → `Book.java`)
- A class = blueprint (attributes + methods)
- Every app needs an entry point → `main` method in a public class

## Imports
- Used to bring in built-in or other classes:
```java
import java.util.List;
import java.util.ArrayList;
```

## Naming Convention
- **camelCase** — first word lowercase, next words capitalized (e.g. `calculatePrice`)

## Best Practices (good habits)
- Use meaningful names (`Customer`, not `C1`)
- Keep code organized into packages
- Comment the "why", not the obvious ("i++" doesn't need a comment)
- Consistent formatting/indentation
- Code runs top-to-bottom, starting from `main`

---

## 🧠 Extra — What matters most
- **Javadoc comments** (`/** */`) are used in real jobs to auto-generate documentation — worth remembering the format.
- File name = class name is a **strict Java rule**, not just a convention — code won't compile otherwise.
- camelCase for variables/methods, but **PascalCase** for class names (e.g. `Book`, `Customer`) — a common beginner mixup.
