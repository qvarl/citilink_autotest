<h1 >Проект автоматизации UI для сайта <a href="https://www.citilink.ru">Citilink.ru</a></h1>
<p align="center">
<img  src="images/screenshots/img.png">
</p>

## Содержание :receipt:

* <a href="#description">Описание</a>
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure Report</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#selenoid">Пример прогона теста в Selenoid</a>

<a id="description"></a>
## Описание :speech_balloon:

Данный проект состоит из автоматизированных UI-тестов для веб-сайта [citilink.ru](https://www.citilink.ru/)

<a id="tools"></a>
## Технологии и инструменты 🧰

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>
</div>


Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк <code>Selenide</code>.
Запуск тестов можно осуществлять локально или с помощью <code>Selenoid</code>.
Также реализована сборка в <code>Jenkins</code> с формированием отчета в <code>Allure</code> и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона.

Allure-отчет включает в себя:

* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

<a id="cases"></a>
## Реализованные проверки :male_detective:
- ✓ Проверка выбора города проживания через спиок основных городов

- ✓ Проверка перехода на страницу 'Журнал' по ссылке

- ✓ Проерка перехода по ссылкам каталога

- ✓ Проверка появления ошибки при вводе пустой почты

- ✓ Проверка прехода на главную страницу при нажатии на логотип

- ✓ Проверка скачивания PDF файла

- ✓ Проверка добавления смартфона в корзину

<a id="console"></a>
##  Запуск тестов из терминала :rocket:
### Локальный запуск тестов

```
gradle clean test 
```

### Удаленный запуск тестов

```
clean test \
  -Dbrowser=${BROWSER} \
  -DbrowserSize=${BROWSER_SIZE} \
  -Dremote=${REMOTE}
```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${REMOTE}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/Project%20009_viktor_jenkins_First_test) <img src="images/logo/Jenkins.svg" width="35" height="35"/>
Для запуска сборки необходимо перейти в раздел **Собрать с параметрами**, после чего необходимо указать параметры для сборки (путем выбора из списка или прямым указанием значения) и нажать кнопку **Собрать**.

<p align="center">
<img  src="images/screenshots/img_1.png">
</p>

<a id="allure"></a>
## Отчеты в [Allure Report](https://jenkins.autotests.cloud/job/Project%20009_viktor_jenkins_First_test/allure) <img src="images/logo/Allure.svg" width="35" height="35"/>
### Основное окно

<p align="center">
<img src="images/screenshots/img_2.png">
</p>

### Тесты

<p align="center">
<img src="images/screenshots/img_3.png">
</p>

### Графики

<p align="center">
<img src="images/screenshots/img_4.png">
</p>

<a id="telegram"></a>
## Уведомления в [Telegram](https://web.telegram.org) с использованием бота <img src="images/logo/Telegram.svg" width="35" height="35"/>
<p align="center">
<img src="images/screenshots/img_5.png">
</p>

<a id="selenoid"></a>
## Пример прогона теста в [Selenoid](https://aerokube.com/selenoid/) <img src="images/logo/Selenoid.svg" width="35" height="35"/>

> К каждому тесту в отчете прилагается видео
<p align="center">
  <img title="Selenoid Video" src="images/video/selenoid.gif">
</p>