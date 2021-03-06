RandomIntFile
=============

Small utility to generate a file with randomly generated integers. This repo contains all the supporting code for my blog post here: http://liviutudor.com/2014/06/25/small-java-utility-to-generate-random-int-files/


Usage
-----

You can run this utility in 2 ways:

* Via maven
* Using the "executable" jara (`java -jar`)


Running it via java -jar
------------------------

`java -jar random-file.jar OutputFile.txt [number of integers [min] [max]]`

* if `number of integers` is not specified, then it is assumed to be 1,000,000 (1 mil)
* if `min` and `max` are not specified (they need to be specified together) the following values are assumed:
	* `min` = 0
	* `max` = `Integer.MAX_INT`


Running it via maven
--------------------

`mvn exec:java`

This assumes the 3 parameters above to have the following values:

* `min` = 0
* `max` = `Integer.MAX_INT`
* `number of integers` = 1,0000,000
* `output file` = `random.txt`

Notes
-----

* This project also includes an utility class to read the output generated by this project into an array of `int`. Simply instantiate the class `liv.randomfile.RandomIntReader` and pass the filename in, then call `read()`.

* This project is used in my repo dealing with parallel sorting in Java 8 https://github.com/liviutudor/Java8ParallelSort -- you can find out more about the speed comparison I've carried out in my blog post about it here: http://liviutudor.com/2014/06/26/parallel-sorting-in-java-8/

* More details in my blog post here: http://liviutudor.com/2014/06/25/small-java-utility-to-generate-random-int-files/
