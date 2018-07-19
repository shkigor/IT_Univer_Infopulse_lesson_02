# IT_Univer_Infopulse_lesson_02
## Transaction
  - Part01. Rollback   
  - Part02. Savepoint
  - Part03. TransactionIsolation
  - Part04. DatabaseMetaData
  - Part05. ResultSetMetaData
## DAO Factory
  - DAO, DTO
## JPA, Hibernate
  - SessionFactory
  - EntityManager

Also see console commands in:

    src\main\resources\console02.txt

Timetable:

	src\main\resources\timetable.txt

http://citforum.ck.ua/database/dblearn/dblearn10.shtml
## Типы чтения транзакций:
- Lost update, когда две транзакции обновляют данные в одной строке и одна из транзакций сбоит.
После окончания обеих транзакций, строка  содержит значение, занесенное более поздней транзакцией B. Транзакция A ничего не знает о существовании транзакции B, и естественно ожидает, что в строке содержится значение, которое она занесла. Таким образом, транзакция A потеряла результаты своей работы.
Lost update по умолчанию запрещен во всех БД.
1. Грязное чтение(dirty reads) происходит, когда транзакциям разрешено видеть несохраненные изменения данных.
   Иными словами, изменения, сделанные в одной транзакции, видны вне ее до того, как она была сохранена. 
   Если изменения не будут сохранены, то, вероятно, другие транзакции выполняли работу на основе некорректных данных.
   Транзакция B изменяет данные в строке. После этого транзакция A читает измененные данные и работает с ними. Транзакция B откатывается и восстанавливает старые данные.

2. Неповторяющееся чтение(nonrepeatable reads) происходит, когда транзакция А читает строку, транзакция Б изменяет эту строку, транзакция А читает ту же строку и получает обновленные данные.
   Транзакция A ничего не знает о существовании транзакции B, и, т.к. сама она не меняет значение в строке, то ожидает, что после повторного чтения значение будет тем же самым.
   Транзакция A работает с данными, которые, с точки зрения транзакции A, самопроизвольно изменяются.

3. Фантомное чтение(phantom reads) происходит, когда транзакция А считывает все строки, удовлетворяющие WHERE-условию, транзакция Б вставляет новую или удаляет одну из строк, которая удовлетворяет этому условию, транзакция А еще раз считывает все строки, удовлетворяющие WHERE-условию, уже вместе с новой строкой или недосчитавшись старой.

## JDBC удовлетворяет четырем уровням изоляции транзакций, определенным в стандарте SQL:2003.
Уровни изоляции транзакций определены в виде констант интерфейса Connection(по возрастанию уровня ограничения):
- TRANSACTION_NONE–информирует о том, что драйвер не поддерживает транзакции;
- TRANSACTION_READ_UNCOMMITTED–позволяет транзакциям видеть несохраненные изменения данных, что разрешает грязное, неповторяющееся и фантомное чтения.
- TRANSACTION_READ_COMMITTED–означает, что любое изменение, сделанное в транзакции, не видно вне неё, пока она не сохранена. Это предотвращает грязное чтение, но разрешает неповторяющееся и фантомное.
- TRANSACTION_REPEATABLE_READ–запрещает грязное и неповторяющееся, но фантомное чтение разрешено.
- TRANSACTION_SERIALIZABLE–определяет, что грязное, неповторяющееся и фантомное чтения запрещены.