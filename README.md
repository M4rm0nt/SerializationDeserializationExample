**Objekt**
Person{name='Max Mustermann', age=30}

**Binäre-Darstellung**
- `10101100 11101101` (`aced` in Hex): Dies sind die Stream-Magic-Werte, die typisch für die Serialisierung in Java sind.
- `00000000 00000101` (`0005` in Hex): Dies ist die Stream-Version.
- `01110011 01110010` (`sr`): Markiert den Anfang eines `Serializable`-Objekts.
- `00000000 00101010` (`002a` in Hex): Die Länge des Klassennamens.
- Der folgende Abschnitt stellt den Klassennamen `SerializationDeserializationExample$Person` dar.
- `00000000 00000000 00000000 00000000 00000000 00000000 00000001`: Die `serialVersionUID` (`0000000000000001` in Hex).
- `00000010 00000000 00000010`: Anzahl der Felder in der Klasse.
- `01001001 00000000 00000011 01100001 01100111 01100101` (`490003616765` in Hex): Das `int`-Feld `age`.
- `01001100 00000000 00000100 01101110 01100001 01101101 01100101` (`4c00046e616d65` in Hex): Das `Object`-Feld (`String`) `name`.
- Der Rest der Sequenz repräsentiert die eigentlichen Daten der Felder `age` und `name`.


**Hexadezimal-Darstellung**
- `aced00057372`: Dies ist der Header der Serialisierung, einschließlich des Stream-Magic-Headers (`aced`) und der Stream-Version (`0005`).
- `002a`: Die Länge des Klassennamens (42 Zeichen).
- `53657269616c697a6174696f6e446573657269616c697a6174696f6e4578616d706c6524506572736f6e`: Dies ist der Klassenname `SerializationDeserializationExample$Person` in Hexadezimalform.
- `0000000000000001`: Die `serialVersionUID` der Klasse `Person`.
- `020002`: Gibt an, dass zwei Felder in der Klasse sind.
- `490003616765`: Das erste Feld, ein `int` mit dem Namen `age` (`49` repräsentiert den Datentyp `int`, `0003` ist die Länge des Namens und `616765` ist der Name `age` in Hexadezimalform).
- `4c00046e616d65`: Das zweite Feld, ein `Object` (String) mit dem Namen `name` (`4c` repräsentiert den Datentyp `Object`, `0004` ist die Länge des Namens und `6e616d65` ist der Name `name` in Hexadezimalform).
- `7400124c6a6176612f6c616e672f537472696e673b`: Typsignatur des `name`-Feldes (`String`).
- `7870`: Markiert das Ende der Felddefinitionen und den Beginn der Feldwerte (`78` ist `tc_enDBlockData`, `70` ist `tc_null`).
- `0000001e`: Der Wert von `age` (30 in Dezimal).
- `74000e4d6178204d75737465726d616e6e`: Der Wert von `name` (`Max Mustermann`), beginnend mit `74` (was `String` signalisiert), gefolgt von der Länge des Strings (`000e`, also 14 Zeichen) und den Zeichen des Strings in Hexadezimalform.


**Hex-dump**
-              00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 11 12 13 14 15 16 17  
-     00000000 ac ed 00 05 73 72 00 2a 53 65 72 69 61 6c 69 7a 61 74 69 6o 6e 44 65 73 ....sr.*SerializationDes
-     00000018 65 72 69 61 6c 69 7a 61 74 69 6f 6e 45 78 61 6d 70 6c 65 24 50 65 72 73 erializationExample$Pers
-     00000030 6f 6e 00 00 00 00 00 00 00 01 02 00 02 49 00 03 61 67 65 4c 00 04 6e 61 on...........I..ageL..na
-     00000048 6d 65 74 00 12 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 78 met..Ljava/lang/String;x
-     00000060 70 00 00 00 1e 74 00 0e 4d 61 78 20 4d 75 73 74 65 72 6d 61 6e 6e       p....t..Max Mustermann












'''