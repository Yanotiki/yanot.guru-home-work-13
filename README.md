[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%231AA432&size=50&duration=5000&center=true&vCenter=true&multiline=true&width=900&height=150&lines=%D0%9F%D1%80%D0%BE%D0%B5%D0%BA%D1%82+%D0%BF%D0%BE+%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%B0%D1%82%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8;%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F+%D1%81%D0%B0%D0%B9%D1%82%D0%B0+citilink.ru)](https://git.io/typing-svg)

<h1>:bookmark_tabs: Содержание</h1>

:eight_spoked_asterisk:	 Стек технологий

:eight_spoked_asterisk:	 Запуск тестов в Jenkins

:eight_spoked_asterisk:	 Отчет о результатах тестирования в Allure Report

:eight_spoked_asterisk:	 Уведомления в Telegram с использованием бота

:eight_spoked_asterisk:	 Пример запуска теста в Selenoid


<h2>:books:	 Стек технологий</h2>


<p>
<img title="Allure Report" src="images/logo/Allure_Report.svg" height="48" width="48"> 
<img title="GitHub" src="images/logo/GitHub.svg" height="48" width="48">
<img title="Gradle" src="images/logo/Gradle.svg" height="48" width="48">
<img title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg" height="48" width="48">
<img title="JUnit5" src="images/logo/JUnit5.svg" height="48" width="48">
<img title="Selenide" src="images/logo/Selenide.svg" height="48" width="48">
<img title="Selenoid" src="images/logo/Selenoid.svg" height="48" width="48">
<img title="Telegram" src="images/logo/Telegram.svg" height="48" width="48">
<img title="Java" src="images/logo/Java.svg" height="48" width="48">
<img title="Jenkins" src="images/logo/Jenkins.svg" height="48" width="48"> 
</p>


<h2>:arrow_forward:	 Запуск тестов в Jenkins</h2>
<p>Для запуска тестов используется инструмент CI/CD под названием <b>Jenkins</b></p>

```
clean
test
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-DremoteUrl=${REMOTEURL}
-Dlogin=${LOGIN}
-Dpassword=${PASSWORD}
```
<p><code>BROWSER</code> – браузер, в котором будут выполняться тесты.</p>
<p><code>VERSION</code> – версия браузера, в которой будут выполняться тесты.</p>
<p><code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.</p>
<p><code>LOGIN</code> - логин для авторизации на удалённом сервере.</p>
<p><code>PASSWORD</code> - пароль для авторизации на удалённом сервере.</p>

<h3>:large_blue_diamond:	 Процесс запуска происходит следующим образом:</h3>

<p><i>На странице сборки выбираем <b>"Собрать с параметрами"</b>: </i>
</br>
</br>
<img title="Jenkins" src="images/screenshots/jenkins_1.png">
</p>

<p><i>Выбираем необходимые параметры запуска и нажимаем <b>"Собрать"</b>: </i>
</br>
</br>
<img title="Jenkins" src="images/screenshots/jenkins_2.png">
</p>

<p><i>После окончания сборки нам доступен отчет в Allure Report, посмотреть который можно, нажав на соответствующий значок:</i>
<img title="Jenkins" src="images/screenshots/jenkins_3.png">
</br>

<h2>:bar_chart:	 Отчет о результатах тестирования в Allure Report</h2>

<h3>:large_orange_diamond:	 Страница с обобщёнными данными по отчёту:</h3>

<p align="center">
<img title="Allure Overview" src="images/screenshots/overview.png">
</p>

<h3>:large_orange_diamond:	 Страница с графической информацией:</h3>

<p align="center">
<img title="Allure Graphs" src="images/screenshots/graphs.png">
</p>

<h3>:large_orange_diamond:	 Страница с описанием шагов теста:</h3>

<p align="center">
<img title="Allure Behaviors" src="images/screenshots/behaviors.png">
</p>


<h2>:mailbox_with_mail:	 Уведомления в Telegram с использованием бота</h2>
<p><i>После окончания сборки в Телеграм отправляется уведомление со ссылкой на отчёт: </i>
</br>
</br>
<img title="Telegram notification" src="images/screenshots/telegram_message.png">
</p>


<h2>:cinema:	 Пример запуска теста в Selenoid</h2>
<p><i>К каждому тесту в отчете прилагается видео: </i>
</br>
</br>
<img title="Selenoid" src="images/screenshots/selenoid.gif">
</p>


<h3>:wink:		Time for jokes</h3>
</br>
<img src="https://readme-jokes.vercel.app/api" alt="Jokes Card" />
