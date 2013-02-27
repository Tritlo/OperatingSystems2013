Haukur Óskar Þorgeirsson, hth152@hi.is
Matthías Páll Gissurarson, mpg3@hi.is

Project 11

1. See RaceThreads.java

Run by typing 'java RaceThreads n' into command prompt
where n is an Integer and will be used as COUNT_MAX.
e.g.
java RaceThreads 42
runs the program with COUNT_MAX = 42.

2-3. The following were printed onto standard output after a few runs of the program,
note that COUNT_MAX is the same as the argument.

COUNT_MAX = 10
in = 18
2*COUNT_MAX - in = 2

COUNT_MAX = 100
in = 188
2*COUNT_MAX - in = 12

COUNT_MAX = 1000
in = 1997
2*COUNT_MAX - in = 3

COUNT_MAX = 10000
in = 18997
2*COUNT_MAX - in = 1003

COUNT_MAX = 100000
in = 183384
2*COUNT_MAX - in = 16616

COUNT_MAX = 1000000
in = 1425444
2*COUNT_MAX - in = 574556

COUNT_MAX = 10000000
in = 14808115
2*COUNT_MAX - in = 5191885

COUNT_MAX = 100000000
in = 125686143
2*COUNT_MAX - in = 74313857

As you can see I have a race condition right at the start, which can partly be
explained by the fact that my computer is running a lot of programs, but is in my
opinion nonetheless strange. If the program were to run without a race condition,
in would be equal to precisely COUNT_MAX at the end, but here this is never the case.
It is noticable, though, that as the input number grows, the error created by race conditions
increases in relation to the input, starting out at 10% (very rough, as the input is only 10)
and growing to (a fairly consistent, according to further tests) 35.2%.
