# job4j_tracker

[![Java CI with Maven](https://github.com/aswsx/job4j_tracker/actions/workflows/maven.yml/badge.svg)](https://github.com/aswsx/job4j_tracker/actions/workflows/maven.yml)
[![codecov](https://codecov.io/gh/aswsx/job4j_tracker/branch/master/graph/badge.svg?token=CFOYCL8LHR)](https://codecov.io/gh/aswsx/job4j_tracker)
![GitHub commit activity](https://img.shields.io/github/commit-activity/w/aswsx/job4j_tracker)
![GitHub last commit](https://img.shields.io/github/last-commit/aswsx/job4j_tracker)
![GitHub top language](https://img.shields.io/github/languages/top/aswsx/job4j_tracker)
![GitHub language count](https://img.shields.io/github/languages/count/aswsx/job4j_tracker)
![Lines of code](https://img.shields.io/tokei/lines/github/aswsx/job4j_tracker)


## Используемые технологии

![Java](https://img.shields.io/badge/-Java-003f5c?style=for-the-badge&logo=Java)
![Spring](https://img.shields.io/badge/-Spring-003f5c?style=for-the-badge&logo=Spring)
![SpringBoot](https://img.shields.io/badge/-SpringBoot-003f5c?style=for-the-badge&logo=SpringBoot)
![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-003f5c?style=for-the-badge&logo=POstgreSQL)
![H2](https://img.shields.io/badge/-H2-003f5c?style=for-the-badge&logo=H2)
![GitHub](https://img.shields.io/badge/-Github-003f5c?style=for-the-badge&logo=Github)
![Actions](https://img.shields.io/badge/-GithubActions-003f5c?style=for-the-badge&logo=GithubActions)
![TravisCI](https://img.shields.io/badge/-TravisCI-003f5c?style=for-the-badge&logo=TravisCI)
![CircleCI](https://img.shields.io/badge/-CircleCI-003f5c?style=for-the-badge&logo=CircleCI)
![Codecov](https://img.shields.io/badge/-Codecov-003f5c?style=for-the-badge&logo=Codecov)
![HTML](https://img.shields.io/badge/-HTML-003f5c?style=for-the-badge&logo=HTML)
![JDBC](https://img.shields.io/badge/-JDBC-003f5c?style=for-the-badge&logo=JDBC)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-003f5c?style=for-the-badge&logo=Bootstrap)
![ThymeLeaf](https://img.shields.io/badge/-ThymeLeaf-003f5c?style=for-the-badge&logo=ThymeLeaf)
![Mockito](https://img.shields.io/badge/-Mockito-003f5c?style=for-the-badge&logo=Mockito)
![Postman](https://img.shields.io/badge/-Postman-003f5c?style=for-the-badge&logo=Postman)
![JSOUP](https://img.shields.io/badge/-JSOUP-003f5c?style=for-the-badge&logo=JSOUP)
![LiquiBase](https://img.shields.io/badge/-LiquiBase-003f5c?style=for-the-badge&logo=LiquiBase)
![Quartz](https://img.shields.io/badge/-Quartz-003f5c?style=for-the-badge&logo=Quartz)
![JUnit4](https://img.shields.io/badge/-JUnit4-003f5c?style=for-the-badge&logo=JUnit)
![JUnit5](https://img.shields.io/badge/-JUnit5-003f5c?style=for-the-badge&logo=JUnit)
## Проект содержит решения блоков "ООП", "Collections Lite", "FP,Lambda, Stream API" курса <a href="https://github.com/aswsx/job4j_elementary"> Job4j по основам языка Java</a>.

<p>Основа проекта- консольное приложение для работы с заявками. После запуска на экране отображается меню с выбором доступных действий:
ввод новой заявки, удаление, поиск заявок по ID и имени</p>
<p align="center">
  <img src="Pictures/Main Menu.jpg" height="150" title="Главное меню программы">
  <img src="Pictures/FindAll.jpg" height="150" title="Поиск всех элементов">
  <img src="Pictures/Create.jpg" height="150" title="Создание элемента">
  <img src="Pictures/FindByName.jpg" height="150" title="Поиск по имени элемента">
</p>
<h2>Содержимое проекта</h2>
<ul>
  <li>Модель данных <a href="https://github.com/ReyBos/job4j_tracker/blob/master/src/main/java/ru/job4j/memTracker/Item.java">ru.job4j.memTracker.Item</a> </li>
  <li>Главное меню <a href="https://github.com/ReyBos/job4j_tracker/blob/master/src/main/java/ru/job4j/memTracker/StartUI.java">ru.job4j.memTracker.StartUI</a></li>
</ul>
<h2>Ключевые этапы</h2>
<ul>
  <li><a href="https://github.com/aswsx/job4j_tracker/commit/e36e582952e28b1635f7c55949ba18cf6990172c">4.1. Разрыв зависимости </a>StartUI от Scanner.</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/commit/ff07445b27e86676e5136f132529a15876791cdc"> Разрыв зависимости </a>StartUI от System.out</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/commit/607689508a2afd6c965d61791b518ba1c7b01357">8. Реализация меню за счет шаблона стратегия.</a>  
Это поведенческий паттерн проектирования, который определяет семейство схожих алгоритмов и помещает каждый из них в собственный класс, 
после чего алгоритмы можно взаимозаменять прямо во время исполнения программы</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/commit/5cb1e916a762c7669c8c971944b4e0636a21ddf0">8. Реализация тестов класса StartUI.</a>
  <li><a href="https://github.com/aswsx/job4j_tracker/commit/0e7196163b014a00dc8ad29f84f6ee405f007a36">Рефакторинг - Шаблон Декоратор для валидатора.</a> 
Декоратор — это структурный паттерн проектирования, который позволяет динамически добавлять объектам новую функциональность, оборачивая их в полезные «обёртки».</li>
  <li>Шаблон фабричный метод. Смысл этого шаблона в создании метода, который создает новый экземпляр объекта.Шаблон абстрактная фабрика.
Главное отличие от фабричного метода, абстрактная фабрика это интерфейс, который содержит абстрактные методы для создания экземпляров. 
Шаблон Фабричный метод применяется в классах CreateAction, DeleteAction, EditAction, FindAction. 
В этих методах возможно применить шаблон Абстрактная фабрика, есл переместить метод execute() в интерфейс UserAction</li>
<li>Подключение Checkstyle с Maven  </li>
  <li>JaCoCo. Процент покрытие тестами <a href="https://github.com/aswsx/job4j_tracker/commit/cd068d3410f37987089af5a14daebb69fbfa42be"></a></li>
  <li>Интеграция с Travis CI </li>
  <li>Лямбда выражения </li>
  <li>StreamAPI </li>
  <li>Optional </li>
  <li>Local-Variable Type Inference (var) </li>
</ul>

<h3>Singleton</h3>
<p><a href="https://github.com/aswsx/job4j_tracker/commit/1738ebf1c2c56a6c81cbd235147b34e2ba40eaa3">Шаблон singleton</a> -
используется для создания класса, который может содержать только один экземпляр объекта в виртуальной машине. Шаблон
singleton применять в проектах, где используются работы с внешними ресурсами: базы данных, серверы. Шаблон может быть
с ленивой и энергичной загрузкой.</p>
<ul>
  <li>Ленивая загрузка (Lazy loading) происходит, когда мы первый раз явно обращаемся к объекту.</li>
  <li>Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.</li>
</ul>
<h4>Представлены следующие варианты реализации</h4>
<ol>
  <li><a href="https://github.com/aswsx/job4j_tracker/blob/1738ebf1c2c56a6c81cbd235147b34e2ba40eaa3/src/main/java/ru/job4j/memTracker/TrackerEnum.java">Enum</a>. Eager loading.</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/blob/1738ebf1c2c56a6c81cbd235147b34e2ba40eaa3/src/main/java/ru/job4j/memTracker/TrackerStaticFieldLazy.java">static field</a>. Lazy loading.</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/blob/1738ebf1c2c56a6c81cbd235147b34e2ba40eaa3/src/main/java/ru/job4j/memTracker/TrackerStaticFieldEager.java">static final field</a>. Eager loading.</li>
  <li><a href="https://github.com/aswsx/job4j_tracker/blob/1738ebf1c2c56a6c81cbd235147b34e2ba40eaa3/src/main/java/ru/job4j/memTracker/TrackerStaticClassLazy.java">private static final class</a>. Lazy loading.</li>
</ol>

