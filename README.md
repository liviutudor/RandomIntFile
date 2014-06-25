RandomIntFile
=============

Small utility to generate a file with randomly generated integers.


Usage
-----

You can run this utility in 2 ways:

* Via maven
* Using the "executable" jara (`java -jar`)


Running it via java -jar
------------------------

`java -jar random-int-file.jar OutputFile.txt [number of integers [min] [max]]`

* if `number of integers` is not specified, then it is assumed to be 1,000,000 (1 mil)
* if `min` and `max` are not specified (they need to be specified together) the following values are assumed:
** `min` = 0
** `max` = `Integer.MAX_INT`


Running it via maven
--------------------

`mvn exec:java`

This assumes the 3 parameters above to have the following values:

* `min` = 0
* `max` = `Integer.MAX_INT`
* `number of integers` = 1,0000,000
* `output file` = `random.txt`

