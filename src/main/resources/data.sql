INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Zhenya', 'zhenya@gmail.com', '{noop}password2'),
       ('Alex', 'alex@gmail.com', '{noop}password3'),
       ('Peter', 'peter@gmail.com', '{noop}password4');


INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4),
       ('USER', 5);

INSERT INTO SURVEYS (description, end_date, name, start_date)
VALUES ( 'first survey', '2022-01-30', 'student survey', now());


INSERT INTO QUESTIONS(name, text, survey_id)
VALUES ( 'первый вопрос','Как вас зовут?', 1),
       ( 'второй вопрос','В каком городе вы живёте?', 1),
       ( 'третий вопрос','Ваши любимые фильмы?', 1);

INSERT INTO type(type, question_id)
VALUES ( 'TEXT' , 1),
       ( 'CHOICE' , 2),
       ( 'MULTIPLE_CHOICE' , 3);

INSERT INTO OPTION(name, question_id)
VALUES ( null, 1),
       ( 'Москва', 2),
       ( 'Владимир', 2),
       ( 'Санкт-Петербург', 2),
       ( 'Фильм_1' , 3),
       ( 'Фильм_2' , 3),
       ( 'Фильм_3' , 3),
       ( 'Фильм_4' , 3),
       ( 'Фильм_5' , 3),
       ( 'Фильм_6' , 3);

