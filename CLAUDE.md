# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is the Kotlin Koans educational project - a series of Kotlin programming exercises designed to teach Kotlin syntax and concepts. The project is structured as a Gradle multi-module project where each Kotlin concept (lesson) contains multiple tasks (koans) that learners solve by implementing failing unit tests.

## Architecture

### Directory Structure
- **Lessons**: Top-level directories (Introduction, Classes, Collections, etc.) represent learning modules
- **Tasks**: Each lesson contains multiple tasks in subdirectories with spaces in names
- **Task Structure**: Each task follows a consistent pattern:
  - `src/Task.kt` - The main implementation file where students write code
  - `test/tests.kt` or `test/Tests.kt` - Unit tests that validate the solution
  - `task.md` - Task description and instructions
  - `task-info.yaml` - Educational platform metadata
  - Additional files like `Shop.kt` provide domain models for exercises

### Key Components
- **util/src/koansTestUtil.kt** - Shared testing utilities across all koans
- **Course Structure**: Defined in `course-info.yaml` with lesson order and metadata
- **Gradle Configuration**: Multi-module setup where each task directory becomes a Gradle subproject

## Build System

### Gradle Setup
- Uses Gradle 6.1.1 with Kotlin 1.5.10
- Multi-module project where each task is a separate subproject
- JVM target: Java 8 (1.8)
- Test framework: JUnit 4.12

### Common Commands
```bash
# Build all projects
./gradlew build

# Test specific task (use module name from settings.gradle)
./gradlew :Introduction-Hello__world_:test

# Test all tasks
./gradlew test

# Run a specific task (if it has a main method)
./gradlew :module-name:run

# List all available tasks
./gradlew tasks
```

**Note**: Gradle may have compatibility issues with newer JVM versions. The project was designed for older Java/Gradle versions.

### Module Naming Convention
Task directories with spaces and special characters are converted to Gradle module names by:
- Replacing spaces and special characters with underscores or dashes
- Example: "Hello, world!" becomes "Introduction-Hello__world_"

## Working with Tasks

### Task Implementation Pattern
1. Students implement functions in `src/Task.kt` to make failing tests pass
2. Tests in `test/` directory validate the implementation
3. Some tasks include additional domain model files (e.g., `Shop.kt` in Collections tasks)

### Educational Structure
- **Lesson Order**: Introduction → Classes → Conventions → Collections → Properties → Builders → Generics → Coroutines
- **Progressive Difficulty**: Tasks within each lesson build upon previous concepts
- **Placeholders**: Tasks may contain TODO() placeholders indicating where code should be implemented

### Testing Individual Tasks
To test a specific task, navigate to its directory and run the test, or use the full module name:
```bash
# From task directory
../../gradlew test

# From root using module name  
./gradlew :Collections-Introduction:test
```

## Development Notes

### File Modifications
- Primary development occurs in `src/Task.kt` files within each task directory
- Test files are generally not modified unless adding new test cases
- Domain model files (like `Shop.kt`) provide context but are typically not modified

### Educational Platform Integration
- This project is designed for JetBrains Educational Tools plugin
- `.yaml` files contain metadata for the educational platform
- Students typically work through tasks in an IDE with educational plugin support

### Common Patterns
- Extension functions are commonly implemented across tasks
- Collection manipulation is a major focus in the Collections lesson
- Kotlin-specific features (null safety, data classes, etc.) are emphasized throughout