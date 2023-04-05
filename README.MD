Проект Recomendation System

REST API приложение проверять через постман

запросы:
Security:
http://localhost:8080/api/v1/users/registration
http://localhost:8080/api/v1/auth/login

Запросы на продукт(пост):
http://localhost:8080/api/v1/admin/saveProduct
http://localhost:8080/api/v1/users/getProductByName
http://localhost:8080/api/v1/users/getAllByAuthor
http://localhost:8080/api/v1/users/getAllByGenre
http://localhost:8080/api/v1/users/getAllByProductName

Запуск на порту localhost:8080

перед сборкой настроить application.properties файл

Также запустить скрипт Flyway для добавления нужных данных в таблицы

