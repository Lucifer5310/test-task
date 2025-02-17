# Test Task

## Описание
Test Task — это Spring Boot приложение с поддержкой базы данных PostgreSQL, миграциями Flyway, аутентификацией JWT и веб-интерфейсом на основе Thymeleaf.

## Требования
- Java 23
- Docker и Docker Compose (для контейнеризированного развертывания)
- PostgreSQL (если запускается локально без Docker)
- Gradle (если используется ручная сборка)

## Установка и запуск
### 1. Запуск с Docker Compose
```bash
docker-compose up --build
```

### 2. Локальный запуск без Docker
#### Сборка JAR файла
```bash
./gradlew clean build
```
#### Запуск приложения
```bash
java -jar build/libs/test-task-0.0.1-SNAPSHOT.jar
```

## API Эндпоинты
### Авторизация
- `POST /auth/login` — Вход в систему, получение JWT-токена.
- `POST /auth/register` — Регистрация нового пользователя.

### Пользовательские операции
- `GET /home/{user_id}` — Получение информации о пользователе.
- `PUT /{id}` — Редактирование данных пользователя.
