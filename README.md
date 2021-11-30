# Краткое описание сервиса:
![alt text](src/main/resourses/static/gif-service-usd.png "Описание будет тут")
gif-usd-service возвращает рандомный gif-файл в зависимости от того, как изменился курс USD относительно вчерашнего дня.
Курс USD сервис получает с ресурса: https://openexchangerates.org/.
Если курс стал выше, вернуть gif-файл с ресура: https://giphy.com/ по тэгу "rich", если ниже - тэг "broke".

***

# В файл application.properties вынесены настройки проекта:
1. exchange.url - url для доступа к https://openexchangerates.org/;
2. gif.url - url для доступа к https://giphy.com/;
3. gif.rich, gif.broke, gif.zero - тэги для поиска и возврата рандомного gif-файла;

***

# Технологии:
SpringBoot, Gradle, FeignClient, Lombok, JsonSimple, WireMock

***

# Запуск проекта:
1. Скачать zip архив с GitHub
2. Распаковать в нужной директории
3. Открыть при помощи IntelliJ IDEA
4. Запустить main class: GifUsdServiceApplication.java
5. После запуска открыть браузер, перейти по URL: http://localhost:8080/compare_currency/RUB
6. Вместо "RUB" можно указать любой код валюты, относительно которой необходимо получить курс USD,
список доступных валют можно посмотреть по ссылке: https://openexchangerates.org/api/currencies.json
