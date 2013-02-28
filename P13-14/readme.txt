Project 14 by Haukur Óskar Þorgeirsson and Matthías Páll Gissurarson
To start program: javac RaceThreadsSemaphore && java RaceThreadsSemaphore 100

Answer to 4:
As can be seen from the comment in 1, initiating the semaphore
with 2 instead of 1 would allow 2 threads to run at once, however,
this would break the program and not give us the correct result. To
fix that however, one could implement some Mutex for access to the
variable, but then we'd have effectively one thread at a time.
