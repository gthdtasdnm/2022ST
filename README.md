# 🏆 Altklausur 2022ST – Turnierbaum im K.-o.-System

Dies ist der begleitende Code zur Altklausur **2022ST** (Objektorientierte Programmierung, UniBw München).

## 📁 Projektstruktur

Der Code befindet sich im Verzeichnis `src/` und ist wie folgt aufgebaut:

- **`Game`** – Abstrakte Oberklasse für alle Spiele.
- **`SeededGame`**, **`ByeGame`**, **`OrdinaryGame`** – Konkrete Spieltypen gemäß Aufgabenstellung.
- **`Visitor`** – Das Visitor-Interface, wie in Aufgabe 3 gefordert.
- **`RemainingPlayersVisitor`** – Konkreter Visitor zur Ermittlung der verbliebenen Spieler (Aufgabe 4).
- **`GameTest`** – Testklasse mit Beispielen und Prüfungen zur Funktionalität.
- **`Main`** – Optional zum Ausprobieren und Debuggen (nicht klausurrelevant, falls enthalten).

## ✅ Hinweise zur Bearbeitung

- **Alle Aufgaben** der Klausur sind vollständig umgesetzt.
- Führt die Datei **`GameTest`** aus, um die Korrektheit eurer Implementierung zu prüfen.
- Besonders hilfreich zum Verständnis ist es, sich die Vererbung und das Zusammenspiel der Spieltypen im Turnierbaum anzusehen.

## 🧩 Verwendete Entwurfsmuster

- **Composite Pattern** – zur Modellierung des Turnierbaums.
- **Visitor Pattern** – zur Traversierung des Baums (z. B. für verbleibende Spieler).

## 📚 Empfehlung

Geht schrittweise vor:
1. Startet mit den konkreten Spielklassen.
2. Versteht den Baumaufbau anhand der `Main` oder `GameTest`.
3. Nutzt den Visitor gezielt, um Logik von Struktur zu trennen.
4. Analysiert die Tests – sie helfen, typische Fehler zu vermeiden.

---

Viel Erfolg beim Verständnis der Klausur und beim Üben!
