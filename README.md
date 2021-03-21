Paint
===
Версия - Java SE 15.0.2

Код написан в IDE IntellijIDEA

Для запуска используется сборщик maven. Его необходимо прописать в переменной ОС Path.

Инструкция по запуску:
1. Склонировать репозиторий
2. Перейти в консоли в склонированный репозитроий
3. Запустить 
```
mvn clean install
cd core-ui
mvn javafx:jlink
target\OOPPaint\bin\java --add-opens javafx.graphics/javafx.scene.paint=com.fasterxml.jackson.databind --add-opens javafx.graphics/javafx.geometry=com.fasterxml.jackson.databind -m core.ui/by.bsuir.oop.labs.first.OOPPaint
```

Для добавления точек в полигон или в ломанную надо нажать пкм. Для завершения рисования нажать лкм.

Отмена последнего действия Ctrl-Z

Отмена отмены - Ctrl-U