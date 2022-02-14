# Автотесты для сайта Почты России
![Intelij_IDEA](img/icons/ПочтаРоссии.png)

## Используемые технологии и инструменты

![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Telegram](img/icons/Telegram.png)

# Джоба в Jenkins 
с параметрами:
<a target="_blank" href="jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13">jenkins.autotests.cloud/job/010-KseniyaAtygaeva-hw13</a>

## Локальный запуск через терминал:
```bash
gradlew clean test & gradlew allureReport
```

## Удаленный запуск через терминал:
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

---
### Пример видео прохождения теста, прикрепляется к Allure отчету после каждого прохождения теста

![video](./img/Selenoid_gif.gif)
