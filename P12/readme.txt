Haukur Óskar Þorgeirsson, hth152@hi.is
Matthías Páll Gissurarson, mpg3@hi.is

Project 12

1.  See RaceThreads.java

The program is run by typing 'java RaceThreads n' into command prompt
where n is a positive integer, n will be used as COUNT_MAX as described in the project description.
e.g.
java RaceThreads 42
runs the program with COUNT_MAX = 42.

2. The following outputs illustrate that no race conditions occurred for the same numbers
many race conditions occurred in project 11. (Note: I decided not to go higher as it takes
very long to run, this methods superriority is conclusively proven using these results)

COUNT_MAX = 10
in = 20
2*COUNT_MAX - in = 0

COUNT_MAX = 100
in = 200
2*COUNT_MAX - in = 0

COUNT_MAX = 1000
in = 2000
2*COUNT_MAX - in = 0

COUNT_MAX = 10000
in = 20000
2*COUNT_MAX - in = 0

COUNT_MAX = 100000
in = 200000
2*COUNT_MAX - in = 0

COUNT_MAX = 1000000
in = 2000000
2*COUNT_MAX - in = 0

COUNT_MAX = 10000000
in = 20000000
2*COUNT_MAX - in = 0

COUNT_MAX = 100000000
in = 200000000
2*COUNT_MAX - in = 0
