# Cross cutting task(Java exam)

Необходимо реализовать консольное приложение, которое:

Читает данные из входного файла;
Обрабатывает полученную информацию;
Записывает данные в выходной файл;
Входной и выходной файл могут быть следующих форматов: plain text, xml, json. Так же входные и выходные файлы могут быть архивированы и зашифрованы, разными engines (только архивирован, только зашифрован, сперва архивирован, а потом зашифрован и наоборот).

«Тип» входного и выходного файла задаются параметрами консоли. Приложение реализовать двумя способами: без использования Design Patterns и c использованием Design Patterns (Decorator и Builder … можно оформить Builder в виде Singleton-а), сравнить реализации.

Обработка информации на первом этапе: найти все арифметические операции во входном файле и заменить на результаты в выходном файле. Реализовать фильтрацию двумя способами без использования регулярных выражений и с использованием регулярных выражений (а так же третьим :) найти библиотеку, которая все делает за вас, парсинг и калькуляцию, такие есть и не одна). Провести сравнительный анализ 2-х вариантов реализации.

Следующие шаги по нашей задаче:

Добавить UI: 
1. консольный;
2. использую любую графическую библиотеку Java на Ваш выбор;
3. сравнить CLI и UI based реализации;
4. поговорить с одногруппниками и сравнить различные графические Java библиотеки;

Реализовать логику как Web Service: 
1. Rest, используя любой Java engine;
2. SOAP, используя любой Java engine;
3. Сравнить Rest и SOAP реализации;
4. поговорить с одногруппниками и сравнить различные Rest \ Soap Java engines;
5. Соединить все вместе UI и Web Service;

Примеры атомарных подзадач: Чтение \ запись текстовый файл;
Чтение \ запись xml файл (используя специальный API для чтения XML и не используя – чтение по строчно);
Чтение \ запись json файл (используя специальный API для чтения XML и не используя – чтение по строчно);
Архивация \ де Архивация файла используя ту или иную реализацию Zip;
Архивация \ де Архивация файла используя ту или иную реализацию Rar;
Шифровка \ де Шифровка файла используя любую библиотеку шифрования;
Покрыть все эти атомарные задачи Unit Test
