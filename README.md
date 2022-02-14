# Автотесты для сайта <a target="_blank" href="https://www.pochta.ru/">Почты России</a>
![Intelij_IDEA](img/icons/ПочтаРоссии.png)

## Реализованы следующие проверки:
 - На главной странице есть поле отслеживания посылки по номеру
 - После ввода валидного и актуального номера отправения, происходит переход на страницу с детальной информацией
 - После ввода невалидного номера не происходит перенаправление на другую страницу
 - Трек номер копируется со страницы с детальной информацией путем одного нажатия левой кнопкой мыши
 - На главной странице есть форма для расчета строимости отправления путем заполения пункта отправления и пункта получения
 - На главной странице список доступных сервисов соответствует ожидаемому
 - На главной странице заголовок "Почта России"
 - При загрузке главной страницы в консоле нет ошибок
 
## Используемые технологии и инструменты

![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Telegram](img/icons/Telegram.png)

# Джоба в Jenkins 
с параметрами:
<a target="_blank" href="jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13">jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13</a>

## Запуск через Jenkins с параметрами:

![Jenkins](img/JenkinsRun.png)

## Локальный запуск через терминал:
```bash
gradlew clean test & gradlew allureReport
```

## Удаленный запуск через терминал с параметрами:
```bash
gradlew clean test -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1  & gradlew allureReport

```
___
## После прохождения тестов приходит оповещение в Telegram через бот 

#### После прохождения всех тестов, приходит отчет в канал в телеграме:
![Telegram](img/Telegram.png)

---
## Анализ результатов
Ссылку на отчет Allure можно найти в 
* Сообщении Telegram
* В последней сборке Jenkins

Allure report (пример):
<a target="_blank" href="https://jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13/8/allure/">https://jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13/8/allure/</a>
![Allure](img/Allure_jenkins.png)
![Allure](img/Allure.png)

---
### Пример видео прохождения теста, прикрепляется к Allure отчету после каждого прохождения теста

![video](./img/Selenoid_gif.gif)
