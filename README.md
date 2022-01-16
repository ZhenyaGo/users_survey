Система опроса пользователей
===============================

### Задача: спроектировать и разработать API для системы опросов пользователей.

**Функционал для администратора системы:**

- **авторизация в системе (регистрация не нужна)**


- **добавление/изменение/удаление опросов. Атрибуты опроса: название, дата старта, дата окончания, описание. После создания поле "дата старта" у опроса менять нельзя**


- **добавление/изменение/удаление вопросов в опросе. Атрибуты вопросов: текст вопроса, тип вопроса (ответ текстом, ответ с выбором одного варианта, ответ с выбором нескольких вариантов)**


**Функционал для пользователей системы:**

- **получение списка активных опросов**


- **прохождение опроса: в качестве идентификатора пользователя в API передаётся числовой ID, по которому сохраняются ответы пользователя на вопросы; один пользователь может участвовать в любом количестве опросов**


- **получение пройденных пользователем опросов с детализацией по ответам (что выбрано) по ID уникальному пользователя**


**Результат выполнения задачи:**

- **исходный код приложения в github (только на github, публичный репозиторий)**

- **инструкция по разворачиванию приложения (в docker или локально)**

- **документация по API**

---

- #### Stack:
    - [JDK 17](http://jdk.java.net/17/)
    - Spring Boot 2.6
    - Lombok
    - H2
    - Swagger/OpenAPI 3.0

---

[REST API documentation](http://localhost:8080/swagger-ui.html)  
Креденшелы:
```
User:  user@yandex.ru / password
Admin: admin@gmail.com / admin
```

---

Документация API
===============================

**Функционал для администратора системы:**

**AdminSurveyController**

1) Создание опроса:
   Метод POST
   /api/admin/surveys
   Respond body:

```
{
  "id": null,
  "name": "Public survey",
  "endDate": "2022-02-15",
  "description": "test survey"
}

```
2) Обновление опроса:
   Метод PUT
   /api/admin/surveys/{id} 
   Respond body:
```
{
  "id": {id},
  "name": "Public survey",
  "endDate": "2022-02-19",
  "description": "test survey"
}

```
3) Удаление опроса
   Метод DELETE
   /api/admin/surveys/{id}

---

**AdminQuestionController**

1) Создание вопроса:
   Метод POST
   /api/admin/questions
   Respond body:

```
{
  "id": null,
  "name": "Первый вопрос",
  "text": "Как ваша фамилия?",
  "types": [
       "TEXT"
    ]
}

```
```
{
  "id": null,
  "name": "Второй вопрос",
  "text": "Вы замужем/женаты?",
  "types": [
       "СHOICE"
    ]
}

```

```
{
  "id": null,
  "name": "Третий вопрос",
  "text": "В каких городах вы хотели бы побывать?",
  "types": [
       "MULTIPLE_CHOICE"
    ]
}

```

2) Обновление вопроса:
   Метод PUT
   /api/admin/questions/{id}/surveys/{surveyId}
   Respond body:
```
{
  "id": {id},
  "name": "Второй вопрос",
  "text": "Вы замужем/женаты?",
  "types": [
       "СHOICE"
    ]
}

```
3) Удаление опроса
   Метод DELETE
   /api/admin/surveys/{id}

---

**AdminOptionController**

   Создание вариантов ответа на вопросы:
   Метод POST
   /api/admin/options/questions/{id}
   Respond body:
   Для вопроса с типом TEXT
   

```

[
  {
    "id": null,
    "name": null,
  }
]

```

Для вопроса с типом CHOICE

```
[
  {
    "id": null,
    "name": "Да"
  },

  {
    "id": null,
    "name": "Нет"
  }

]

```

Для вопроса с типом MULTIPLE_CHOICE

```
[
  {
    "id": null,
    "name": "Рим"
  },

  {
    "id": null,
    "name": "Мадрид"
  },
  {
    "id": null,
    "name": "Нью-Йорк"
  },
  {
    "id": null,
    "name": "Вена"
  },
  {
    "id": null,
    "name": "Саратов"
  }
]

```
----

**Функционал для пользователя системы:**

**SurveyController**

  Получение активных опросов
  Метод GET
  /api/surveys
  Response body

```
[
[
  {
    "id": 1,
    "name": "student survey",
    "startDate": "2022-01-16",
    "endDate": "2022-01-30",
    "description": "first survey",
    "questions": [
      {
        "id": 2,
        "name": "второй вопрос",
        "text": "В каком городе вы живёте?",
        "types": [
          "CHOICE"
        ],
        "options": [
          {
            "id": 2,
            "name": "Москва"
          },
          {
            "id": 3,
            "name": "Владимир"
          },
          {
            "id": 4,
            "name": "Санкт-Петербург"
          }
        ]
      },
      {
        "id": 3,
        "name": "третий вопрос",
        "text": "Ваши любимые фильмы?",
        "types": [
          "MULTIPLE_CHOICE"
        ],
        "options": [
          {
            "id": 5,
            "name": "Фильм_1"
          },
          {
            "id": 6,
            "name": "Фильм_2"
          },
          {
            "id": 7,
            "name": "Фильм_3"
          },
          {
            "id": 8,
            "name": "Фильм_4"
          },
          {
            "id": 9,
            "name": "Фильм_5"
          },
          {
            "id": 10,
            "name": "Фильм_6"
          }
        ]
      }
    ]
  },
  {
    "id": 2,
    "name": "Public survey",
    "startDate": "2022-01-16",
    "endDate": "2022-02-19",
    "description": "test survey",
    "questions": [
      {
        "id": 4,
        "name": "Первый вопрос",
        "text": "Как ваша фамилия?",
        "types": [
          "TEXT"
        ],
        "options": [
          {
            "id": 11,
            "name": null
          }
        ]
      },
      {
        "id": 5,
        "name": "Второй вопрос",
        "text": "Вы замужем/женаты?",
        "types": [
          "CHOICE"
        ],
        "options": [
          {
            "id": 12,
            "name": "Да"
          },
          {
            "id": 13,
            "name": "Нет"
          }
        ]
      },
      {
        "id": 6,
        "name": "Третий вопрос",
        "text": "В каких городах вы хотели бы побывать?",
        "types": [
          "MULTIPLE_CHOICE"
        ],
        "options": [
          {
            "id": 16,
            "name": "Нью-Йорк"
          },
          {
            "id": 17,
            "name": "Вена"
          },
          {
            "id": 18,
            "name": "Саратов"
          },
          {
            "id": 14,
            "name": "Рим"
          },
          {
            "id": 15,
            "name": "Мадрид"
          }
        ]
      }
    ]
  }
]

```
---

**QuestionController**

Получение вопросов опроса
Метод GET
/api/questions
Response body

```
[
  {
    "id": 4,
    "name": "Первый вопрос",
    "text": "Как ваша фамилия?",
    "types": [
      "TEXT"
    ],
    "options": [
      {
        "id": 11,
        "name": null
      }
    ]
  },
  {
    "id": 5,
    "name": "Второй вопрос",
    "text": "Вы замужем/женаты?",
    "types": [
      "CHOICE"
    ],
    "options": [
      {
        "id": 12,
        "name": "Да"
      },
      {
        "id": 13,
        "name": "Нет"
      }
    ]
  },
  {
    "id": 6,
    "name": "Третий вопрос",
    "text": "В каких городах вы хотели бы побывать?",
    "types": [
      "MULTIPLE_CHOICE"
    ],
    "options": [
      {
        "id": 16,
        "name": "Нью-Йорк"
      },
      {
        "id": 17,
        "name": "Вена"
      },
      {
        "id": 18,
        "name": "Саратов"
      },
      {
        "id": 14,
        "name": "Рим"
      },
      {
        "id": 15,
        "name": "Мадрид"
      }
    ]
  }
]

```

---

**AnswerController**

  Создание ответов на вопросы:
  Метод POST
  /api/answers
  RequestBody

```
{
  "id": null,
  "survey_id": 2,
  "question_id": 4,
  "answer": "Петров"
}

```
---
```
{
  "id": null,
  "survey_id": 2,
  "question_id": 5,
  "answer": "2"
}

```
---

```
{
  "id": null,
  "survey_id": 2,
  "question_id": 6,
  "answer": "2, 3, 5"
}

```

Получение ответов на опрос пользователя.
Метод GET
/api/answers/surveys/{id}
RespondBody

```
[
  {
    "id": 2,
    "user_id": 2,
    "survey_id": 2,
    "question_id": 4,
    "answer": "Петров",
    "questionName": "Как ваша фамилия?"
  },
  {
    "id": 3,
    "user_id": 2,
    "survey_id": 2,
    "question_id": 5,
    "answer": "2",
    "questionName": "Вы замужем/женаты?"
  },
  {
    "id": 4,
    "user_id": 2,
    "survey_id": 2,
    "question_id": 6,
    "answer": "2, 3, 5",
    "questionName": "В каких городах вы хотели бы побывать?"
  }
]

```

Получение ответов на опрос произвольного пользователя по id.
Метод GET
/api/answers/surveys/{id}/users/{userId}
RespondBody

```
[
    {
        "id": 1,
        "user_id": 3,
        "survey_id": 1,
        "question_id": 1,
        "answer": "Евгений",
        "questionName": "Как вас зовут?"
    },
    {
        "id": 2,
        "user_id": 3,
        "survey_id": 1,
        "question_id": 2,
        "answer": "2",
        "questionName": "В каком городе вы живёте?"
    },
    {
        "id": 3,
        "user_id": 3,
        "survey_id": 1,
        "question_id": 3,
        "answer": "1,3,5",
        "questionName": "Ваши любимые фильмы?"
    }
]

```